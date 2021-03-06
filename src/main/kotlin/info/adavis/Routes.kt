package info.adavis

import com.google.gson.Gson
import info.adavis.graphql.AppSchema
import io.ktor.application.Application
import io.ktor.application.log
import io.ktor.content.default
import io.ktor.content.static
import io.ktor.routing.routing
import org.koin.ktor.ext.inject

@Suppress("unused")
fun Application.routes() {

    routing {
        val appSchema: AppSchema by inject()
        val gson: Gson by inject()

        graphql(log, gson, appSchema.schema)

        static("/") {
            default("index.html")
        }
    }
}