package com.dev.booklist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.poto_1),
            contentDescription = "Profile Image",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nama: Erlin Marbella")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Email: erlinmarvella@gmail.com")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Asal Perguruan Tinggi: Universitas Negeri Makassar")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Jurusan: Desain Komunikasi Visual")
    }
}
