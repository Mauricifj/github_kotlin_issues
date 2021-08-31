package dev.mauricifj.github_kotlin_issues.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.mauricifj.github_kotlin_issues.data.api.IssueApi
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import dev.mauricifj.github_kotlin_issues.utils.IssueList
import dev.mauricifj.github_kotlin_issues.utils.IssueResponseList
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

private val mockApi: IssueApi = mockk()

class GithubRepositoryTest {
    @Test
    fun `Given api is ok When getIssues is called Then IssueList is returned`() {
        every { mockApi.getIssues(any()) } returns
                Observable.fromArray( IssueResponseList() )

        val sut = GithubRepository(service = mockApi)
        val observer = TestObserver.create<List<Issue>>()

        sut.getIssues().subscribe(observer)

        observer.assertComplete()
        observer.assertValueCount(1)
        observer.assertValues(IssueList())
    }

    @Test
    fun `Given api returns empty list When getIssues is called Then empty list is returned`() {
        every { mockApi.getIssues(any()) } returns Observable.fromIterable(listOf())

        val sut = GithubRepository(service = mockApi)
        val observer = TestObserver.create<List<Issue>>()

        sut.getIssues().subscribe(observer)

        observer.assertNoValues()
        observer.assertComplete()
    }
}