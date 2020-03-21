package com.core.poc.database

import com.core.poc.feed.model.FeedInfoDto

/**
 * [CTSPOCDbContract] :
 *
 * Data contract class that provides constant data related to [CTSPOCDb] & it's related entity models.
 *
 * List of the constants are as below:
 *   1. [CTSPOCDbContract.DB_VERSION]
 *   2. [CTSPOCDbContract.NEW_DB_VERSION]
 *   3. [CTSPOCDbContract.DB_NAME]
 *   4. [CTSPOCDbContract.FEEDS_TABLE_NAME]
 *   5. [CTSPOCDbContract.COLUMN_FEED_ID]
 *   6. [CTSPOCDbContract.COLUMN_FEED_TITLE]
 *   7. [CTSPOCDbContract.COLUMN_FEED_DESCRIPTION]
 *   8. [CTSPOCDbContract.COLUMN_FEED_URL]
 *
 * @author Shweta Porwal
 * @since 03/21/2020
 * @version 1.0.0
 */
class CTSPOCDbContract {
    companion object {
        // Tag for logcat.
        const val TAG = "CTSPOCDbContract"
        /**
         * defines database version for [CTSPOCDb]
         */
        const val DB_VERSION = 1
        /**
         * defines new database version for [CTSPOCDb] migration
         */
        const val NEW_DB_VERSION = 1
        /**
         * defines database name for [CTSPOCDb]
         */
        const val DB_NAME = "CTSPOCApp"

        /**
         * defines Feeds table name for [FeedInfoDto]
         */
        const val FEEDS_TABLE_NAME = "Feeds"

        /**
         * defines column name `id` for [FeedInfoDto]
         */
        const val COLUMN_FEED_ID = "id"
        /**
         * defines column name `title` for [FeedInfoDto]
         */
        const val COLUMN_FEED_TITLE = "title"
        /**
         * defines column name `description` for [FeedInfoDto]
         */
        const val COLUMN_FEED_DESCRIPTION = "description"
        /**
         * defines column name `image_url` for [FeedInfoDto]
         */
        const val COLUMN_FEED_URL = "image_url"
    }
}