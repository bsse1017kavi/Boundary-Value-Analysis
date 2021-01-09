package testingPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Worst
{
    Tester tester;

    int [][] output;

    int [][] possibleValues;

    public Worst(Tester tester)
    {
        this.tester = tester;
        output = new int[(int)Math.pow(5,tester.numberOfParameters)][tester.numberOfParameters];

        possibleValues = new int[tester.numberOfParameters][5];

        for(int i=0;i<tester.numberOfParameters;i++)
        {
            possibleValues[i][0] = tester.min[i]; //min
            possibleValues[i][1] = tester.min[i] + 1; //min+
            possibleValues[i][2] = (tester.min[i] + tester.max[i])/2; //nom
            possibleValues[i][3] = tester.max[i] - 1; //max-
            possibleValues[i][4] = tester.max[i]; //max
        }
    }

    public void writeFile()
    {
        try
        {
            File file = new File("worst.csv");

            FileWriter fileWriter = new FileWriter(file);

            String currentLine = "";

            currentLine += "Test no.,";

            for(int i=0;i<tester.numberOfParameters;i++)
            {
                currentLine += "Parameter " + (i+1) + ",";
            }

            currentLine += "Expected result\n";

            fileWriter.write(currentLine);

            for(int i=0;i<(int)Math.pow(5,tester.numberOfParameters);i++)
            {
                currentLine = "";

                currentLine += (i+1) + ",";

                for(int j=0;j<tester.numberOfParameters;j++)
                {
                    currentLine += output[i][j] + ",";
                }

                if(i!=(int)Math.pow(5,tester.numberOfParameters)-1)currentLine += "\n";

                fileWriter.write(currentLine);
            }

            fileWriter.close();
        }catch (IOException e)
        {

        }
    }

    public void evaluate()
    {
        int rowcount = 0;
        int sameValueNumber = (int)Math.pow(5, tester.numberOfParameters-1);

        int currentValueAmount = sameValueNumber;

        int counter = 0;

        int currentValue = 0;

        for(int i=0;i<tester.numberOfParameters;i++)
        {
            counter = 0;
            currentValue = 0;

            for(int k=0;k< (int) 5*sameValueNumber/currentValueAmount; k++)
            {
                for(int j=0;j<currentValueAmount;j++)
                {
                    output[counter][i] = possibleValues[i][currentValue%5];
                    counter++;
                }

                currentValue++;
            }

            currentValueAmount /= 5;

        }
    }

    public void generateOutput()
    {
        evaluate();
        writeFile();
    }
}
