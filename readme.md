**Heth Project**


Sources for Heth Modules

- heth-services : Services for business project
- heth-api : Rest Api
- heth-front : Front


- To run :
mci ; java -jar heth-api/target/heth-api-1.0.0-SNAPSHOT.jar

- To dbug :
mci ; java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n  -jar heth-api/target/heth-api-1.0.0-SNAPSHOT.jar

- in a browser, go to [this URL](http://localhost:8080/api)

Well listen, let the developer do the job, be sure I'll push as soon as possible okay ?

Vel lytte, la utbygger gjøre jobben, være sikker på at jeg vil presse så fort som mulig i orden?
.

- To call :
1- Execeute :
TestMealService.testFindByCooker()

2- Call with API REST client :
To get meal from specific cooker :
http://localhost:8080/api/meal/get?cooker=testFFF
GET
