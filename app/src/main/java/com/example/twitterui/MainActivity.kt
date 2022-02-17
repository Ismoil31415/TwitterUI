package com.example.twitterui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adapter.FeedAdapter
import com.adapter.StoryAdapter
import com.model.Post
import com.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerStory: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFeed = findViewById<RecyclerView>(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)
        recyclerStory = findViewById<RecyclerView>(R.id.recyclerStory)
        recyclerStory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun getAllFeeds(): ArrayList<Post> {
        val feeds: ArrayList<Post> = ArrayList<Post>()
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644943013701-b0112e8f58d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMDZ8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
                feeds.add(
            Post(
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "https://images.unsplash.com/photo-1644943013701-b0112e8f58d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMDZ8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644982652061-df82282e178d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxMTN8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644943013701-b0112e8f58d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMDZ8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "https://images.unsplash.com/photo-1644943013701-b0112e8f58d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMDZ8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644982652061-df82282e178d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxMTN8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644943013701-b0112e8f58d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMDZ8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644982652061-df82282e178d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxMTN8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        feeds.add(
            Post(
                "https://images.unsplash.com/photo-1640622661487-b78d06f91d66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                "Ibragimov Ismoil",
                "https://images.unsplash.com/photo-1553272725-086100aecf5e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1530&q=80",
                "https://images.unsplash.com/photo-1644982652061-df82282e178d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxMTN8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                "https://player.vimeo.com/progressive_redirect/playback/183629075/rendition/360p?loc=external&oauth2_token_id=1027659655&signature=236bd56aa7f22c87808dd77d0817309af997dce65e5ac7b99a395492a822e84c"
            )
        )
        return feeds
    }

    private fun getAllFilters(): ArrayList<Story> {
        val filters: ArrayList<Story> = ArrayList<Story>()
        filters.add(Story(R.drawable.im_user_1, "Ismoil"))
        filters.add(Story(R.drawable.im_user_3, "Ismoil"))
        filters.add(Story(R.drawable.im_user_2, "Ismoil"))
        filters.add(Story(R.drawable.im_user_3, "Ismoil"))
        filters.add(Story(R.drawable.im_user_1, "Ismoil"))
        filters.add(Story(R.drawable.im_user_2, "Ismoil"))
        filters.add(Story(R.drawable.im_user_3, "Ismoil"))
        filters.add(Story(R.drawable.im_user_2, "Ismoil"))
        filters.add(Story(R.drawable.im_user_1, "Ismoil"))
        filters.add(Story(R.drawable.im_user_3, "Ismoil"))
        filters.add(Story(R.drawable.im_user_2, "Ismoil"))
        filters.add(Story(R.drawable.im_user_1, "Ismoil"))
        filters.add(Story(R.drawable.im_user_3, "Ismoil"))
        filters.add(Story(R.drawable.im_user_2, "Ismoil"))
        filters.add(Story(R.drawable.im_user_1, "Ismoil"))
        return filters
    }

    private fun refreshFeedAdapter(feeds: ArrayList<Post>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed.adapter = adapter
    }

    private fun refreshStoryAdapter(chats: ArrayList<Story>) {
        val adapter = StoryAdapter(this, chats)
        recyclerStory.adapter = adapter
    }

}