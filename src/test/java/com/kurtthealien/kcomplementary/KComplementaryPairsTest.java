package com.kurtthealien.kcomplementary;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.kurtthealien.kcomplementary.KComplementary;

@RunWith(Parameterized.class)
public class KComplementaryPairsTest {
	
	int k;
	int[] intArray;
	StringBuffer expectedPairsString;
	
	private StringBuffer getPairsString(int[][] inputArray) {
		StringBuffer sb = new StringBuffer();
		Boolean first = true;
		for (int[] element : inputArray) {
			if (!first) {
				sb.append(", ");
			}
			System.out.println("New Expected Pair: {" + element[0] + "," + element[1] + "}");
			sb.append("{" + element[0] + "," + element[1] + "}");
			first = false;
		}
		return sb;
	}

	public KComplementaryPairsTest(int[][] k, int[][] intArray, int[][] pairsArray) {
		this.k = k[0][0];
		this.intArray = intArray[0];
		this.expectedPairsString = getPairsString(pairsArray); 
	}
	
	@Parameterized.Parameters
	public static Collection<?> testCases() {
		return Arrays.asList(new int[][][][] {
			{ {{8}}, {{}}, {}},
			{ {{8}}, {{4}}, {}},
			{ {{8}}, {{4,6}}, {}},
			{ {{8}}, {{2,6}}, {{2,6}}},
			{ {{7}}, {{0,2,4,5,6}}, {{2,5}}},
			{ {{7}}, {{4,0,6,5,2}}, {{2,5}}},
			{ {{5}}, {{1, 2, 3, 4, 5, 6, 7}}, {{1,4},{2,3}}},
			{ {{8}}, {{1, 2, 3, 4, 5, 6, 7}}, {{1,7},{2,6},{3,5}}},
			{ {{5}}, {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}}, {{0,5},{1,4},{2,3}}},
			{ {{5}}, {{0, 1, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9}}, {{0,5},{1,4},{2,3}}},
			{ {{5}}, {{0, 1, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9}}, {{0,5},{1,4},{2,3}}}
		});
	}
	
	@Test
	public void testComplementaryPairs() {
		System.out.println("Testing Complementary Pairs algorithm with input: " + Arrays.toString(intArray) + " and k=" + k);
		
		StringBuffer resultString = KComplementary.findComplementaryPairs(k, intArray);
		
		System.out.println("Expecting \"" + expectedPairsString + "\" and retrieved \"" + resultString + "\"");
		assertEquals(expectedPairsString.toString(), resultString.toString());
	}
}
