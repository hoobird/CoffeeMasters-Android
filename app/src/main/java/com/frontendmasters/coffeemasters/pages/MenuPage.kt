package com.frontendmasters.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.frontendmasters.coffeemasters.DataManager
import com.frontendmasters.coffeemasters.Product
import com.frontendmasters.coffeemasters.R
import com.frontendmasters.coffeemasters.ui.theme.Alternative1
import com.frontendmasters.coffeemasters.ui.theme.CardBackground
import com.frontendmasters.coffeemasters.ui.theme.Primary

//@Preview
//@Composable
//fun MenuPage_Preview() {
//    MenuPage(PaddingValues(0.dp))
//}


@Composable
fun MenuPage(padding: PaddingValues, dataManager: DataManager) {
    LazyColumn(
        modifier = Modifier.
        padding(padding)
    ){
        items(dataManager.menu) {
            Text(it.name,
                color = Primary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 20.dp, 10.dp, 10.dp))
            it.products.forEach {
                Card(
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp)
                ) {
                    ProductItem(product = it, onAdd = {
                        dataManager.cartAdd(it)
                    })
                }
            }
        }
//        items(
//            count = 5,
//            itemContent = {
//                Card(
//                    modifier = Modifier
//                        .background(CardBackground)
//                        .padding(12.dp)
//                ) {
//                    ProductItem(product = Product(1, "Dummy", 1.25, "")) { }
//                }
//            }
//        )
    }
}

@Preview
@Composable
fun ProductItem_Preview() {
    ProductItem(product = Product(1, "Dummy", 1.25, "")) { }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

//        Image(
        AsyncImage(
//            painter = painterResource(id = R.drawable.black_coffee),
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Alternative1, // Use containerColor instead of backgroundColor
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}
