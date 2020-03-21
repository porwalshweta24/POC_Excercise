package com.core.poc.api

import com.core.poc.feed.model.FeedListDto
import retrofit2.Call
import retrofit2.http.GET

/**
 * [FeedsApi] :
 *
 * Feeds API interface provides method for Retrofit endpoint connection as RESTFul APIs
 *
 * @author : Shweta Porwal
 * @version 1.0.0
 * @since 03/21/2020
 */

interface FeedsApi {
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getFeedsDetails(): Call<FeedListDto?>
}