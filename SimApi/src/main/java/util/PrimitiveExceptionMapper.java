package util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
class PrimitiveExceptionMapper implements ExceptionMapper<Throwable>
{
    // this code will need to handle WebApplicationExceptions better
    // see http://stackoverflow.com/questions/19621653/how-should-i-log-uncaught-exceptions-in-my-restful-jax-rs-web-service
    // and http://stackoverflow.com/questions/583973/jax-rs-jersey-how-to-customize-error-handling?lq=1
    public Response toResponse(Throwable t)
    {
        if (t instanceof WebApplicationException)
        {
            return ((WebApplicationException) t).getResponse();
        } else
        {
            System.err.println("Uncaught exception thrown by REST service " + t);
            t.printStackTrace();
            return null;
        }
    }
}