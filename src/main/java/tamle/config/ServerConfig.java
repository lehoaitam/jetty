package tamle.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import tamle.service.HelloService;

/**
 * @author tle
 *
 */
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml" })
public class ServerConfig {

    @Autowired
    private List<HelloService> serviceBeans;

    @Autowired
    private JacksonJaxbJsonProvider jsonProvider;

    @Resource(name = "apiExceptionMapper")
    private ExceptionMapper<RuntimeException> exceptionMapper;

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @DependsOn("cxf")
    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setStaticSubresourceResolution(true);
        factory.setAddress("/api");

        factory.setServiceBeans(Arrays.<Object> asList(serviceBeans));
        factory.setProviders(Arrays.<Object> asList(jsonProvider, exceptionMapper));

        return factory.create();
    }

}