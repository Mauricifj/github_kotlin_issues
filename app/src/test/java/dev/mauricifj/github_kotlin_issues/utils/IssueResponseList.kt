package dev.mauricifj.github_kotlin_issues.utils

import dev.mauricifj.github_kotlin_issues.data.model.IssueResponse
import dev.mauricifj.github_kotlin_issues.data.model.User
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import dev.mauricifj.github_kotlin_issues.presenter.model.IssueUi
import dev.mauricifj.github_kotlin_issues.presenter.model.toUiModel
import dev.mauricifj.github_kotlin_issues.utils.fakeIssueList

fun IssueResponseList() : List<IssueResponse> = fakeIssueList().map { it.toIssueResponse() }
fun IssueList() : List<Issue> = fakeIssueList()
fun IssueUiList() : List<IssueUi> = IssueList().map { it.toUiModel() }

fun Issue.toIssueResponse() = IssueResponse(
    id = this.id,
    title = this.title,
    state = this.state,
    body = this.description ?: "",
    url = this.url,
    createdAt = this.createdAt,
    user = User(
        login = this.user,
        avatarUrl = this.avatar
    )
)