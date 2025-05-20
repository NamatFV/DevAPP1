package br.qi.aula06.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.qi.aula06.DatePickerState
import br.qi.aula06.MyButton
import br.qi.aula06.MyTextField
import br.qi.aula06.ui.theme.Aula06Theme

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        Text(
            text = "Cadastro",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        MyTextField(
            label = "Nome",
            isPassword = false,
            icon = Icons.Outlined.AccountCircle
        )

        MyTextField(
            label = "Email",
            isPassword = false,
            icon = Icons.Outlined.MailOutline
        )

        MyTextField(
            label = "Telefone",
            isPassword = false,
            icon = Icons.Outlined.Phone
        )

        DatePickerState()

        MyTextField(
            label = "Senha",
            isPassword = true,
            icon = Icons.Outlined.Lock
        )

        MyButton(
            label = "Cadastrar",
            size = 300.dp
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
fun RegisterScreenPreview(){
    Aula06Theme {
        RegisterScreen()
    }
}
