package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.commands.ClimberResetEncoder;
import org.usfirst.frc.team3255.robot2017.commands.DriveDistance;
import org.usfirst.frc.team3255.robot2017.commands.DriveResetEncoder;
import org.usfirst.frc.team3255.robot2017.commands.DriveRotate;
import org.usfirst.frc.team3255.robot2017.commands.NavigationResetYaw;
import org.usfirst.frc.team3255.robot2017.commands.TelemetryUpdate;
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
		SmartDashboard.putData("Drive Reset Encoders", new DriveResetEncoder());
		SmartDashboard.putData("Climber Reset Encoder", new ClimberResetEncoder());
		SmartDashboard.putData("Reset Yaw", new NavigationResetYaw());
		SmartDashboard.putData("Drive Distance", new DriveDistance(1.0));
		SmartDashboard.putData("Drive Rotate 180", new DriveRotate(180));
	}
	
	public void update() {
		//Shooter
		SmartDashboard.putNumber("Shooter Speed", Robot.shooter.getShooterSpeed());
		
		//Drivetrain
		SmartDashboard.putNumber("Drivetrain Encoder Position", Robot.drivetrain.getEncoderCount());
		SmartDashboard.putNumber("Drivetrain Encoder Distance", Robot.drivetrain.getEncoderDistance());
		SmartDashboard.putBoolean("lowGear", Robot.drivetrain.isLowGear());
		
		//Climber
		SmartDashboard.putBoolean("Climber Switch Closed", Robot.climber.isTouchpadSwitchClosed());
		SmartDashboard.putBoolean("Climber Enabled", Robot.climber.isClimberEnabled());
		SmartDashboard.putNumber("Climber Encoder Position", Robot.climber.getEncoderPosition());
		SmartDashboard.putNumber("Climber Encoder Distance", Robot.climber.getEncoderDistance());
		
		//Collector
		SmartDashboard.putBoolean("Collector Enabled", Robot.collector.isCollectorCollecting());
		
		//Navigation
		SmartDashboard.putNumber("Yaw", Robot.navigation.getYaw());
		SmartDashboard.putNumber("Pitch", Robot.navigation.getPitch());
		SmartDashboard.getBoolean("navX Calibrating", Robot.navigation.isCalibrating());
		SmartDashboard.putNumber("Acceleration", Robot.navigation.getAccel());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }
    //Tayler is the best :D
}

