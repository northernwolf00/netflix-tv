package com.googadev.tvapp.ui.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.googadev.tvapp.ui.constant.popularShows
import com.googadev.tvapp.ui.presentation.screens.home.components.FeaturedShow
import com.googadev.tvapp.ui.presentation.screens.home.components.PopularSection
import com.googadev.tvapp.ui.presentation.screens.home.components.TopBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.dp


@Composable
fun NetflixHomeScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            TopBar { clickedItem ->
                println("Clicked: $clickedItem")
            }
        }
        item {
            FeaturedShow()
        }
        item {
            PopularSection(popularShows = popularShows)
        }

    }
}
