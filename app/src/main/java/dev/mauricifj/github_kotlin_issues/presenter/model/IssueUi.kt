package dev.mauricifj.github_kotlin_issues.presenter.model

import dev.mauricifj.github_kotlin_issues.data.api.IssueState
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import kotlinx.serialization.Serializable

@Serializable
data class IssueUi (
    val id: String,
    val title: String,
    val state: IssueState,
    val description: String,
    val avatar: String,
    val user: String,
    val url: String,
    val createdAt: String,
)

fun Issue.toUiModel() = IssueUi(
    id = this.id,
    title = this.title,
    state = this.state,
    description = this.description,
    avatar = this.avatar,
    createdAt = this.createdAt,
    user = this.user,
    url = this.url
)