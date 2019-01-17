# SPRINT FRAMEWORK
## Comando para crear proyecto
    mvn archetype:generate -DgroupId=com.rofai.demo -DartifactId=com.rofai.demo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
## Obtener detalle de usuario
**URI:** localhost:8080/rofai/v1/administration/user/{id}
**Method** GET
## Obtener lista de usuario
**URI:** localhost:8080/rofai/v1/administration/user
**Method** GET
## Crear usuario
**URI:** localhost:8080/rofai/v1/administration/user
**Method** POST
**Body**
> {
> name="Ejemplo",
> surname="Ejemplo"
> }
## Editar usuario
**URI:** localhost:8080/rofai/v1/administration/user
**Method** PUT
**Body**
> {
> idUser="UUID",
> name="Ejemplo",
> surname="Ejemplo"
> }

