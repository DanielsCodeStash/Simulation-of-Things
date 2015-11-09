package util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiError extends WebApplicationException
{
    public ApiError(ErrorType code)
    {
        super(code.getHttpCode());
    }

    public ApiError(ErrorType type, String message)
    {

        super(
                Response.status(type.getHttpCode())
                        .entity(message)
                        .type(MediaType.TEXT_PLAIN_TYPE)
                        .build()
        );
    }
}
