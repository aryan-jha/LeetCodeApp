package com.example.leetcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leetcode.Screens.HomeScreen
import com.example.leetcode.Screens.ProfileScreen
import com.example.leetcode.ViewModel.ProfileViewModel
import com.example.leetcode.ui.theme.LeetCodeTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    val viewModel : ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeetCodeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)){

                        val navController = rememberNavController()

                        NavHost(navController = navController, startDestination = homeScreen){
                            composable<homeScreen> {
                                HomeScreen(viewModel,navController)
                            }
                            composable<profileScreen> {
                                ProfileScreen(viewModel,navController)
                            }
                        }




                    }
                }
            }
        }
    }
}

@Serializable
object homeScreen

@Serializable
data class profileScreen(
    val username : String
)

