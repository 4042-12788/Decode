package org.firstinspires.ftc.teamcode.Navigation;


public abstract class PIDController implements NavigationController {


    protected double[] getPIDValues(double currentPos, double targetPos) {
        //Calculate PID values
        return new double[] {};
    }


    @Override
    public boolean hasArrived() {
        //return Math.abs(error) <= (isPIDRot ? arrivedDistThresholdRot : arrivedDistThresholdPos);
        return false;
    }
}
