package com.googadev.tvapp.ui.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import com.googadev.tvapp.ui.constant.Show



@Composable
fun PopularSection(popularShows: List<Show>) {
    Column(modifier = Modifier.padding(16.dp)
        .height(120.dp)) {
        Text(
            "Popular on Netflix",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(popularShows) { show ->
                var isFocused by remember { mutableStateOf(false) }

                Box(
                    modifier = Modifier
                        .onFocusChanged { isFocused = it.isFocused }
                        .focusable()
                        .border(
                            width = if (isFocused) 2.dp else 0.dp,
                            color = if (isFocused) Color.Red else Color.Transparent,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(end = 8.dp)
                        .height(120.dp)
                ) {
                    Image(
                        painter = painterResource(id = show.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 120.dp, height = 180.dp)
                    )
                }
            }
        }
    }
}