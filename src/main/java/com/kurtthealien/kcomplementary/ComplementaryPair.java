package com.kurtthealien.kcomplementary;

public class ComplementaryPair {

	public int i;
	public int j;
	
	public ComplementaryPair(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	@Override
	public boolean equals(Object o) {

	    // Null and class checks
	    if ((o == null) || (getClass() != o.getClass()))
	        return false;
	    
	    // Identity check
	    if (this == o)
	        return true;

	    // Real comparison
	    ComplementaryPair otherPair = (ComplementaryPair) o;
	    return (i == otherPair.i) && (j == otherPair.j);
	}
	
	public String toString() {
		return "{" + i + "," + j + "}";
	}
}
