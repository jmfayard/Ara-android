/*
 * Copyright (c) 2019. Fulton Browne
 *  This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.andromeda.ara

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.animation.AlphaAnimation




class Adapter
//private final OnItemClickListener listener;

(private val mRssFeedModels: List<RssFeedModel> //= MainActivity.RssClass.getFeedList();
) : RecyclerView.Adapter<Adapter.FeedModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): FeedModelViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)

        return FeedModelViewHolder(v)
    }



    override fun onBindViewHolder(holder: FeedModelViewHolder, position: Int) {
        val rssFeedModel = mRssFeedModels[position]

        //(holder.rssFeedView.card.cardBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary)))
        (holder.rssFeedView.findViewById<View>(R.id.item_number) as TextView).text = rssFeedModel.description
        (holder.rssFeedView.findViewById<View>(R.id.content) as TextView).text = rssFeedModel.title
        (holder.rssFeedView.findViewById<View>(R.id.url2) as TextView).text = rssFeedModel.link
        setFadeAnimation(holder.itemView)
        /** if (rssFeedModel.image !== "") {
            var `is`: InputStream? = null
            try {
                `is` = URL(rssFeedModel.image).content as InputStream
            } catch (e: IOException) {
                e.printStackTrace()
            }

            val draw = Drawable.createFromStream(`is`, "src name")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        holder.rssFeedView.findViewById<View>(R.id.item_image_view).clipToOutline = true
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        holder.rssFeedView.findViewById<View>(R.id.item_image_view).foreground = draw
        }
        }**/
        //((TextView)holder.rssFeedView.findViewById(R.id.item_number)).setText(R.string.test);
        //((TextView)holder.rssFeedView.findViewById(R.id.content)).setText(R.string.test);
        //((TextView)holder.rssFeedView.findViewById(R.id.url2)).setText(R.string.test);
    }

    override fun getItemCount(): Int {
        return mRssFeedModels.size
        //return 1;
    }
    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        view.startAnimation(anim)
    }

    class FeedModelViewHolder(val rssFeedView: View) : RecyclerView.ViewHolder(rssFeedView)
}

