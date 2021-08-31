package dev.mauricifj.github_kotlin_issues.domain.usecase

import dev.mauricifj.github_kotlin_issues.data.repository.GithubRepository
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import dev.mauricifj.github_kotlin_issues.utils.IssueList
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test

private val mockRepository: GithubRepository = mockk()

class ListIssuesTest {
    @Test
    fun `Given repository is ok When ListIssues is invoked Then IssueList is returned`() {
        every { mockRepository.getIssues() } returns
                Observable.fromArray(IssueList())

        val sut = ListIssues(mockRepository)
        val observer = TestObserver.create<List<Issue>>()

        sut().subscribe(observer)

        observer.assertComplete()
        observer.assertValueCount(1)
        observer.assertValues(IssueList())
    }

    @Test
    fun `Given repository returns empty list When ListIssues is invoked Then empty list is returned`() {
        every { mockRepository.getIssues() } returns Observable.fromIterable(listOf())

        val sut = ListIssues(mockRepository)
        val observer = TestObserver.create<List<Issue>>()

        sut().subscribe(observer)

        observer.assertComplete()
        observer.assertNoValues()
    }
}