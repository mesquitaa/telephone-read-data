package br.rpm.call.list.main.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        ButterKnife.inject(this, itemView)
    }

    abstract fun bind(element: T)
}
