package dev.mauricifj.github_kotlin_issues

import dev.mauricifj.github_kotlin_issues.data.api.IssueApi
import dev.mauricifj.github_kotlin_issues.data.network.Service
import dev.mauricifj.github_kotlin_issues.data.repository.GithubRepository
import dev.mauricifj.github_kotlin_issues.data.repository.InMemoryRepository
import dev.mauricifj.github_kotlin_issues.data.repository.IssueRepository
import dev.mauricifj.github_kotlin_issues.domain.usecase.ListIssues
import dev.mauricifj.github_kotlin_issues.domain.usecase.ListIssuesUseCase
import dev.mauricifj.github_kotlin_issues.presenter.IssuesViewModel
import org.koin.dsl.module

val issuesModule = module {
    single { Service().createService(IssueApi::class.java) }
    single<IssueRepository> { InMemoryRepository(get()) }
    single<ListIssuesUseCase> { ListIssues(get()) }
    single { IssuesViewModel(get()) }
}