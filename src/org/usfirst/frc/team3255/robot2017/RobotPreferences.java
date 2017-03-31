package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//Drivetrain
	public static double drivetrainPulsesPerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 245.8;
		}
		
		return Preferences.getInstance().getDouble("DrivePulsesPerFoot", 245.8);
	}
	
	//Collector
	public static double collectorLoadSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.7;
		}
		
		return Preferences.getInstance().getDouble("CollectorLoadSpeed", 0.7);
	}
	
	public static double shootSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		
		return Preferences.getInstance().getDouble("CollectorShootSpeed", 1.0);
	}
	
	//Climber
	public static double climberPulsesPerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 3753.0;
		}
		
		return Preferences.getInstance().getDouble("ClimberPulsesPerFoot", 3753.0);
	}
	
	public static double climberSwitchDistance() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("ClimberSwitchDistance", 0.0);
	}
	
	//GearCollector
	public static double gearRetractDelay() {
		return 0.5;
	}
	
	//Navigation
	public static double navYawP() {
		if(AutoPreferences.isDebug() == false) {
			return 0.2;
		}
		
		return Preferences.getInstance().getDouble("NavYawP", 0.2);
	}

	public static double navYawI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("NavYawI", 0.0);
	}

	public static double navYawD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.5;
		}
		
		return Preferences.getInstance().getDouble("NavYawD", 0.5);
	}
	
	public static double yawTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		
		return Preferences.getInstance().getDouble("YawTolerance", 1.5);
	}

	public static double maxYawSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.6;
		}
		
		return Preferences.getInstance().getDouble("MaxYawSpeed", 0.6);
	}
	
	public static double minYawSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("MinYawSpeed", 0.1);
	}

	//Drivetrain PID
	public static double driveDistance() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("DriveDistance", 0.0);
	}
	
	public static double distanceTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 0.03;
		}
		
		return Preferences.getInstance().getDouble("DistanceTolerance", 0.03);
	}

	public static double driveDistanceP() {
		if(AutoPreferences.isDebug() == false) {
			return 5.5;
		}
		
		return Preferences.getInstance().getDouble("DriveDistanceP", 5.5);
	}

	public static double driveDistanceI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.7;
		}
		
		return Preferences.getInstance().getDouble("DriveDistanceI", 0.7);
	}

	public static double driveDistanceD() {
		if(AutoPreferences.isDebug() == false) {
			return 9.0;
		}
		
		return Preferences.getInstance().getDouble("DriveDistanceD", 9.0);
	}

	public static double maxMoveSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.8;
		}
		
		return Preferences.getInstance().getDouble("MaxMoveSpeed", 0.8);
	}

	public static double minMoveSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("MinMoveSpeed", 0.0);
	}

	//Autonomous
	public static double autoGearD1() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoGearD1", 0.0);
	}

	public static double autoGearTurn() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoGearTurn", 0.0);
	}

	public static double autoGearD2() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoGearD2", 0.0);
	}

	public static double autoGearDelay() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		
		return Preferences.getInstance().getDouble("AutoGearDelay", 1.0);
	}

	public static double autoShotD1() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoShotD1", 0.0);
	}

	public static double autoShotTurn() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoShotTurn", 0.0);
	}

	public static double autoShotD2() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoShotD2", 0.0);
	}
	
	public static double autoShotTime() {
		if(AutoPreferences.isDebug() == false) {
			return 5.0;
		}
		
		return Preferences.getInstance().getDouble("AutoShotTime", 5.0);
	}
	
	public static double autoCrossD1() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoCrossD1", 0.0);
	}
	
	public static double autoCrossTurn() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoCrossTurn", 0.0);
	}
	
	public static double autoCrossD2() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoCrossD2", 0.0);
	}
	
	public static double autoDoDelay() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		
		return Preferences.getInstance().getDouble("AutoDoDelay", 0.0);
	}
	
	public static int targetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 5;
		}
		
		return Preferences.getInstance().getInt("TargetCount", 5);
	}

	//Two Gear Auto
	public static double autoTwoGearD1() {
		if(AutoPreferences.isDebug() == false){
			return 0.0;	
		}
		return 0.0;
	}

	public static double autoTwoGearD2() {
		if(AutoPreferences.isDebug() == false){
			return 0.0;	
		}
		return 0;
	}

	public static double autoTwoGearTurn() {
		if(AutoPreferences.isDebug() == false){
			return 0.0;	
		}
		return 0;
	}

	public static double autoTwoGearD3() {
		if(AutoPreferences.isDebug() == false){
			return 0.0;	
		}
		return 0;
	}

	public static double autoTwoGearDelay() {
		if(AutoPreferences.isDebug() == false){
			return 0.0;	
		}
		return 0;
	}
}
