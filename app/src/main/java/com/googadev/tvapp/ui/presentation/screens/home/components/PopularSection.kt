package com.googadev.tvapp.ui.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import com.googadev.tvapp.ui.constant.popularShows


@Composable
fun PopularSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Popular on Netflix", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        LazyRow {
            items(popularShows) { show ->
                Image(
                    painter = painterResource(id = show.imageRes),
                    contentDescription = show.title,
                    modifier = Modifier
                        .size(width = 120.dp, height = 180.dp)
                        .padding(end = 8.dp),

                )
            }
        }
    }
}