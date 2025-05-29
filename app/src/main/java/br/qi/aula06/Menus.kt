package br.qi.aula06

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.qi.aula06.ui.theme.Aula06Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    title: String = "Disney Channel",
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(72, 133, 240)
        ),
        title = {
            Text( text = title )
        },
        actions = {
            IconButton(
                onClick = {/*TODO*/}
            ) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "Ícone de menu"
                )
            }//IconButton
        }
    )
}

@Composable
fun MyBottomBar(
    navController: NavController,
    item: Int = -1,
    color: Color = Color.Black,
    colorSelected: Color = Color(186, 162, 232),
    size: Dp = 26.dp,
    sizeSelected: Dp = 40.dp,
    modifier: Modifier = Modifier
){

    var itemSelected by remember {
        mutableIntStateOf(item)
    }

    BottomAppBar (
        containerColor = Color(72, 133, 240)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    itemSelected = item
                    navController.navigate(Rotas.Profile)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Ícone de perfil",
                    tint = if(itemSelected == 0) colorSelected else color,
                    modifier = modifier.size( if (itemSelected == 0) sizeSelected else size )
                )
            }//IconButton

            IconButton(
                onClick = {
                    itemSelected = item
                    navController.navigate(Rotas.AddPost)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = "Ícone de nova postagem",
                    tint = if(itemSelected == 1) colorSelected else color,
                    modifier = modifier.size( if (itemSelected == 1) sizeSelected else size )
                )
            }//IconButton

            IconButton(
                onClick = {
                    itemSelected = item
                    navController.navigate(Rotas.Settings)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Ícone de configuração",
                    tint = if(itemSelected == 2) colorSelected else color,
                    modifier = modifier.size( if (itemSelected == 2) sizeSelected else size )
                )
            }//IconButton
        }//Row
    }//BottomAppBar
}

/////////////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun MyTopBarPreview(){
    Aula06Theme {
        MyTopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MyBottomBarPreview(){
    Aula06Theme {
        //MyBottomBar()
    }
}

