package org.firstinspires.ftc.teamcode.Navigation;


import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {

    double integralSum;
    public double kp;
    public double ki;
    public double kd;
    double lastError = 0;
    ElapsedTime pidTimer = new ElapsedTime();
    public double runPID(double currentVal, double targetVal){
        double error = targetVal - currentVal;
        integralSum  += error * pidTimer.seconds();
        double derivative = (error - lastError) / pidTimer.seconds();
        lastError = error;
        pidTimer.reset();
        double outPut = (error * kp) + (derivative * kd) + (integralSum * ki);
        return outPut;
    }
}
