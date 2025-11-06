package org.firstinspires.ftc.teamcode.botParts;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    HardwareMap hardwareMap;
    Telemetry telemetry;
    public MecanumDrive drive;
    public Launcher launcher;
    public CamServo cameraServo;
    public Intake intake;
    public InertialMeasurementUnit imu;
    public Camera cam;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        drive = new MecanumDrive(hardwareMap, telemetry);
        launcher = new Launcher(hardwareMap, telemetry);
        cameraServo = new CamServo(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);
        imu = new InertialMeasurementUnit(hardwareMap, telemetry);
        cam = new Camera(hardwareMap, telemetry);
    }
}