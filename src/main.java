import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class main {
    public position [] boards;
    public int[] current;
    public int[][] winners;
    public int[][] losers;
    public JFrame mainframe;
    public JPanel north;
    public JPanel south;
    public JButton click;
    public TextField Input1, Input2, Input3;

    public static void main() {
        main ex = new main();
    }
    public main() {
        click = new JButton("Clickme");
        mainframe = new JFrame("Random");
        Input1 = new TextField();
        Input1.setText("Board");
        Input2 = new TextField();
        Input2.setText("Board");
        Input3 = new TextField();
        Input3.setText("Board");

        mainframe.setSize(400,400);
        mainframe.setLayout(new BorderLayout());
        north = new JPanel(new GridLayout(1,3));
        north.add(Input1);
        north.add(Input2);
        north.add(Input3);

        north.add(click);

        mainframe.add(north,BorderLayout.NORTH);
        mainframe.setResizable(false);
        mainframe.setVisible(true);
        current = new int[3];
        current[0] = 3;
        current[1] = 1;
        current[2] = 1;
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
        System.out.println(printboards(current));
    }

    public String printboards(int[] board)
    { int pos = 0;
        int[] num = new int[3];
        for (int a = 0; a <= board[0]; a++)
        {
            num[0] = a;

            for (int b = 0; b <= board[1]; b++)
            {   if(b<= a) {
                num[1] = b;

                    for (int c = 0; c <= board[2]; c++) {
                        if(c<=b) {
                            num[2] = c;

                            for (int x = 0; x < num.length; x++) {
                                System.out.print(num[x]);
                            }
                            System.out.println();
                            if(nextestboard(num, pos))
                            {
                                return "done";
                            }
                            pos++;
                        }
                    }
                }
            }
        }
        return "Your board is a losing position, play whatever move you want and hope";
    }

    public boolean nextestboard(int[] num, int pos) {
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
                        System.out.print(x+1);
                        System.out.print("-");System.out.print(y+1);
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
            if(look(current, pos))
            {return true;}
            System.out.println();
        }
        return false;

    }

    public boolean look (int[] num, int pos) {
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
                        System.out.println("You Have a winner");
                        System.out.println();
                        System.out.print(x+1);
                        System.out.print("-");System.out.print(y+1);
                        System.out.println();
                        System.out.println();
                        return true;
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
            System.out.println("loser so far");
            System.out.println();
        }
        return false;

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
