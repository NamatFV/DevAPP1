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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.qi.aula06.model.PostData
import br.qi.aula06.ui.theme.Aula06Theme

@Composable
fun ListPost(
    list: List<PostData> = List(10) { PostData() },
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(list){
            Surface(
                color = Color.LightGray,
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
