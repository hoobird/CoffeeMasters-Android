package com.frontendmasters.coffeemasters.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Preview
@Composable
private fun InfoPage_Preview() {
    InfoPage(padding = PaddingValues(0.dp))
}

@Composable
fun MyWebView(padding: PaddingValues) {
    var url = "https://firtman.github.io/coffeemasters/webapp"
    // AndroidView - Composable that allows you to put a classic android view
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient() // Not compulsory, for customizing the web view eg: disable javascript
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    },
        modifier = Modifier.padding(padding)
    )

}

@Composable
fun InfoPage(padding: PaddingValues) {
    MyWebView(padding)
}