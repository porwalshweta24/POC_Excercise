package com.core.poc.feed.view

import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.core.poc.BR
import com.core.poc.R
import com.core.poc.databinding.ActivityFeedBinding
import com.core.poc.feed.model.FeedInfoDto
import com.core.poc.core.AbstractBinding
import com.core.poc.core.adapters.BindingRecyclerAdapter

/**
 * [FeedsActivityBinder] :
 *
 * [AbstractBinding] class provides data-binding logic to particular view to move UI logic off the Activity/Fragment.
 * This binder binds list of `Feeds` to `RecyclerView` and handles swipe refresh states.
 *
 * @author : Shweta Porwal
 * @version 1.0.0
 * @since 10/16/2019
 *
 * @see AbstractBinding
 */
class FeedsActivityBinder() : AbstractBinding<ActivityFeedBinding>(),
    SwipeRefreshLayout.OnRefreshListener {

    /**
     * Variable as Lambda method expression to handle swipe refresh callback
     */
    var onRefreshCallback: (() -> Unit)? = null
    /**
     * Observable field handles state of `SwipeRefreshLayout` with the pair of Booleans.
     */
    val swipeProgress: ObservableField<Pair<Boolean?, Boolean?>> =
        ObservableField(Pair(first = true, second = false))
    /**
     * Adapter class object for `RecyclerView`
     */
    var feedsAdapter: BindingRecyclerAdapter? = null

    override fun onCreated() {
        binding?.data = this
        setUpRecyclerView()
    }

    /**
     * Method basically setup new `RecyclerView` & it's `Adapter`
     */
    private fun setUpRecyclerView() {
        feedsAdapter = BindingRecyclerAdapter.Builder()
            .setLayoutResId(R.layout.item_feed_layout)
            .onBindViewHolderCallback { holder, _, adapter ->
                val feed = adapter.list[holder.adapterPosition] as? FeedInfoDto
                holder.binding.setVariable(BR.feed, feed)
            }
            .build()
        binding?.rvFeeds?.adapter = feedsAdapter
    }

    /**
     * Set [RecyclerView.LayoutManager] passed from input [layoutManager] on `RecyclerView`
     *
     * @param layoutManager as type of [RecyclerView.LayoutManager] to be set
     */
    fun setRecyclerLayoutManager(layoutManager: RecyclerView.LayoutManager) {
        binding?.rvFeeds?.layoutManager = layoutManager
    }

    /**
     * Decide to whether shoe/hide `SwipeRefreshLayout` based on [show] flag
     *
     * @param show flag to set current state of `RefreshLayout`, default value is **true** meaning it's showing progress.
     */
    fun showSwipeProgress(show: Boolean = true) {
        swipeProgress.set(Pair(first = true, second = show))
    }

    override fun onRefresh() {
        onRefreshCallback?.invoke()
    }

    override fun onDestroy() {
        binding?.data = null
    }
}