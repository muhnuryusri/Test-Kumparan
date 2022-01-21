package com.example.testkumparan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testkumparan.adapter.CommentAdapter
import com.example.testkumparan.data.DataCallback
import com.example.testkumparan.data.entity.CommentEntity
import com.example.testkumparan.data.entity.DetailPostEntity
import com.example.testkumparan.data.entity.PostEntity
import com.example.testkumparan.databinding.ActivityDetailPostBinding
import com.example.testkumparan.viewmodel.CommentViewModel
import com.example.testkumparan.viewmodel.DetailPostViewModel
import com.example.testkumparan.viewmodel.ViewModelFactory

class DetailPostActivity : AppCompatActivity(), DataCallback {
    private lateinit var binding: ActivityDetailPostBinding
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var detailPostViewModel: DetailPostViewModel
    private lateinit var commentViewModel: CommentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        detailPostViewModel = ViewModelProvider(this, factory)[DetailPostViewModel::class.java]
        commentViewModel = ViewModelProvider(this, factory)[CommentViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getInt(EXTRA_DATA, 0)
            detailPostViewModel.getSelectedPost(dataId).observe(this, { detail ->
                populateDataPost(detail)
            })

            commentViewModel.getListComment(dataId).observe(this, { listComment ->
                binding.rvComment.adapter?.let { adapter ->
                    when (adapter) {
                        is CommentAdapter -> adapter.setData(listComment)
                    }
                }
            })
        }

        showRecyclerList()
    }

    private fun showRecyclerList() {
        commentAdapter = CommentAdapter(this)

        binding.rvComment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvComment.adapter = commentAdapter
    }

    @SuppressLint("SetTextI18n")
    private fun populateDataPost(post: DetailPostEntity) {
        binding.tvTitle.text = post.title
        binding.tvBody.text = post.body
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onPostClicked(data: PostEntity) {
        TODO("Not yet implemented")
    }

    override fun onCommentClicked(comment: CommentEntity) {
        TODO("Not yet implemented")
    }
}