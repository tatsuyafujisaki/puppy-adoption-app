package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DogDetail(dog: Dog) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(dog.drawableResId),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))
        Text("Breed: ${dog.breed}", style = MaterialTheme.typography.h6)
        Spacer(Modifier.height(16.dp))
        Text("Origin: ${dog.origin}", style = MaterialTheme.typography.h6)
        Spacer(Modifier.height(16.dp))
        Text(dog.description, style = MaterialTheme.typography.body2)
    }
}