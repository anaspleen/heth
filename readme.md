**Heth Project**


Sources for Heth Modules

- heth-services : Services for business project
- heth-api : Rest Api
- heth-front : Front

- To add heth.properties, add env variable :
export HETH_CONF_PATH=pathContainesProperties
This path contains heth.properties

Example :
export HETH_CONF_PATH=/products/eclipse/ws/heth/heth-services/src/test/resources

- To run :
mci ; java -Dlogging.config=file:/products/eclipse/ws/heth/heth-services/src/test/resources/logback.xml -jar heth-api/target/heth-api-1.0.0-SNAPSHOT.jar

- To debug :
mci ; java -Dlogging.config=file:/products/eclipse/ws/heth/heth-services/src/test/resources/logback.xml -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n  -jar heth-api/target/heth-api-1.0.0-SNAPSHOT.jar

- in a browser, go to [this URL](http://localhost:8080/api)

Well listen, let the developer do the job, be sure I'll push as soon as possible okay ?

Vel lytte, la utbygger gjøre jobben, være sikker på at jeg vil presse så fort som mulig i orden?
.

- To call :
- Execute :
TestMealService.testFindByCooker()

- Call with API REST client :
To get meal from specific cooker :
http://localhost:8080/api/meal/get?cooker=testFFF
GET
