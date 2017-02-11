package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//Drivetrain
	public static double drivetrainPulsesPerFoot() {
		return Preferences.getInstance().getDouble("DrivePulsePerFoot", 1.0);
	}
	
	//Climber
	public static double climberPulsesPerFoot() {
		return Preferences.getInstance().getDouble("ClimberPulsePerFoot", 1.0);
	}
	
	public static double climbDistance() {
		return Preferences.getInstance().getDouble("ClimbDistance", 1.0);
	}

	//Shooter
	public static double shooterMaxHighSpeed() {
		return Preferences.getInstance().getDouble("ShooterMaxHighSpeed", 1.0);
	}
	public static double shooterMaxLowSpeed() {
		return Preferences.getInstance().getDouble("ShooterMaxLowSpeed", 0.5);
	}
	
	//Navigation
	public static double navYawP() {
		return Preferences.getInstance().getDouble("NavYawP", 0.0);
	}

	public static double navYawI() {
		return Preferences.getInstance().getDouble("NavYawI", 0.0);
	}

	public static double navYawD() {
		return Preferences.getInstance().getDouble("NavYawD", 0.0);
	}
	
	public static double yawTolerance() {
		return Preferences.getInstance().getDouble("YawTolerance", 0.0);
	}

	public static double maxYawSpeed() {
		return Preferences.getInstance().getDouble("MaxYawSpeed", 1.0);
	}

	//Drivetrain PID
	public static double driveDistance() {
		return Preferences.getInstance().getDouble("DriveDistance", 1.0);
	}
	
	public static double distanceTolerance() {
		return Preferences.getInstance().getDouble("DistanceTolerance", 0.0);
	}

	public static double driveDistanceP() {
		return Preferences.getInstance().getDouble("DriveDistanceP", 0.0);
	}

	public static double driveDistanceI() {
		return Preferences.getInstance().getDouble("DriveDistanceI", 0.0);
	}

	public static double driveDistanceD() {
		return Preferences.getInstance().getDouble("DriveDistanceD", 0.0);
	}

	public static double maxMoveSpeed() {
		return Preferences.getInstance().getDouble("MaxMoveSpeed", 1.0);
	}
}
