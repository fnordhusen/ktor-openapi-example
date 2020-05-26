package com.senacor.fnordhusen.ktorOpenapiSample

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.gson.GsonConverter
import io.ktor.http.ContentType
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        register(ContentType.Application.Json, GsonConverter())
    }
    install(Locations)
    //potentially install more custom features I like

    routing {
        // some other interfaces I may have

        FooApiImpl()
    }
}

