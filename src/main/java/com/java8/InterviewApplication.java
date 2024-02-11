package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static java.util.function.Function.identity;

@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
		findEachCharacterOccurence("ilovejavatechie");
		CountofEachCharacterInString("ilovejavatechie");
		findAllDuplicatesInGivenString("ilovejavatechie");
		findNonDuplicateValueInGivenString("ilovejavatechie");
		findfirstNonReaptingCharacter("ilovejavatechie");
		findfirstRepeatingCharacter("ilovejavatechie");
		SortNumbers();
		SortReverseOrder();
		FindLongggestString();
		findNo1InGivenNumbers();
		
	
	}

	private static void findNo1InGivenNumbers() {
		int[] count = {1,4,6,5,10,8};
		
	  List<String>	ad =Arrays.stream(count).boxed().map(s->s+"").filter(s->s.startsWith("1")).collect(Collectors.toList());
	  System.out.println(ad);
		
	}

	private static void FindLongggestString() {
		String[] str = {"venkat","uma","vijay"};
		String longestString = Arrays.stream(str).reduce(( word1,word2) -> word1.length()> word2.length()?word1:word2).get();
		System.out.println(longestString);
		
	}

	private static void SortReverseOrder() {
		int[] count = {1,4,6,5,10,8};	
		List<Integer> ad =	Arrays.stream(count).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(ad);
	}

	private static void SortNumbers() {
		int[] count = {1,4,6,5,10,8};
		List<Integer> ad =Arrays.stream(count).boxed().sorted().collect(Collectors.toList());
		System.out.println(ad);
		
	}

	private static void findfirstRepeatingCharacter(String string) {
		String  ad =	Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
				.entrySet()
			    .stream()
			    .filter( s-> s.getValue() > 1)
			    .findFirst().get().getKey();
		System.out.println(ad);
		
	}

	private static void findfirstNonReaptingCharacter(String string) {
		String  ad =	Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
				.entrySet()
			    .stream()
			    .filter( s-> s.getValue() == 1)
			    .findFirst().get().getKey();
		
		System.out.println(ad);
		
	}

	private static void findNonDuplicateValueInGivenString(String string) {
		List<String>  ad =	Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
	    .stream()
	    .filter( s-> s.getValue() == 1)
	    .map( Map.Entry :: getKey)
	    .collect(Collectors.toList());
		System.out.println(ad);
	}

	private static void findAllDuplicatesInGivenString(String string) {
		List<String>  ad =Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.filter( s -> s.getValue() >1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		System.out.println(ad);
		
	}

	private static void findEachCharacterOccurence(String string) {
		String[] occ = string.split("");
		Map<String, List<String>> ad = Arrays.stream(occ).collect(Collectors.groupingBy(s -> s));
		System.out.println(ad);
		System.out.println(ad);

	}

	private static void CountofEachCharacterInString(String string) {

		String[] occ = string.split("");

		Map<String, Long> ad = Arrays.stream(occ)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(ad);

	}

}
