package com.frontendmasters.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.frontendmasters.coffeemasters.pages.InfoPage
import com.frontendmasters.coffeemasters.pages.MenuPage
import com.frontendmasters.coffeemasters.pages.OffersPage
import com.frontendmasters.coffeemasters.pages.OrderPage


import com.frontendmasters.coffeemasters.ui.theme.CoffeeMastersTheme


//@Preview
//@Composable
//private fun App_Preview(){
//    CoffeeMastersTheme {
//        App()
//    }
//}

//@Preview
@Composable
fun AppTitle() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {
    var selectedRoute  = remember {
        mutableStateOf("menu")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    AppTitle()
                }
            )
        },
        bottomBar = {
            NavBar (
                selectedRoute = selectedRoute.value,
                onChange = {
                    selectedRoute.value = it
            })
        },
        content = {
            padding ->
                when (selectedRoute.value) {
                    Routes.MenuPage.route -> MenuPage(padding, dataManager)
                    Routes.OffersPage.route -> OffersPage(padding)
                    Routes.OrderPage.route -> OrderPage(padding, dataManager)
                    Routes.InfoPage.route -> InfoPage(padding)
                }
        }
    )
}


