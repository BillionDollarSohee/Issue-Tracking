package server.issue.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.issue.entity.Issue
import server.issue.entity.IssueStatus

interface IssueRepository : JpaRepository<Issue, Long> {
    fun findAllByStatusOrderByCreatedAtDesc(status: IssueStatus): List<Issue>
}