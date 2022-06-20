/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drake.debugkit

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * 创建调试窗口
 */
fun FragmentActivity.dev(devTool: DevTool? = null, block: DevTool.() -> Unit) {
    val realDev = devTool ?: DevTool(this)
    realDev.block()
    realDev.build()
}

/**
 * 创建调试窗口
 * 在Fragment视图销毁(onDestroyView)时会被关闭调试窗口, 支持Navigation
 */
fun Fragment.dev(devTool: DevTool? = null, block: DevTool.() -> Unit) {
    val realDev = devTool ?: DevTool(requireActivity())
    viewLifecycleOwner.lifecycle.addObserver(realDev)
    realDev.block()
    realDev.build()
}