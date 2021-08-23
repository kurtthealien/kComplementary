package com.kurtthealien.kcomplementary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.kurtthealien.kcomplementary.ComplementaryPair;
import com.kurtthealien.kcomplementary.KComplementary;

@RunWith(Parameterized.class)
public class KComplementaryPairsIndexesTest {
	
	int k;
	int[] intArray;
	List<ComplementaryPair> expectedPairsIndexesList;
	
	public KComplementaryPairsIndexesTest(int k[][], int[][] intArray, int[][] pairsArray) {
		this.k = k[0][0];
		this.intArray = intArray[0];
		
		expectedPairsIndexesList = new ArrayList<ComplementaryPair>();
		for (int[] pair:pairsArray) {
			expectedPairsIndexesList.add(new ComplementaryPair(pair[0], pair[1]));
		}
	}

	@Parameterized.Parameters
	public static Collection<?> testCases() {
		return Arrays.asList(new int[][][][] {
			{ {{8}}, {{}}, {}},
			{ {{8}}, {{4}}, {}},
			{ {{8}}, {{4,6}}, {}},
			{ {{8}}, {{2,6}}, {{0,1}}},
			{ {{7}}, {{0,2,4,5,6}}, {{1,3}}},
			{ {{7}}, {{4,0,6,5,2}}, {{3,4}}},
			{ {{5}}, {{1, 2, 3, 4, 5, 6, 7}}, {{0,3},{1,2}}},
			{ {{8}}, {{1, 2, 3, 4, 5, 6, 7}}, {{0,6},{1,5},{2,4}}},
			{ {{5}}, {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}}, {{0,5},{1,4},{2,3}}},
			{ {{5}}, {{0, 1, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9}}, {{0,6},{1,5},{2,5},{3,4}}},
			{ {{5}}, {{7, 1, 6, 9, 3, 6, 5, 1, 4, 0, 8, 2}}, {{1,8},{4,11},{6,9},{7,8}}}
		});
	}
	
	@Test
	public void testComplementaryPairsIndexes() {
		System.out.println("Testing Complementary Pairs Indexes algorithm with input: " + Arrays.toString(intArray) + " and k=" + k);
		
		List<ComplementaryPair> pairIndexesList = KComplementary.findComplementaryPairIndexes(k, intArray);
		assertEquals(expectedPairsIndexesList.size(), pairIndexesList.size());
		
		for (int i=0; i < expectedPairsIndexesList.size(); i++) {
			System.out.println("Comparing Complementary Pair Indexes " + i + ": " +  expectedPairsIndexesList.get(i).toString() + " vs " + pairIndexesList.get(i).toString());
		}
		
		assertEquals(expectedPairsIndexesList, pairIndexesList);
	}
}
