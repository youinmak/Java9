package com.java9.mak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Effective final resource
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Java\\Java9\\LICENSE")));
		
		try(br){
			br.lines().limit(20).forEach(e -> System.out.println(e));
			
		}
		
		// underscore (_) invalid identifier
		//String _ = "";
		
		List<String> lst = List.<String>of("Makarand", "Thorat", "eCommera");
		
		Set<String> set = Set.<String>of("Makarand", "Thorat", "eCommera");
		
		Map<String, Integer> mp = Map.<String, Integer>of("A", 1, "B", 2, "C", 3);
		
		Optional<String> findAny = lst.stream().findAny();
		
		Optional<String> findFirst = lst.stream().findFirst();
		
		findAny.ifPresent(e -> System.err.println(e));
		
		findFirst.ifPresentOrElse(ele -> System.out.println(ele), () -> System.out.println("I am runnable"));
		
		Optional<String> optional = findAny.or(() -> Optional.empty());
		
		Stream<String> stream = findFirst.stream();
		
		lst.stream().dropWhile(e1 -> e1.equals("Thorat")).forEach(e2 -> System.out.println(e2));
		
		lst.stream().takeWhile(e1 -> e1.equals("Makarand")).forEach(e2 -> System.out.println(e2));
		
		Thread thread = new Thread(()-> System.out.println("new runnable"));

		Thread.onSpinWait();
		thread.start();
		
		ProcessBuilder ls = new ProcessBuilder()
				.command("ls")
				.directory(Paths.get("/tmp").toFile());
		ProcessBuilder wc = new ProcessBuilder()
				.command("wc", "-l")
				.redirectOutput(Redirect.INHERIT);
		List<Process> lsPipeWc = ProcessBuilder
				.startPipeline(Arrays.asList(ls, wc));
		
		//lsPipeWc.forEach(e -> e.);
	}
	
	
	public Main(int a) {
		super();
	}
	
	// safevarargs allowed on 
	@SafeVarargs
	private void safeMethod() {
		
	}

}
