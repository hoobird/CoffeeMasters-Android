package com.frontendmasters.coffeemasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.frontendmasters.coffeemasters.ui.theme.CoffeeMastersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataManager = ViewModelProvider(this)
            .get(DataManager::class.java)
        setContent {
            CoffeeMastersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(dataManager)
                }
            }
        }
    }
}


@Preview(showBackground = true)
//@Preview(showBackground = true, widthDp = 200)
@Composable
fun TestComposable() {
    var name = remember{ mutableStateOf("") }
    Column {
        Text(
            text = "Hello ${name.value}",
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
                .padding(16.dp)
        )
        TextField(name.value, onValueChange = {
            name.value = it
        })
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TestComposable2() {
//    Text(
//        text = "Hello world",
//        modifier = Modifier
//            .background(Color.Blue)
//            .padding(16.dp)
//            .background(Color.White)
//    )
//    Text(
//        text = "Test "
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun TestComposable2() {
//    Text(text = "Hello world")
//}