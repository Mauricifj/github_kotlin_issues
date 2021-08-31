package dev.mauricifj.github_kotlin_issues

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class IssuesActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issues)
        setTheme(R.style.Theme_Github_kotlin_issues)
    }
}