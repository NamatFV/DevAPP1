package br.qi.aula06

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.qi.aula06.screens.FeedScreen
import br.qi.aula06.screens.LoginScreen
import br.qi.aula06.screens.ProfileScreen
import br.qi.aula06.screens.RegisterScreen

@Composable
fun MyNav(

    modifier: Modifier = Modifier
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rotas.Login,
        builder = {
            composable(Rotas.Login) {
                LoginScreen(navController = navController)
            }
            composable(Rotas.Register) {
                RegisterScreen(navController = navController)
            }
            composable(Rotas.Feed) {
                FeedScreen(navController = navController)
            }
            composable(Rotas.Profile) {
                ProfileScreen(navController = navController)
            }/*
            composable(Rotas.AddPost) {
                AddPostScreen(navController = navController)
            }*/
        }
    )
}