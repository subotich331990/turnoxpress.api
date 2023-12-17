package turnoXpress.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import turnoXpress.entities.Patient;

import turnoXpress.entities.Role;
import turnoXpress.services.UserService;

@Configuration
@EnableWebSecurity
public class WebConfig {

    private final UserService userService;


    public WebConfig(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // deshabilita csrf(cross-site request forgery) que viene por defecto
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/css/**", "/js/**", "/api/v1/login", "/api/v1/register").permitAll()
                        .requestMatchers("/admin").hasRole(Role.ADMIN.toString())
                     .requestMatchers("/").hasAnyRole(
                              Role.ADMIN.toString(), Role.USER.toString())
                       .anyRequest().authenticated()
                        )
           //    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // no se mantiene registro de la sesion, HASTA NO TENER JWT NO SE USA :)
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
