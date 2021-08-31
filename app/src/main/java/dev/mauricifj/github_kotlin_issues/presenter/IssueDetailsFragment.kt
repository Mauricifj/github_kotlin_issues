package dev.mauricifj.github_kotlin_issues.presenter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dev.mauricifj.github_kotlin_issues.R
import dev.mauricifj.github_kotlin_issues.databinding.FragmentIssueDetailsBinding
import dev.mauricifj.github_kotlin_issues.presenter.model.IssueUi
import kotlinx.serialization.json.Json
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent
import android.net.Uri
import dev.mauricifj.github_kotlin_issues.data.api.IssueState
import dev.mauricifj.github_kotlin_issues.utils.getColorsFromState


class IssueDetailsFragment : Fragment() {
    private var _binding: FragmentIssueDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<IssueDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIssueDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val issue = Json.decodeFromString(IssueUi.serializer(), args.issueUi)

        with(binding) {
            val (textColor, backgroundColor) = getColorsFromState(root.context, issue.state)

            state.setTextColor(textColor)
            state.setChipBackgroundColorResource(backgroundColor)

            title.text = issue.title
            description.text = issue.description
            user.text = issue.user
            issueDetailsToolbar.title = "ISSUE #${issue.id}"
            createdAt.text = formatCreatedAt(issue.createdAt)
            state.text = issue.state.value

            btnGoToIssuePage.setOnClickListener {
                val url = issue.url
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            issueDetailsToolbar.setNavigationOnClickListener { findNavController().popBackStack() }

            Glide.with(this@IssueDetailsFragment)
                .load(issue.avatar)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.image_not_found)
                .override(194)
                .circleCrop()
                .into(avatar)
        }
        return view
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SimpleDateFormat")
    private fun formatCreatedAt(createdAt: String)  : String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val outputFormat = SimpleDateFormat("dd/MM/yyyy - HH:mm:ss")
        val date: Date = inputFormat.parse(createdAt)
        return outputFormat.format(date)
    }
}