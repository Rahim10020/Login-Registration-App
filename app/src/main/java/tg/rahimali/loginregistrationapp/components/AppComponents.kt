package tg.rahimali.loginregistrationapp.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tg.rahimali.loginregistrationapp.R

@Composable
fun NormalTextComponent(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        color = colorResource(R.color.colorText),
        textAlign = TextAlign.Center
    )
}


@Composable
fun HeadingTextComponent(text: String) {
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
fun MyTextField(labelValue: String, painterResource: Painter) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.colorPrimary),
            focusedLabelColor = colorResource(R.color.colorText),
            cursorColor = colorResource(R.color.colorText),
            unfocusedContainerColor = colorResource(R.color.bgColor),
            focusedTextColor = colorResource(R.color.colorText)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = null,
            )
        },
        onValueChange = {
            textValue.value = it
        }
    )
}


@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter) {
    val password = remember { mutableStateOf("") }
    val passwordIsVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.colorPrimary),
            focusedLabelColor = colorResource(R.color.colorText),
            cursorColor = colorResource(R.color.colorText),
            unfocusedContainerColor = colorResource(R.color.bgColor),
            focusedTextColor = colorResource(R.color.colorText)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = null,
            )
        },
        trailingIcon = {
            val iconImage = if (passwordIsVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordIsVisible.value) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }
            IconButton(
                onClick = { passwordIsVisible.value = !passwordIsVisible.value }
            ) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        // masquer le texte qui s'affiche
        visualTransformation =
        if (passwordIsVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = {
            password.value = it
        }
    )
}


@Composable
fun CheckBoxComponent(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val checkedState = remember { mutableStateOf(false) }

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = !checkedState.value }
        )
        ClickableTextComponent(text)
    }
}

@Composable
fun ClickableTextComponent(text: String) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "privacy policy "
    val andText = "and "
    val termsOfUseText = "terms of use "

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(
            style = SpanStyle(color = colorResource(R.color.colorPrimary))
        ) {

            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(
            style = SpanStyle(color = colorResource(R.color.colorPrimary))
        ) {

            pushStringAnnotation(tag = termsOfUseText, annotation = termsOfUseText)
            append(termsOfUseText)
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = {offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("clickableTextComponent", "{ $span }")
                }


        }
    )
}