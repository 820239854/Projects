package com.Geng;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;
    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        pack();
//        setSize(canvasWidth, canvasHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String  title){
        this(title, 1024,728);
    }
    public int getCanvasWidth() {
        return canvasWidth;
    }
    public int getCanvasHeight() {
        return canvasHeight;
    }

    public class AlgoCanvas extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawOval(50,50,300,300);
        };
    }
}
