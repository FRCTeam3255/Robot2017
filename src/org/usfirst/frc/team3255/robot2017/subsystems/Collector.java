package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private boolean collectorOn = false;
	
	private CANTalon intakeTalon = null;
	private CANTalon loadTalon = null;
	
	public Collector() {
		//CANTalons
		intakeTalon = new CANTalon(RobotMap.COLLECTOR_INTAKE_TALON);
		loadTalon = new CANTalon(RobotMap.SHOOTER_LOAD_TALON);
		
		intakeTalon.setSafetyEnabled(false);
		loadTalon.setSafetyEnabled(false);
	}
	
	public void collect() {
		intakeTalon.set(1.0);
		loadTalon.set(1.0);
		collectorOn = true;
	}
	
	public void reverse() {
		intakeTalon.set(-1.0);
		loadTalon.set(0.0);
		collectorOn = false;
	}
	
	public void stop() {
		intakeTalon.set(0.0);
		loadTalon.set(0.0);
		collectorOn = false;
	}
	
	public void shoot() {
		intakeTalon.set(1.0);
		loadTalon.set(-1.0);
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

