package org.generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SA_LPD10 {
	
	public static ArrayList<Integer> randNums(Integer max, Integer nums) {
		Set<Integer> repeat = new HashSet<Integer>();
		ArrayList<Integer> rands = new ArrayList<Integer>();
		
		while(rands.size() < nums) {
			Integer randint = (int) (Math.random()*max);
			if(repeat.contains(randint)) continue;
			
			rands.add(randint);
			repeat.add(randint);
		}
			
		return rands;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, String> dict = new HashMap<String, String>();
		
		dict.put("gato", "cat");
		dict.put("perro", "dog");
		dict.put("silla", "chair");
		dict.put("ventilador", "fan");
		dict.put("computador", "computer");
		dict.put("mesa", "desk");
		dict.put("correr", "run");
		dict.put("caminar", "walk");
		dict.put("hablar", "talk");
		dict.put("escribir", "write");
		dict.put("manzana", "apple");
		dict.put("comida", "food");
		dict.put("descansar", "rest");
		dict.put("fotografia", "picture");
		dict.put("bocina", "speaker");
		dict.put("desayuno", "breakfast");
		dict.put("almuerzo", "lunch");
		dict.put("guitarra", "guitar");
		dict.put("audifonos", "earphones");
		dict.put("taza", "mug");
		dict.put("lapiz", "pencil");
		
		ArrayList<String> words = new ArrayList<String>(dict.keySet());
		ArrayList<Integer> randNums;
		ArrayList<String> responses = new ArrayList<String>();
		boolean out = false;
		
		do {
			responses.clear();
			randNums = randNums(dict.size() - 1, 5);
			
			for(int i = 0; i < randNums.size(); i++) {
				String word = words.get(randNums.get(i));
				System.out.print("Escriba la traduccion de " + word + ": ");
				responses.add(sc.nextLine().toLowerCase());
			}
			
			for(int i = 0; i < randNums.size(); i++) {
				String word = words.get(randNums.get(i));
				if(dict.get(word).equals(responses.get(i))) {
					System.out.println(i+1 + ": " + "GOOD");
				} else {
					System.out.println(i+1 + ": " + "WRONG");
				}
			}
			
			System.out.print("Salir? (S/N): ");
			String sOut = sc.nextLine().toLowerCase();
			
			if(sOut.equals("s")) {
				out = true;
			}
			
		} while(!out);
		
		
		sc.close();
		
	}
	
}
