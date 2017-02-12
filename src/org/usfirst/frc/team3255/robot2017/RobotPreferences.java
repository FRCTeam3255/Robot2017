package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//Drivetrain
	public static double drivetrainPulsesPerFoot() {
		return Preferences.getInstance().getDouble("DrivePulsesPerFoot", 1.0);
	}
	
	//Climber
	public static double climberPulsesPerFoot() {
		return Preferences.getInstance().getDouble("ClimberPulsesPerFoot", 1.0);
	}
	
	public static double climberSwitchDistance() {
		return Preferences.getInstance().getDouble("ClimberSwitchDistance", 1.0);
	}

	//Shooter
	public static double shooterMaxHighSpeed() {
		return Preferences.getInstance().getDouble("ShooterMaxHighSpeed", 1.0);
	}
	
	public static double shooterMaxLowSpeed() {
		return Preferences.getInstance().getDouble("ShooterMaxLowSpeed", 0.5);
	}
	public static double shooterSwitchDelay() {
		return Preferences.getInstance().getDouble("ShooterSwitchDelay", 1.0);
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

	//Autonomous
	public static double autoGearD1() {
		return Preferences.getInstance().getDouble("AutoGearD1", 0.0);
	}

	public static double autoGearTurn() {
		return Preferences.getInstance().getDouble("AutoGearTurn", 0.0);
	}

	public static double autoGearD2() {
		return Preferences.getInstance().getDouble("AutoGearD2", 0.0);
	}

	public static double autoGearDelay() {
		return Preferences.getInstance().getDouble("AutoGearDelay", 0.0);
	}

	public static double autoShotD1() {
		return Preferences.getInstance().getDouble("AutoShotD1", 0.0);
	}

	public static double autoShotTurn() {
		return Preferences.getInstance().getDouble("AutoShotTurn", 0.0);
	}

	public static double autoShotD2() {
		return Preferences.getInstance().getDouble("AutoShotD2", 0.0);
	}
	
	public static double autoShotTime() {
		return Preferences.getInstance().getDouble("AutoShotTime", 0.0);
	}
	
	public static double autoCrossD1() {
		return Preferences.getInstance().getDouble("AutoCrossD1", 0.0);
	}
	
	public static double autoCrossTurn() {
		return Preferences.getInstance().getDouble("AutoCrossTurn", 0.0);
	}
	
	public static double autoCrossD2() {
		return Preferences.getInstance().getDouble("AutoCrossD2", 0.0);
	}
}
