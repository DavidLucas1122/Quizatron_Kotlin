package com.example.quiz.screens

import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.R
import com.example.quiz.components.BotaoStart
import com.example.quiz.components.CardNumeroPergunta
import com.example.quiz.components.Logo

@Composable
fun FinalScreen(navController: NavController) {

    Box (
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {

            Logo(size = 90.dp)


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.azul)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                Card(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                            )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                    ) {
                        // Card Bom Trabalho
                        Card(
                            modifier = Modifier
                                .width(250.dp)
                                .height(60.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(R.color.verde)
                            ),
                            border = BorderStroke(2.dp, Color.Black),
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Bom Trabalho",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 23.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "Você Acertou 1 de 3 Perguntas",
                            fontSize = 20.sp
                        )
                    }
                }
            }

                BotaoStart(text = "JOGAR NOVAMENTE",
                    modifier = Modifier.fillMaxWidth(0.6f),
                    onClick = {
                    navController.navigate(route = "perguntas")
                }
            )

        }
    }
}