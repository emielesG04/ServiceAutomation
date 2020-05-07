#language: es
#Author: zuleyma.l@tcs.com
# Author: emieles@tuya.com.co
@autenticacionCliente
Característica: autentica cliente desde el servicio
  Yo como Analista de Calidad
  Deseo validar la funcionalidad del modulo autenticar del servicio Rest autentica Cliente
  Para garantizar que los usuarios puedan ingresar correctamente

  @AutenticarUsuario
  Escenario: Verificar funcionamiento del servicio Autenticar usuario
    Dado que el Analista desea autenticarse como usuario
    Cuando consume el servicio de autenticar nuevo usuario
    Entonces El Analista obtiene como codigo de respuesta 200
