package org.firstinspires.ftc.teamcode;

public class Rotator {
    public double rotateX(double x, double y, double rot){
        rot *= (Math.PI/180);
        x = x * Math.cos(rot) - y * Math.sin(rot);
        return x;
    }
    public double rotateY(double x, double y, double rot){
        rot *= (Math.PI/180);
        x = x * Math.sin(rot) + y * Math.cos(rot);
        return y;
    }
}
