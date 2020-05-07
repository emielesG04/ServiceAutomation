#language: es
# Author: emieles@tuya.com.co
#Author: zuleyma.l@tcs.com
Característica: creacion cliente desde el servicio
  Yo como Analista de Calidad
  Deseo validar la funcionalidad del modulo cliente de los servicios Rest
  Para garantizar que los usuarios puedan  realizar el CRUD

  Antecedentes: Generar Token
    Dado que el Analista desea autenticarse como usuario
    Cuando consume el servicio de autenticar nuevo usuario

  @creacionClienteNuevo
  Escenario: El Analista de Calidad verifica la respuesta del servicio de crear cliente
    Dado el Analista envia la peticion con los datos:
      | name        | credit_card | address       | phone_number | email                 |
      | Pipelineni1 | 1128f       | calle 103 n 1 | 3045410190   | Pipelineez3@gmail.com |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '201'
    Y el mensaje 'Cliente Registrado' en el campo 'message'

  @creacionClienteExistente
  Escenario: El Analista de Calidad verifica la respuesta del servicio de crear cliente  no exitoso
    Dado el Analista envia la peticion con los datos:
      | name        | credit_card | address       | phone_number | email                 |
      | PepitoPerez | 1128        | calle 103 n 1 | 3045410190   | PepitoPerez@gmail.com |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '400'
    Y el mensaje 'El cliente ya existe' en el campo 'message'

  @creacionClienteSinNombre
  Escenario: El Analista de Calidad verifica la respuesta del servicio de crear cliente sin nombre
    Dado el Analista envia la peticion con los datos:
      | name | credit_card | address     | phone_number | email           |
      |      | 33121221    | calle34 n 1 | 3045410190   | zuly4@gmail.com |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '400'

  @creacionClienteSinTarjeta
  Escenario: El Analista de Calidad verifica la respuesta del servicio crear cliente  sin tarjeta
    Dado el Analista envia la peticion con los datos:
      | name    | credit_card | address     | phone_number | email           |
      | Prueb16 |             | calle34 n 1 | 3045410190   | zuly4@gmail.com |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '400'

  @creacionClienteSinDireccion
  Escenario: El Analista de Calidad verifica la respuesta del servicio crear cliente sin direccion
    Dado el Analista envia la peticion con los datos:
      | name    | credit_card | address | phone_number | email           |
      | Prueb16 | 1234        |         | 3045410190   | zuly4@gmail.com |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '400'

  @creacionClienteSinTelefono
  Escenario: El Analista de Calidad verifica la respuesta del servicio crear cliente sin telefono
    Dado el Analista envia la peticion con los datos:
      | name    | credit_card | address  | phone_number | email           |
      | Prueb16 | 1234        | calle 12 |              | zuly4@gmail.com |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '400'

  @creacionClienteSinTelefono
  Escenario: Validar las respuestas del servicios REST de crear cliente  no exitoso
    Dado el Analista envia la peticion con los datos:
      | name    | credit_card | address  | phone_number | email |
      | Prueb16 | 1234        | calle 12 | 3115677      |       |
    Cuando que el Analista desea consumir el servicio llamado 'cliente'
    Entonces el deberia ver que la respuesta es un codigo '400'

  @consultarCliente
  Escenario: El Analista de Calidad verifica la respuesta del servicio consultar Cliente
    Cuando El analista consulta el servicio de consultar 'cliente'
    Entonces el deberia ver el estado '200' en la respuesta
    Y la siguiente lista de clientes:
      | zuleima | ElvisMieles | pepito | dulce Maria |

  @consultarClientePorID
  Escenario: El Analista de Calidad verifica la respuesta del servicio consultar Cliente por ID
    Cuando El analista realiza la consulta del servicio 'cliente_id' con el siguiente ID '26'
    Entonces El Analista obtiene como codigo de respuesta 404

  @consultarClientePorEmail
  Escenario: El Analista de Calidad verifica la respuesta del servicio consultar Cliente por Email
    Cuando El analista realiza la consulta del servicio 'cliente_email' con el siguiente Email 'Zuly1605@gmail.com'
    Entonces El Analista obtiene como codigo de respuesta 200

  @consultarClientePorEmailNoExistente
  Escenario: El Analista de Calidad verifica la respuesta del servicio consultar Cliente por Email no Exitoso
    Cuando El analista realiza la consulta del servicio 'cliente_email' con el siguiente Email 'aaaaaaaaa@aaa.com'
    Entonces El Analista obtiene como codigo de respuesta 200

  @eliminarClientePorIdNoExistente
  Escenario: El Analista de Calidad verifica que el servicio permita elimimar el cliente no existente
    Cuando El analista realiza la consulta de 'eliminar' cliente con el siguiente Id '1'
    Entonces El Analista obtiene como codigo de respuesta 404

  @actualizacionCliente
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name         | credit_card | address     | phone_number | email               |
      | elvisZuleima | 123456      | calle 103n1 | 3045410190   | zulyelvis@gmail.com |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '21'
    Entonces el deberia ver que la respuesta es un codigo '200'
    Y el mensaje 'Cliente Actualizado' en el campo 'message'

  @actualizacionClienteNoExistente
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente no existente
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name         | credit_card | address     | phone_number | email               |
      | elvisZuleima | 123456      | calle 103n1 | 3045410190   | zulyelvis@gmail.com |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '87654'
    Entonces el deberia ver que la respuesta es un codigo '404'

  @actualizacionClientesinNombre
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente sin nombre
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name | credit_card | address     | phone_number | email               |
      |      | 123456      | calle 103n1 | 3045410190   | zulyelvis@gmail.com |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '20'
    Entonces el deberia ver que la respuesta es un codigo '200'

  @actualizacionClientesinCard
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name      | credit_card | address     | phone_number | email               |
      | elvisZuly |             | calle 103n1 | 3045410190   | zulyelvis@gmail.com |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '20'
    Entonces el deberia ver que la respuesta es un codigo '200'

  @actualizacionClientesinDireccion
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente sin Direccion
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name      | credit_card | address | phone_number | email               |
      | elvisZuly | 123456      |         | 3045410190   | zulyelvis@gmail.com |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '20'
    Entonces el deberia ver que la respuesta es un codigo '200'

  @actualizacionClientesinTelefono
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente sin telefono
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name      | credit_card | address     | phone_number | email               |
      | elvisZuly | 123456      | calle 103n1 |              | zulyelvis@gmail.com |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '20'
    Entonces el deberia ver que la respuesta es un codigo '200'

  @actualizacionClientesinEmail
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente sin Email
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name      | credit_card | address     | phone_number | email |
      | elvisZuly | 123456      | calle 103n1 | 3045410190   |       |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '20'
    Entonces el deberia ver que la respuesta es un codigo '200'

  @actualizacionClienteconEmailInvalido
  Escenario: El Analista de Calidad verifica el servicio de actualizar Cliente con email invalido
    Dado el Analista envia la peticion de actualizacion con los datos:
      | name      | credit_card | address     | phone_number | email     |
      | elvisZuly | 123456      | calle 103n1 | 3045410190   | elviszuly |
    Cuando El analista realiza la consulta del servicio  'actualizar' cliente con el ID '20'
    Entonces el deberia ver que la respuesta es un codigo '200'

  @eliminarClientePorId
  Escenario: El Analista de Calidad verifica que el servicio permita elimimar el cliente
     Cuando El analista consulta el servicio de consultar 'cliente'
    Cuando El analista realiza la consulta de 'eliminar' cliente con el siguiente Id '38'
    Entonces El Analista obtiene como codigo de respuesta 404
