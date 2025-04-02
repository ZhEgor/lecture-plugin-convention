package com.zhiro.lecture.plugin.convention.core.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

fun test() {
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

}