package br.qi.aula06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.qi.aula06.screens.ProfileScreen
import br.qi.aula06.ui.theme.Aula06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula06Theme {
                //Aqui virá o código que criará o design no aparelho
            }
        }
    }
}

@Composable //destinada a UI
fun ProfileName(
    @DrawableRes image : Int,
    name : String,
    time : String,
    modifier: Modifier = Modifier //padrão para "editar"
){
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "Foto de perfil",
            modifier = modifier
                .size(40.dp)
                .border(
                    shape = CircleShape,
                    width = 0.dp,
                    color = Color.Transparent
                )
                .clip(CircleShape)
        )

        Spacer(
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Column {
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = time,
                color = Color.Gray
            )

        }
    }
}

@Composable
fun Post(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
){
    Box (
        modifier = modifier.height(260.dp)
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "Imagem do post",
            modifier = modifier.fillMaxSize()
        )
    }
}

@Composable
fun PostIcons(
    like: Boolean,
    onChange: () -> Unit,
    modifier: Modifier = Modifier
){
    Row {
        IconButton(
            onClick = onChange
        ) {
            Icon(
                imageVector = if(like) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Ícone de curtida",
                tint = if(like) Color.Red else Color.Black
            )
        }

        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Ícone de comentário"
            )
        }
    }
}

//Componente para controle de estado do like
@Composable
fun PostIconsState(
    modifier: Modifier = Modifier
){
    var changeLike by remember {
        mutableStateOf(false)
    }

    PostIcons(
        like = changeLike,
        onChange = { changeLike = !changeLike }
    )
}

@Composable
fun PostText(
    text: String,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        Text(
            text = if (isExpanded) text else text.take(100) + "...", // Mostra uma versão truncada quando não expandido
            maxLines = if (isExpanded) Int.MAX_VALUE else 1, // Controla a quantidade de linhas visíveis
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .clickable { isExpanded = !isExpanded } // Alterna o estado de expandido ao clicar
                .fillMaxWidth() // Garante que o clique será detectado em toda a largura do texto
        )
    }
}

@Composable
fun PostPage (
    @DrawableRes imageProfile: Int,
    nameProfile: String,
    timeProfile: String,
    @DrawableRes imagePost: Int,
    textPost: String,
    modifier: Modifier = Modifier
) {
    Column {
        ProfileName(
            image = imageProfile,
            name = nameProfile,
            time = timeProfile
        )

        Post(image = imagePost)

        PostIconsState()

        PostText(text = textPost)
    }
}

/*
/////////////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun ProfileNamePreview() {
    Aula06Theme {
        ProfileName(
            image = R.drawable.perry,
            name = "Perry, o ornitorrinco",
            time = "4 horas atrás"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostPreview(){
    Aula06Theme{
        Post(image = R.drawable.perry)
    }
}

@Preview(showBackground = true)
@Composable
fun PostIconsPreview(){
    Aula06Theme {
        PostIconsState()
    }
}

@Preview(showBackground = true)
@Composable
fun PostPagePreview(){
    Aula06Theme {

    PostPage(imageProfile = R.drawable.perry,
        nameProfile = "Perry",
        timeProfile = "2 minutos atrás",
        imagePost =R.drawable.perry,
        textPost = "Ouviram do Ipiranga as margens plácidas, de um povo heróico o brado retumbante"
    )

    }
}

 */

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun MyAppPreview(){
    MyNav()
}
