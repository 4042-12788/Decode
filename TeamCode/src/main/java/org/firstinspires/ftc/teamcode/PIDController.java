package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {

    double integralSum = 0;
    double P = 0;
    double I = 0;
    double D = 0;
    double lastError = 0;
    ElapsedTime PIDTimer = new ElapsedTime();


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
