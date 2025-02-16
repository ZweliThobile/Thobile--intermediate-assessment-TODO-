package com.example.thobile_intermediateassessementtodo.reusableComponents

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import org.w3c.dom.Text


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun InputText(modifier: Modifier = Modifier,
                  text: String,
                  label: String,
                  maxLine: Int =1,
                  onTextChange : (String) -> Unit,
                  onImeAction: () -> Unit = {}) {

    val keyboardController = LocalSoftwareKeyboardController.current


    TextField(value = text, onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
        maxLines = maxLine,
        label = { Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()

            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@Composable
fun uiButton(modifier: Modifier = Modifier,
               text: String,
               onClick: () -> Unit,
               enabled: Boolean = true){

Button(onClick =  onClick,
    shape = CircleShape,
    enabled = enabled,
    modifier = modifier) {
  
    Text(text = text)
}

}

fun TextField(value: String, onValueChange: (String) -> Unit, maxLines: Int, label: () -> Unit, KeyboardOptions: KeyboardOptions, KeyboardActions: KeyboardActions) {

}
