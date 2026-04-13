package com.bfernandez.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Pagina2(val name: String)

@Serializable
object Paginaprueba
@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Pagina2>{backstackEntry ->
            val args = backstackEntry.toRoute<Pagina2>()
            Pagina2Screen(navController = navController, name = args.name)
        }
        composable<Paginaprueba>{backstackEntry->
            val args = backstackEntry.toRoute<Paginaprueba>()
            PaginapruebaScreen(navController = navController)
        }
    }
}
@Composable
fun HomeScreen(navController: NavHostController){   Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = Color(0, 16, 41, 255),
    topBar = {
        Button(
            onClick = {},
            colors = ButtonColors(
                containerColor = Color(40, 196, 217, 255),
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White,
            )
        ) {
            Text("< Back", fontSize = 20.sp)
        }
    },
    bottomBar = {BottomBar(navController = rememberNavController())}
) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
        Text(
            "Select User Type ",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text("Please choose your profession", color = Color(255, 255, 255, 200))
        GridCards()
    }
}
}

