package net.devstudy.basic.lection9_string;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class StringUtils {

	public static String capitalizeWord(String word) {
		if (word.length() <= 1) {
			return word.toUpperCase();
		} else {
			return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
		}
	}
	
	public static int countMatch(String text, String phrase) {
		int count = 0;
		int index = 0;
		while(true) {
			index = text.indexOf(phrase, index);
			if(index == -1) {
				break;
			}
			count++;
			index += phrase.length();
		}
		return count;
	}
	
	public static String join(String[] array, String delimeter) {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<array.length;i++) {
			result.append(array[i]);
			if(i != array.length-1) {
				result.append(delimeter);
			}
		}
		return result.toString();
	}
	
	public static String replace(String text, String phraseToFind, String phraseToReplace) {
		return text.replace(phraseToFind, phraseToReplace);
	}
	
	public static void main(String[] args) {
		System.out.println(capitalizeWord("jaVa"));
		System.out.println(capitalizeWord("i"));
		
		System.out.println(countMatch("Hello world!", "world"));
		System.out.println(countMatch("Hello world!", "o"));
		System.out.println(countMatch("ooooo", "o"));
		System.out.println(countMatch("ooooo", "2"));
		
		System.out.println(join(new String[]{"1"},  ","));
		System.out.println(join(new String[]{"1", "2", "3"},  ","));
		
		System.out.println(replace("Hello Java! Java is a language", "Java", "C#"));
	}
}
