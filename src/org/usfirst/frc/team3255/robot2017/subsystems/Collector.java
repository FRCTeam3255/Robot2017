package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private boolean collectorOn = false;
	
	private WPI_TalonSRX loadTalon = null;
	private WPI_TalonSRX shooterLeftTalon = null;
	private WPI_TalonSRX shooterRightTalon = null;
	
	public Collector() {
		//CANTalons
		loadTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_LOAD_TALON);
		shooterLeftTalon = new WPI_TalonSRX(RobotMap.SHOOTER_LEFT_TALON);
		shooterRightTalon = new WPI_TalonSRX(RobotMap.SHOOTER_RIGHT_TALON);
		
		loadTalon.setInverted(true);
		
		shooterLeftTalon.setNeutralMode(NeutralMode.Brake);
		shooterRightTalon.setNeutralMode(NeutralMode.Brake);
		
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

