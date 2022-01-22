package kr.co.markncompany.markorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"kr.co.markncompany.markorder.util"})
public class MarkOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkOrderApplication.class, args);
    }

}
