package com.example.quiz.components

import android.R.attr.text
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CardNumeroPergunta(
    numero: Int
) {
    Text(
        text = "Pergunta $numero de 3",
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp
    )
}