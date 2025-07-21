package com.googadev.tvapp.ui.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.googadev.tvapp.ui.presentation.screens.home.components.FeaturedShow
import com.googadev.tvapp.ui.presentation.screens.home.components.PopularSection
import com.googadev.tvapp.ui.presentation.screens.home.components.TopBar

@Composable
fun NetflixHomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        FeaturedShow()
        PopularSection()
    }
}