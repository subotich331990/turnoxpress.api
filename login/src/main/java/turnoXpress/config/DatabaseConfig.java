package turnoXpress.config;
// DatabaseConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        /* Configuracion para BD en la Nube
        dataSource.setUrl("jdbc:mysql://umyclhuz5u6tl7e4:stxyITD7Sm4thFpUfXin@byoiwctmutmjnurpkqnz-mysql.services.clever-cloud.com:3306/byoiwctmutmjnurpkqnz");
        dataSource.setUsername("umyclhuz5u6tl7e4");
        dataSource.setPassword("stxyITD7Sm4thFpUfXin");
         */

        /* Configuracion para BD local */
        dataSource.setUrl("jdbc:mysql://localhost:3306/turnoxpress");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}