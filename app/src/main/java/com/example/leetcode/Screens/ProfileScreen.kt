    package com.example.leetcode.Screens

    import androidx.compose.foundation.layout.Column
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.lifecycle.compose.collectAsStateWithLifecycle
    import androidx.navigation.NavHostController
    import com.example.leetcode.Network.USERNAME
    import com.example.leetcode.ViewModel.ProfileViewModel

    @Composable
    fun ProfileScreen(viewModel: ProfileViewModel, navController: NavHostController, username: String) {

        USERNAME = username

        viewModel.fetchUserStats(username)

        val userStats = viewModel.userStats
//        val userStats = viewModel.userStats.collectAsStateWithLifecycle()
        val errorMessage = viewModel.errorMessage
//        val errorMessage = viewModel.errorMessage.collectAsStateWithLifecycle()

        Column {
            Text(text = "Username: $username")

            userStats.value?.let {
                Text(text = "Total Solved: ${it.solvedProblem}")
                Text(text = "Easy: ${it.easySolved}")
                Text(text = "Medium: ${it.mediumSolved}")
                Text(text = "Hard: ${it.hardSolved}")
            }

            errorMessage.value?.let {
                Text(text = "Error: $it")
            }
        }


    }