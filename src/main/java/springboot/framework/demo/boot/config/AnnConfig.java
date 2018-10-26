package springboot.framework.demo.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class AnnConfig {

    private String driver_class_name;
    private String url;
    private String username;
    private String password;


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedOrigin("http://111.207.151.82:17801");
        corsConfiguration.addAllowedOrigin("http://101.236.57.220:17801");
        corsConfiguration.addAllowedOrigin("http://192.168.8.55:17801"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }


    @Bean
    public FilterRegistrationBean corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(source));
        filterRegistrationBean.setName("corsFilter");
        return filterRegistrationBean;
    }


    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver_class_name);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    public void setDriver_class_name(String driver_class_name) {
        this.driver_class_name = driver_class_name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        System.out.println("username==>"+username);
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
