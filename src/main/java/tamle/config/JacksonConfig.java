package tamle.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * 
 * @author tle
 *
 */
@Configuration
public class JacksonConfig {

	@Bean(name = "jacksonMapper")
	public ObjectMapper jacksonMapper() {
		ObjectMapper om = new ObjectMapper();
		om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

		return om;
	}

	@Bean(name = "jsonProvider")
	public JacksonJaxbJsonProvider jsonProvider() {
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.setMapper(jacksonMapper());

		return provider;
	}

}
