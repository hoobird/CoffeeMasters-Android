package com.frontendmasters.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frontendmasters.coffeemasters.R

//@Preview(showBackground = true, widthDp = 400)
//@Composable
//private fun Offer_Preview() {
//    Offer("My title 1", "This is an example description")
//}

//@Preview(showBackground = true, widthDp = 400)
@Preview(showBackground = true, widthDp = 400)
@Composable
fun OffersPagePreview() {
    OffersPage(padding = PaddingValues(16.dp))
}


@Composable
fun OffersPage(padding: PaddingValues) {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .padding(padding)
    ) {
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")

    }
}

//@Preview(showBackground = true, widthDp = 400)
@Composable
fun Offer(title:String, description: String) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.background_pattern),
            contentDescription = "Bg pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
//        Text("Title", fontSize = 16.sp)
            Text(
                title,
                style = MaterialTheme.typography.titleLarge,
//                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}