package com.manriquetavi.appgestor.presentation.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.navigation.Screen
import com.manriquetavi.appgestor.presentation.components.PasswordInputField
import com.manriquetavi.appgestor.presentation.components.UsernameInputField
import java.lang.Exception

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    val textUsername = rememberSaveable { mutableStateOf("") }
    val textPassword = rememberSaveable { mutableStateOf("") }
    val isVisible = rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //Image Login
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "Image LoginScreen")
            //Text title
            Text(
                modifier = Modifier.padding(bottom = 32.dp),
                text = "App Gestor",
                style = MaterialTheme.typography.h3,
            )
            //InputField Username
            UsernameInputField(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = textUsername,
                focusManager = focusManager
            )
            //InputField PasswordField
            PasswordInputField(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = textPassword,
                focusManager = focusManager,
                isVisible = isVisible
            )
            //Bottom to enter
            Button(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                onClick = {
                    loginViewModel.signInWithEmailAndPassword(
                        textUsername.value.trim(),
                        textPassword.value.trim()
                    ) {
                        textUsername.value = ""
                        textPassword.value = ""
                        navController.popBackStack()
                        navController.navigate(Screen.Main.route)
                    }
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Login"
                )
            }
            //Bottom to register
            OutlinedButton(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                onClick = {  },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Register"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}