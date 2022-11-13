package dev.compose.app.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.compose.app.components.ForgotPasswordScreen
import dev.compose.app.components.OnBoardingScreen
import dev.compose.app.components.home.HomeScreen
import dev.compose.app.components.login.LoginScreen
import dev.compose.app.components.profile.ProfileScreen
import dev.compose.app.components.registration.RegistrationScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.OnBoarding.path
    ) {

        addOnBoardingScreen(navController, this)

        addLoginScreen(navController, this)

        addRegistrationScreen(navController, this)

        addForgotPasswordScreen(navController, this)

        addHomeScreen(navController, this)

        addProfileScreen(navController, this)
    }
}

private fun addOnBoardingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.OnBoarding.path) {
        OnBoardingScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            },
            navigateToRegistration = {
                navController.navigate(NavRoute.Registration.path)
            }
        )
    }
}

private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        LoginScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            },
            navigateToRegistration = {
                navController.navigate(NavRoute.Registration.path)
            }
        )
    }
}

private fun addRegistrationScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Registration.path) {
        RegistrationScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            },
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addForgotPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.ForgotPassword.path) {
        ForgotPasswordScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            }
        )
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToProfile = { id, showDetails ->
                navController.navigate(
                    NavRoute.Profile.withArgs(
                        id.toString(),
                        showDetails.toString()
                    )
                )
            },
            navigateToSearch = { query ->
                navController.navigate(NavRoute.Search.withArgs(query))
            },
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) },
        )
    }
}

private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(NavRoute.Login.path, inclusive = false)
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.withArgsFormat(NavRoute.Profile.id, NavRoute.Profile.showDetails),
        arguments = listOf(
            navArgument(NavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(NavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        ProfileScreen(
            id = args?.getInt(NavRoute.Profile.id)!!,
            showDetails = args.getBoolean(NavRoute.Profile.showDetails),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController) }
        )
    }
}
