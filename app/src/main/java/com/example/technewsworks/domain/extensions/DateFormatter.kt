package com.example.technewsworks.domain.extensions

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.formatDate(formatInput: String, formatOutput: String): String {
    return try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.parse(this, DateTimeFormatter.ofPattern(formatInput))
                .format(DateTimeFormatter.ofPattern(formatOutput))
        } else {
            val locale = Locale.getDefault()
            return SimpleDateFormat(formatOutput, locale).format(
                SimpleDateFormat(formatInput, locale).parse(this)!!,
            )
        }
    } catch (_: Throwable) {
        ""
    }
}