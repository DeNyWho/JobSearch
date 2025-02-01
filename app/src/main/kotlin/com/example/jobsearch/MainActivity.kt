package com.example.jobsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jobsearch.core.common.util.network.NetworkMonitor
import com.example.jobsearch.core.uikit.theme.JobSearchTheme
import com.example.jobsearch.ui.JobSearchApp
import com.example.jobsearch.ui.rememberJobSearchAppState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val appState = rememberJobSearchAppState(
                networkMonitor = networkMonitor,
            )

            JobSearchTheme {
                JobSearchApp(appState)
            }
        }
    }
}
