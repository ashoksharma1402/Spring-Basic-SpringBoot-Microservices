package com.ashokit.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobMoniteringListener implements JobExecutionListener {
	private long start, end;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		start=System.currentTimeMillis();
		System.out.println("Job is about to start @"+new Date());

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		end=System.currentTimeMillis();
		System.out.println("job completion @::"+new Date());
		System.out.println("Jpob execution time::"+(start-end)+"ms");
		System.out.println("job completion status::"+jobExecution.getStatus());

	}

}
