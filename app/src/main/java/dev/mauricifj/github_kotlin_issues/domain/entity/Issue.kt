package dev.mauricifj.github_kotlin_issues.domain.entity

import dev.mauricifj.github_kotlin_issues.data.api.IssueState

data class Issue(
    val id: String,
    val title: String,
    val state: IssueState,
    val description: String,
    val url: String,
    val avatar: String,
    val user: String,
    val createdAt: String,
)