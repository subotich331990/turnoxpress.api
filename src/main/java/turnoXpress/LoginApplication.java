package turnoXpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import turnoXpress.services.UserService;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		 SpringApplication.run(LoginApplication.class, args);

	}

}
