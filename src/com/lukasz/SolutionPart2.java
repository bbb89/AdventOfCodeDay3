package com.lukasz;

public class SolutionPart2 {
    private static final int MAX_COLUMNS = 11;
    private static final int MAX_COLUMNS_WITH_MARGIN = MAX_COLUMNS + 2;

    public static int findFirstLargerThan(int number) {
        int[][] table = new int[MAX_COLUMNS_WITH_MARGIN][MAX_COLUMNS_WITH_MARGIN];
        int center = (MAX_COLUMNS_WITH_MARGIN / 2 + MAX_COLUMNS_WITH_MARGIN % 2) - 1;
        table[center][center] = 1;

        int x = center;
        int y = center;

        for(int i = 1; i < MAX_COLUMNS; i++) {
            for(int j = 0; j < i; j++) {
                y += 1;
                table[x][y] = calculateField(table, x, y);
                if(table[x][y] >= number) return table[x][y];
            }
            for(int j = 0; j < i; j++) {
                x -= 1;
                table[x][y] = calculateField(table, x, y);
                if(table[x][y] >= number) return table[x][y];
            }
            i++;
            for(int j = 0; j < i; j++) {
                y -= 1;
                table[x][y] = calculateField(table, x, y);
                if(table[x][y] >= number) return table[x][y];
            }
            for(int j = 0; j < i; j++) {
                x += 1;
                table[x][y] = calculateField(table, x, y);
                if(table[x][y] >= number) return table[x][y];
            }
        }

        return 0;
    }

    private static int calculateField(int[][] table, int x, int y) {
        return table[x-1][y] +
                table[x-1][y-1] +
                table[x-1][y+1] +
                table[x][y-1] +
                table[x][y+1] +
                table[x+1][y-1] +
                table[x+1][y] +
                table[x+1][y+1];
    }

    private static void printTable(int[][] table) {
        for(int i = 0; i < MAX_COLUMNS_WITH_MARGIN; i++) {
            for (int j = 0; j < MAX_COLUMNS_WITH_MARGIN; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
