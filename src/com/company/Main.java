package com.company;

public class Main {

    public static void main(String[] args) {

        int[][] example =  {{0,1,0,1},
                            {0,0,0,1},
                            {1,0,0,1},
                            {1,0,0,1}};

	    System.out.println(mineralFormation(example));
    }
    protected static String mineralFormation(int[][] table)
    {
        boolean stalaktytFlag = false;
        boolean stalagmitFlag = false;
        boolean filarFlag = false;
        int[] colIndex = new int[3];
        int tempCounterFilar = 0;
        int rowSize = table.length;
        int colSize = table[0].length;
        String feedbackMessage ="";

        for(int i = 0; i < colSize; i++)
        {
            for(int j = 0; j < rowSize -1; j++)
            {
                if((table[0][i] == 0) && (table[rowSize-1][i] == 0))break;
                if((table[j][i] == 1) && (table[j + 1][i] == 0) && !stalaktytFlag)
                {
                    stalaktytFlag = true;
                    colIndex[0] = i+1;
                }
                if((table[j][i] == 0) && (table[j + 1][i] == 1) && !stalagmitFlag)
                {
                    stalagmitFlag = true;
                    colIndex[1] = i+1;
                }
                if((table[j][i] == 1) && (table[j + 1][i] == 1) && !filarFlag)
                {
                    tempCounterFilar++;
                }
            }
            if(tempCounterFilar == rowSize - 1)
            {
                filarFlag = true;
                colIndex[2] = i+1;
            }
            else
                tempCounterFilar = 0;

            if(filarFlag & stalagmitFlag & stalaktytFlag)break;
        }

        if(stalaktytFlag) feedbackMessage = feedbackMessage + "stalaktyt: kolumna - "+colIndex[0]+'\n';
        if(stalagmitFlag) feedbackMessage = feedbackMessage + "stalagmit: kolumna - "+colIndex[1]+'\n';
        if(filarFlag) feedbackMessage = feedbackMessage + "filar: kolumna - "+colIndex[2]+'\n';
        return feedbackMessage;

    }
}
