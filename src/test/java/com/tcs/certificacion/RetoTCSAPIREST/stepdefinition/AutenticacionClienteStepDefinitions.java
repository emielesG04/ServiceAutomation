package com.tcs.certificacion.RetoTCSAPIREST.stepdefinition;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.tcs.certificacion.RetoTCSAPIREST.models.AutenticacionModels;
import com.tcs.certificacion.RetoTCSAPIREST.tasks.Capturar;
import com.tcs.certificacion.RetoTCSAPIREST.tasks.consulta.ConsumirServicio;
import com.tcs.certificacion.RetoTCSAPIREST.utils.CrearBody;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import java.util.List;
import java.util.Map;

public class AutenticacionClienteStepDefinitions {

	@Dado("que el Analista desea crear el registro con los siguientes datos:")
	public void queElAnalistaDeseaCrearElRegistroConLosSiguientesDatos(List<Map<String, String>> datos) {
		String regitrarUsuario = CrearBody.conLaPlantilla(AutenticacionModels.REGISTRO_USUARIO).yLosValores(datos);
		OnStage.theActorInTheSpotlight().remember("regitrarUsuario", regitrarUsuario);
	}
	@Cuando("consume el servicio de (.*) nuevo usuario")
	public void consumeElServicioDeCrearRegistroUsuarioNuevo(String endpoint) {

		OnStage.theActorInTheSpotlight().attemptsTo(ConsumirServicio.conElSiguienteEndPoint(endpoint));

	}
	@Dado("que el Analista desea autenticarse como usuario")
	public void queElAnalistaDeseaAutenticarseComoUsuarioConLosSiguientesDatos() {
		OnStage.theActorInTheSpotlight().wasAbleTo(Capturar.secretos());
		String autenticar = CrearBody.conLaPlantilla(AutenticacionModels.AUTENTICAR_USUARIO)
				.yLosValores(theActorInTheSpotlight().recall("listaDeSecretos"));
		OnStage.theActorInTheSpotlight().remember("autenticar", autenticar);
	}
	@Entonces("El Analista obtiene como codigo de respuesta (.*)")
	public void el_Analista_obtiene_como_codigo_de_respuesta(Integer respuesta) {
		OnStage.theActorInTheSpotlight()
				.should(seeThatResponse("Estado correcto", lastResponse -> lastResponse.statusCode(respuesta)));
	}
}
