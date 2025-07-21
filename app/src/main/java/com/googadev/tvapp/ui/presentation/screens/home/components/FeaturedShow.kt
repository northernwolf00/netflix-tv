package com.googadev.tvapp.ui.presentation.screens.home.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import com.googadev.tvapp.R

@Composable
fun FeaturedShow() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        // ✅ Background Image enabled
        Image(
            painter = painterResource(id = R.drawable.inersteller),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = "Intersteller",
                fontSize = 28.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "#1 in TV Shows Today",
                fontSize = 16.sp,
                color = Color.Red,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "A psychiatrist shelters a cult escapee — risking her family and life.",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp)
            )

                ActionButtonsRow()
        }
    }
}
