package com.wearperfect.android.app.constant.navigation

enum class Destination(val route: String, val title: String) {
    ROOT_NAV_GRAPH(route = "/", title = "Nav Root"),

    LAUNCH_NAV_GRAPH(route = "/launch", title = "Launch Nav Graph"),
    SPLASH_SCREEN(route = "/launch/splash", title = "Splash"),

    AUTH_NAV_GRAPH(route = "/auth", title = "Auth Nav Graph"),
    LOGIN_SCREEN(route = "/auth/login", title = "Log in"),
    LOGIN_HELP_SCREEN(route = "/auth/login/help", title = "Log in help"),
    SIGNUP_SCREEN(route = "/auth/signup", title = "Sign up"),

    MAIN_NAV_GRAPH(route = "/main", title = "Main Nav Graph"),
    MAIN_SCREEN(route = "/main/home", title = "Main"),

    BOTTOM_NAV_HOST(route = "/main/home/host", title = "Bottom Nav Host"),
    BOTTOM_NAV_GRAPH(route = "/main/home/tabs", title = "Bottom Nav Graph"),
    FEED_SCREEN(route = "/main/home/tabs/feed", title = "Feed"),
    STORE_SCREEN(route = "/main/home/tabs/store", title = "Store"),
    STUDIO_SCREEN(route = "/main/home/tabs/studio", title = "Studio"),
    EXPLORE_SCREEN(route = "/main/home/tabs/explore", title = "Explore"),
    PROFILE_SCREEN(route = "/main/home/tabs/profile", title = "Profile")
}