package com.example.pensionkeybackend.global.error

enum class GlobalErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {

    FEED_NOT_FOUND(404, "Feed Not Found"),
    NOT_DELETE_FEED(401, "Not Delete Feed"),
    NOT_VALID_USER(403, "Not Valid User"),

    BAD_REQUEST(400, "Bad Request"),
    PASSWORD_MISMATCH(400, "Password Mismatched"),

    EXPIRED_TOKEN(401, "Expired Token"),
    INVALID_TOKEN(401, "Invalid Token"),

    USER_NOT_FOUND(404, "User Not Found"),


    ALREADY_USER(409, "Already User"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    override fun status(): Int = status
    override fun message(): String = message
}
