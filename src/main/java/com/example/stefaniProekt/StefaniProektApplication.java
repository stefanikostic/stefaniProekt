package com.example.stefaniProekt;

import com.example.stefaniProekt.service.getData.GetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@ServletComponentScan
@EnableAsync
public class StefaniProektApplication implements CommandLineRunner {

	@Autowired
	private GetDataService getDataService;

	public static void main(String[] args) {
		SpringApplication.run(StefaniProektApplication.class, args);
	}

	@Bean (name = "taskExecutor")
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("default_task_executor_thread");
		executor.initialize();
		return executor;
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		getDataService.findImageUrl();
	}
}
