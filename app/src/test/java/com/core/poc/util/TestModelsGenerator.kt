package com.core.poc.util

import com.core.poc.feed.model.FeedInfoDto
import com.core.poc.feed.model.FeedListDto
import com.google.gson.Gson
import java.io.File
import java.util.*

/**
 * Created by AhmedEltaher
 */

class TestModelsGenerator {

    private var feedListDto : FeedListDto

    init {
        val gson = Gson()
        val jsonString = getJson("NewsApiResponse.json")
        feedListDto = gson.fromJson(jsonString, FeedListDto::class.java)
    }

    fun generateFeedListDto(): FeedListDto {
        return feedListDto
    }

    fun generateFeedListDtoWithEmptyList(): FeedListDto {
        feedListDto.feedsList = ArrayList()
        return feedListDto
    }

    fun generateFeedInfoDto(): FeedInfoDto? {
        return feedListDto.feedsList?.get(0)
    }

    fun getStupTitle(): String? {
        return feedListDto.feedsList?.get(0)?.mTitle
    }


    /**
     * Helper function which will load JSON from
     * the path specified
     *
     * @param path : Path of JSON file
     * @return json : JSON from file at given path
     */

    private fun getJson(path: String): String {
        // Load the JSON response
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path)
        return String(file.readBytes())
    }
}
