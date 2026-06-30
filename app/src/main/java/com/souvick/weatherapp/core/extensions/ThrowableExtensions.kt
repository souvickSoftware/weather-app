package com.souvick.weatherapp.core.extensions

import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.toUserMessage(): String =
    when (this) {

        is UnknownHostException ->
            "No internet connection."

        is SocketTimeoutException ->
            "Request timed out. Please try again."

        is HttpException ->
            "Unable to connect to the server."

        else ->
            "Something went wrong. Please try again."
    }