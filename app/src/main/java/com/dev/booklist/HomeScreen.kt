package com.dev.booklist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    val genres = listOf(
        "Romance", "Drama", "Metropop", "Horror", "Sejarah",
        "Fantasi", "Thriller", "Self Improvement", "Favorite", "Komedi"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp) // Mengatur padding horizontal
    ) {
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalAlignment = Alignment.CenterVertically // Mengatur alignment vertical
            ) {
                items(genres) { genre ->
                    Box(
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(12.dp)
                    ) {
                        Text(text = genre, color = Color.Black, fontSize = 16.sp)
                    }
                }
            }
        }
        items(genres) { genre ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp), // Mengatur padding vertical
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cover_1),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = genre, modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}
