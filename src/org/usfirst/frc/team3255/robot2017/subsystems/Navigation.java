package org.usfirst.frc.team3255.robot2017.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Navigation extends Subsystem {

	public static AHRS ahrs = null;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Navigation() {
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(), true);
		}
	}
	
	public double getYaw() {
		return ahrs.getYaw();
	}
	
	public double getPitch() {
		return ahrs.getRoll();
	}

	public void resetYaw() {
		// reset the yaw
		ahrs.reset();
		
		// wait for 1/4 seconds to allow the NavX to reset the yaw
		try {
			Thread.sleep(250);
		}
		catch (InterruptedException e) {
		}
		
		// make the reset yaw position be the zero yaw position
		ahrs.zeroYaw();
	}
	
	public boolean isCalibrating() {
		return ahrs.isCalibrating();
	}
	
	public double getAccel() {
		return ahrs.getRawAccelX();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

