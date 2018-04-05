package br.rpm.call.list.main.adapter.viewholder

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.View

import br.rpm.call.list.BR
import br.rpm.call.list.R
import br.rpm.call.list.model.CallDetail

class CallDetailViewHolder(itemView: View) : BaseViewHolder<CallDetail>(itemView) {

    private val bind: ViewDataBinding?

    init {

        this.bind = DataBindingUtil.bind(itemView)
    }

    override fun bind(contact: CallDetail) {
        bind!!.setVariable(BR.contact, contact)
    }

    companion object {

        @LayoutRes
        val LAYOUT = R.layout.widget_contact_item
    }
}
