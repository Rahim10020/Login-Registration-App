package tg.rahimali.loginregistrationapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tg.rahimali.loginregistrationapp.R

@Composable
fun NormalTextComponent(text : String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = colorResource(R.color.colorText),
        textAlign = TextAlign.Center
    )
}


@Composable
fun HeadingTextComponent(text : String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        color = colorResource(R.color.colorText),
        textAlign = TextAlign.Center
    )
}


@Composable
fun MyTextField(labelValue: String) {
    val textValue = remember {mutableStateOf("")}

    OutlinedTextField(
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.colorPrimary),
            focusedLabelColor = colorResource(R.color.colorPrimary),
            cursorColor = colorResource(R.color.colorPrimary),
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        }
    )
}