package com.Simulation.GetPi;
import java.awt.*;

public class MonteCarloExpe {
    private int squareSide;
    private int N;
    private int outputInterval = 100;

    public MonteCarloExpe(int squareSide,int N){
        if(squareSide<=0 || N<=0)
            throw new IllegalArgumentException("squareSide and N must larger than 0");
        this.squareSide = squareSide;
        this.N = N;
    }

    public void run(){
        Circle circle = new Circle(squareSide/2,squareSide/2,squareSide/2);
        MonteCarloPiData data = new MonteCarloPiData(circle);
        for(int i=0; i<N; i++){
            if(i % outputInterval == 0){
                System.out.println(data.estimatePi());
            }
            int x = (int)(Math.random()*squareSide);
            int y = (int)(Math.random()*squareSide);
            data.addPoint(new Point(x,y));
        }
    }

    public void setOutputInterval(int interval) {
        if(interval <= 0)
            throw new IllegalArgumentException("interval must be larger than zero");
        this.outputInterval = outputInterval;
    }

    public static void main(String[] args){
        int squareSide = 800;
        int N = 10000;

        MonteCarloExpe exp = new MonteCarloExpe(squareSide,N);
        exp.run();
    }
}
