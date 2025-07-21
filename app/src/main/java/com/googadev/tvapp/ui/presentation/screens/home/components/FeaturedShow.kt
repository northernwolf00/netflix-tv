package com.googadev.tvapp.ui.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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


@Composable
fun FeaturedShow() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.devil_in_ohio_bg), // Your background image
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxSize()
//        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text("DEVIL IN OHIO", fontSize = 28.sp, color = Color.White)
            Text(
                "#1 in TV Shows Today",
                fontSize = 16.sp,
                color = Color.Red,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                "A psychiatrist shelters a cult escapee — risking her family and life.",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp)
            )

            Row(modifier = Modifier.padding(top = 12.dp)) {
//                Button(onClick = { /* Play */ }) {
//                    Text("Play")
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//                OutlinedButton(onClick = { /* More info */ }) {
//                    Text("More Info")
//                }
            }
        }
    }
}