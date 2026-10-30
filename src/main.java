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

        for(int y=0; y< winners[0].length; y++) {
            for (int x = 0; x < winners.length; x++) {
                System.out.print(losers[x][y]);
            }
            System.out.println();

        }

    }

    public void printboards()
    {
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

                    nextestboard(num);
                }
            }
        }
    }

    public void nextestboard(int[] num) {
        int[] helper = new int[num.length];
        for(int x = 0; x<helper.length; x++)
        {
            helper[x] = num[x];
        }
        for (int x = num.length-1; x >-1 ; x--)
        {
            for (int y = num[x]-1; y>-1; y--)
            {
                num[x] = y;
                for(int z = x; z<num.length; z++) {
                    if (num[z] > num[x]) {
                        num[z] = num[x];
                    }
                }
                if(!choose(num))
                {
                    for(int j = 0; j< losers.length; j++)
                    {
                        for(int l=0; l< losers[0].length; l++) {
                            losers[j][l] = helper[j];

                        }
                    }
                }

                for(int k = x; k< num.length; k++)
                {
                    num[k] = helper[k];

                }
            }
        }
    }


    public boolean choose(int[] num)
    {
        for(int y = 0; y<losers[0].length; y++)
        {  boards[y].iswin = false;
            for(int x = 0; x<losers.length; x++)
            {
                if(losers[x][y] != num[x])
                {
                    boards[y].iswin = true;
                }

            }
            if(boards[y].iswin == false)
            {
                System.out.println("jfiosdjfklashdkfjnasd");

                for(int x = 0; x<losers.length; x++)
                {
                    for(int j = 0; j<losers[0].length-y; j++) {
                        if(losers[x][y+j] == -1) {
                            System.out.println("gh");
                            losers[x][y+j] = num[x];
                            break;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

}
