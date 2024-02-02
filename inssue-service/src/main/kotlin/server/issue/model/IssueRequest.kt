package server.issue.model

import com.fasterxml.jackson.annotation.JsonFormat
import server.comment.Comment
import server.comment.CommentResponse
import server.comment.toResponse
import server.issue.entity.Issue
import server.issue.entity.IssuePriority
import server.issue.entity.IssueStatus
import server.issue.entity.IssueType
import java.time.LocalDateTime

data class IssueRequest(
        val summary: String,
        val description: String,
        val type: IssueType,
        val priority: IssuePriority,
        val status: IssueStatus,
) {
}

data class IssueResponse(
        val id : Long,
        val userId: Long,
        val summary: String,
        val description: String,
        val type: IssueType,
        val priority: IssuePriority,
        val status: IssueStatus,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val createdAt: LocalDateTime?,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val updatedAt: LocalDateTime?,

        val comments: List<CommentResponse> = emptyList(),
) {
    companion object {
        operator fun invoke(issue: Issue) =
                with(issue) {
                    IssueResponse(
                            id = id!!,
                            userId = userId,
                            summary = summary,
                            description = description,
                            type = type,
                            priority = priority,
                            status = status,
                            createdAt = createdAt,
                            updatedAt = updatedAt,

                            comments = comments.sortedByDescending(Comment::id).map(Comment::toResponse),
                    )
                }
    }

}
