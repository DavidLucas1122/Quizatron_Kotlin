package com.example.quiz.screens.perguntas;

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

class PerguntasScreenViewModel {
    private val _acertos = MutableLiveData<Int>(0)

    private val _alternativaSelecionada = MutableLiveData<String>()

    val acertos: LiveData<Int> = _acertos

    val alternativaSelecionada: LiveData<String> = _alternativaSelecionada

    fun incrementaPontuacao(alternativaCorreta: String) {
        if(_alternativaSelecionada.value == alternativaCorreta) {
            _acertos.value = _acertos.value!! + 1
        }

    }

    fun alterarAlternativaSelecionada(alternativa: String) {
        _alternativaSelecionada.value = alternativa
    }
}