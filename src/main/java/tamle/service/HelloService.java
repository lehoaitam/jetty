package tamle.service;

import javax.ws.rs.*;

@Path("/sampleService")
@Produces("application/json")
public interface HelloService {

    @GET
    @Produces("application/json")
    @Path("/hello")
    public String hello(String name);

}
