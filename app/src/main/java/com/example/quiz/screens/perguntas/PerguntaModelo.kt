package com.example.quiz.screens.perguntas

data class PerguntaModelo(
    val enunciado: String,
    val alternativas: List<String>,
    val respostaCorretaIndex: Int
)