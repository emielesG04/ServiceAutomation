package com.tcs.certificacion.RetoTCSAPIREST.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class Capturar implements Task {
	
	private Map<String, String> secretos = new HashMap<>();
	private List<Map<String, String>> listaDeSecretos = new ArrayList<>();

	@Override
	public <T extends Actor> void performAs(T actor) {	
		actor.whoCan(CallAnApi.at("https://login.microsoftonline.com"));
		actor.attemptsTo(Get.resource("/5f027903-9f00-4970-96c0-a46d59e8e470/oauth2/token")
				.with(request -> request
						.header("Content-Type", "application/x-www-form-urlencoded")
						.body("client_id=2a54c9bc-5b24-49a3-8896-a13dbfa7f361&"
								+ "client_secret=X_85Guv3A/Bsh2:-WB_mN.Ex[TIZ1ge0&"
								+ "grant_type=client_credentials&"
								+ "resource=https://vault.azure.net")
						.log().all()));
		String keyVaultToken = SerenityRest.lastResponse().jsonPath().getString("access_token");
			
		
		actor.whoCan(CallAnApi.at("https://keyvaultreto.vault.azure.net"));
		actor.attemptsTo(Get.resource("/secrets/email/e303ec8d926040c8b9ca084e2ede347e?api-version=7.0")
				.with(request -> request
						.header("Authorization", "Bearer "+keyVaultToken)
						.log().all()));
		secretos.put("email", SerenityRest.lastResponse().jsonPath().getString("value"));
		
		actor.attemptsTo(Get.resource("/secrets/password/8d4df4c24a5f4e4497bf888ca20b908f?api-version=7.0")
				.with(request -> request
						.header("Authorization", "Bearer "+keyVaultToken)
						.log().all()));
		secretos.put("password", SerenityRest.lastResponse().jsonPath().getString("value"));
		
		listaDeSecretos.add(secretos);
		actor.remember("listaDeSecretos", listaDeSecretos);
	}
	public static Capturar secretos() {

		return instrumented(Capturar.class);
	}
}








