package server.exception

data class ErrorResponse(
        val code: Int,
        val message: String,
)