class LoadTests extends Simulation {  
    before {
 println("Tasklist Management Load Tests are about to start!!")
 }  
 val rampUsersCount: Int = Properties.propOrElse("rampUsers", "20").toInt
 val rampDuration: Int = Properties.propOrElse("rampDuration", "5").toInt 
 
 val tasklistManagementTest: ScenarioBuilder = scenario("Tasklist Management Simulation")
 .exec(
 karateFeature("classpath:features/users.feature")
 )  setUp(
 tasklistManagementTest.inject(rampUsers(rampUsersCount) during rampDuration)
 )  
 after {
 println("Tasklist Management Load Tests finished!!")
 }
}