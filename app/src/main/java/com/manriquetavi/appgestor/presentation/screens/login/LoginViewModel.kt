package com.manriquetavi.appgestor.presentation.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.RuntimeExecutionException
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    fun signInWithEmailAndPassword(email: String, password: String, main: () -> Unit)
            = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Log.d("FB", "Success: ${task.result.toString()}")
                        main()
                    } else {
                        Log.w("FB", "Failed: ${task.result.toString()}",task.exception)
                    }
                }
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        } catch (e: RuntimeExecutionException) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        } catch (e: FirebaseAuthEmailException) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        } catch (e: FirebaseAuthUserCollisionException) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        } catch (e: FirebaseAuthInvalidUserException) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        } catch (e: FirebaseException) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        } catch (e: Exception) {
            Log.e("FB", "Error: ${e.message}")
            e.printStackTrace()
        }
    }
}