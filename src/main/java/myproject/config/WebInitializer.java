package myproject.config;

import myproject.config.security.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/mvc/*"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ConfigApp.class, SecurityConfig.class};
    }

}
