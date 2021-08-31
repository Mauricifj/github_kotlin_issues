package dev.mauricifj.github_kotlin_issues.presenter

import RxImmediateSchedulerRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.mauricifj.github_kotlin_issues.domain.usecase.ListIssuesUseCase
import dev.mauricifj.github_kotlin_issues.utils.IssueList
import dev.mauricifj.github_kotlin_issues.utils.IssueUiList
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import junit.framework.TestCase.assertEquals
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test

private val listIssuesMock: ListIssuesUseCase = mockk()

class IssuesViewModelTest {
    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Test
    fun `Given UseCase is ok When GetIssues is called Then IssueList is returned`() {
        every { listIssuesMock() } returns
                Observable.fromArray(IssueList())

        val sut = IssuesViewModel(listIssuesMock)

        sut.handleEvent(IssueListEvent.OnStart)

        assertEquals(
            IssueUiList(),
            sut.issueList.value
        )
    }
}
