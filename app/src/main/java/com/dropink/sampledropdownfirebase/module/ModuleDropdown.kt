package com.dropink.sampledropdownfirebase.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModuleDropdown(
    var date: String = "",
    var time: String = "",
    var location: String = ""
): Parcelable