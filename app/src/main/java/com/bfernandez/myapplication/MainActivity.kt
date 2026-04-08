package com.bfernandez.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bfernandez.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme {
                Navigation()
                Scaffold(
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
                    bottomBar = {BottomBar()}
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
        }
    }
}

@Composable
fun GridCards() {
    val items = listOf(
        ItemCard(1, "Author", R.drawable.pencil),
        ItemCard(2, "Editor", R.drawable.edit_document),
        ItemCard(3, "Moderator", R.drawable.user),
        ItemCard(4, "Accountant", R.drawable.analytics),
        ItemCard(5, "Designer", R.drawable.design_services),
        ItemCard(6, "Developer", R.drawable.settings)
    )
    var selected by remember { mutableIntStateOf(0) }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 50.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(items) {
            Card(
                colors = CardDefaults.cardColors(
                        containerColor = if (selected == it.id)
                            Color(48, 79, 251, 255)
                        else
                            Color(26, 40, 65, 255),
                        contentColor = if (selected == it.id)
                            Color.White
                        else
                            Color(62, 184, 200, 255)
                ),
                onClick = { selected = it.id }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(.9f),
                        horizontalArrangement = Arrangement.End
                    ) {
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = "Check",
                                modifier = Modifier.alpha(if (selected == it.id) 1f else 0f)
                            )
                    }
                    Icon(
                        painterResource(it.icon),
                        contentDescription = "Author",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        "Author",
                    )
                }
            }
        }
    }
}

class ItemCard(val id: Int, val title: String, val icon: Int)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun BottomBar(){
    var textValue by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Enter as Guest") },
        )
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(48, 82, 250, 255),
                contentColor = Color.White
            )
        ) {
            Icon(Icons.AutoMirrored.Default.ArrowForward, contentDescription = "next")
        }
    }
}