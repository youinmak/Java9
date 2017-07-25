package com.java9.mak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Effective final resource
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Java\\Java9\\LICENSE")));
		
		try(br){
			br.lines().forEach(e -> System.out.println(e));
			
		}

	}

}
