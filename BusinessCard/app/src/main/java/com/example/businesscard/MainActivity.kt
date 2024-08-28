package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(Color.LightGray).padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Profile(
            imageId = R.drawable.android_logo,
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        Contacts()
    }

}

@Composable
fun Profile(imageId: Int, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Android logo",
            Modifier
                .size(200.dp)
                .background(color = Color.DarkGray)
        )
        Text(
            text = name,
            fontWeight = FontWeight.W200,
            fontSize = 36.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        )
    }
}

@Composable
fun Contacts(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Contact(
            icon = R.drawable.baseline_phone_24,
            contentDescription = "Phone",
            text = "+389 70 374 689",
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Contact(
            icon = R.drawable.baseline_add_a_photo_24,
            contentDescription = "Instagram",
            text = "@baldovaliev.lj",
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Contact(
            icon = R.drawable.baseline_alternate_email_24,
            contentDescription = "Email",
            text = "baldovaliev.b@gmail.com",
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }

}

@Composable
fun Contact(icon: Int, contentDescription: String, text: String, modifier: Modifier = Modifier) {
    Row(modifier, Arrangement.Start) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            modifier = Modifier.padding(end = 8.dp),
        )
        Text(text = text, Modifier.padding(start = 8.dp))
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}