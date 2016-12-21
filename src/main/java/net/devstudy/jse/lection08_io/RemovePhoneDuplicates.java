package net.devstudy.jse.lection08_io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class RemovePhoneDuplicates {
	public static void main(String[] args) throws IOException {
		Set<String> uniquePhones = new LinkedHashSet<>(Files.readAllLines(Paths.get("files/phones.txt"), StandardCharsets.UTF_8));
		Files.write(Paths.get("files/target/unique-phones.txt"), uniquePhones, StandardCharsets.UTF_8);
	}
}
