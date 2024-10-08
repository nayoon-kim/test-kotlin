package com.zonzal.musinsa.response

data class ApiResponse<T> (
    val message: String? = "success",
    val body: T? = null
) {
    companion object {
        fun error(message: String?): ApiResponse<Unit> = ApiResponse(message = message)
        fun <T> success(body: T?): ApiResponse<T> = ApiResponse(body = body)
    }
}
