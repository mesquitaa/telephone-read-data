package br.com.getninjas.pro.koins.model

import br.rpm.call.list.main.adapter.factory.TypeFactory

interface CallModel {
    fun type(typeFactory: TypeFactory): Int
}
