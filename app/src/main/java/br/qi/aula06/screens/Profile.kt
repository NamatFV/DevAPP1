package br.qi.aula06.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.qi.aula06.MyBottomBar
import br.qi.aula06.MyTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Scaffold (
        containerColor = Color(186, 162, 232),
        topBar = { MyTopBar(title = "Perfil")},
        bottomBar = { MyBottomBar(navController = navController, item = 0)}
    ){
        Box(
            modifier = modifier.padding(it)
        ){
            Text(text = "Tela de Perfil")
        }
    }
}
