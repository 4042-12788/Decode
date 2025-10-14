package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    HardwareMap hardwareMap;
    Telemetry telemetry;
    public MecanumDrive drive;
    public Launcher launcher;
    public CamServo cameraServo;
    public Intake intake;
    public InternalMeasurementUnit imu;
    public Camera cam;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        drive = new MecanumDrive(hardwareMap, telemetry);
        launcher = new Launcher(hardwareMap, telemetry);
        cameraServo = new CamServo(hardwareMap);
        intake = new Intake(hardwareMap);
        imu = new InternalMeasurementUnit(hardwareMap);
        cam = new Camera(hardwareMap);
    }
}