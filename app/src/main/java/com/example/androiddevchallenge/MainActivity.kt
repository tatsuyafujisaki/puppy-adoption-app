package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, "dogs") {
        composable("dogs") {
            DogList(navController, dogs)
        }
        composable(
            "dogs/{id}",
            listOf(navArgument("id") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments!!.getString("id")
            DogDetail(dogs.find { it.id == id }!!)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

val dogs = listOf(
    Dog("1", "Shiba", "Japan", R.drawable.shiba),
    Dog("2", "American Cocker Spaniel", "United States", R.drawable.american_cocker_spaniel),
    Dog("3", "Pug", "China", R.drawable.pug),
    Dog("4", "West Highland White Terrier", "Scotland", R.drawable.west_highland_white_terrier),
    Dog("5", "Chihuahua", "Mexico", R.drawable.chihuahua),
    Dog("6", "Dalmatian", "Croatia", R.drawable.dalmatian),
    Dog("7", "Dachshund", "Germany", R.drawable.dachshund),
    Dog("8", "Dobermann", "Germany", R.drawable.dobermann),
    Dog("9", "Labrador Retriever", "United Kingdom", R.drawable.labrador_retriever),
    Dog("10", "Beagle", "England", R.drawable.beagle)
)
