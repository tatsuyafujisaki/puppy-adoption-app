package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                DogList(dogs) {
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface {
            content()
        }
    }
}

@Composable
fun DogList(
    dogs: List<Dog>,
    onClick: () -> Unit,
) {
    LazyColumn(Modifier.fillMaxWidth()) {
        items(dogs) {
            DogListItem(
                dog = it,
                onClick = onClick
            )
            Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun DogListItem(
    dog: Dog,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .clickable(onClick = onClick)
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

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        DogList(dogs) {}
    }
}

val dogs = listOf(
    Dog("Shiba", "Japan", R.drawable.shiba),
    Dog("American Cocker Spaniel", "United States", R.drawable.american_cocker_spaniel),
    Dog("Pug", "China", R.drawable.pug),
    Dog("West Highland White Terrier", "Scotland", R.drawable.west_highland_white_terrier),
    Dog("Chihuahua", "Mexico", R.drawable.chihuahua),
    Dog("Dalmatian", "Croatia", R.drawable.dalmatian),
    Dog("Dachshund", "Germany", R.drawable.dachshund),
    Dog("Dobermann", "Germany", R.drawable.dobermann),
    Dog("Labrador Retriever", "United Kingdom", R.drawable.labrador_retriever),
    Dog("Beagle", "England", R.drawable.beagle)
)
