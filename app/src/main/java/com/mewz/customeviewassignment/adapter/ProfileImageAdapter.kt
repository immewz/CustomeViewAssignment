package com.mewz.customeviewassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mewz.customeviewassignment.R
import com.mewz.customeviewassignment.delegate.ProfileItemDelegate
import com.mewz.customeviewassignment.views.components.RoundedProfileImage
import com.mewz.customeviewassignment.views.viewholders.ProfileImageViewHolder

class ProfileImageAdapter(private val delegate: ProfileItemDelegate):RecyclerView.Adapter<ProfileImageViewHolder>() {

    private val profileImageList = listOf(
        R.drawable.mew,
        R.drawable.mew,
        R.drawable.mew,
        R.drawable.plus
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_profile_image, parent, false)
        return ProfileImageViewHolder(view.rootView, delegate)
    }

    override fun getItemCount(): Int {
        return profileImageList.count()
    }

    override fun onBindViewHolder(holder: ProfileImageViewHolder, position: Int) {
        var profile = holder.itemView.findViewById<RoundedProfileImage>(R.id.customProfileImage)
        profile.setImageResource(profileImageList[position])

        holder.itemView.setOnClickListener {
            if (holder.adapterPosition == profileImageList.lastIndex){
                delegate.onTapTask()
            }else{
                delegate.onTapProfileDetail()
            }
        }

    }

}