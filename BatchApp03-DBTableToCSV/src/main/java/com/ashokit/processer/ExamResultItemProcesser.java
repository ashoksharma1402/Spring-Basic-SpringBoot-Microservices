package com.ashokit.processer;

import org.springframework.batch.item.ItemProcessor;

import com.ashokit.model.ExamResult;

public class ExamResultItemProcesser implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>=75)
			return item;
		else
		return null;
	}

}
