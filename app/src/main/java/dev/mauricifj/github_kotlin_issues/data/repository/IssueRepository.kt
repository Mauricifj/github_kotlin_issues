package dev.mauricifj.github_kotlin_issues.data.repository

import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import io.reactivex.Observable

interface IssueRepository {
    fun getIssues(): Observable<List<Issue>>
}