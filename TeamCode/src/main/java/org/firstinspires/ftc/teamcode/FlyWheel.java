package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class FlyWheel{
    private DcMotor flyWheel;
    private PIDController control = new PIDController();

    public  FlyWheel(HardwareMap hardwareMap, Telemetry telemetry){
        flyWheel = hardwareMap.get(DcMotor.class, "Flywheel");
        control.setP(0);
        control.setI(0);
        control.setD(0);
    }
    public void launchArtifact(boolean gp1a, double x, double y, MecanumDrive drive, InternalMeasurementUnit imu, Camera camera, int tagID){
        AprilTagDetection tag = camera.tagProcessor.getDetections().get(tagID);
        if(gp1a){
            drive.calculateDrivePowers(x, y, control.pidOutput(imu.heading(AngleUnit.DEGREES) + CamServo.robotBearing, imu.heading(AngleUnit.DEGREES)));
            flyWheel.setPower(tag.ftcPose.bearing/200);
        }else{
            flyWheel.setPower(0);
        }
    }
}
