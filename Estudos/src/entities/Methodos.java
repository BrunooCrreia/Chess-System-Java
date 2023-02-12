package entities;

import java.util.Arrays;

public class Methodos {
	int[] vector;

	public Methodos() {
	}

	public Integer colectNumbers(int[] vector) {
		vector = new int[2];
		for (int i = 0; i < 2; i++) {
			Arrays.sort(vector);
		}
		return vector[0];

	}

}
