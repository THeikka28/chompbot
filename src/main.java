public class main {
    //need to make the way to assign the numbers to winners/losers array and compare that array
    public position [] boards;
    public int[] current;
    public int[][] winners;
    public int[][] losers;
    public static void main() {
        main ex = new main();
    }
    public main() {

        current = new int[3];
        current[0] = 3;
        current[1] = 1;
        current[2] = 0;
        boards= new position[20];
        winners = new int [3][20];
        losers = new int [3][20];
        for(int x = 0; x< winners.length; x++)
        {
            for(int y=0; y< winners[0].length; y++) {
                winners[x][y] = -1;
                losers[x][y] = -1;
            }
        }
        losers[0][0]= 1;
        losers[1][0]= 0;
        losers[2][0]= 0;

        for(int x = 0; x< boards.length; x++)
        {
            boards[x] = new position();
        }
        for(int x = 19; x>-1;x--)
        {
            for(int y = 0; y<boards[x].board.length; y++)
            {boards[x].board[y] = -1;
            }

        }

       printboards();
    }

    public void printboards()
    { int pos = 0;
        int[] num = new int[3];

        for (int a = 0; a <= 3; a++)
        {
            num[0] = a;

            for (int b = 0; b <= a; b++)
            {
                num[1] = b;

                for (int c = 0; c <= b; c++)
                {
                    num[2] = c;

                    for (int x = 0; x < num.length; x++)
                    {
                        System.out.print(num[x]);
                    }
                    System.out.println();
                    nextestboard(num, pos);
                    pos++;
                }
            }
        }
    }

    public void nextestboard(int[] num, int pos) {
        int[] helper = new int[num.length];
        boolean isloser = true;

        for(int x = 0; x<helper.length; x++)
        {
            helper[x] = num[x];
        }
        for (int x = num.length-1; x >-1 ; x--)
        {
            for (int y = num[x]-1; y>-1; y--) {
                num[x] = y;
                for (int z = x; z < num.length; z++) {
                    if (num[z] > num[x]) {
                        num[z] = num[x];
                    }
                }
                if (num[0] != 0) {
                    if(choose(num))
                    {
                        for (int j = 0; j < winners.length; j++)
                        {
                        winners[j][pos] = helper[j];
                        }
                        isloser = false;
                        System.out.println("put in winner list");
                        for (int k = 0; k < num.length; k++) {
                            System.out.print(num[k] + ",");
                        }
                        System.out.println();
                        System.out.print(x+1);                        System.out.print(y+1);
                        System.out.println();
                        System.out.println();
                    }
                }

                for(int k = x; k< num.length; k++)
                {
                    num[k] = helper[k];

                }
            }
        }
        if(isloser)
        {
            for (int j = 0; j < losers.length; j++) {
                losers[j][pos] = helper[j];
            }
            System.out.println("put in loser list************");
            System.out.println();
        }

    }


    public boolean choose(int[] num)
    { boolean iswin;
        for(int y = 0; y<losers[0].length; y++)
        {  iswin = false;

            boolean issame = true;
            for(int x = 0; x<losers.length; x++)
            {
                if (losers[x][y] != num[x]) {
                    issame = false;
                }
            }
            if(issame)
            {
                iswin = true;
            }
            if(iswin) {
                return true;
            }
        }

        return false;}

}
