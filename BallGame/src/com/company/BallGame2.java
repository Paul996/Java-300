package com.company;

import javax.swing.*;
import java.awt.*;


public class BallGame2 extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/Ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/BilliardTable.jpg");
    double x = 100; //x axis of the ball
    double y = 100; //y axis of the ball

    double degree = 3.14/3; //60 degree

    public void paint(Graphics g){
        System.out.println("Draw window once!");

        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int)x, (int)y, null);

        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        //上下边界
        //500窗口高度，40边框，30球直径，标题栏宽度也是40
        if(y > 500-40-30||y<40+40){
            degree = -degree;
        }

        //左右边界
        if(x<0+40||x>856-40-30){
            degree = 3.14 - degree;
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
        BallGame2 game = new BallGame2();
        game.launchFrame();
    }
}
