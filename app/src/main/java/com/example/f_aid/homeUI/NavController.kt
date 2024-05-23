package com.example.f_aid.homeUI

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.f_aid.chatBot.ChatBot
import com.example.f_aid.scanner.DisplayResult
import com.example.f_aid.scanner.StateText
import com.example.f_aid.scanner.cameraApp


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NavController() {


    val navController = rememberNavController()

    var recognizedText = remember {
        StateText().recognizedText
    }



    NavHost(navController = navController, startDestination = "homePage") {



        composable("homePage") {HomePage(navController) }
        composable("CameraApp") {recognizedText=cameraApp(navController) }
        composable("ChatBot") { ChatBot(navController) }
        composable("DisplayResult") { DisplayResult(recognizedText) }
       // composable("TextScanner") { TextScanner(navController) }
    }
}