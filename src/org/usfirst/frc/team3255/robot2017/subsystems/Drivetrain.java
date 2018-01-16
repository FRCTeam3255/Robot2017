package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;
import org.usfirst.frc.team3255.robot2017.commands.DriveArcade;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

	boolean lowGear = true;
		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftFrontTalon = null;
	private WPI_TalonSRX leftBackTalon = null;
	private WPI_TalonSRX rightFrontTalon = null;
	private WPI_TalonSRX rightBackTalon = null;
	
	private DoubleSolenoid driveSolenoid = null;
	
	private Encoder driveEncoder = null;
	
	private DifferentialDrive differentialDrive = null;
	
	public Drivetrain() {
		//CANTalons
    	leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		leftFrontTalon.setNeutralMode(NeutralMode.Brake);
		leftBackTalon.setNeutralMode(NeutralMode.Brake);
		rightFrontTalon.setNeutralMode(NeutralMode.Brake);
		rightBackTalon.setNeutralMode(NeutralMode.Brake);
		
		leftFrontTalon.setSafetyEnabled(false);
		leftBackTalon.setSafetyEnabled(false);
		rightFrontTalon.setSafetyEnabled(false);
		rightBackTalon.setSafetyEnabled(false);
		
		leftBackTalon.follow(leftFrontTalon);
		rightBackTalon.follow(rightFrontTalon);
		
		//Solenoids
		driveSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFT_UP, RobotMap.DRIVETRAIN_SHIFT_DOWN);
		
		//Encoders
		driveEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
		
		//RobotDrive
		differentialDrive = new DifferentialDrive(leftFrontTalon, rightFrontTalon);
		
		differentialDrive.setSafetyEnabled(false);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){
		differentialDrive.arcadeDrive(-moveSpeed, rotateSpeed);
	}
	
	//Solenoids
	public void shiftUp() {
		driveSolenoid.set(Value.kForward);
		lowGear = false;
	}
	
	public void shiftDown() {
		driveSolenoid.set(Value.kReverse);
		lowGear = true;
	}
	
	public boolean isLowGear() {
		return lowGear;
	}
	
	public double getEncoderCount() {
		return driveEncoder.get();
	}
	
	public void resetEncoderCount() {
		driveEncoder.reset();
	}
	
	public double getEncoderDistance() {
		return (getEncoderCount() / RobotPreferences.drivetrainPulsesPerFoot());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}

