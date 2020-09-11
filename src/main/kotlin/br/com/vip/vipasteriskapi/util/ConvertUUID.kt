package br.com.vip.vipasteriskapi.util

import java.util.*

fun convertToUUID(id: String): UUID? {
    return try {
        UUID.fromString(id)
    } catch (ex: IllegalArgumentException) {
        println("UUID recebido invalido $id")
        null
    }
}