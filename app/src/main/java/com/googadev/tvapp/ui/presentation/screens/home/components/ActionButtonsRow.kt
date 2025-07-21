package com.googadev.tvapp.ui.presentation.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtonsRow() {
    Row(modifier = Modifier.padding(top = 12.dp)) {
        // Play Button with focus state
        var playFocused by remember { mutableStateOf(false) }
        OutlinedButton(
            onClick = { /* Play action */ },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .height(40.dp)
                .onFocusChanged { playFocused = it.isFocused }
                .focusable()
                .border(
                    width = if (playFocused) 2.dp else 0.dp,
                    color = if (playFocused) Color.Red else Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            Text("Play")
        }

        Spacer(modifier = Modifier.width(8.dp))

        // More Info Button with focus state
        var infoFocused by remember { mutableStateOf(false) }
        OutlinedButton(
            onClick = { /* More info action */ },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .height(40.dp)
                .onFocusChanged { infoFocused = it.isFocused }
                .focusable()
                .border(
                    width = if (infoFocused) 2.dp else 0.dp,
                    color = if (infoFocused) Color.Red else Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            Text("More Info")
        }
    }
}
