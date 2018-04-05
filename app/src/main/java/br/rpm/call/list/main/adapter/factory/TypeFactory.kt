package br.rpm.call.list.main.adapter.factory

import android.view.View

import br.rpm.call.list.main.adapter.viewholder.BaseViewHolder
import br.rpm.call.list.model.CallDetail

interface TypeFactory {
    fun type(detail: CallDetail): Int
    fun createViewHolder(parent: View, type: Int): BaseViewHolder<*>
}
