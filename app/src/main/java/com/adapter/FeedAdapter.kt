package com.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.twitterui.R
import com.google.android.material.imageview.ShapeableImageView
import com.model.Post

class FeedAdapter(var context: Context, var items: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val ONE_IMAGE = 0
    private val TWO_IMAGE = 1
    private val VIDEO = 2
    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 3 == 1) {
            return ONE_IMAGE
        } else if (position % 2 == 0) {
            return TWO_IMAGE
        }
        return VIDEO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ONE_IMAGE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
            return FeedViewHolderOneImage(view)
        } else if(viewType == TWO_IMAGE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_two_image, parent, false)
            return FeedViewHolderTwoImage(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_video, parent, false)
        return FeedViewHolderVideo(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is FeedViewHolderOneImage) {
            var iv_profile = holder.iv_profile
            var iv_post = holder.iv_post
            var tv_fullname = holder.tv_fullname


            Glide.with(context).load(feed.profile).into(holder.iv_profile)
            Glide.with(context).load(feed.photo_1).into(holder.iv_post)
            tv_fullname.text = feed.fullname
        }else if(holder is FeedViewHolderTwoImage){
            var iv_profile = holder.iv_profile
            var iv_post_1 = holder.iv_post_1
            var iv_post_2 = holder.iv_post_2
            var tv_fullname = holder.tv_fullname


            Glide.with(context).load(feed.profile).into(holder.iv_profile)
            Glide.with(context).load(feed.photo_1).into(holder.iv_post_1)
            Glide.with(context).load(feed.photo_2).into(holder.iv_post_2)
            tv_fullname.text = feed.fullname
        }
        else if(holder is FeedViewHolderVideo){
            var iv_profile = holder.iv_profile
            var iv_post_video = holder.iv_post_video
            var tv_fullname = holder.tv_fullname

            iv_post_video.setVideoURI(Uri.parse(feed.video))
            val mediaController = MediaController(context)
            mediaController.setAnchorView(iv_post_video);
            mediaController.setMediaPlayer(iv_post_video);
            iv_post_video.setMediaController(mediaController);
            iv_post_video.requestFocus(1)

            iv_post_video.start()
        }

    }

    class FeedViewHolderOneImage(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.iv_post)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }

    }
    class FeedViewHolderTwoImage(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post_1: ShapeableImageView
        var iv_post_2: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post_1 = view.findViewById(R.id.iv_post_1)
            iv_post_2 = view.findViewById(R.id.iv_post_2)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }

    }
    class FeedViewHolderVideo(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post_video: VideoView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post_video = view.findViewById(R.id.iv_post_video)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }

    }
}