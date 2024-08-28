package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComposable()
                }
            }
        }
    }
}

@Composable
fun MainComposable() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1F)) {
            TextComposable(
                title = stringResource(id = R.string.title_1),
                description = stringResource(id = R.string.description_1),
                color = colorResource(id = R.color.color_1),
                modifier = Modifier.weight(1f)
            )
            TextComposable(
                title = stringResource(id = R.string.title_2),
                description = stringResource(id = R.string.description_2),
                color = colorResource(id = R.color.color_2),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1F)) {
            TextComposable(
                title = stringResource(id = R.string.title_3),
                description = stringResource(id = R.string.description_3),
                color = colorResource(id = R.color.color_3),
                modifier = Modifier.weight(1f)
            )
            TextComposable(
                title = stringResource(id = R.string.title_4),
                description = stringResource(id = R.string.description_4),
                color = colorResource(id = R.color.color_4),
                modifier = Modifier.weight(1f)
            )
        }
    }


}

@Composable
fun TextComposable(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        MainComposable()
    }
}