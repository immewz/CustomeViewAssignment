package com.mewz.customeviewassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mewz.customeviewassignment.R
import com.mewz.customeviewassignment.delegate.ProfileItemDelegate
import com.mewz.customeviewassignment.views.viewholders.TaskViewHolder

class TaskAdapter(private val delegate: ProfileItemDelegate):RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pod_task, parent, false)
        return TaskViewHolder(view.rootView, delegate)
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
    }
}