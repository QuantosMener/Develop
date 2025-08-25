package com.quantos.composestarter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val HOME = "home"
    const val DETAILS = "details"
}

@Composable
fun AppNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            val vm: MainViewModel = hiltViewModel()
            HomeScreen(
                state = vm.uiState,
                onIncrement = vm::increment,
                onOpenDetails = { navController.navigate(Routes.DETAILS) }
            )
        }
        composable(Routes.DETAILS) {
            DetailsScreen(onBack = { navController.popBackStack() })
        }
    }
}
