package com.ventia

import com.ventia.entities.LocationStatusEntity
import liquibase.util.LiquibaseUtil
import org.hibernate.cfg.Configuration
import org.hibernate.cfg.JdbcSettings.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }

    val c: Connection = DriverManager.getConnection("jdbc:hsqldb:file:target/test/db", "SA", "")
    val s: Statement = c.createStatement()
    s.close()
    c.close()


    println(LiquibaseUtil.getBuildVersionInfo());



    val sessionFactory = Configuration()
        .addAnnotatedClass(LocationStatusEntity::class.java) // use H2 in-memory database
        .setProperty(URL, "jdbc:hsqldb:file:target/test/db")
        .setProperty(USER, "SA")
        .setProperty(PASS, "") // use Agroal connection pool
        //.setProperty("hibernate.agroal.maxSize", 20) // display SQL in console
        .setProperty(SHOW_SQL, true)
        .setProperty(FORMAT_SQL, true)
        .setProperty(HIGHLIGHT_SQL, true)
        .setProperty(USE_SQL_COMMENTS, true)
        .buildSessionFactory()

    //sessionFactory.getSchemaManager().exportMappedObjects(true);

    sessionFactory.schemaManager.validateMappedObjects();

    sessionFactory.inTransaction { session ->
        session.persist(LocationStatusEntity(id = 0, systemStatus = "TEST", status = "TEST", description = "Test Status", active = true))
        session.flush()
    }

    sessionFactory.close()

}