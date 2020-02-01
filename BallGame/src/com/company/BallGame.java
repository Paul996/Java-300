package com.company;

import java.awt.*;
import javax.swing.*;


public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/Ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/BilliardTable.jpg");

    public void paint(Graphics g){
        System.out.println("Draw window once!");

        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, 100, 100, null);
    }

    //load game window
    void launchFrame(){
        setSize(856, 500);
        setLocation(50,50);
        setVisible(true);

        //redraw window
        while(true){
            repaint();
            try{
                Thread.sleep(40);//40ms, 1s=1000ms, 20times/1s
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
