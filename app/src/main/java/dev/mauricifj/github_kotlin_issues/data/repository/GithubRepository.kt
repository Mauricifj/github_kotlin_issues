package dev.mauricifj.github_kotlin_issues.data.repository

import dev.mauricifj.github_kotlin_issues.data.api.IssueApi
import dev.mauricifj.github_kotlin_issues.data.api.IssueState
import dev.mauricifj.github_kotlin_issues.data.model.toIssue
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import io.reactivex.Observable

class GithubRepository(private val service: IssueApi) : IssueRepository {
    override fun getIssues(): Observable<List<Issue>> {
        return service.getIssues(IssueState.All)
            .map {
                it.map { issueResponse -> issueResponse.toIssue() }
            }
    }
}