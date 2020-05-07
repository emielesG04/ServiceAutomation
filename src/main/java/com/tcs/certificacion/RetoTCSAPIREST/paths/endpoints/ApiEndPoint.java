package com.tcs.certificacion.RetoTCSAPIREST.paths.endpoints;

public class ApiEndPoint {

	private static final String REGISTRAR = "/auth/register";
	private static final String AUTENTICAR = "/auth/login";
	private static final String CONSULTAR_CLIENTE = "/clients";
	private static final String CLIENTE_ID = "/clients/id/getinfobyid";
	private static final String CLIENTE_EMAIL = "/clients/email/getinfobyemail";
	private static final String CONSULTA_LOG = "/logs";
	private static final String CONSULTA_LOG_NAME = "/logs/?name={name}";
	private static final String ELIMINAR_CLIENTE = "/clients/id/delete";
	private static final String ACTUALIZAR_CLIENTE ="/clients/id/update";

	public static String obtenerEndPoint(String endpoint) {
		switch (endpoint) {
		case "registrar":
			return ApiEndPoint.REGISTRAR;
		case "autenticar":
			return ApiEndPoint.AUTENTICAR;
		case "cliente":
			return ApiEndPoint.CONSULTAR_CLIENTE;
		case "cliente_id":
			return ApiEndPoint.CLIENTE_ID;
		case "cliente_email":
			return ApiEndPoint.CLIENTE_EMAIL;
		case "log":
			return ApiEndPoint.CONSULTA_LOG;
		case "log_name":
			return ApiEndPoint.CONSULTA_LOG_NAME;
		case "elliminar":
			return ApiEndPoint.ELIMINAR_CLIENTE;
		case "actualizar":
			return ApiEndPoint.ACTUALIZAR_CLIENTE;
		default:
			break;
		}
		return "";
	}
}
