package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				 arguments(1,2,3,false),
				 arguments(1,0,1,true),
				 arguments(1,-1,0,true),
				 arguments(-1,1,0,true),
				 arguments(0,1,1,true),
				 arguments(-1,-1,-2,true)
				);
	}
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a , int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() ->
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);
		}

	}
	
	@Test
	void assertThatNandLogicOperatorIsCorrect(){
		assertThat(testDemo.nandLogicOperator(false,false)).isEqualTo(true);
		assertThat(testDemo.nandLogicOperator(false,true)).isEqualTo(true);
		assertThat(testDemo.nandLogicOperator(true,false)).isEqualTo(true);
		assertThat(testDemo.nandLogicOperator(true,true)).isEqualTo(false);
	}
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	



	
	



}
