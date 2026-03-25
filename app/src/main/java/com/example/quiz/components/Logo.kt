package com.example.quiz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.quiz.R

@Composable
fun Logo(
    size: Dp
) {
    Image(
        modifier = Modifier.size(size),
        painter = painterResource(R.drawable.quiz),
        contentDescription = "Logo"
    )
}