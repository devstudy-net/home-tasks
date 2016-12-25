package net.devstudy.basic.lection6_array;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class DisplayPercentageOfNumbersFromArray {

	public static void main(String[] args) {
		int array[] = { 1, 2, 1, 2, 2, 3 };

		int processedElements[] = new int[array.length];
		int elementsCount[] = new int[array.length];
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			// Проверяем было ли обработано данное число на предыдущих итерациях цикла
			boolean processed = false;
			for (int j = 0; j < count; j++) {
				if (processedElements[j] == value) {
					processed = true;
					break;
				}
			}
			// Если число не было обработано
			if (!processed) {
				// Считаем вложенным циклом количество одинаковых элементов
				int number = 1;
				for (int j = i + 1; j < array.length; j++) {
					if (value == array[j]) {
						number++;
					}
				}
				// Заполняем результирующие массивы и увеличиваем счетчик чисел (P.S. счетчик чисел используем как текущий индекс в массивах)
				processedElements[count] = value;
				elementsCount[count] = number;
				count++;
			}
		}

		for (int j = 0; j < count; j++) {
			System.out.println(processedElements[j] + "=" + (elementsCount[j] * 100 / array.length) + "%");
		}
	}
}
