package br.rpm.call.list.main

import br.rpm.call.list.model.CallDetail

interface MainView {
    fun fillData(list: List<CallDetail>)
}
