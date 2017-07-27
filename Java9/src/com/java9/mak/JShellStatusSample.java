package com.java9.mak;
import java.util.List;
import java.util.function.Consumer;


public class JShellStatusSample {
	public static void main(String... args) {
		// Create a JShell instance
		JShell shell = JShell.create();
		// Evaluate the Java code
		List<SnippetEvent> events = shell
				.eval("int x, y, sum; " + "x = 15; y = 23; sum = x + y; " + "System.out.println(sum)");
		for (SnippetEvent event : events) {
			// Create a snippet instance
			Snippet snippet = event.snippet();

			// Store the status of the snippet
			Snippet.Status snippetstatus = shell.status(snippet);
			if (snippetstatus == Status.VALID) {
				System.out.println("Successful ");
			}
		}
		
		
	}
}