package annotation_config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("annotation_config")
public class AppConfig {
	//Alternative of bean configuration xml file(e.g. Dispatcher-servlet.xml)

}
