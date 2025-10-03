package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
public class FlyWheel{
    private DcMotor flyWheel;
    MecanumDrive drive;

    public void launch (boolean gamePad1A,double x, double y){
        if(gamePad1A){
            drive.calculateDrivePowers(x,y,1);
            while(Camera.aprilTagBearing <-10 || Camera.aprilTagBearing>10){}
            drive.calculateDrivePowers(x,y,0);
            flyWheel.setPower(Camera.aprilTagRange/200);
        }else{
            flyWheel.setPower(0);
        }
    }
}
