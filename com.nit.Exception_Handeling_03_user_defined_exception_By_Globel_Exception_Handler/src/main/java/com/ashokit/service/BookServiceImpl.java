package com.ashokit.service;

import org.springframework.stereotype.Service;

import com.ashokit.exception.NoBookFoundException;

@Service
public class BookServiceImpl implements IBookService{

	@Override
	public double findPriceById(String bookId) {
		
		if(bookId.equals("B101")) {
			return 450.50;
		}
		else {
			throw new NoBookFoundException("No book find with given id");
		}
		
	}

}
