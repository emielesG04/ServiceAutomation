# Introdución
Se Automatiza una API tipos REST para verificar y validar el correcto funcionamiento de las tareas asignadas al servicio; Esta tiene 3 modulos los cuales son: 
1. Modulo Autenticación: Este cumple con 2 sub-servicios,los cuales son:
   1.1 POST:/auth/register
   1.2 POST:/auth/login
2.Módulo Clients: Este cumple con 6 sub-servicios,los cuales son:
   2.1 POST: /clients
   2.2 GET: /clients
   2.3 GET: /clients/?id={id}
   2.4 GET: /clients/?email={email}
   2.5 DELETE: /clients/?id=:id
   2.6 PUT: /clients/?id={id}
3.Módulo Logs: Este cumple con 6 sub-servicio, los cuales son:
  3.1 GET: /logs
  3.2 GET: /logs/?name={name}
Para la realización de este  proyecto se usa el lenguaje de programación Java con el IDEA Eclipse, Intellij(2019.3.1), consumiendo los servicios por POSTMAN usando la herramienta de versionamiento GIT. Los secretos del servicio se manejan por medio de Azure Devops, utilizando Key Vault.  

# Consumo del servicio
La url base para consumir el servicio es: http://40.70.169.110 con el puerto 8080; dependiendo la ejecución del servicio que se desea realizar cambia el enpoint
      REGISTRAR = "/auth/register";
      AUTENTICAR = "/auth/login";
	  CONSULTAR_CLIENTE = "/clients";
	  CLIENTE_ID = "/clients/id/getinfobyid";
	  CLIENTE_EMAIL = "/clients/email/getinfobyemail";
	  CONSULTA_LOG = "/logs";
	  CONSULTA_LOG_NAME = "/logs/?name={name}";
	  ELIMINAR_CLIENTE = "/clients/id/delete";
	  ACTUALIZAR_CLIENTE ="/clients/id/update";
	  
El servicio  Loguin del modelo Autenticación es aquel que ofrece el token para los servicios de los modulos clientes y Logs.


# Request para cada modulos

1. Modulo Autenticación: Este cumple con 2 sub-servicios,los cuales son:
   1.1 POST:/auth/register
   
   enpoint: http://40.70.169.110:8080/auth/register
   {
    "name": "Zulyelvis",
    "email": "zulyelvis@google.com",
    "password": "zulyelvis"
   }
 
   1.2 POST:/auth/login
   
   enpoint: http://40.70.169.110:8080/auth/login
   {
    "email": "zulyelvis@google.com",
    "password": "zulyelvis"
   }
2.Módulo Clients: Este cumple con 2 sub-servicios,los cuales son:
   2.1 POST: /clients
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
   enpoint:http://40.70.171.45:8080/clients
   {
	"name":"elvis zulyii qa",
	"credit_card":"126645998",
	"address":"calle 20",
	"phone_number":"jhjh",
	"email":"elvismieles"
  }
   
   2.2 GET: /clients
   enpoint:http://40.70.169.110:8080/clients
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
   
   2.3 GET: /clients/?id={id}
   enpoint:http://40.70.169.110:8080/clients/?id=42
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
   
   2.4 GET: /clients/?email={email}
   enpoint: http://40.70.171.45:8080/clients/?email={zulyelvis@google.com}
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
   
   2.5 DELETE: /clients/?id=:id
   enpoint: http://40.70.169.110:8080/clients/14/delete
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
   
   2.6 PUT: /clients/?id={id}
   enpoint:http://40.70.169.110:8080/clients/id/update
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
   
3.Módulo Logs: Este cumple con 6 sub-servicio, los cuales son:
  3.1 GET: /logs
  enpoint:http://40.70.171.45:8080/logs
  
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
  3.2 GET: /logs/?name={name}
  enpoint: http://40.70.171.45:8080/logs/{zulyelvis}/getbyname
   Auth: Selecciona la opción Bearer Token  y copia el toke que le arroja el servicio de Loguin.
  
#Servicios que conectan a Azures
4. Modulo de Azure - Este cumple con 2 sub-servicios,los cuales son
    4.1- GET- Token de Azure
	enpoint: https://login.microsoftonline.com/5f027903-9f00-4970-96c0-a46d59e8e470/oauth2/token
	El body esta conformado por los siguientes campos:
	client_id           2a54c9bc-5b24-49a3-8896-a13dbfa7f361   
	client_secret       X_85Guv3A/Bsh2:-WB_mN.Ex[TIZ1ge0
	grant_type          client_credentials
	resource            https://vault.azure.net
	
	4.2- GET- Consulta Secretos 
	enpoint: https://keyvaultreto.vault.azure.net/secrets/email/e303ec8d926040c8b9ca084e2ede347e?api-version=7.0
	El token del servicio TOKEN DE AZURE se envía en este 
  
# Ejecución de la automatización


# Información del Swagger UI
40.70.169.110:8080/api

#Ejecución para el analisis del codigo con sonar.

mvn sonar:sonar -Dsonar.projectKey=AUT_CrudReto_1742699_1266078 -Dsonar.host.url=http://10.101.145.30:9000 -Dsonar.login=0ea85769aa3f82e21f277df64726af989ac069d1



