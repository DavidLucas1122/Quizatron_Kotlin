package com.example.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.screens.FinalScreen
import com.example.quiz.screens.InicioScreen
import com.example.quiz.screens.perguntas.PerguntasScreen
import com.example.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //  InicioScreen (modifier = Modifier.padding(innerPadding),)
                    // Pergunta1 (modifier = Modifier.padding(innerPadding),)
                    // Pergunta2 (modifier = Modifier.padding(innerPadding),)
                    // Pergunta3 (modifier = Modifier.padding(innerPadding),)
                    // FinalScreen (modifier = Modifier.padding(innerPadding),)

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "inicio",
                        exitTransition = {
                            slideOutOfContainer (
                                towards  = AnimatedContentTransitionScope
                                    .SlideDirection.Up,
                                animationSpec = tween (1000 )
                            ) + fadeOut(animationSpec = tween (1000))
                        }
                    ) {
                        composable (route = "inicio") { InicioScreen(navController = navController) }
                        composable( route = "perguntas" ) { PerguntasScreen(
                            navController = navController,
                            quizScreenViewModel = viewModel())
                        }
                        composable( route = "final" ) {FinalScreen(navController = navController) }
                    }
                }
            }
        }
    }
}