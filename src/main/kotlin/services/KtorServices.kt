package services

import com.fasterxml.jackson.databind.ObjectMapper
import firestore.FirestoreUtils
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.jackson
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import objects.Project
import objects.User
import java.text.DateFormat


// Entry Point of the application as defined in resources/application.conf.
// @see https://ktor.io/servers/configuration.html#hocon-file
fun Application.main() {
    // This adds Date and Server headers to each response, and allows custom additional headers
    install(DefaultHeaders)
    // This uses use the logger to log every call (request/response)
    install(CallLogging)

    install(ContentNegotiation) {
        jackson {
            dateFormat = DateFormat.getDateInstance()
            disableDefaultTyping()
        }
    }

    routing {
        get("/") {
            call.respondRedirect("/login")
        }

        //USER OPERATIONS
        post("/doLogin") {
            val parameters = call.receiveParameters()
            val email = parameters["email"] ?: ""
            val password = parameters["password"] ?: ""

            if(UserHandler.authenticateUser(email, password)){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Login exitoso" }
            }else{
                call.response.status(HttpStatusCode.Unauthorized)
                call.respondText { "Usuario o contraseña incorrecta" }
            }
        }

        delete("/deleteUser") {
            FirestoreUtils.deleteDocumentWithId(FirestoreUtils.USER_COLLECTION, call.receiveParameters()["id"] ?: "")
            call.respondText { "Documento eliminado exitosamente" }
        }
        post("/getUserWithId") {
            val id = call.receiveParameters()["id"] ?: ""
            val user = FirestoreUtils.getObject<User>(FirestoreUtils.USER_COLLECTION, id)
            call.respondText { ObjectMapper().writeValueAsString(user) }
        }

        //ISSUE OPERATIONS

        delete("/deleteProject"){
            val id = call.receiveParameters()["id"] ?: ""
            FirestoreUtils.deleteDocumentWithId(FirestoreUtils.PROJECT_COLLECTION, id)
            call.respondText { "Operacion exitosa" }
        }
        post("/getProjectWithId"){
            val id = call.receiveParameters()["id"] ?: ""
            val project = FirestoreUtils.getObject<Project>(FirestoreUtils.PROJECT_COLLECTION, id)
            call.respondText { ObjectMapper().writeValueAsString(project) }
        }
    }
}