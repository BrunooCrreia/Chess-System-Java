package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Methodos;

public class Praticas {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Methodos met = new Methodos();
				
		int[] vector = new int[2];
		vector[0] =25;
		vector[1] =38;
		vector[2] =29;
		met.colectNumbers(vector);
		
		System.out.println(met.colectNumbers(vector));
		
		
	}

}
