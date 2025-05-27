package br.qi.aula06.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.qi.aula06.LogoLogin
import br.qi.aula06.MyButton
import br.qi.aula06.MySwitchState
import br.qi.aula06.MyTextField
import br.qi.aula06.R
import br.qi.aula06.Rotas
import br.qi.aula06.ui.theme.Aula06Theme

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        LogoLogin(
            logo = R.drawable.ic_launcher_foreground
        )

        MyTextField(
            label = "Usuário",
            isPassword = false,
            icon = Icons.Outlined.AccountCircle
        )

        MyTextField(
            label = "Senha",
            isPassword = true,
            icon = Icons.Outlined.Lock
        )

        MySwitchState(
            label = "Mantenha-me conectado"
        )

        MyButton(
            label = "Entrar",
            size = 300.dp,
            action = { navController.navigate(Rotas.Feed) }
        )

        MyButton(
            label = "Registrar",
            size = 300.dp,
            action = { navController.navigate(Rotas.Register) }
        )
    }//Column
}

/////////////////////////////////////////////////////////////
@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 620
)
@Composable
fun LoginScreenPreview(){
    Aula06Theme {
        //LoginScreen()
    }
}
