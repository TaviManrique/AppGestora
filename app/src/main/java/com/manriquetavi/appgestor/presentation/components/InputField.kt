package com.manriquetavi.appgestor.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manriquetavi.appgestor.ui.theme.Purple500
import com.manriquetavi.appgestor.ui.theme.descriptionColor

@Composable
fun UsernameInputField(
    modifier: Modifier,
    text: MutableState<String>,
    focusManager: FocusManager?,
) {
    OutlinedTextField(
        modifier = modifier.padding(vertical = 16.dp).fillMaxWidth(),
        value = text.value,
        onValueChange = { text.value = it},
        placeholder = {
            Text(
                modifier = Modifier.alpha(alpha = ContentAlpha.medium),
                text = "Username"
            )
        },
        textStyle = TextStyle(
            color = MaterialTheme.colors.descriptionColor
        ),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person Icon",
                tint = MaterialTheme.colors.descriptionColor
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager?.clearFocus()
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Purple500
        )
    )
}

@Composable
fun PasswordInputField(
    modifier: Modifier,
    text: MutableState<String>,
    focusManager: FocusManager?,
    isVisible: MutableState<Boolean>
) {
    OutlinedTextField(
        modifier = modifier.padding(vertical = 16.dp).fillMaxWidth(),
        value = text.value,
        onValueChange = { text.value = it},
        placeholder = {
            Text(
                modifier = Modifier.alpha(alpha = ContentAlpha.medium),
                text = "Password"
            )
        },
        textStyle = TextStyle(
            color = MaterialTheme.colors.descriptionColor
        ),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock Icon",
                tint = MaterialTheme.colors.descriptionColor
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { isVisible.value = !isVisible.value }
            ) {
                Icon(
                    imageVector = Icons.Default.Visibility,
                    contentDescription = "Visibility Icon",
                    tint = MaterialTheme.colors.descriptionColor
                )
            }
        },
        visualTransformation = if (isVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager?.clearFocus()
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Purple500
        )
    )
}

@Preview(showBackground = true)
@Composable
fun InputFieldPreview() {
    UsernameInputField(
        modifier = Modifier,
        text = rememberSaveable { mutableStateOf("") },
        focusManager = null
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordInputFieldPreview() {
    PasswordInputField(
        modifier = Modifier,
        text = rememberSaveable { mutableStateOf("") },
        focusManager = null,
        isVisible = rememberSaveable { mutableStateOf(false) }
    )
}

