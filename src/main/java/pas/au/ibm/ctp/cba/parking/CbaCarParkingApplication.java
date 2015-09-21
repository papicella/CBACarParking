package pas.au.ibm.ctp.cba.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CbaCarParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbaCarParkingApplication.class, args);
    }
}
