package com.coding.utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static <E> void generate(String text, Collection<E> collection) {
		System.out.println(text + " --> {");
		for (E element: collection) {
			System.out.println("   + " + element);
		}
		System.out.println("}\n");
	}
	
	public static <E> void generate(String text, E element) {
		Optional.ofNullable(element)
			.ifPresentOrElse(
				val -> generate(text, List.of(element)),
				() -> System.out.println(text + " --> Phần tử không tồn tại")
			);
	}
	
}
