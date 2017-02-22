package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
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
	
	// Switches
	private DigitalInput touchpadSwitch = null;
	private DigitalInput enableSwitch = null;
	
	//Encoder
	private Encoder climberEncoder = null;
	
	public Climber() {
		//CANTalons
		leftTalon = new CANTalon(RobotMap.CLIMBER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.CLIMBER_RIGHT_TALON);
		
		leftTalon.enableBrakeMode(false);
		rightTalon.enableBrakeMode(false);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);	
		
		//DigitalInputs
		touchpadSwitch = new DigitalInput(RobotMap.CLIMBER_TOUCHPAD_SWITCH);
		enableSwitch = new DigitalInput(RobotMap.CLIMBER_ENABLE_SWITCH);
		
		//Encoder
		climberEncoder = new Encoder(RobotMap.CLIMBER_ENCODER_A, RobotMap.CLIMBER_ENCODER_B);
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
	
	public boolean isTouchpadSwitchClosed() {
		return touchpadSwitch.get();
	}
	
	public boolean isClimberEnabled() {
		return enableSwitch.get();
	}
	
	//Encoders
	public double getEncoderCount() {
		return climberEncoder.get();
	}
	
	public void resetEncoderCount() {
		climberEncoder.reset();
	}
	
	public double getEncoderDistance() {
		return (getEncoderCount() / RobotPreferences.climberPulsesPerFoot());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

