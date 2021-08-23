package com.kurtthealien.kcomplementary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KComplementary {
	
	// The algorithm is O(n), but the sorting is O(NlogN), so the result is O(NlogN)
	public static StringBuffer findComplementaryPairs(int k, int[] inputArray) {
		
		StringBuffer buffer = new StringBuffer();
		
		if ((inputArray == null) || (inputArray.length < 2)) {
			return buffer;
		}
		
		Arrays.sort(inputArray);
		
		int startIter = 0;
		int endIter = inputArray.length - 1;
		Boolean first = true;
		
		while (startIter < endIter) {
						
			int currentSum = inputArray[startIter] + inputArray[endIter]; 
			
			if (currentSum == k) {
				if (!first) {
					buffer.append(", ");
				}
				System.out.println("New k-pair {" + inputArray[startIter] + "," + inputArray[endIter] + "}");
				buffer.append("{" + inputArray[startIter] + "," + inputArray[endIter] + "}");
				startIter++;
				endIter--;
				first = false;
			}
			else if (currentSum < k) {
				startIter++;
			}
			else
			{
				endIter--;
			}
		}
		
		System.out.println("Result: " + buffer);
		
		return buffer;
	}

	//As we run through the list one time per element, this algorithm is O(n^2)
	public static List<ComplementaryPair> findComplementaryPairIndexes(int k, int[] inputArray) {
		
		List<ComplementaryPair> resultList = new ArrayList<>();
		
		if ((inputArray == null) || (inputArray.length < 2)) {
			return resultList;
		}
				
		for (int firstIter = 0; firstIter < inputArray.length - 1; firstIter++) {
			
			for (int secondIter = firstIter + 1; secondIter < inputArray.length; secondIter++) {
		
				int currentSum = inputArray[firstIter] + inputArray[secondIter]; 
				
				if (currentSum == k) {
					System.out.println("New k-pair with indexes {" + firstIter + "," + secondIter + "}");
					resultList.add(new ComplementaryPair(firstIter, secondIter));
				}
			}
		}
		
		return resultList;
	}
}
