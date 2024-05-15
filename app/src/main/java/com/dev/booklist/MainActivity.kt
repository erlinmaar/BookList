package com.dev.booklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dev.booklist.ui.theme.BookListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookListTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = { TopAppBar(navController) },
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
                    NavHostContainer(navController, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController) {
    val currentRoute = currentRoute(navController)
    CenterAlignedTopAppBar(
        title = { Text(text = getScreenTitle(currentRoute)) },
        navigationIcon = {
            if (currentRoute != "home") {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            } else null
        }
    )
}

fun getScreenTitle(route: String?): String {
    return when (route) {
        "home" -> "My List Book"
        "book" -> "My Book"
        "about" -> "About"
        else -> "My Book"
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == "grid",
            onClick = { navController.navigate("grid") },
            icon = { Icon(Icons.Default.GridOn, contentDescription = "Book") },
            label = { Text("Book") }
        )
        NavigationBarItem(
            selected = currentRoute == "about",
            onClick = { navController.navigate("about") },
            icon = { Icon(Icons.Default.Info, contentDescription = "About") },
            label = { Text("About") }
        )
    }
}

@Composable
fun NavHostContainer(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "home", modifier = modifier) {
        composable("home") { HomeScreen() }
        composable("grid") { GridScreen() }
        composable("about") { AboutScreen() }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}