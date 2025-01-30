package com.example.jobsearch.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.example.jobsearch.lint.designsystem.DesignSystemDetector

class JobSearchIssueRegistry : IssueRegistry() {

    override val issues = listOf(
        DesignSystemDetector.ISSUE,
        TestMethodNameDetector.FORMAT,
        TestMethodNameDetector.PREFIX,
    )

    override val api: Int = CURRENT_API

    override val minApi: Int = 13

    override val vendor: Vendor = Vendor(
        vendorName = "Anifox",
        feedbackUrl = "https://github.com/DeNyWho/AnifoxAndroid/issues",
        contact = "https://github.com/DeNyWho/AnifoxAndroid",
    )
}