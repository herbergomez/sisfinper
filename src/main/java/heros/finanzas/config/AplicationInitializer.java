package heros.finanzas.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * @author oswaldo
 *
 */
@Configuration
public class AplicationInitializer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext)
													throws ServletException {
		AnnotationConfigWebApplicationContext rootContext
						   = new AnnotationConfigWebApplicationContext();
		//Load Application Context
		rootContext.register(AplicationContext.class);
		rootContext.setDisplayName("SPRING SISFINPER");
		
		//Context loader Listener
		servletContext.addListener(new ContextLoaderListener(rootContext));

		//Filter Force encoding all aplication map
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
		
        //Dysplatcher Servlet
        ServletRegistration.Dynamic dispatcher = 
        		servletContext.addServlet("dispatcher_sisfinper", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        dispatcher.addMapping("*.css");
        dispatcher.addMapping("*.png");
        dispatcher.addMapping("*.js");
	}

}
