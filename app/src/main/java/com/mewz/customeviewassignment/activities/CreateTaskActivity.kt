package com.mewz.customeviewassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mewz.customeviewassignment.R
import com.mewz.customeviewassignment.adapter.ProfileImageAdapter
import com.mewz.customeviewassignment.adapter.ProfileImageItemOverlap
import com.mewz.customeviewassignment.adapter.TaskAdapter
import com.mewz.customeviewassignment.databinding.ActivityCreateTaskBinding
import com.mewz.customeviewassignment.delegate.ProfileItemDelegate

class CreateTaskActivity : AppCompatActivity(), ProfileItemDelegate {

    private lateinit var binding: ActivityCreateTaskBinding
    private lateinit var mProfileImageAdapter: ProfileImageAdapter

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,CreateTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Removing Status bar color while showing dialog
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setUpRecyclerView()
        setUpChipListener()
        setUpListeners()
    }

    private fun setUpChipListener() {
        binding.chipDesign.setOnClickListener {
            if(binding.chipDesign.isChecked) {
                binding.chipDesign.setChipBackgroundColorResource(R.color.colorAccent)
            } else {
                binding.chipDesign.setChipBackgroundColorResource(android.R.color.transparent)
            }
        }

        binding.chipFrontend.setOnClickListener {
            if(binding.chipFrontend.isChecked) {
                binding.chipFrontend.setChipBackgroundColorResource(R.color.colorAccent)
            } else {
                binding.chipFrontend.setChipBackgroundColorResource(android.R.color.transparent)
            }
        }

        binding.chipBackend.setOnClickListener {
            if(binding.chipBackend.isChecked) {
                binding.chipBackend.setChipBackgroundColorResource(R.color.colorAccent)
            } else {
                binding.chipBackend.setChipBackgroundColorResource(android.R.color.transparent)
            }
        }
    }

    private fun setUpListeners() {
        binding.btnBackTask.setOnClickListener {
            finish()
        }

    }

    private fun setUpRecyclerView() {
        mProfileImageAdapter = ProfileImageAdapter(this)
        binding.rvProfileImage.adapter = mProfileImageAdapter
        binding.rvProfileImage.addItemDecoration(ProfileImageItemOverlap())
        binding.rvProfileImage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onTapTask() {

    }

    override fun onTapProfileDetail() {
        startActivity(ProfileActivity.newIntent(this))
    }
}