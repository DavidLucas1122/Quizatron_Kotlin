package com.example.quiz.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pergunta(
    text: String,
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        fontSize = 21.sp,
        color = Color.Black,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Start
    )
}