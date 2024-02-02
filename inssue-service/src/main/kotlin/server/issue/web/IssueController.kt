package server.issue.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import server.config.AuthUser
import server.issue.entity.IssueStatus
import server.issue.model.IssueRequest
import server.issue.service.IssueService

@RestController
@RequestMapping("/v1/issues")
class IssueController(
        private val issueService: IssueService,
) {

    @PostMapping
    fun create(
            authUser: AuthUser,
            @RequestBody request: IssueRequest,
    ) = issueService.create(authUser.userId, request)

    @PutMapping("/{id}")
    fun edit(
            authUser: AuthUser,
            @PathVariable id: Long,
            @RequestBody request: IssueRequest,
    ) = issueService.edit(authUser.userId, id, request)

    @GetMapping("/{id}")
    fun get(
            authUser: AuthUser,
            @PathVariable id: Long,
    ) = issueService.get(id)


    @GetMapping
    fun getAll(
            authUser: AuthUser,
            @RequestParam(required = false, defaultValue = "TODO") status : IssueStatus,
    ) = issueService.getAll(status)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
            authUser: AuthUser,
            @PathVariable id: Long,
    ) {
        issueService.delete(id)
    }


}