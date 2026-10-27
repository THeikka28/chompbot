public class main {
    public position [] boards;
    public int[] current;
    public int[][] winners;
    public static void main() {
        main ex = new main();
    }
    public main() {

        current = new int[3];
        current[0] = 3;
        current[1] = 3;
        current[2] = 3;
        boards= new position[20];
        winners = new int [3][20];
        for(int x = 0; x< winners.length; x++)
        {
            for(int y=0; y< winners[0].length; y++) {
                winners[x][y] = -1;
            }
        }

        for(int x = 0; x< boards.length; x++)
        {
            boards[x] = new position();
        }
        for(int x = 18; x>-1;x--)
        {
            for(int y = 0; y<boards[x].board.length; y++)
            {boards[x].board[y] = -1;
            }

        }
        printboards();
        nextestboard(current,0);



    }

    public void printboards()
    {
        int[] num = new int[3];
        int pos =0;
        for (int x = 0; x < num.length; x++)
        {
            num[x] = 3;
        }

        int[] helper = new int[num.length];

        for (int x = 0; x < helper.length; x++)
        {
            helper[x] = num[x];
        }

        for (int a = 3; a >= 0; a--)
        {
            num[0] = a;

            for (int b = a; b >= 0; b--)
            {
                num[1] = b;

                for (int c = b; c >= 0; c--)
                {
                    num[2] = c;

                    for (int x = 0; x < num.length; x++)
                    {
                        System.out.print(num[x]);
                    }
                    System.out.println();
                    pos = pos+1;
                }
            }
        }
       /*

               int[] num = new int[3];

        for (int x = 0; x < num.length; x++)
        {
            num[x] = 3;
        }

        int[] helper = new int[num.length];

        for (int x = 0; x < helper.length; x++)
        {
            helper[x] = num[x];
        }

        for (int count = 0; count < 20; count++)
        {
            for (int x = 0; x < num.length; x++)
            {
                System.out.print(num[x]);
            }
            System.out.println();

            int x = num.length - 1;

            for (; x >= 0 && num[x] == 0; x--)
            {}

            if (x >= 0)
            {
                num[x]--;

                for (int y = x + 1; y < num.length; y++)
                {
                    num[y] = num[x];
                }
            }
        }

       int[] num = new int[3];
        for(int x = 0; x<num.length; x++)
        {num[x] = 3;}
        int[] helper = new int[num.length];
        for(int x = 0; x<helper.length; x++)
        {
            helper[x] = num[x];
        }


        for(int x = num.length-1; x>-1; x--)
        {
            for(int y = num[x]; y>-1; y--)
            {
                num[x] = y;
                for(int z = x; z<num.length; z++) {
                    if (num[z] > num[x]) {
                        num[z] = num[x];
                    }
                }
                for(int z = 0; z<num.length; z++)
                {
                    System.out.print(num[z] + ", ");
                }
                System.out.println();
            }
            for(int k = x; k< num.length; k++)
            {
                num[k] = helper[k];
            }
        }

        */
    }

    public void nextestboard(int[] num, int board) {
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

                for(int l = 0; l<num.length; l++)
                {
                    System.out.print(num[l] + ", ");
                }
                System.out.println();
                if (choose(num))
                {
                    for(int i = 0; i<num.length; i++) {
                        boards[i].board[board] = num[i];
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
        for(int y = 0; y<boards.length; y++)
        {  boards[y].iswin = true;
            for(int x = 0; x<boards[y].board.length; x++)
            {
                if(boards[y].board[x] != num[x])
                {boards[y].iswin = false;}
            }
        }
        if(num[0] == 1 && num[1] == 0)
        {
            System.out.println("YAYYYYYY");
            return true;
        }
        else
        {
            System.out.println("cooked");
            return false;
        }
    }

}
