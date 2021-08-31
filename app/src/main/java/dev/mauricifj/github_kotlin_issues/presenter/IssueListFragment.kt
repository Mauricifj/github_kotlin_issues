package dev.mauricifj.github_kotlin_issues.presenter

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import dev.mauricifj.github_kotlin_issues.databinding.FragmentIssueListBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import dev.mauricifj.github_kotlin_issues.R

class IssueListFragment : Fragment() {
    private val viewModel: IssuesViewModel by sharedViewModel()
    private lateinit var binding: FragmentIssueListBinding
    private lateinit var adapter: IssueListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssueListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvIssues.adapter = null
    }

    override fun onStart() {
        super.onStart()
        setLoadingVisibility(true)
        setUpAdapter()
        observeViewModel()
    }

    private fun setUpAdapter() {
        adapter = IssueListAdapter()
        adapter.event.observe(
            viewLifecycleOwner,
            Observer {
                viewModel.handleEvent(it)
            }
        )
        binding.rvIssues.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.errors.observe(
            viewLifecycleOwner,
            Observer { errorMessage ->
                showErrorState(errorMessage)
            }
        )

        viewModel.issueList.observe(
            viewLifecycleOwner,
            Observer { issueList ->
                adapter.submitList(issueList)

                if (issueList.isNotEmpty()) {
                    setLoadingVisibility(false)
                } else {
                    setMessageText(getString(R.string.message_empty_list))
                    setMessageVisibility(true)
                }
            }
        )

        viewModel.handleEvent(IssueListEvent.OnStart)
    }

    private fun showErrorState(errorMessage: String) = Toast.makeText(this.context, errorMessage, Toast.LENGTH_SHORT)

    private fun setLoadingVisibility(visible: Boolean) {
        if (visible) {
            binding.loadingSpinner.show()
            binding.loader.visibility = View.VISIBLE
        } else {
            binding.loadingSpinner.hide()
            binding.loader.visibility = View.GONE
        }
    }

    private fun setMessageVisibility(visible: Boolean) {
        binding.issueListMessage.visibility = if (visible) View.VISIBLE else View.GONE
    }

    private fun setMessageText(text: String) {
        binding.issueListMessage.text = text
    }

}