package org.firstinspires.ftc.teamcode;
import android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
public class Camera extends LinearOpMode {

    //The variable to store our instance of the AprilTag processor.
    public static int aprilTagID = 0;
    public static double aprilTagX = 0;
    public static double aprilTagY = 0;
    public static double aprilTagZ = 0;
    public static double aprilTagPitch = 0;
    public static double aprilTagRoll = 0;
    public static double aprilTagYaw = 0;
    public static double aprilTagRange = 0;
    public static double aprilTagBearing = 0;
    public static double aprilTagElevation = 0;

    public static AprilTagProcessor tagProcessor;
    private VisionPortal visionPortal;

    @Override
    public void runOpMode() {

        initAprilTag();
        waitForStart();
    }

    private void initAprilTag() {

        tagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawTagOutline(true)
                // set camera calibrations once we have the camera
                //.setLensIntrinsics(578.272, 578.272, 402.145, 221.506)
                // ... these parameters are fx, fy, cx, cy.
                .build();

        tagProcessor.setDecimation(3);

        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        builder.setCamera(hardwareMap.get(WebcamName.class, "AprilTag Webcam"));

        builder.setCameraResolution(new Size(640, 480));

        builder.enableLiveView(true);

        builder.addProcessor(tagProcessor);

        visionPortal = builder.build();

        visionPortal.setProcessorEnabled(tagProcessor, true);

        while (!isStopRequested() && opModeIsActive()) {
            if(tagProcessor.getDetections().size()>0){
                AprilTagDetection tag = tagProcessor.getDetections().get(0);
                aprilTagID = tag.id;
                aprilTagX = tag.ftcPose.x;
                aprilTagY = tag.ftcPose.y;
                aprilTagZ = tag.ftcPose.z;
                aprilTagPitch = tag.ftcPose.pitch;
                aprilTagRoll = tag.ftcPose.roll;
                aprilTagYaw = tag.ftcPose.yaw;
                aprilTagRange = tag.ftcPose.range;
                aprilTagBearing = tag.ftcPose.bearing;
                aprilTagElevation = tag.ftcPose.elevation;
            }
        }
    }
}
