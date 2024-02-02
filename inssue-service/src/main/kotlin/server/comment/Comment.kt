package server.comment

import jakarta.persistence.*
import server.issue.entity.BaseEntity
import server.issue.entity.Issue

@Entity
@Table
class Comment (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    val issue: Issue,

    @Column
    val userId: Long,

    @Column
    val username: String,

    @Column
    var body: String,

    ) : BaseEntity()