package dev.mauricifj.github_kotlin_issues.data.repository

import dev.mauricifj.github_kotlin_issues.data.api.IssueApi
import dev.mauricifj.github_kotlin_issues.data.api.IssueState
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import dev.mauricifj.github_kotlin_issues.utils.fakeIssueList
import io.reactivex.Observable

class InMemoryRepository(private val service: IssueApi) : IssueRepository {
    override fun getIssues(): Observable<List<Issue>> {
        return Observable.fromArray(
            fakeIssueList()
        )
    }
}