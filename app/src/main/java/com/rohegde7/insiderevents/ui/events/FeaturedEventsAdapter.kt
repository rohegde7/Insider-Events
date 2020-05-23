package com.rohegde7.insiderevents.ui.events

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rohegde7.insiderevents.R
import com.rohegde7.insiderevents.pojo.Featured

class FeaturedEventsAdapter(
    val context: Context,
    val events: ArrayList<Featured>
) :
    RecyclerView.Adapter<FeaturedEventsAdapter.FeaturedEventsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedEventsViewHolder {
        return FeaturedEventsViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.featured_events_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return events.size
    }

    fun updateData(events: List<Featured>) {
        this@FeaturedEventsAdapter.events.clear()
        this@FeaturedEventsAdapter.events.addAll(events)

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FeaturedEventsViewHolder, position: Int) {
        val event = events[position]

        Glide.with(context).load(event.horizontalCoverImage).into(holder.eventImage)
        holder.venueDate.text = event.venueDateString
        holder.venueName.text = event.venueName
        holder.eventPrice.text = "Rs.${event.minPrice}"
        holder.eventName.text = event.name
    }

    class FeaturedEventsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventImage = view.findViewById<ImageView>(R.id.event_image)
        val venueDate = view.findViewById<TextView>(R.id.venue_date)
        val venueName = view.findViewById<TextView>(R.id.venue_name)
        val eventPrice = view.findViewById<TextView>(R.id.price)
        val eventName = view.findViewById<TextView>(R.id.event_name)
    }
}