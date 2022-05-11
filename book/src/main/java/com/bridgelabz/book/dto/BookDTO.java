package com.bridgelabz.book.dto;

import lombok.Data;

@Data
public class BookDTO {
	private String authoreName;
	private String bookName;
	private String bookImg;
	private int price;
	private int quantity;
}
