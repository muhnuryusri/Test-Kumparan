package com.example.testkumparan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testkumparan.adapter.PostAdapter
import com.example.testkumparan.data.DataCallback
import com.example.testkumparan.data.entity.CommentEntity
import com.example.testkumparan.data.entity.PostEntity
import com.example.testkumparan.databinding.ActivityMainBinding
import com.example.testkumparan.viewmodel.PostViewModel
import com.example.testkumparan.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity(), DataCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]
        postViewModel.getPostList().observe(this, { listPost ->
            binding.rvPost.adapter?.let { adapter ->
                when (adapter) {
                    is PostAdapter -> adapter.setData(listPost)
                }
            }
        })
        showRecyclerList()
    }

    private fun showRecyclerList() {
        adapter = PostAdapter(this)

        binding.rvPost.layoutManager = LinearLayoutManager(this)
        binding.rvPost.adapter = adapter
    }

    override fun onPostClicked(data: PostEntity) {
        val intent = Intent(this, DetailPostActivity::class.java)
        intent.putExtra(DetailPostActivity.EXTRA_DATA, data.id)
        startActivity(intent)
    }

    override fun onCommentClicked(comment: CommentEntity) {
        TODO("Not yet implemented")
    }
}