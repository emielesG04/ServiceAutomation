package com.tcs.certificacion.RetoTCSAPIREST.stepdefinition;

import com.tcs.certificacion.RetoTCSAPIREST.models.AutenticacionModels;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints.ApiEndPoint;
import com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints.ConsumirApi;
import com.tcs.certificacion.RetoTCSAPIREST.utils.CrearBody;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.restassured.specification.ProxySpecification;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ClienteStepDefinitions {

	private EnvironmentVariables envVars;

	@Before
	public void configurarElEscenario() {

		String baseUrl = envVars.optionalProperty("restapi.baseurl").orElseThrow(IllegalArgumentException::new);
		SerenityRest.setDefaultProxy(new ProxySpecification("10.101.85.253", 8080, "http"));
		SerenityRest.useRelaxedHTTPSValidation("TLS");
		OnStage.setTheStage(new OnlineCast());
		OnStage.theActorCalled("Analista");

	}

	@Dado("el Analista envia la peticion con los datos:")
	public void elAnalistaEnviaLaPeticionConLosDatos(List<Map<String, String>> datos) {
		String bodyCrearCliente = CrearBody.conLaPlantilla(AutenticacionModels.CREAR_CLIENTE).yLosValores(datos);
		theActorInTheSpotlight().remember("bodyCrearCliente", bodyCrearCliente);
	}
	@Dado("el Analista envia la peticion de actualizacion con los datos:")
	public void elAnalistaEnviaLaPeticionDeActualizacionConLosDatos(List<Map<String, String>> datos) {
		String bodyActualizarCliente = CrearBody.conLaPlantilla(AutenticacionModels.ACTUALIZAR_CLIENTE).yLosValores(datos);
		theActorInTheSpotlight().remember("bodyActualizarCliente", bodyActualizarCliente);

	}
	

	@Dado("que el Analista desea consumir el servicio llamado '(.*)'")
	public void queElAnalistaDeseaConsumirElServicioLlamadoCreacionCliente(String servicio) {
		String bodyCrearCliente = theActorInTheSpotlight().recall("bodyCrearCliente");
		ConsumirApi.tipoPOST(ApiEndPoint.obtenerEndPoint(servicio), bodyCrearCliente);
	}

	@Entonces("el deberia ver que la respuesta es un codigo '(.*)'")
	public void elDeberiaVerQueLaRespuestaEsUnCodigo(int codigo) {
		theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse("Estado Correcto",
				LastResponse -> LastResponse.statusCode(codigo)));
	}

	@Entonces("el mensaje '(.*)' en el campo '(.*)'")
	public void elMensajeEnElCampo(String mensaje, String campo) {
		theActorInTheSpotlight().should(
				seeThatResponse("Estado correcto", lastResponse -> lastResponse.body(campo, Matchers.is(mensaje))));
	}

	@Cuando("El analista consulta el servicio de consultar '(.*)'")
	public void elAnalistaConsultaElServicioDeConsultar(String servicio) {

		ConsumirApi.tipoGET(ApiEndPoint.obtenerEndPoint(servicio));

	}

	@Entonces("el deberia ver el estado '(.*)' en la respuesta")
	public void elDeberiaVerElEstadoEnLaRespuesta(int codigo) {
		theActorInTheSpotlight()
				.should(seeThatResponse("Estado correcto", lastResponse -> lastResponse.statusCode(codigo)));
	}

	@Cuando("El analista realiza la consulta del servicio '(.*)' con el siguiente ID '(.*)'")
	public void elAnalistaRealizaLaConsultaDelServicioConElSiguienteID(String servicio, int id) {

		ConsumirApi.tipoGetId(ApiEndPoint.obtenerEndPoint(servicio), id);
	}

	@Cuando("El analista realiza la consulta del servicio '(.*)' con el siguiente Email '(.*)'")
	public void elAnalistaRealizaLaConsultaDelServicioConElSiguienteEmail(String servicio, String email) {
		ConsumirApi.tipoGET_Email(ApiEndPoint.obtenerEndPoint(servicio), email);
	}

	@Cuando("El analista realiza la consulta del servicio '(.*)' con el siguiente nombre '(.*)'")
	public void elAnalistaRealizaLaConsultaDelServicioConElSiguienteNombre(String servicio, String name) {

		ConsumirApi.tipoGetName(ApiEndPoint.obtenerEndPoint(servicio), name);
	}

	@Cuando("El analista realiza la consulta de '(.*)' cliente con el siguiente Id '(.*)'")
	public void elAnalistaRealizaConsultaDeClientConElSiguienteId(String servicio, String id) {
		ConsumirApi.tipoDeleteId(ApiEndPoint.obtenerEndPoint(servicio), id);
	}

	@Cuando("El analista realiza la consulta del servicio  '(.*)' cliente con el ID '(.*)'")
	public void elAnalistaRealizaConsultaDelServicioActualizarClientConElSiguienteId(String servicio, int id) {

		String bodyActualizarCliente = theActorInTheSpotlight().recall("bodyActualizarCliente");
		ConsumirApi.tipoPUT(ApiEndPoint.obtenerEndPoint(servicio),bodyActualizarCliente, id);
	}

	@After
	public void cerrarElEscenario() {
		OnStage.drawTheCurtain();
	}
}
