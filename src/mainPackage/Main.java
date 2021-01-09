package mainPackage;

import testingPackage.BVC;
import testingPackage.Robust;
import testingPackage.Tester;
import testingPackage.Worst;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int numberOfparameters;

        int [] min;

        int [] max;

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter number of parameters: ");

        numberOfparameters = scanner.nextInt();

        min = new int[numberOfparameters];
        max = new int[numberOfparameters];

        for(int i=0;i<numberOfparameters;i++)
        {
//            System.out.println("Enter the minimum and maximum value of parameter " + (i+1) + " :");
            min[i] = scanner.nextInt();
            max[i] = scanner.nextInt();
        }

        Tester tester = new Tester(numberOfparameters, min, max);

        BVC bvc = new BVC(tester);
        Robust robust = new Robust(tester);
        Worst worst = new Worst(tester);

        bvc.generateOutput();
        robust.generateOutput();
        worst.generateOutput();

        scanner.close();
    }
}
