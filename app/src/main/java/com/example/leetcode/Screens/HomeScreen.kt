package com.example.leetcode.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.leetcode.ViewModel.ProfileViewModel
import com.example.leetcode.profileScreen

@Composable
fun HomeScreen(viewModel: ProfileViewModel, navController: NavHostController) {

    val name = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(profileScreen(name.value))
            },
            colors = ButtonDefaults.buttonColors(Color(0, 150, 136)),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit")
        }
    }

}