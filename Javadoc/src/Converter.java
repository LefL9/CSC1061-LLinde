/*
 * Copyright (c) 2025 Lef Linde
 */

/**
 * Methods for converting between inches and centimeters
 * @author Lef Linde
 */
//Javadoc comment^^
public class Converter {
	
	public static final double CM_PER_INCH = 2.54;
	private static final int IN_PER_FOOT = 12;
	
	/**
	 * Converts a measurement in centimeters to inches
	 * @param cm length in centimeters
	 * @return length in inches
	 */
	
	public static double toInches(double cm) {
		return cm/CM_PER_INCH;
	}
	
	/**
	 * Converts a length in feet and inches to centimeters
	 * @param feet how many feet
	 * @param inches how many inches
	 * @return length in centimeters
	 */
	public static double toCentimeters(int feet, int inches) {
		int total = feet * IN_PER_FOOT;
		return total * CM_PER_INCH;
	}
}
