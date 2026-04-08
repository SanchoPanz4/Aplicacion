package com.bfernandez.myapplication

import androidx.compose.runtime.Composable
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
@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScrean(navController = navController)
        }
        composable<Pagina2>{backstackEntry ->
            val args = backstackEntry.toRoute<Pagina2>()
            Pagina2Screen(navController = navController, name = args.name)
        }
    }
}
@Composable
fun HomeScreen(navController: NavHostController){
    Button(onClick = {navController.navigate(pagina2("hola"))}){
        Text("Ir a la segunda pagina.")
    }
}

@Composable
fun Pagina2Screen(navController: NavHostController, name: String){
    Button(onClick = {
        val popped = navController.popBackStack()
        if(!popped){
            navController.navigate(Home)
        }
    })
    {
        Text("Volver")
    }
}