package com.frontendmasters.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.frontendmasters.coffeemasters.DataManager
import com.frontendmasters.coffeemasters.ItemInCart
import com.frontendmasters.coffeemasters.Product
import com.frontendmasters.coffeemasters.ui.theme.Primary

//@Preview
@Composable
fun OrderPage(padding: PaddingValues, dataManager: DataManager) {
    LazyColumn(
        modifier = Modifier.padding(padding)
    ) {
        if (dataManager.cart.count() == 0) {
            item {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text("Order is empty",
                        style = MaterialTheme.typography.titleLarge)
                }

            }
        }
        items(dataManager.cart) {
            CartItem(it, onDelete = {
                dataManager.cartRemove(it)
            })
        }
    }
}

@Composable
fun CartItem(it: ItemInCart, onDelete: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("${it.quantity}")
            Text(it.product.name,
                modifier = Modifier.width(150.dp)
            )
            Text(
                "${(it.quantity*it.product.price).format(2)}",
                modifier = Modifier.width(50.dp)
            )
            Image(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete",
                colorFilter = ColorFilter.tint(Primary),
                modifier = Modifier.clickable {
                    onDelete(it.product)
                }
            )
        }
    }
}
