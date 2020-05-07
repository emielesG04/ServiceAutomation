package com.tcs.certificacion.RetoTCSAPIREST.tasks.consulta;

import com.tcs.certificacion.RetoTCSAPIREST.tasks.Autenticar;
import com.tcs.certificacion.RetoTCSAPIREST.tasks.RegistrarUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;

public class ConsumirServicio implements Task {
	private String endpoint;

	public ConsumirServicio(String endpoint) {
		this.endpoint = endpoint;
	}

	public static ConsumirServicio conElSiguienteEndPoint(String endpoint) {
		return Tasks.instrumented(ConsumirServicio.class, endpoint);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		switch (endpoint) {

		case "registrar":
			String registrarUsuarioNuevo = OnStage.theActorInTheSpotlight().recall("regitrarUsuario");
			actor.attemptsTo(RegistrarUsuario.conLaInformacionDel(registrarUsuarioNuevo).yElEndPoint(endpoint));
			break;

		case "autenticar":
			String autenticarUsuario = OnStage.theActorInTheSpotlight().recall("autenticar");
			actor.attemptsTo(Autenticar.conLaInformacionDel(autenticarUsuario).yElEndPoint(endpoint));
			break;

		}

	}

}
