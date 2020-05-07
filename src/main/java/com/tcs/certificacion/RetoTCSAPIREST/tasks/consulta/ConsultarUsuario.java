package com.tcs.certificacion.RetoTCSAPIREST.tasks.consulta;

import com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints.ApiEndPoint;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarUsuario implements Task {

    private String endpoint;
    private int parametro;

    public ConsultarUsuario conEndPoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public static ConsultarUsuario conId(int id){
        return Tasks.instrumented(ConsultarUsuario.class,id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
    	actor.whoCan(CallAnApi.at("http://40.70.169.110:8080"));
        actor.attemptsTo(Get.resource(ApiEndPoint.obtenerEndPoint(endpoint)).with(request -> request
                .header("Authorization",actor.recall("respuestaToken")).param("id",parametro)));
    }
}
