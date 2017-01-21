package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.commands.DriveArcade;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	boolean lowGear = true;
		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon leftFrontTalon = null;
	private CANTalon leftBackTalon = null;
	private CANTalon rightFrontTalon = null;
	private CANTalon rightBackTalon = null;
	
	private Encoder driveEncoder = null;
	
	private DoubleSolenoid driveSolenoid = null;
	
	private RobotDrive robotDrive = null;
	
	public Drivetrain() {
		//CANTalons
    	leftFrontTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		leftFrontTalon.setSafetyEnabled(false);
		leftBackTalon.setSafetyEnabled(false);
		rightFrontTalon.setSafetyEnabled(false);
		rightBackTalon.setSafetyEnabled(false);
		
		//Encoders
		driveEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
		
		//Solenoids
		driveSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFT_UP, RobotMap.DRIVETRAIN_SHIFT_DOWN);
		
		//RobotDrive
		robotDrive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		
		robotDrive.setSafetyEnabled(false);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}
	
	//Encoders
	public void resetEncoders() {
		leftFrontTalon.setEncPosition(0);
	}
	
	public double getEncoderPosition() {
		return leftFrontTalon.getEncPosition();
	}
	
	//Solenoids
	public void shiftUp() {
		driveSolenoid.set(Value.kReverse);
		lowGear = false;
	}
	
	public void shiftDown() {
		driveSolenoid.set(Value.kForward);
		lowGear = true;
	}
	
	public boolean isLowGear() {
		return lowGear;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}

