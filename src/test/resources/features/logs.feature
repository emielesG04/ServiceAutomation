#language: es
# Author: emieles@tuya.com.co
#Author: zuleyma.l@tcs.com
Característica: Validar registros de Logs
  Yo como Analista de Calidad
  Deseo validar la funcionalidad del modulo cliente de los servicios Rest
  Para garantizar que los usuarios puedan  realizar el CRUD

  Antecedentes: Generar Token
    Dado que el Analista desea autenticarse como usuario
    Cuando consume el servicio de autenticar nuevo usuario

  @consultarLog
  Escenario: El Analista de Calidad verifica la respuesta del servicio consultar Log Cliente
    Cuando El analista consulta el servicio de consultar 'log'
    Entonces el deberia ver el estado '200' en la respuesta

  @consultarLogName
  Escenario: El Analista de Calidad verifica la respuesta del servicio consultar Log por ID
    Cuando El analista realiza la consulta del servicio 'log_name' con el siguiente nombre 'Zulyelvis'
    Entonces El Analista obtiene como codigo de respuesta 200

 