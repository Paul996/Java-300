package com.company;

import java.awt.*;
import javax.swing.*;


public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/Ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/BilliardTable.jpg");
    double x = 100; //x axis of the ball
    double y = 100; //y axis of the ball
    boolean right = true; // right direction

    public void paint(Graphics g){
        System.out.println("Draw window once!");

        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int)x, (int)y, null);

        if(right) {
            x = x + 10;
        }else{
            x = x - 10;
        }

        //856 is the width of the game screen,
        //40 is the width of the side of the table,
        // 30 is the diameter of the ball
        if(x>856-40-30){
            right = false;
        }

        if(x<40){
            right = true;
        }
    }

    //load game window
    void launchFrame(){
        setSize(856, 500);
        setLocation(50,50);
        setVisible(true);

        //redraw window, 25times/1s
        while(true){
            repaint();
            try{
                Thread.sleep(40);//40ms, 1s=1000ms, 25times/1s
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //main method
    public static void main (String[] args){
        System.out.println("This is a Ball Game!");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}
