package com.core.poc.feed.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.core.poc.database.CTSPOCDbContract
import com.core.poc.feed.model.FeedInfoDto

/**
 * [FeedDao] :
 *
 * Interface provided to expose some method related to CRUD operations on database for [FeedInfoDto]
 *
 * @author Shweta Porwal
 * @since 03/21/2020
 * @version 1.0.0
 */
@Dao
interface FeedDao {
    /**
     * insert all feeds to the database, replace entries on conflict
     *
     * @param feeds as [List] of [FeedInfoDto]s object
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllFeeds(feeds: List<FeedInfoDto?>): List<Long?>

    /**
     * Get list of [FeedInfoDto] from local db
     *
     * @return list of [FeedInfoDto]
     */
    @Query("SELECT * FROM ${CTSPOCDbContract.FEEDS_TABLE_NAME}")
    fun getAllFeeds(): MutableList<FeedInfoDto?>?

    /**
     *  get count (no of rows) from the table [CTSPOCDbContract.FEEDS_TABLE_NAME]
     *
     *  @return count: [Long] number of rows present in table
     */
    @Query("SELECT COUNT(${CTSPOCDbContract.COLUMN_FEED_ID}) FROM ${CTSPOCDbContract.FEEDS_TABLE_NAME}")
    fun getFeedsCount(): Long

    /**
     * Clear table [CTSPOCDbContract.FEEDS_TABLE_NAME]
     */
    @Query("DELETE FROM ${CTSPOCDbContract.FEEDS_TABLE_NAME}")
    fun clearFeedsTable()
}