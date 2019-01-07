package com.GUI.Basic;

import java.awt.*;
import java.awt.event.*;

public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimated = true;

    private void run(){
        while (true){
            frame.render(circles);
            AlgoVisHelper.pause(20);
            if(isAnimated) {
                for (Circle circle : circles) {
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }
            }
        }
    }

    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar() == ' '){
                isAnimated = !isAnimated;
            }
        }
    }

    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(0,-(frame.getBounds().height-frame.getCanvasHeight()));
            for(Circle circle : circles){
                if(circle.contain(e.getPoint())){
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }

    public AlgoVisualizer(int sceneWidth,int sceneHeight,int N) {
        circles = new Circle[N];
        int R = 50;
        for(int i = 0 ; i < N ; i ++ ) {
            int x = (int)(Math.random()*(sceneWidth-2*R)) + R;
            int y = (int)(Math.random()*(sceneHeight-2*R)) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("Welcome",sceneWidth,sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth,sceneHeight,N);
    }
}
