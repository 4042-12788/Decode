package org.firstinspires.ftc.teamcode;
import android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
public class Camera{

    public static AprilTagProcessor tagProcessor;
    public VisionPortal visionPortal;


    public Camera(HardwareMap hardwareMap, Telemetry telemetry) {

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

        builder.setCamera(hardwareMap.get(WebcamName.class, "Apriltag Cam"));

        builder.setCameraResolution(new Size(640, 480));

        builder.enableLiveView(true);

        builder.addProcessor(tagProcessor);

        visionPortal = builder.build();

        visionPortal.setProcessorEnabled(tagProcessor, true);
    }
//        tagProcessor.getDetections().size()
//        AprilTagDetection tag = tagProcessor.getDetections().get();
//        tag.ftcPose.x;
//        tag.ftcPose.y;
//        tag.ftcPose.z;
//        tag.ftcPose.pitch;
//        tag.ftcPose.roll;
//        tag.ftcPose.yaw;
//        tag.ftcPose.range;
//        tag.ftcPose.bearing;
//        tag.ftcPose.elevation;
}
