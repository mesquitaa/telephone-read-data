package br.rpm.call.list.model

class CallDetail {

    var date: String? = null
    var duration: String? = null
    var callType: String? = null
    var number: String? = null
    var name: String? = null

    constructor() {

    }

    constructor(timestamp: String, duration: String, callType: String, number: String, name: String) {
        this.date = timestamp
        this.duration = duration
        this.callType = callType
        this.number = number
        this.name = name
    }
}
