package dev.mauricifj.github_kotlin_issues.presenter

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.findNavController
import dev.mauricifj.github_kotlin_issues.domain.entity.Issue
import dev.mauricifj.github_kotlin_issues.domain.usecase.ListIssuesUseCase
import dev.mauricifj.github_kotlin_issues.presenter.model.IssueUi
import dev.mauricifj.github_kotlin_issues.presenter.model.toUiModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.json.Json

class IssuesViewModel(
    private val listIssues: ListIssuesUseCase
) : ViewModel()  {

    private val issueListState = MutableLiveData<List<IssueUi>>()
    val issueList: LiveData<List<IssueUi>> get() = issueListState

    private val errorsState = MutableLiveData<String>()
    val errors: LiveData<String> get() = errorsState

    fun handleEvent(event: IssueListEvent) {
        when (event) {
            is IssueListEvent.OnStart -> getIssues()
            is IssueListEvent.OnIssueClick -> showIssueDetails(event.fragment, event.issue)
        }
    }

    private fun getIssues() {
        listIssues()
//            .timeout(60, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getObserver())
    }

    private fun getObserver() : Observer<List<Issue>> {
        return object : Observer<List<Issue>> {
            override fun onNext(t: List<Issue>) {
                issueListState.value = t.map { it.toUiModel() }
            }
            override fun onError(e: Throwable) {
                errorsState.value = e.message ?: "Something went wrong"
            }
            override fun onSubscribe(d: Disposable) {}
            override fun onComplete() {}
        }
    }

    private fun showIssueDetails(fragment: Fragment, issue: IssueUi) {
        val json = Json.encodeToString(IssueUi.serializer(), issue)
        val action = IssueListFragmentDirections.actionIssueListToIssuesDetails(json)
        findNavController(fragment).navigate(action)
    }
}

sealed class IssueListEvent {
    data class OnIssueClick(val fragment: Fragment, val issue: IssueUi) : IssueListEvent()
    object OnStart : IssueListEvent()
}