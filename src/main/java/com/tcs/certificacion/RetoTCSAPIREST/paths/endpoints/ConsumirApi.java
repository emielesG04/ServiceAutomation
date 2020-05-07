package com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints;

import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;


import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumirApi {



	public static void tipoGET(String endPoint) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		theActorInTheSpotlight().attemptsTo(Get.resource(endPoint)
                .with(request -> request
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " +  token)));
		
		}
	public static void tipoGetId(String endPoint, int id) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		theActorInTheSpotlight().attemptsTo(Get.resource(endPoint)
				.with(request -> request
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " +  token)
				.queryParam("id", id)));
		}
	
	public static void tipoGET_Email(String endPoint, String email) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		theActorInTheSpotlight().attemptsTo(Get.resource(endPoint)
				.with(request -> request
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " +  token)
				.queryParam("email", email)));

	}
	public static void tipoGetName(String endPoint, String name) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		theActorInTheSpotlight().attemptsTo(Get.resource(endPoint)
				.with(request -> request
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " +  token)
				.pathParam("name", name)));

	}
	public static void tipoDeleteId(String endPoint, String id) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		theActorInTheSpotlight().attemptsTo(Delete.from(endPoint)
				.with(request -> request
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " +  token)));
	}
	public static void tipoPOST( String endPoint,String body) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		theActorInTheSpotlight().attemptsTo(Post.to(endPoint)
				.with(request -> request
						.header("Content-Type", "application/json")
						.header("Authorization","Bearer " +  token)
						.body(body)
						.log().all()));
		
		}
	
	public static void tipoPUT( String endPoint,String body, int id) {
		String token = theActorInTheSpotlight().recall("respuestaToken").toString().trim();
		endPoint = endPoint.replace("id", id+"");
		
		theActorInTheSpotlight().attemptsTo(Put.to(endPoint)
				.with(request -> request
						.header("Content-Type", "application/json")
						.header("Authorization","Bearer " +  token)
						.body(body)
						.log().all()));
		}
}
