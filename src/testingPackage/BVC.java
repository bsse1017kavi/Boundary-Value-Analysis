package testingPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BVC
{
    Tester tester;

    int [][] output;

    public BVC(Tester tester)
    {
        this.tester = tester;
        output = new int[4*tester.numberOfParameters+1][tester.numberOfParameters];
    }

    public void writeFile()
    {
        try
        {
            File file = new File("BVC.csv");

            FileWriter fileWriter = new FileWriter(file);

            String currentLine = "";

            currentLine += "Test no.,";

            for(int i=0;i<tester.numberOfParameters;i++)
            {
                currentLine += "Parameter " + (i+1) + ",";
            }

            currentLine += "Expected result\n";

            fileWriter.write(currentLine);

            for(int i=0;i<4*tester.numberOfParameters+1;i++)
            {
                currentLine = "";

                currentLine += (i+1) + ",";

                for(int j=0;j<tester.numberOfParameters;j++)
                {
                    currentLine += output[i][j] + ",";
                }

                if(i!=4*tester.numberOfParameters)currentLine += "\n";

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

        for(int i=0;i<tester.numberOfParameters;i++)
        {
            //min value
            for(int j=0;j<tester.numberOfParameters;j++)
            {
                if(i==j)
                {
                    output[rowcount][j] = tester.min[j];
                }

                else
                {
                    output[rowcount][j] = (tester.min[j] + tester.max[j])/2;
                }
            }

            rowcount++;

            //min+ value
            for(int j=0;j<tester.numberOfParameters;j++)
            {
                if(i==j)
                {
                    output[rowcount][j] = tester.min[j]+1;
                }

                else
                {
                    output[rowcount][j] = (tester.min[j] + tester.max[j])/2;
                }
            }

            rowcount++;

            //max value
            for(int j=0;j<tester.numberOfParameters;j++)
            {
                if(i==j)
                {
                    output[rowcount][j] = tester.max[j];
                }

                else
                {
                    output[rowcount][j] = (tester.min[j] + tester.max[j])/2;
                }
            }

            rowcount++;

            //max- value
            for(int j=0;j<tester.numberOfParameters;j++)
            {
                if(i==j)
                {
                    output[rowcount][j] = tester.max[j]-1;
                }

                else
                {
                    output[rowcount][j] = (tester.min[j] + tester.max[j])/2;
                }
            }

            rowcount++;

        }

        //nom value
        for(int j=0;j<tester.numberOfParameters;j++)
        {
            output[rowcount][j] = (tester.min[j] + tester.max[j])/2;
        }
    }

    public void generateOutput()
    {
        evaluate();
        writeFile();
    }
}
