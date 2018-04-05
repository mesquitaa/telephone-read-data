package br.rpm.call.list.main.adapter.factory.impl

import android.view.View

import br.rpm.call.list.main.adapter.factory.TypeFactory
import br.rpm.call.list.main.adapter.viewholder.BaseViewHolder
import br.rpm.call.list.main.adapter.viewholder.CallDetailViewHolder
import br.rpm.call.list.model.CallDetail

class TypeFactoryImpl : TypeFactory {

    override fun type(detail: CallDetail): Int {
        return CallDetailViewHolder.LAYOUT
    }

    override fun createViewHolder(parent: View, type: Int): BaseViewHolder<*> {
        when (type) {
            CallDetailViewHolder.LAYOUT -> return CallDetailViewHolder(parent)
            else -> throw RuntimeException(String.format("LayoutType: %d", type))
        }
    }
}
