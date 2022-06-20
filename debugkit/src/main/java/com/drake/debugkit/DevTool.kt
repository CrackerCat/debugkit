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

@file:Suppress("MemberVisibilityCanBePrivate")

package com.drake.debugkit

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class DevTool(val activity: FragmentActivity) : LifecycleObserver {

    companion object {
        /** 是否显示调试窗口 */
        var debug = true

        /** 默认主题 */
        var theme: DevTheme = DevTheme.DARK

        /** 窗口默认显示坐标X */
        var defaultX = 0F

        /** 窗口默认显示坐标Y */
        var defaultY = 0F

        /** 最小窗口宽度 */
        var minWidth = 132
    }

    /** 主题 */
    var theme: DevTheme = DevTool.theme

    /** 终端窗口文字大小 */
    var textSize: Int = 12

    /** 窗口默认显示坐标X */
    var startX: Float? = null

    /** 窗口默认显示坐标Y */
    var startY: Float? = null

    /** 是否显示调试窗口 */
    var debug: Boolean = DevTool.debug

    private val functions = ArrayList<DevFunction>()
    private val devFragment = DevFragment()

    /**
     * 添加一个按钮到调试窗口
     * @param title 按钮标题
     * @param block 点击按钮回调函数
     */
    fun function(title: String? = null, block: DevFunction.() -> Unit) {
        val devFunction = DevFunction(devFragment)
        devFunction.title = title
        devFunction.block = block
        this.functions.add(devFunction)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun close(lifecycleOwner: LifecycleOwner) {
        devFragment.close()
    }

    /**
     * 构建一个DevFragment
     */
    fun build() {
        if (!debug) {
            return
        }
        if (functions.size > 0) devFragment.setFunctionList(functions)
        devFragment.setConsoleTextSize(textSize)
        devFragment.displayAt(startX, startY)
        try {
            activity.supportFragmentManager.beginTransaction()
                .add(android.R.id.content, devFragment)
                .commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        devFragment.setTheme(theme)
    }

}
