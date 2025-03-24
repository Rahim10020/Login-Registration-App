package tg.rahimali.loginregistrationapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tg.rahimali.loginregistrationapp.R
import tg.rahimali.loginregistrationapp.components.HeadingTextComponent


@Composable
@Preview
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}

@Composable
fun TermsAndConditionsScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        HeadingTextComponent(text = stringResource(R.string.terms_and_conditons))
    }
}