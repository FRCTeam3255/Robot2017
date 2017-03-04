package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//CANTalons
	private CANTalon leftTalon = null;
	private CANTalon rightTalon = null;

	public Climber() {
		//CANTalons
		leftTalon = new CANTalon(RobotMap.CLIMBER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.CLIMBER_RIGHT_TALON);
		
		leftTalon.enableBrakeMode(true);
		rightTalon.enableBrakeMode(true);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);	
	}
	
	public void forwardLowSpeed() {
		setClimberSpeed(-0.5);
	}
	
	public void forwardHighSpeed() {
		setClimberSpeed(-0.7);
	}
	
	public void stop() {
		setClimberSpeed(0);		
	}
	
	private void setClimberSpeed(double speed) {
		leftTalon.set(speed);
		rightTalon.set(-speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

