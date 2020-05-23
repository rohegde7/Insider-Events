package com.rohegde7.insiderevents.ui.events

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohegde7.insiderevents.R
import com.rohegde7.insiderevents.actionenums.HomeAction
import com.rohegde7.insiderevents.utils.UiUtil
import kotlinx.android.synthetic.main.activity_event_list.*

class EventListActivity : AppCompatActivity() {

    private val mViewModel by viewModels<EventListVM>()
    private val featuredEventsAdapter = FeaturedEventsAdapter(this, ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)

        setUpFeaturedEventsRecyclerView()
        observerLiveData()
        mViewModel.fetchHomeData()
    }

    private fun observerLiveData() {
        mViewModel.homeAction.observe(this, Observer {
            when (it) {
                HomeAction.FETCHING_HOME_DATA -> UiUtil.displayProgress(
                    this,
                    getString(R.string.loading_events)
                )
                HomeAction.HOME_DATA_FETCHED -> onHomeDataFetched()
                HomeAction.FETCHING_HOME_DATA_FAILED -> onHomeDataFetchFail()
            }
        })
    }

    private fun onHomeDataFetched() {
        UiUtil.hideProgress()
        featured_events_tv.visibility = View.VISIBLE
        updateFeaturedEvents()
    }

    private fun onHomeDataFetchFail() {
        UiUtil.hideProgress()

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.oops))
            .setMessage(getString(R.string.data_load_fail_message))
            .setNegativeButton(getString(R.string.retry)) { _, _ ->
                mViewModel.fetchHomeData()
            }
            .setPositiveButton(getString(R.string.ok), null)
            .show()
    }

    private fun setUpFeaturedEventsRecyclerView() {
        val layoutManager = LinearLayoutManager(this)

        featured_events_rv.layoutManager = layoutManager
        featured_events_rv.adapter = featuredEventsAdapter
    }

    private fun updateFeaturedEvents() {
        featuredEventsAdapter.updateData(mViewModel.getFeaturedEvents())
    }
}

