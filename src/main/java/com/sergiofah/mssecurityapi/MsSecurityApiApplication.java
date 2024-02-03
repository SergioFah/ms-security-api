package com.sergiofah.mssecurityapi;

import com.sergiofah.mssecurityapi.model.Update;
import com.sergiofah.mssecurityapi.service.UpdateService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableScheduling
public class MsSecurityApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsSecurityApiApplication.class, args);
	}

}
