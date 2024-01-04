import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

	public static int[][] populate(ArrayList<Integer> list) {
		int[][] matrix = new int[list.size() / 2 + 1][list.get(0) + 1];
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				int skip = matrix[i - 1][j];
				int take = (j >= list.get(2 * i - 1))? matrix[i - 1][j - list.get(2 * i - 1)] + list.get(2 * i):0;
				//System.out.println(skip + ", " + take);
				if (skip > take) {
					matrix[i][j] = skip;
				} else {
					matrix[i][j] = take;
				}
			}
		}
		
		return matrix;
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> instances = new ArrayList<ArrayList<Integer>>();
		int numInstances = scnr.nextInt();

		for (int i = 0; i < numInstances; i++) {
			int items = scnr.nextInt();
			instances.add(new ArrayList<Integer>());
			instances.get(i).add(scnr.nextInt());
			
			for (int j = 0; j < items ; j++) {
				instances.get(i).add(scnr.nextInt());
				instances.get(i).add(scnr.nextInt());
			}
		}
		scnr.close();
		//System.out.println(instances);
		int[][] m;

		for (int i = 0; i < instances.size(); i++) {
			m = populate(instances.get(i));
			/*
			for (int j = 0; j < m.length; j++) {
				System.out.println(Arrays.toString(m[j]));
			}
			System.out.println();
			*/
			System.out.println(m[instances.get(i).size() / 2][instances.get(i).get(0)]);
		}
		
	}

}
