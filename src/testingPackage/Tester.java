package testingPackage;

import java.util.Arrays;

public class Tester
{
    int numberOfParameters;

    int[] min;
    int[] max;

    public Tester(int numberOfParameters, int[] min, int[] max) {
        this.numberOfParameters = numberOfParameters;
        this.min = min;
        this.max = max;
    }

    public void print()
    {
        System.out.println("Number of parameters: " + numberOfParameters);

        for(int i=0;i<min.length;i++)
        {
            System.out.println("Param " + (i+1) + " extremes: " + min[i] + " " + max[i]);
        }
    }
}
