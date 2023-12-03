package com.promineotech;

import java.util.Random;
import java.util.function.IntPredicate;

public class TestDemo {

	public int addPositive(int a, int b) {

		if (a > 0 && b > 0)
			return a + b;
		else
			throw new IllegalArgumentException("Both parameters must be positive!");
	}

	

	public boolean nandLogicOperator(boolean a, boolean b) {
		return !(a&&b);
	}
	
	public int randomNumberSquared() {
		
		int squaredValue = getRandomInt();
		
		return squaredValue*squaredValue;
	}
	int getRandomInt() {

	    Random random = new Random();

	    return random.nextInt(10) + 1;

	}

}
