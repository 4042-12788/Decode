package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlyWheel{
    private DcMotor flyWheel;
    MecanumDrive drive;
    public  FlyWheel(HardwareMap hardwareMap){
        flyWheel = hardwareMap.get(DcMotor.class, "Flywheel");
    }
    public void launchArtifact(boolean gp1a, double x, double y){
        if(gp1a){
            drive.calculateDrivePowers(x,y,1);
            while(Camera.aprilTagBearing <-10 || Camera.aprilTagBearing>10){}
            drive.calculateDrivePowers(x,y,0);
            flyWheel.setPower(Camera.aprilTagRange/200);
        }else{
            flyWheel.setPower(0);
        }
    }
}
