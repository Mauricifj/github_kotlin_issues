package dev.mauricifj.github_kotlin_issues.domain.usecase

import dev.mauricifj.github_kotlin_issues.data.repository.IssueRepository
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import io.reactivex.Observable

interface ListIssuesUseCase {
    operator fun invoke(): Observable<List<Issue>>
}

class ListIssues (
    private val issueRepository: IssueRepository
) : ListIssuesUseCase {
    override fun invoke(): Observable<List<Issue>> {
        return issueRepository.getIssues()
    }
}

