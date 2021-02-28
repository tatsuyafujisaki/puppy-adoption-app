package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

@Composable
fun DogList(
    navController: NavController,
    dogs: List<Dog>
) {
    LazyColumn(Modifier.fillMaxWidth()) {
        items(dogs) {
            DogListItem(
                modifier = Modifier.clickable {
                    navController.navigate("dogs/${it.id}")
                },
                dog = it,
            )
            Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun DogListItem(
    modifier: Modifier,
    dog: Dog
) {
    Row(
        modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.surface)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(dog.drawableResId),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp, Color.LightGray, CircleShape),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(dog.breed, style = MaterialTheme.typography.h6)
            Text(dog.origin, style = MaterialTheme.typography.subtitle1, color = Color.LightGray)
        }
    }
}
