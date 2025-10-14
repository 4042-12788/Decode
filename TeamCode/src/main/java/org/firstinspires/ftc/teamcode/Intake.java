package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Intake {
    DcMotor intakeWheel;
    public Intake(HardwareMap hardwareMap){
        intakeWheel = hardwareMap.get(DcMotor.class,"Intake");
    }
    public void intake(double leftTrigger, boolean leftBump){
        if(leftTrigger<=0.05 && !leftBump){
            intakeWheel.setPower(0);
        }
        if(leftBump){
            intakeWheel.setPower(-1);
        }
        if(leftTrigger>0.05){
            intakeWheel.setPower(1);
        }
    }
}
