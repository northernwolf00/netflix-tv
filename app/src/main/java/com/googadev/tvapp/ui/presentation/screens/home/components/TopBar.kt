package com.googadev.tvapp.ui.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import androidx.compose.foundation.clickable


import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.focus.*
import androidx.compose.ui.unit.*

@Composable
fun TopBar(onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("NETFLIX", fontSize = 20.sp, color = Color.Red, fontWeight = FontWeight.Bold)

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            listOf("Home", "TV Shows", "Movies").forEach { label ->
                val focusRequester = remember { FocusRequester() }
                var isFocused by remember { mutableStateOf(false) }

                Box(
                    modifier = Modifier
                        .focusRequester(focusRequester)
                        .onFocusChanged { focusState -> isFocused = focusState.isFocused }
                        .focusable()
                        .clickable { onItemClick(label) }
                        .border(
                            width = if (isFocused) 2.dp else 0.dp,
                            color = if (isFocused) Color.Red else Color.Transparent,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(8.dp)
                ) {
                    Text(text = label, color = Color.White)
                }
            }
        }
    }
}

