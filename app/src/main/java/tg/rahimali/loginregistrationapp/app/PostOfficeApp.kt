package tg.rahimali.loginregistrationapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import tg.rahimali.loginregistrationapp.navigation.PostOfficeAppRouter
import tg.rahimali.loginregistrationapp.navigation.Screen
import tg.rahimali.loginregistrationapp.screens.SignUpScreen
import tg.rahimali.loginregistrationapp.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TermsAndConditions -> {
                    TermsAndConditionsScreen()
                }
            }
        }
    }
}