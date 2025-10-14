package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {

    double integralSum = 0;
    double P;
    double I;
    double D;
    double lastError = 0;
    ElapsedTime PIDTimer = new ElapsedTime();

    public void setP(double temp)
    {
        P = temp;
    }
    public void setI(double temp)
    {
        I = temp;
    }
    public void setD(double temp)
    {
        D = temp;
    }

    public double pidOutput(double targetPos, double currentPos){
        double error = targetPos - currentPos;
        integralSum += PIDTimer.seconds() * error;
        double derivitive = (error - lastError) / PIDTimer.seconds();
        lastError = error;
        PIDTimer.reset();
        double output = (error * P) + (derivitive *D) + (integralSum * I);
        return output;
    }
}
