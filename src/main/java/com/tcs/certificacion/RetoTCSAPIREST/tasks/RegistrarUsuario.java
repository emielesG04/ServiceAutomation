package com.tcs.certificacion.RetoTCSAPIREST.tasks;

import com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints.ApiEndPoint;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class RegistrarUsuario implements Task {
	private String endpoint;
	private String nuevoRegistro;

	public RegistrarUsuario(String nuevoRegistro) {
		this.nuevoRegistro = nuevoRegistro;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Post.to(ApiEndPoint.obtenerEndPoint(endpoint)).with(request -> request
				.header("Content-Type", "application/json").body(nuevoRegistro)));

	}

	public static RegistrarUsuario conLaInformacionDel(String nuevoRegistro) {
		return Tasks.instrumented(RegistrarUsuario.class, nuevoRegistro);
	}

	public RegistrarUsuario yElEndPoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

}
