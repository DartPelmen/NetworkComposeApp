package edu.festu.ivankuznetsov.networkcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import edu.festu.ivankuznetsov.networkcomposeapp.model.Post
import edu.festu.ivankuznetsov.networkcomposeapp.network.NetworkObject
import edu.festu.ivankuznetsov.networkcomposeapp.network.PostAPI
import edu.festu.ivankuznetsov.networkcomposeapp.ui.theme.NetworkComposeAppTheme
import edu.festu.ivankuznetsov.networkcomposeapp.viewmodel.PostViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            NetworkComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()

                }
            }
        }
    }
}
@Composable
fun Screen(modifier: Modifier = Modifier, postViewModel: PostViewModel = koinViewModel()){
    val posts by postViewModel.getAllPosts().collectAsState(initial = emptyList())
    ListPost(listPost = posts)
}

@Composable
fun ListPost(modifier: Modifier = Modifier, listPost: List<Post>) {
    LazyColumn {
        items(listPost) {
            PostCard(modifier = Modifier, title = it.title, completed = it.completed)
        }
    }
}

@Composable
fun PostCard(
    modifier: Modifier,
    title: String,
    completed: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(title)
        Icon(
            imageVector = if (completed) Icons.Filled.Check else Icons.Filled.Create,
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostCard(modifier: Modifier = Modifier) {
    PostCard(modifier = modifier, title = "example example example", completed = false)
}