package com.senacor.fnordhusen.ktorOpenapiSample

import com.senacor.fnordhusen.ktorOpenapiSample.model.Foo
import com.senacor.fnordhusen.ktorOpenapiSample.server.Paths
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.delete
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route

/**
 * This Api Implementation has to be written completely manually. No help from the generated Code...
 */
@KtorExperimentalLocationsAPI
fun Route.FooApiImpl() {
    get<Paths.getAllFoos> {
        call.respond(listOf(
            Foo( id = -1, bar = "hello"),
            Foo( id = -2, bar = "world")
        ))
    }

    // the path gets named after the first method, which is weird in my eyes.
    post<Paths.getAllFoos> {
        val foo = call.receive<Foo>()
        // fooService.save(foo)
        call.respond(foo)
    }

    delete<Paths.deleteFooById> { path ->
        val id = path.id
        // fooService.deleteById(id)
        call.respond(HttpStatusCode.NoContent)
    }
}