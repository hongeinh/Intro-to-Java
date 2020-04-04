package hust.soict.globalict.Lab02;
import java.util.Scanner;

public class MatrixAddition
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Matrix size n x m \nEnter n:");
        int n = sc.nextInt();
        System.out.print("Enter m:");
        int m = sc.nextInt();

        double [][] matrix_1 = new double[n][m];
        double [][] matrix_2 = new double[n][m];

        System.out.println("Enter first matrix elements:");
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < m; j++)
            {
                double temp = sc.nextDouble();
                matrix_1[i][j] = temp;
            }
        }
        System.out.println("Enter second matrix elements:");
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < m; j++)
            {
                double temp = sc.nextDouble();
                matrix_2[i][j] = temp;
            }
        }

        System.out.println("Sum matrix of the above two:");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                double sum = matrix_1[i][j] + matrix_2[i][j];
                System.out.format("%.2f ", sum);
            }
            System.out.println("\n");
        }
        sc.close();
    }
}
