package tg.rahimali.loginregistrationapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tg.rahimali.loginregistrationapp.R
import tg.rahimali.loginregistrationapp.components.CheckBoxComponent
import tg.rahimali.loginregistrationapp.components.HeadingTextComponent
import tg.rahimali.loginregistrationapp.components.MyTextField
import tg.rahimali.loginregistrationapp.components.NormalTextComponent
import tg.rahimali.loginregistrationapp.components.PasswordTextField
import tg.rahimali.loginregistrationapp.navigation.PostOfficeAppRouter
import tg.rahimali.loginregistrationapp.navigation.Screen


@Composable
@Preview
fun SignUpScreenPreview() {
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
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(stringResource(R.string.hello))
            HeadingTextComponent(stringResource(R.string.create_account))
            Spacer(modifier = Modifier.height(25.dp))
            MyTextField(
                stringResource(R.string.first_name),
                painterResource(R.drawable.ic_profile)
            )
            MyTextField(
                stringResource(R.string.last_name),
                painterResource(R.drawable.ic_profile)
            )
            MyTextField(
                stringResource(R.string.email),
                painterResource(R.drawable.ic_email)
            )
            PasswordTextField(
                stringResource(R.string.password),
                painterResource(R.drawable.ic_lock)
            )
            CheckBoxComponent(
                text = stringResource(R.string.policy),
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                }
            )
        }
    }
}