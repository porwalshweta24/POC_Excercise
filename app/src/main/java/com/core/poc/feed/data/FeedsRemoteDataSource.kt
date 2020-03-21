package com.core.poc.feed.data

import com.core.poc.BuildConfig
import com.core.poc.CTSPOCApp
import com.core.poc.api.FeedsApi
import com.core.poc.feed.model.FeedListDto
import com.core.poc.core.api.*
import com.core.poc.core.isNetworkConnected

/**
 * [FeedsRemoteDataSource] :
 *
 * Remote connection provider for feeds repository, basically performs network API call asynchronously
 * and provides list of feeds as callback result, see method [FeedsRemoteDataSource.getFeeds]
 *
 * @author : Shweta Porwal
 * @version 1.0.0
 * @since 03/21/2020
 *
 * @see FeedsApi
 */
class FeedsRemoteDataSource {
    object HOLDER {
        val instance = FeedsRemoteDataSource()
    }

    companion object {
        /**
         * Provides Singleton object [FeedsRemoteDataSource]
         */
        @JvmStatic
        fun getInstance() = HOLDER.instance
    }

    /**
     * Provides API connection object as [FeedsApi] for Retrofit setup
     *
     * @see provideApiService
     */
    private val mApiService by lazy {
        return@lazy provideApiService<FeedsApi?>(BuildConfig.BASE_URL) {}
    }

    /**
     * Get list of feeds from API end asynchronously and provides result to [onFeedsCallback] as
     * lambda method parameter
     *
     * @param onFeedsCallback receives result from network async and forward it to observer.
     */
    fun getFeeds(onFeedsCallback: (ResultResponse<FeedListDto?>?) -> Unit) {
        if (CTSPOCApp.getContext().isNetworkConnected()) {
            mApiService?.getFeedsDetails().enqueueOn().success { _, response ->
                when {
                    response.isSuccessful && response.code() == 200 -> {
                        onFeedsCallback(ResultResponse.Success(response.body()))
                    }
                    else -> {
                        onFeedsCallback(ResultResponse.ErrorMessage(response.errorBody()))
                    }
                }
            } failure { _, t ->
                onFeedsCallback(ResultResponse.Error(t))
            }
        } else
            onFeedsCallback(ResultResponse.NoConnection())
    }
}