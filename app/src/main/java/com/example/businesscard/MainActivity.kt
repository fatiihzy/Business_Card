package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Muhammad Fatih",
                        title = "D121221103",
                        phone = "+6285163000911",
                        email = "muhammadfatih204@gmail.com",
                        social = "@fatiihzy"
                    )
                }
            }
        }
    }
}

@Composable
fun ContactInfo(iconId: Int, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun BusinessCard(name: String, title: String, phone: String, email: String, social: String) {
    val background = painterResource(R.drawable.unhaslogo) // Replace with your background image
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = background,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.3F
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.unhaslogo), // Replace with your logo
                contentDescription = "Business Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = name,
                fontSize = 36.sp,
                lineHeight = 44.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = title,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContactInfo(
                iconId = R.drawable.phonelogo, // Replace with your phone icon
                text = phone
            )
            ContactInfo(
                iconId = R.drawable.emaillogo, // Replace with your email icon
                text = email
            )
            ContactInfo(
                iconId = R.drawable.instagramlogo, // Replace with your social media icon
                text = social
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = "Muhammad Fatih",
            title = "D121221103",
            phone = "+6285163000911",
            email = "muhammadfatih204@gmail.com",
            social = "@fatiihzy"
        )
    }
}
