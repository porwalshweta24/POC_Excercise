package com.core.poc.feed.data

import com.core.poc.CTSPOCApp
import com.core.poc.database.CTSPOCDb
import com.core.poc.feed.model.FeedInfoDto
import com.core.poc.core.getDefaultPreference
import com.core.poc.core.getValue
import com.core.poc.core.putValue
import com.core.poc.core.runInBackground

/**
 * [FeedsLocalDataSource] :
 *
 * Local data source file handles communication between Repository and Database/SharedPreference by
 * providing business logic to it.
 *
 * @author : Shweta Porwal
 * @version 1.0.0
 * @since 03/21/2020
 */
class FeedsLocalDataSource private constructor() : FeedDao {
    object HOLDER {
        val instance = FeedsLocalDataSource()
    }

    private val database by lazy {
        return@lazy CTSPOCDb.INSTANCE
    }

    companion object {
        const val PREF_KEY_TITLE = "title"

        /**
         * Provides Singleton INSTANCE of [FeedsLocalDataSource]
         */
        @JvmStatic
        fun getInstance() = HOLDER.instance
    }

    override fun getAllFeeds(): MutableList<FeedInfoDto?>? {
        return database?.feedDao?.runInBackground { getAllFeeds() }
    }

    override fun addAllFeeds(feeds: List<FeedInfoDto?>): List<Long?> {
        return database?.feedDao?.runInBackground {
            if (feeds.isNullOrEmpty().not()) {
                clearFeedsTable()
                addAllFeeds(feeds)
            } else emptyList()
        } ?: emptyList()
    }

    override fun clearFeedsTable() {
        database?.feedDao?.runInBackground { clearFeedsTable() }
    }

    override fun getFeedsCount(): Long {
        return database?.feedDao?.runInBackground { getFeedsCount() } ?: 0
    }

    /**
     * Store `title` to shared preference to set it on UI when local data requested
     */
    fun saveTitle(title: String?) {
        CTSPOCApp.getContext().getDefaultPreference()
            .putValue(PREF_KEY_TITLE, title)
    }

    /**
     * Return title saved in SharedPreference
     *
     * @return [String] as title or empty if null
     */
    fun getTitle(): String {
        return CTSPOCApp.getContext().getDefaultPreference().getValue(PREF_KEY_TITLE) ?: ""
    }
}

