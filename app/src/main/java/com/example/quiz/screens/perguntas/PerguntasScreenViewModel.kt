package com.example.quiz.screens.perguntas;

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

class PerguntasScreenViewModel {

    val listaDePerguntas = listOf(
        PerguntaModelo("Qual a capital da França?", listOf("Londres", "Paris", "Berlim", "Itapevi"), 1),
        PerguntaModelo("2 + 2 é?", listOf("3", "4", "5", "222222222"), 1),
        PerguntaModelo("Qual é o primeiro Pokémon Criado", listOf("Rhydon", "Bulbasaur", "Mew", "Arceus"), 0)
    )


    private val _numeroAcertos = MutableLiveData<Int>(0)
    private val _numeroPerguntaState = MutableLiveData<Int>(1)

    val numeroAcertos: LiveData<Int> = _numeroAcertos
    val numeroPerguntas: LiveData<Int> = _numeroPerguntaState

    fun respostaIncorreta () {
    }

    fun respostaCorreta () {
    }
}