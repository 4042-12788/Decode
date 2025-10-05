package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    HardwareMap hardwareMap;
    Telemetry telemetry;
    public MecanumDrive drive;
    public FlyWheel launcher;
    public CamServo cameraServo;
    public Intake intake;
    public boolean RED;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        drive = new MecanumDrive(hardwareMap, telemetry);
        launcher = new FlyWheel(hardwareMap);
        cameraServo = new CamServo(hardwareMap);
        intake = new Intake(hardwareMap);
    }
}