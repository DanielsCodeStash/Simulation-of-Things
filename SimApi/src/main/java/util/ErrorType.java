package util;

public enum ErrorType
{
    UNAUTHORIZED(401),      // Unauthorized. Wrong or missed credentials.
    BAD_REQUEST(400),       // Bad format. Incorrect parameter or query string.
    FORBIDDEN(403),         // Forbidden. A user has insufficient rights to perform an action.
    NOT_FOUND(404),         // Could not found the requested resource
    INTERNAL_ERROR(500),    // Internal server error. Arifiq messed up.
    NOT_IMPLEMENTED(501);   // Not implemented. The requested action is either not supported or not implemented yet.

    int httpCode;

    ErrorType(int httpCode)
    {
        this.httpCode = httpCode;
    }

    public int getHttpCode()
    {
        return httpCode;
    }
}
