package br.qi.aula06

import android.os.Bundle
import android.security.identity.AccessControlProfile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
        modifier = modifier.height(200.dp)
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
                imageVector = if(like) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                contentDescription = "Ícone de curtida",
                tint = if(like) Color.Black else Color.Red
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

// Componente para controle de estado
@Composable
fun PostIconsState(
    modifier: Modifier = Modifier
){
    var changeLike by remember {
        mutableStateOf(true)
    }

    PostIcons(
        like = changeLike,
        onChange = {changeLike = !changeLike}
    )
}

@Composable
fun PostText(
    text : String,
    modifier: Modifier = Modifier
){
    Box{
        Text(
            text = text,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun PostPage(
    @DrawableRes imageProfile: Int,
    nameProfile: String,
    timeProfile: String,
    @DrawableRes imagePost: Int,
    textPost: String,
    modifier: Modifier = Modifier
){
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
fun PostTextPreview(){
    Aula06Theme {
        PostText(text = "São três meses de férias, que passam depressa, curtir é a prioridade. Temos que aproveitar bem, então vamos nessa, mas tem que rolar novidade...")
    }
}

@Preview(showBackground = true)
@Composable
fun PostPagePreview(){
    Aula06Theme {
        PostPage(
            imageProfile = R.drawable.perry,
            nameProfile = "Perry, o ornitorrinco",
            timeProfile = "30 minutos atrás",
            imagePost = R.drawable.ic_launcher_background,
            textPost = "Não seja pau para toda obra, porque sempre terá obra"
        )
    }
}