package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mypack.ArticFox;

@Configuration
@ComponentScan(basePackageClasses=ArticFox.class)
public class MyConfig {

}
