package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class FlyWheel{
    private DcMotor flyWheel;
    MecanumDrive drive;

    public void launch (boolean gamePad1A){
        if(gamePad1A){
            drive.calculateDrivePowers(0,0,1);
                while(Camera.aprilTagBearing<-10 || Camera.aprilTagBearing>10){}
                drive.calculateDrivePowers(0,0,0);
                flyWheel.setPower(Camera.aprilTagRange/200);
        }else{
            flyWheel.setPower(0);
        }
    }
}
