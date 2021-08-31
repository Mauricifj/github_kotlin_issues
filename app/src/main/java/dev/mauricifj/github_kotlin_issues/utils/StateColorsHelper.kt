package dev.mauricifj.github_kotlin_issues.utils

import android.content.Context
import dev.mauricifj.github_kotlin_issues.R
import dev.mauricifj.github_kotlin_issues.data.api.IssueState

fun getColorsFromState(context: Context, state: IssueState) =
    when (state) {
        IssueState.Open -> listOf(context.resources.getColor(R.color.issue_open_state_text), R.color.issue_open_state_background)
        else -> listOf(context.resources.getColor(R.color.issue_closed_state_background), R.color.issue_closed_state_text)
    }