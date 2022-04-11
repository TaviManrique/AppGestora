package com.manriquetavi.appgestor.presentation.screens.login


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manriquetavi.appgestor.R
import com.manriquetavi.appgestor.domain.model.Response
import com.manriquetavi.appgestor.navigation.Screen
import com.manriquetavi.appgestor.presentation.components.PasswordInputField
import com.manriquetavi.appgestor.presentation.components.ProgressBar
import com.manriquetavi.appgestor.presentation.components.ToastMessage
import com.manriquetavi.appgestor.presentation.components.UsernameInputField
import com.manriquetavi.appgestor.util.Util
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    val email = loginViewModel.email
    val password = loginViewModel.password
    val response = loginViewModel.signInState.value
    val isVisible = rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {}
    ) {
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
                        .padding(top = 40.dp)
                        .fillMaxWidth()
                        .height(150.dp),
                    painter = painterResource(id = R.drawable.img1),
                    contentDescription = "Image LoginScreen")
                //Text title
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "App Gestor",
                    style = MaterialTheme.typography.h4,
                )
                //InputField Username
                UsernameInputField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = email,
                    focusManager = focusManager
                )
                //InputField PasswordField
                PasswordInputField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = password,
                    focusManager = focusManager,
                    isVisible = isVisible
                )
                //Bottom to enter
                Button(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 16.dp)
                        .fillMaxWidth(),
                    onClick = {
                        loginViewModel.sigIn(
                            email.value.trim(),
                            password.value.trim()
                        )
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

    when(response) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> if(response.data) {
            LaunchedEffect(response.data) {
                navController.popBackStack()
                navController.navigate(Screen.Main.route)
            }
        }
        is Response.Error -> {
            Util.printError(response.message)
            ToastMessage(duration = Toast.LENGTH_SHORT, message = "Email or Password incorrect")
        }
    }
}

@ExperimentalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}