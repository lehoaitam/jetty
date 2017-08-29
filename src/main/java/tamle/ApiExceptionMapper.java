package tamle;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author tle
 *
 */
@Component("apiExceptionMapper")
public class ApiExceptionMapper implements ExceptionMapper<Exception> {


    /*
     * (non-Javadoc)
     *
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    public Response toResponse(Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new RuntimeException()).build();
    }
}