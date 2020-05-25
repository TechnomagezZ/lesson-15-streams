package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlgorithmsUsingStreams {

	public static long countGoodEggs(List<String> eggs) {
		return eggs.stream()				// 1. create stream
		.filter(egg -> egg.equals("whole")) // 2. intermediate filter operation
		.count();							// 3. terminal operation: reduce to an int
	}

	public static Object findTallest(List<Double> peeps) {
//		return Collections.max(peeps);
		return peeps.stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}

	public static long addStringOfNumbers(String numbers) {
		return numbers
		 	.chars()		
		 	.mapToObj(c -> Character.toString(c))	
			.mapToInt(num -> Integer.parseInt(num))
			.sum();
	}

	public static long countPearls(List<Boolean> oysters) {
		return oysters.stream()
		.filter(oyster -> oyster.equals(true))
		.count();
	}

	public static Object findLongestWord(List<String> words) {
		return words.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
	}

	public static Object sortDNA(List<String> unsortedSequences) {
		return unsortedSequences.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
	}

	public static List<String> sortWords(List<String> words) {
		return words.stream().sorted().collect(Collectors.toList());
	}

	public static Object getDistinctSpellsInAlphabeticalOrder(List<String> spellsCastThisWeek) {
		return spellsCastThisWeek.stream().distinct().sorted().collect(Collectors.toList());
	}

	public static List<Double> sortScores(List<Double> results) {
		
		return results.stream().sorted().collect(Collectors.toList());
	}

	//public static Object getBatPhrases(String[] batmanScript) {
		//List<String> batScript = Arrays.asList(batmanScript); 
		//String str1 = "Bam";
		//String str2 = "Pow";
		//return batScript.stream()
						//.filter(batScripts -> batScripts.contains(str1))
						//.map(String::toUpperCase)
						//.collect(Collectors.toList());
	//}


	public static Long countXs(String xString) {
		char c = 'x';
		return xString.chars() 
	            .filter(chars -> chars == c) 
	            .count();
	}

	public static Double getAverage(int[] numbers) {
		return Arrays.stream(numbers).average().orElse(Double.NaN);
	}

	public static Integer countOccurrences(String[] strArr, String string) {
		List<String> occur = Arrays.asList(strArr);
		return (int) occur.stream().filter(occurance -> occurance.equalsIgnoreCase(string)).count();
	}

	//public static Integer addEven(String numbers) {
		//List<String> number = Arrays.asList(numbers);
		//return number.stream().mapToInt(num -> Integer.parseInt(numbers))
				//.filter(num -> num % 2 == 0)
				//.sum();
	//}
	}

	
