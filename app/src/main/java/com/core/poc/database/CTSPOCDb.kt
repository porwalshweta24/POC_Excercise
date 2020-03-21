package com.core.poc.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.core.poc.CTSPOCApp
import com.core.poc.feed.data.FeedDao
import com.core.poc.feed.model.FeedInfoDto

/**
 * [CTSPOCDb] :
 *
 * Main Database class defined to provide and store data using [FeedDao] for [RoomDatabase] as ORM help for this project.
 * So, basically, it manages `Room` object INSTANCE and helps you provide [feedDao] to connect local SQLite db for feeds related operations.
 *
 * @author Shweta Porwal
 * @since 03/21/2020
 * @version 1.0.0
 *
 * @see RoomDatabase
 */
@Database(
    entities = [FeedInfoDto::class],
    version = CTSPOCDbContract.DB_VERSION
)
abstract class CTSPOCDb : RoomDatabase() {
    private object Holder {
        val INSTANCE = with(CTSPOCApp.getContext()) {
            Room.databaseBuilder(
                this,
                CTSPOCDb::class.java,
                CTSPOCDbContract.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()

        }
    }

    companion object {
        // Tag for logcat.
        const val TAG = "CTSPOCDb"

        /**
         * Singleton INSTANCE of [CTSPOCDb]
         */
        val INSTANCE: CTSPOCDb? by lazy { Holder.INSTANCE }

    }

    /**
     * Main Feeds DataAccessObject to handle local db connections using interface APIs
     */
    abstract val feedDao: FeedDao
}