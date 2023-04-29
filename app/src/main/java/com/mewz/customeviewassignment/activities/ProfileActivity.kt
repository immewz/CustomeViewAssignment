package com.mewz.customeviewassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mewz.customeviewassignment.adapter.TaskAdapter
import com.mewz.customeviewassignment.databinding.ActivityProfileBinding
import com.mewz.customeviewassignment.delegate.ProfileItemDelegate

class ProfileActivity : AppCompatActivity(), ProfileItemDelegate {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var mTaskAdapter: TaskAdapter

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Removing Status bar color while showing dialog
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setUpTabLayout()
        setUpRecyclerView()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnCancelProfile.setOnClickListener {
            finish()
        }
    }

    private fun setUpRecyclerView() {
        mTaskAdapter = TaskAdapter(this)
        binding.rvTaskProfile.adapter = mTaskAdapter
        binding.rvTaskProfile.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpTabLayout() {
        val tabList = listOf("Project Tasks", "Contacts", "About You", "Jobs")
        tabList.forEach{
            binding.tlTitleProfile.newTab().apply {
                text = it
                binding.tlTitleProfile.addTab(this)
            }
        }
    }

    override fun onTapTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }

    override fun onTapProfileDetail() {

    }
}