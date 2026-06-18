package com.example.quiz.screens.perguntas

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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quiz.R
import com.example.quiz.components.BotaoAlternativa
import com.example.quiz.components.CardNumeroPergunta
import com.example.quiz.components.Logo
import com.example.quiz.components.Pergunta

@Composable
fun PerguntasScreen(
    navController: NavController,
    quizScreenViewModel: PerguntasScreenViewModel
) {

    val alternativaSelecionada by quizScreenViewModel
        .alternativaSelecionada
        .observeAsState(null)

    val questaoRespondida by quizScreenViewModel
        .questaoRespondida
        .observeAsState(false)

    val indicePerguntaAtual by quizScreenViewModel
        .indicePerguntaAtual
        .observeAsState(0)

    val perguntaAtual =
        quizScreenViewModel.perguntas[indicePerguntaAtual]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.rosa))
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Logo(size = 90.dp)

            Spacer(modifier = Modifier.height(20.dp))

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
                    CardNumeroPergunta(
                        numero = indicePerguntaAtual + 1
                    )
                }
            }

            CardPerguntas(
                pergunta = perguntaAtual.enunciado,
                alternativas = perguntaAtual.alternativas,
                alternativaCorreta = perguntaAtual.alternativas[
                    perguntaAtual.respostaCorretaIndex
                ],
                alternativaSelecionada = alternativaSelecionada,
                questaoRespondida = questaoRespondida,
                respondeuQuestao = { alternativa ->
                    quizScreenViewModel.responderPergunta(
                        alternativaSelecionada = alternativa
                    )
                }
            )

            if (questaoRespondida) {
                Button(
                    onClick = {

                        if (
                            indicePerguntaAtual <
                            quizScreenViewModel.perguntas.size - 1
                        ) {
                            quizScreenViewModel.proximaPergunta()
                        } else {
                            navController.navigate("final")
                        }
                    }
                ) {
                    Text("Próxima")
                }
            }
        }
    }
}

@Composable
fun CardPerguntas(
    pergunta: String,
    alternativas: List<String>,
    alternativaCorreta: String,
    alternativaSelecionada: String?,
    questaoRespondida: Boolean,
    respondeuQuestao: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Pergunta(text = pergunta)

            alternativas.forEach { alternativa ->

                val corBotao = when {
                    !questaoRespondida -> Color.White

                    alternativa == alternativaSelecionada &&
                            alternativa == alternativaCorreta -> Color.Green

                    alternativa == alternativaSelecionada &&
                            alternativa != alternativaCorreta -> Color.Red

                    else -> Color.White
                }

                BotaoAlternativa(
                    text = alternativa,
                    containerColor = corBotao,
                    onClick = {
                        if (!questaoRespondida) {
                            respondeuQuestao(alternativa)
                        }
                    }
                )
            }
        }
    }
}