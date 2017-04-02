package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.commands.AutoShot;
import org.usfirst.frc.team3255.robot2017.commands.CrossLine;
import org.usfirst.frc.team3255.robot2017.commands.DriveResetEncoder;
import org.usfirst.frc.team3255.robot2017.commands.DriveStraightDistance;
import org.usfirst.frc.team3255.robot2017.commands.NavigationResetYaw;
import org.usfirst.frc.team3255.robot2017.commands.PlaceGear;
import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.Robot;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Telemetry() {
		//Command buttons
		SmartDashboard.putData("Drive Reset Encoders", new DriveResetEncoder());
		SmartDashboard.putData("Reset Yaw", new NavigationResetYaw());
		SmartDashboard.putData("Drive Distance", new DriveStraightDistance("Debug Straight Distance", RobotPreferences.driveDistance()));
		SmartDashboard.putData("Place Gear", new PlaceGear());
		SmartDashboard.putData("Auto Shot", new AutoShot());
		SmartDashboard.putData("Cross Line", new CrossLine());
	}
	
	public void update() {		
		//Drivetrain
		SmartDashboard.putNumber("Drivetrain Encoder Count", Robot.drivetrain.getEncoderCount());
		SmartDashboard.putNumber("Drivetrain Encoder Distance", Robot.drivetrain.getEncoderDistance() * 12);
		SmartDashboard.putBoolean("lowGear", Robot.drivetrain.isLowGear());

		//Collector
		SmartDashboard.putBoolean("Collector Enabled", Robot.collector.isCollectorCollecting());
		
		//Navigation
		SmartDashboard.putNumber("Yaw", Robot.navigation.getYaw());
		SmartDashboard.getBoolean("navX Calibrating", Robot.navigation.isCalibrating());
		
		//Autonomous Preferences
		SmartDashboard.putNumber("Lane", AutoPreferences.getLane());
		SmartDashboard.putBoolean("Is Red Alliance", AutoPreferences.isRedAlliance());
		SmartDashboard.putBoolean("Do Gear", AutoPreferences.doGear());
		SmartDashboard.putBoolean("Do Shot", AutoPreferences.doShot());
		SmartDashboard.putBoolean("Do Cross", AutoPreferences.doCross());
		SmartDashboard.putBoolean("Competition Mode", !AutoPreferences.isDebug());
		SmartDashboard.putBoolean("Resetting", AutoPreferences.isReset());
		SmartDashboard.putBoolean("Two Gear", AutoPreferences.doTwoGear());
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Automomous Status", statusText);
	}

    public void initDefaultCommand() {
    }
}

