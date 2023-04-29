package com.mewz.customeviewassignment.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ProfileImageItemOverlap: RecyclerView.ItemDecoration() {
    private val overlapValue = -30

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0, 0, overlapValue, 0)
    }
}