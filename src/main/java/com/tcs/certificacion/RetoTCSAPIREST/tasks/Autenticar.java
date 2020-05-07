package com.tcs.certificacion.RetoTCSAPIREST.tasks;

import com.tcs.certificacion.RetoTCSAPIREST.models.TokenModel;
import com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints.ApiEndPoint;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.Map;

public class Autenticar implements Task {

	private String endpoint;
	private String autenticarUsuario;

	public Autenticar(String autenticarUsuario) {

		this.autenticarUsuario = autenticarUsuario;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.whoCan(CallAnApi.at("http://40.70.169.110:8080"));
		actor.attemptsTo(Post.to(ApiEndPoint.obtenerEndPoint(endpoint)).with(request -> request
				.header("Content-Type", "application/json").body(autenticarUsuario)));

		ObjectMapper mapper = new ObjectMapper();
		Map response = SerenityRest.lastResponse().getBody().as(Map.class);
		TokenModel result = mapper.convertValue(response, TokenModel.class);
		actor.remember("respuestaToken", result.getAccessToken());
		

	}

	public static Autenticar conLaInformacionDel(String autenticarUsuario) {
		return Tasks.instrumented(Autenticar.class, autenticarUsuario);
	}

	public Autenticar yElEndPoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

}
