package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private boolean collectorOn = false;
	
	private CANTalon loadTalon = null;
	private CANTalon shooterLeftTalon = null;
	private CANTalon shooterRightTalon = null;
	
	public Collector() {
		//CANTalons
		loadTalon = new CANTalon(RobotMap.COLLECTOR_LOAD_TALON);
		shooterLeftTalon = new CANTalon(RobotMap.SHOOTER_LEFT_TALON);
		shooterRightTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_TALON);
		
		loadTalon.setInverted(true);
		
		loadTalon.setSafetyEnabled(false);
		shooterLeftTalon.setSafetyEnabled(false);
		shooterRightTalon.setSafetyEnabled(false);
	}
	
	public void collect() {
		loadTalon.set(-RobotPreferences.collectorLoadSpeed());
		shooterLeftTalon.set(-RobotPreferences.shootSpeed());
		shooterRightTalon.set(RobotPreferences.shootSpeed());
		collectorOn = true;
	}
	
	public void reverse() {
		loadTalon.set(-RobotPreferences.collectorLoadSpeed());
		shooterLeftTalon.set(0.0);
		shooterRightTalon.set(0.0);
		collectorOn = false;
	}
	
	public void stop() {
		loadTalon.set(0.0);
		shooterLeftTalon.set(0.0);
		shooterRightTalon.set(0.0);
		collectorOn = false;
	}
	
	public void shoot() {
		loadTalon.set(RobotPreferences.collectorLoadSpeed());
		shooterLeftTalon.set(-RobotPreferences.shootSpeed());
		shooterRightTalon.set(RobotPreferences.shootSpeed());
		collectorOn = false;
	}
	
	public boolean isCollectorCollecting() {
		return collectorOn;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

