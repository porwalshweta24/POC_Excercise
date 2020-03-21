package com.core.poc

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

/**
 * [CTSPOCApp] :
 *
 * Main Application class as entry point to this app, on create simply set context variable from companion object
 * that can be used further in app.
 *
 * For example, see [CTSPOCApp.getContext]
 *
 * @author : Shweta Porwal
 * @version 1.0.0
 * @since 03/21/2020
 *
 * @see Application
 */
class CTSPOCApp : Application() {
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }

        @Volatile
        @JvmStatic
        private lateinit var context: CTSPOCApp

        /**
         * Provides context or throw [UninitializedPropertyAccessException] if it's not initialized yet.
         */
        @Throws
        fun getContext(): Context =
            if (this::context.isInitialized) context
            else throw UninitializedPropertyAccessException("Context is null, did you forget to initialize it?")
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}