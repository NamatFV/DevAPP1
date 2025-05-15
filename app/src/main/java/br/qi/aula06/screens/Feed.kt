package br.qi.aula06.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.qi.aula06.ListPost
import br.qi.aula06.MyBottomBar
import br.qi.aula06.MyTopBar
import br.qi.aula06.PostText
import br.qi.aula06.ui.theme.Aula06Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
){
    Scaffold (
        containerColor = Color(186, 162, 232),
        topBar = { MyTopBar()},
        bottomBar = { MyBottomBar()}
    ){
        Box(
            modifier = modifier.padding(it)
        ){
            ListPost()
        }
    }
}

/////////////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun FeedScreenPreview(){
    Aula06Theme {
        FeedScreen()
    }
}