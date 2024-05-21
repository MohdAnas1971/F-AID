package com.example.f_aid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.f_aid.homeUI.NavController
import com.example.f_aid.ui.theme.FAIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FAIDTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavController()
    }
}
