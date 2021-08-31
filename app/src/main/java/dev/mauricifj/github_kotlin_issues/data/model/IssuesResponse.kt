package dev.mauricifj.github_kotlin_issues.data.model

import com.squareup.moshi.Json
import dev.mauricifj.github_kotlin_issues.data.api.IssueState
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue

data class IssueResponse(
    val id: String,
    val title: String,
    val state: IssueState,
    val body: String?,
    val user: User,

    @field:Json(name = "created_at")
    val createdAt: String,

    @field:Json(name = "html_url")
    val url: String
)

data class User (
    val login: String,

    @field:Json(name="avatar_url")
    val avatarUrl: String
)

fun IssueResponse.toIssue() = Issue(
    id = this.id,
    title = this.title,
    state = this.state,
    description = this.body ?: "",
    url = this.url,
    avatar = this.user.avatarUrl,
    user = this.user.login,
    createdAt = this.createdAt
)