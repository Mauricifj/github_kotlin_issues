package dev.mauricifj.github_kotlin_issues.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.mauricifj.github_kotlin_issues.databinding.ListItemIssueBinding
import dev.mauricifj.github_kotlin_issues.presenter.model.IssueUi
import dev.mauricifj.github_kotlin_issues.utils.getColorsFromState

class IssueListAdapter(val event:MutableLiveData<IssueListEvent> = MutableLiveData()): ListAdapter<IssueUi, IssueListAdapter.IssueViewHolder>(IssueDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val itemView = ListItemIssueBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return IssueViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        getItem(position).let { issueUi ->
            with(holder.binding) {
                title.text = issueUi.title
                state.text = issueUi.state.value
                user.text = issueUi.user

                val (textColor, backgroundColor) = getColorsFromState(root.context, issueUi.state)

                state.setTextColor(textColor)
                state.setChipBackgroundColorResource(backgroundColor)

                root.setOnClickListener {
                    event.postValue(IssueListEvent.OnIssueClick(root.findFragment<IssueListFragment>(), issueUi))
                }
            }
        }
    }

    inner class IssueViewHolder(val binding: ListItemIssueBinding) : RecyclerView.ViewHolder(binding.root)
}

class IssueDiffUtilCallback : DiffUtil.ItemCallback<IssueUi>() {
    override fun areItemsTheSame(oldItem: IssueUi, newItem: IssueUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: IssueUi, newItem: IssueUi): Boolean {
        return oldItem.id == newItem.id
    }
}