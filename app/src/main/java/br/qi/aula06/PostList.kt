package br.qi.aula06

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.qi.aula06.model.PostData
import br.qi.aula06.ui.theme.Aula06Theme

@Composable
fun ListPost(
    list: List<PostData> = listagem,
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(list){
            Surface(
                color = Color.White,
                modifier = modifier.padding(20.dp),
            ) {
                PostPage(
                    imageProfile = it.imageProfile,
                    nameProfile = it.nameProfile,
                    timeProfile = it.timeProfile,
                    imagePost = it.imagePost,
                    textPost = it.textPost
                )
            }
        }
    }
}


/////////////////////////////////////////////////////////////
@Preview(
    showBackground = true,
    heightDp = 400
)
@Composable
fun ListPostPreview(){
    Aula06Theme {
        ListPost()
    }
}

/////////////////////////////////////////////////////////////
val listagem = listOf(
    PostData(
        imageProfile = R.drawable.phineas,
        nameProfile = "Phineas",
        timeProfile = "Hoje",
        imagePost = R.drawable.phineas,
        textPost = "O que vamos fazer hoje? " +
                "--------------------------" +
                "--------------------------"
    ),
    PostData(
        imageProfile = R.drawable.ferb,
        nameProfile = "Ferb",
        timeProfile = "há dois anos",
        imagePost = R.drawable.ferb,
        textPost = "👍 " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.candace,
        nameProfile = "Candace",
        timeProfile = "há 15 minutos",
        imagePost = R.drawable.candace,
        textPost = "C + J "  +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.jeremy,
        nameProfile = "Jeremy",
        timeProfile = "15 minutos",
        imagePost = R.drawable.jeremy,
        textPost = "J + C " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.isabela,
        nameProfile = "Isabela",
        timeProfile = "há 2 minutos",
        imagePost = R.drawable.isabela,
        textPost = "🩷 " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.buford,
        nameProfile = "Bufford",
        timeProfile = "Ontem",
        imagePost = R.drawable.buford,
        textPost = "Assistam Clube da Luta " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.baljeet,
        nameProfile = "Baljeet",
        timeProfile = "há 3 dias",
        imagePost = R.drawable.baljeet,
        textPost = "Estudando nas férias " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.doofensmirtz,
        nameProfile = "Doofensmirtz",
        timeProfile = "Hoje",
        imagePost = R.drawable.doofensmirtz,
        textPost = "PostagemNator " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.vanessa,
        nameProfile = "Vanessa",
        timeProfile = "Hoje",
        imagePost = R.drawable.vanessa,
        textPost = "You're busted " +
                "-------------------------" +
                "-------------------------"
    ),
    PostData(
        imageProfile = R.drawable.major,
        nameProfile = "Maj. Monograma",
        timeProfile = "Hoje",
        imagePost = R.drawable.major,
        textPost = "Trabalho " +
                "-------------------------" +
                "-------------------------"
    ),
)