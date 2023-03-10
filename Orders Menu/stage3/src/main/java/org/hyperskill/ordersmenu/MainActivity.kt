package org.hyperskill.ordersmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.hyperskill.ordersmenu.theme.PlayOrdersMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayOrdersMenuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.fillMaxSize()) {
                        Title(title = "Orders Menu")
                        OrderMenuItem(itemName = "Fettuccine")
                    }
                }
            }
        }
    }

    @Composable
    fun Title(title: String) {
        Row(Modifier.fillMaxWidth(), Arrangement.Center) {
            Text(title, fontSize = 48.sp)
        }
    }

    @Composable
    fun OrderMenuItem(itemName: String) {
        Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.Bottom) {
            var quantity by remember { mutableStateOf(0) }

            Text(
                text = itemName,
                color = if (quantity >= 5) Color.Red else Color.Black,
                fontSize = 24.sp
            )

            Text(text = "+", fontSize = 24.sp, modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable {
//                                if(quantity == 1)
//                                    quantity++

                    if (quantity < 5) {
//                                    quantity += 2
                        quantity++

                    }
                })

            Text(text = "${quantity}", fontSize = 24.sp)

            Text(text = "-", fontSize = 24.sp, modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable {
                    if (quantity > 0) {
                        quantity--
                    }
                })
        }
    }
}