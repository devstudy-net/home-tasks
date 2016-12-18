package net.devstudy.jse.lection08_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class GenerateFakeAccounts {

	public static void main(String[] args) throws IOException {
		int countMale = 100;
		int countFemale = 100;

		List<String> maleNames = normalizeData(Files.readAllLines(Paths.get("files/people/male.txt"), StandardCharsets.UTF_8));
		List<String> femaleNames = normalizeData(Files.readAllLines(Paths.get("files/people/female.txt"), StandardCharsets.UTF_8));
		List<String> surnames = normalizeData(Files.readAllLines(Paths.get("files/people/surname.txt"), StandardCharsets.UTF_8));
		// Перемешиваем списки случайным образом, чтобы сгенерировать случайные
		// данные
		Collections.shuffle(maleNames);
		Collections.shuffle(femaleNames);
		Collections.shuffle(surnames);

		// Фамилии не должны повторяться, поэтому удаляем фамилию после
		// использования из списка и обязательно проверяем наличие данных для
		// генерации, чтобы не было IndexOutOfBoundsException
		try (PrintWriter pw = new PrintWriter(new FileWriter(new File("male-accounts.txt")))) {
			for (int i = 0; i < countMale && i < maleNames.size() && !surnames.isEmpty(); i++) {
				pw.println(maleNames.get(i) + " " + surnames.remove(0));
			}
			pw.flush();
		}
		try (PrintWriter pw = new PrintWriter(new FileWriter(new File("female-accounts.txt")))) {
			for (int i = 0; i < countFemale && i < maleNames.size() && !surnames.isEmpty(); i++) {
				pw.println(femaleNames.get(i) + " " + surnames.remove(0));
			}
			pw.flush();
		}
	}

	private static List<String> normalizeData(List<String> source) {
		// С помощью Set удалим дубликаты. LinkedHashSet нужен чтобы сохранился
		// порядок списка
		Set<String> set = new LinkedHashSet<>();
		for (String item : source) {
			// Приводим все символы к нижнему регистру и удаляем начальные и
			// конечные пробелы в строке
			String value = item.toLowerCase().trim();
			// Приводим первый символ строки к верхнему регистру. а остальные
			// символы остаются как есть
			value = toNameFormat(value);
			// Если строка не пустая. то добавляем в set
			if (value.length() > 0) {
				set.add(value);
			}
		}
		// Возвращаем список без дубликатов
		return new LinkedList<>(set);
	}

	private static String toNameFormat(String lowerCaseString) {
		if (lowerCaseString.length() > 1) {
			return Character.toUpperCase(lowerCaseString.charAt(0)) + lowerCaseString.substring(1);
		} else {
			return lowerCaseString.toUpperCase();
		}
	}
}
