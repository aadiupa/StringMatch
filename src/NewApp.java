import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.Subset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
//C:\\Users\\aditya_upadhyay\\Desktop/abc.txt
public class NewApp {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\aditya_upadhyay\\Desktop/abc.txt";
		String c = readLineByLineJava8(filePath);
		System.out.println(c);
		String regex = "\\bhere\\b";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(c);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
		}
	}

	private static String readLineByLineJava8(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}
}
