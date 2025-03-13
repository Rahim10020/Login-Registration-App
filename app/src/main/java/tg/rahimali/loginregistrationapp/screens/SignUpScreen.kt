package tg.rahimali.loginregistrationapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import tg.rahimali.loginregistrationapp.components.NormalTextComponent


@Composable
@Preview
fun SignUpScreenPreview(){
    SignUpScreen()
}


@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
    ) {
        Column(modifier  = Modifier.fillMaxSize()) {
            NormalTextComponent(stringResource(R.string.hello))
            HeadingTextComponent(stringResource(R.string.create_account))
        }
    }
}