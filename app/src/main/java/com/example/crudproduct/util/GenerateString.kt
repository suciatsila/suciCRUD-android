package com.example.crudproduct.util

import java.util.*

object GenerateString {
    /**
     * Genera una password RANDOM
     */
    const val DATA =
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    var RANDOM = Random()
    fun randomString(len: Int): String {
        val sb = StringBuilder(len)
        for (i in 0 until len) {
            sb.append(DATA[RANDOM.nextInt(DATA.length)])
        }
        return sb.toString()
    }
}
