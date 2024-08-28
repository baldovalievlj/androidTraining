package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Top) {
        Header(stringResource(R.string.header_title))
        Content(stringResource(R.string.content_intro), stringResource(R.string.content_main))
    }
}

@Composable
fun Header(title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null)
    Text(
        text = title,
        modifier = modifier.padding(16.dp),
        fontSize = 24.sp,
    )
}

@Composable
fun Content(intro: String, description: String, modifier: Modifier = Modifier) {
    Text(
        text = intro,
        modifier = modifier.padding(horizontal = 16.dp),
        textAlign = TextAlign.Justify,
    )
    Text(
        text = description,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify,
    )
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Home()
    }
}