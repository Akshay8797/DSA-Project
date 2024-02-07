package problems;

import java.util.HashMap;
import java.util.Map;

public class StringFrequency {

	public static void main(String[] args) {
		String s = "Akshay Kumar";
		String input = (s.toLowerCase()).replaceAll("\\s", "");
		Map<Character, Integer> frequencyMap = countCharacterFrequency(input);
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			System.out.println("Char: " + entry.getKey() + ", frequency: " + entry.getValue());
		}
	}

	private static Map<Character, Integer> countCharacterFrequency(String s) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}
		return frequencyMap;
	}

}
