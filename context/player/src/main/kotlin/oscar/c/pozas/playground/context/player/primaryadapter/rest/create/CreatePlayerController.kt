package oscar.c.pozas.playground.context.player.primaryadapter.rest.create

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import oscar.c.pozas.playground.context.player.application.command.CreatePlayerCommand
import oscar.c.pozas.playground.context.player.application.command.CreatePlayerCommandHandler
import oscar.c.pozas.playground.kernel.idgenerator.IdGenerator

@RestController
@RequestMapping("public/v1/player")
class CreatePlayerController(
    private val handler: CreatePlayerCommandHandler,
    private val idGenerator: IdGenerator,
) {

    @PostMapping
    @Operation(summary = "Create a tmp player")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "List of plans"
            ),
            ApiResponse(
                responseCode = "400",
                description = "The request was not correctly formed (missing required parameters, wrong types...)",
                content = [ Content(schema = Schema(hidden = true)) ]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Generic error",
                content = [ Content(schema = Schema(hidden = true)) ]
            )
        ]
    )
    @ResponseStatus(HttpStatus.OK)
    fun createPlayer(@RequestBody body: CreatePlayerInputModel) =
        handler.handle(CreatePlayerCommand(idGenerator.generate(), body.name))
}