package com.example.quiz.screens.perguntas;

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel

class PerguntasScreenViewModel : ViewModel() {

    val perguntas = listOf(
        PerguntaModelo(
            enunciado = "Qual a capital da França?",
            alternativas = listOf(
                "Londres",
                "Berlim",
                "Paris",
                "Madrid"
            ),
            respostaCorretaIndex = 2
        ),
        PerguntaModelo(
            enunciado = "Qual planeta é conhecido como planeta vermelho?",
            alternativas = listOf(
                "Terra",
                "Marte",
                "Júpiter",
                "Saturno"
            ),
            respostaCorretaIndex = 1
        ),
        PerguntaModelo(
            enunciado = "Quanto é 5 x 5?",
            alternativas = listOf(
                "10",
                "15",
                "20",
                "25"
            ),
            respostaCorretaIndex = 3
        )
    )

    private val _acertos = MutableLiveData(0)
    val acertos: LiveData<Int> = _acertos

    private val _alternativaSelecionada = MutableLiveData<String?>(null)
    val alternativaSelecionada: LiveData<String?> = _alternativaSelecionada

    private val _questaoRespondida = MutableLiveData(false)
    val questaoRespondida: LiveData<Boolean> = _questaoRespondida

    private val _indicePerguntaAtual = MutableLiveData(0)
    val indicePerguntaAtual: LiveData<Int> = _indicePerguntaAtual

    fun responderPergunta(alternativaSelecionada: String) {

        if (_questaoRespondida.value == true) {
            return
        }

        _alternativaSelecionada.value = alternativaSelecionada
        _questaoRespondida.value = true

        val perguntaAtual =
            perguntas[_indicePerguntaAtual.value ?: 0]

        val respostaCorreta =
            perguntaAtual.alternativas[perguntaAtual.respostaCorretaIndex]

        if (alternativaSelecionada == respostaCorreta) {
            _acertos.value = (_acertos.value ?: 0) + 1
        }
    }

    fun proximaPergunta() {

        _indicePerguntaAtual.value =
            (_indicePerguntaAtual.value ?: 0) + 1

        _alternativaSelecionada.value = null
        _questaoRespondida.value = false
    }

    fun terminouQuiz(): Boolean {
        return (_indicePerguntaAtual.value ?: 0) >= perguntas.size
    }

    fun reiniciarQuiz() {
        _acertos.value = 0
        _indicePerguntaAtual.value = 0
        _alternativaSelecionada.value = null
        _questaoRespondida.value = false
    }
}