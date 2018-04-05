package br.rpm.call.list.model

import br.com.getninjas.pro.koins.model.CallModel
import br.rpm.call.list.main.adapter.factory.TypeFactory

class CallDetail : CallModel {
    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)

    var date: String? = null
    var duration: String? = null
    var callType: String? = null
    var number: String? = null
    var name: String? = null
}
