package com.example.technewsworks.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Source
 *
 * @property name The name of the source.
 */
@Parcelize
class Source(
    val name: String? = null,
) : Parcelable