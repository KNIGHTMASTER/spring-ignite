package com.zisal.ignite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

/**
 * Created on 4/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.zisal.ignite" })
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine((SpringTemplateEngine) templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }

    @Bean
    public TemplateEngine templateEngine(){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver());
        springTemplateEngine.addTemplateResolver(templateResolver());
        springTemplateEngine.addTemplateResolver(urlTemplateResolver());
        //springTemplateEngine.addDialect(new SpringSecurityDialect());
        /*springTemplateEngine.addDialect(new TilesDialect());
        springTemplateEngine.addDialect(new LayoutDialect());*/
        return springTemplateEngine;
    }

    @Bean
    public UrlTemplateResolver urlTemplateResolver(){
        return new UrlTemplateResolver();
    }

    @Bean
    public ITemplateResolver templateResolver(){
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/resources/templates/");
        resolver.setTemplateMode("HTML");
        resolver.setSuffix(".html");
        resolver.setCacheable(false);
        return resolver;
    }

}
