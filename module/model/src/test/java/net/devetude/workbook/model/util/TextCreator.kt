package net.devetude.workbook.model.util

import androidx.annotation.IntRange
import androidx.annotation.Size

internal object TextCreator {
    @Size(min = 0)
    fun create(@IntRange(from = 0) len: Int): String {
        assert(value = 0 <= len) { "The len should be greater or equal than 0." }
        val sb = StringBuilder()
        for (i in 0 until len) sb.append(i % 10)
        return sb.toString()
    }
}
