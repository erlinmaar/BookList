package com.dev.booklist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GridScreen() {
    val images = listOf(
        R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4,
        R.drawable.image_5, R.drawable.image_6, R.drawable.image_7, R.drawable.image_8,
        R.drawable.image_9, R.drawable.image_10
    )

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(images.size) { index ->
            Image(
                painter = painterResource(id = images[index]),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp), // Gunakan Modifier.size() dengan benar
                contentScale = ContentScale.Crop
            )
        }
    }
}
