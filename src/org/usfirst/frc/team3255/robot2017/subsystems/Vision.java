package org.usfirst.frc.team3255.robot2017.subsystems;

import org.opencv.core.Mat; 
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem implements Runnable {
	
	private UsbCamera frontCamera = null;
	private UsbCamera rearCamera = null;
	
	private CameraServer cameraServer = null;
	
	private CvSink cameraSink = null;
	
	private CvSource outputStream = null;
		
	private Thread visionThread = null;
	
	private boolean frontCameraSelected = true;
	private UsbCamera selectedUsbCamera = null;

	public static final int CAMERA_WIDTH = 320;
	public static final int CAMERA_HEIGHT = 240;
	public static final int CAMERA_FPS = 30;
	
	public Vision() {
		visionThread = new Thread(this);
		visionThread.setDaemon(true);
		visionThread.start();
	}
	
	@Override
	public void run() {
		
		// get an instance of the CameraServer class
		cameraServer = CameraServer.getInstance();

		// create the front camera
		frontCamera = new UsbCamera("Front Camera", 0);

		// set the resolution of the front camera
        frontCamera.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
        
        // create the rear camera
        rearCamera = new UsbCamera("Rear Camera", 1);

        // set the resolution of the rear camera
        rearCamera.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);

        // set front camera by frames per second (FPS), and set the rear camera FPS to 0
        frontCamera.setFPS(CAMERA_FPS);
        rearCamera.setFPS(0);

        // make the front camera the "selected" camera
        frontCameraSelected = true;
        selectedUsbCamera = frontCamera;
        
        // create a CvSink for sourcing a camera
        cameraSink = new CvSink("CameraCvSink");

        // set the source for the CvSink to the selected camera
        cameraSink.setSource(selectedUsbCamera);
        
        // create an outPutStream to write video the dashboard
        // This stream can be viewed on SmartDashboard by adding a "CameraServer Stream Viewer" widget
        // and setting its "Camera Choice" property to "Selected Camera"
        outputStream = cameraServer.putVideo("Selected Camera", CAMERA_WIDTH, CAMERA_HEIGHT);
        
        // Creates a mat to hold a video image frame
        Mat image = new Mat();
        
        ////======= Thread Loop ======////
		// This cannot be 'true'. The program will never exit if it is. This
		// lets the robot stop this thread when restarting robot code or
		// deploying.
		while (!Thread.interrupted()) {
			// check to see if we have to swap cameras
			if((frontCameraSelected == true) && (selectedUsbCamera != frontCamera)) {
                cameraSink.setEnabled(false);		// disable the CvSink
				rearCamera.setFPS(0);				// set FPS to 0 for rear camera
				frontCamera.setFPS(CAMERA_FPS);		// set FPS for front camera
                cameraSink.setSource(frontCamera);	// set the CVSink source to the front camera
                cameraSink.setEnabled(true);		// enable the CvSink

                selectedUsbCamera = frontCamera;
			}
			else if((frontCameraSelected == false) && (selectedUsbCamera != rearCamera)) {
                cameraSink.setEnabled(false);		// disable the CvSink 
            	frontCamera.setFPS(0);				// set FPS to 0 for front camera
            	rearCamera.setFPS(CAMERA_FPS);		// set FPS for rear camera
                cameraSink.setSource(rearCamera);	// set the CvSink source to the rear camera
                cameraSink.setEnabled(true);		// enable the CvSink

                selectedUsbCamera = rearCamera;
			}
			
			// grab a frame from the CvSink
			if(cameraSink.grabFrame(image) == 0) {
				// Send the output the error.
				outputStream.notifyError("grabFrame failed: " + cameraSink.getError());
				// skip the rest of the current iteration
				continue;
			}

			// the code below shows how to draw on top of the capture image based on which camera is selected
            if(frontCameraSelected) {
            	// write text on the image indicating this is the front camera
            	Imgproc.putText(image, "Front Camera", new Point(10, CAMERA_HEIGHT / 2), 0, 1.0, new Scalar(255, 255, 255));

            	// draw a rectangle across the top of the image
                Imgproc.rectangle(image, new Point(10, 10), new Point(CAMERA_WIDTH - 10, 20),
    					new Scalar(255, 255, 255), 2);
            } 
			else {
            	// write text on the image indicating this is the rear camera
            	Imgproc.putText(image, "Rear Camera", new Point(10, CAMERA_HEIGHT / 2), 0, 1.0, new Scalar(255, 255, 255));

            	// draw a rectangle across the bottom of the image
    			Imgproc.rectangle(image, new Point(10, CAMERA_HEIGHT - 20), new Point(CAMERA_WIDTH - 10, CAMERA_HEIGHT - 10),
    					new Scalar(255, 255, 255), 2);
            }
			
			// write the captured image to the output stream
			outputStream.putFrame(image);
		}
	}
	
	public void selectForwardCamera() {
		frontCameraSelected = true;
	}
	
	public void selectRearCamera() {
		frontCameraSelected = false;
	}
	
	public boolean isRearCameraSelected() {
		return (frontCameraSelected == false);
	}

	@Override
	protected void initDefaultCommand() {
	}
}