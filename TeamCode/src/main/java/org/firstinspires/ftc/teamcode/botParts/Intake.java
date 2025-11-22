package org.firstinspires.ftc.teamcode.botParts;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotor intakeWheel;
    public Intake(HardwareMap hardwareMap, Telemetry telemetry){
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
    public void intake(){
        intakeWheel.setPower(1);
    }
    public void stop(){
        intakeWheel.setPower(0);
    }

}
