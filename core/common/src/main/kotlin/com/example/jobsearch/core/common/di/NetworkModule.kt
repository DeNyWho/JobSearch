package com.example.jobsearch.core.common.di

import com.example.jobsearch.core.common.util.network.ConnectivityManagerNetworkMonitor
import com.example.jobsearch.core.common.util.network.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

}