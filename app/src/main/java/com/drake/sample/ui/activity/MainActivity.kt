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

package com.drake.sample.ui.activity

import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.drake.engine.base.EngineActivity
import com.drake.sample.R
import com.drake.sample.databinding.ActivityMainBinding
import com.drake.statusbar.immersive


class MainActivity : EngineActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        immersive(binding.toolbar, true)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav)
        binding.toolbar.setupWithNavController(
            navController,
            AppBarConfiguration(binding.navView.menu, binding.drawer)
        )
        binding.navView.setupWithNavController(navController)
    }

    override fun initData() {
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawers()
        } else super.onBackPressed()
    }
}