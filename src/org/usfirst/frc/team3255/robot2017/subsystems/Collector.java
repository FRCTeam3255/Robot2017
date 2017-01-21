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
	boolean collectorOn = false;
	
	private CANTalon intakeTalon = null;
	
	public Collector() {
		//CANTalons
		intakeTalon = new CANTalon(RobotMap.COLLECTOR_INTAKE_TALON);
		
		intakeTalon.setSafetyEnabled(false);
	}
	
	public void setIntakeSpeed(double speed) {
		intakeTalon.set(speed);
	}
	
	public boolean isCollectorCollecting(){
		return collectorOn;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

