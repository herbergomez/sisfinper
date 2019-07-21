package heros.finanzas.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


/**
 * 
 * @author oswaldo
 *
 */
@Configuration
@ComponentScan(value="heros.finanzas.*")
//@EnableTransactionManagement(proxyTargetClass=true)
@EnableWebMvc
public class AplicationContext extends WebMvcConfigurerAdapter{
	
	@Resource
	private Environment env;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
        //registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		 registry.addResourceHandler("/resources/**").addResourceLocations("/webjars/").resourceChain(false);
		 registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/resources/").resourceChain(false);
    }
	
	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();		
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("i18n/messages", "i18n/messages_EN");
		//source.setDefaultEncoding(env.getRequiredProperty("DEFAULT_ENCODING"));
		return source;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect());
		return engine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() 
	{
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		resolver.setContentType("text/html; charset=UTF-8");
		return resolver;
	}
}
