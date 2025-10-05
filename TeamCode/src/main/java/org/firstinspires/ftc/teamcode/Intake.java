package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Intake {
    DcMotor intakeWheel;
    public Intake(HardwareMap hardwareMap){
        intakeWheel = hardwareMap.get(DcMotor.class,"Intake");
    }
    public void intake(boolean gp2x, boolean gp2b){
        if(gp2x){
            intakeWheel.setPower(1);
        }
        if(gp2b){
            intakeWheel.setPower(-1);
        }
        if(!gp2x && !gp2b){
            intakeWheel.setPower(0);
        }
    }
}
