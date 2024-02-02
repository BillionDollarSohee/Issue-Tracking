package server.issue.entity

import jakarta.persistence.*
import server.comment.Comment

@Entity
@Table
class Issue (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column
        var userId: Long,

        @Column
        var summary: String,

        @Column
        var description: String,

        @Column
        @Enumerated(EnumType.STRING)
        var type: IssueType,

        @Column
        @Enumerated(EnumType.STRING)
        var priority: IssuePriority,

        @Column
        @Enumerated(EnumType.STRING)
        var status: IssueStatus,

        @OneToMany(fetch = FetchType.EAGER)
        val comments : MutableList<Comment> = mutableListOf()

        ) : BaseEntity()