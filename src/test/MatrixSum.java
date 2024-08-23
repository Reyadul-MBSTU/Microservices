package test;

import java.util.Scanner;

public class MatrixSum {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[][] matrix = new int[6][6];
        for(int i =0; i< matrix.length; i++)
        {
            for(int j=0; j<matrix.length ; j++)
            {
                matrix[i][j]= sc.nextInt();
            }
        }
        printResult(matrix);
    }

    private static void printResult(int[][] matrix) {
        int value=0,max=0;
        for(int i=0; i< matrix.length-2; i++)
        {
            for(int j=0; j< matrix.length-2; j++)
            {
                value= matrix[i][j]+matrix[i][j+1]+matrix[i][j+2]
                        +matrix[i][j]+
                        matrix[i+2][j]+matrix[i+2][j+1]+matrix[i+2][j+2];
                max=Math.max(max, value);
            }
        }
        System.out.println(max);
    }
}
