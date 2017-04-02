package org.usfirst.frc.team3255.robot2017;

import org.usfirst.frc.team3255.robot2017.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// Button button = new JoystickButton(stick, buttonNumber);

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	//create Joysticks
	public Joystick driverStick = new Joystick(RobotMap.JOYSTICK_DRIVER);
	public Joystick shooterStick = new Joystick(RobotMap.JOYSTICK_SHOOTER);
	
//	ShooterStick
	Button S1 = new JoystickButton(shooterStick, 1);
	Button S2 = new JoystickButton(shooterStick, 2);
	Button S3 = new JoystickButton(shooterStick, 3);
	Button S4 = new JoystickButton(shooterStick, 4);
	Button S5 = new JoystickButton(shooterStick, 5);
	Button S7 = new JoystickButton(shooterStick, 7);
	Button S8 = new JoystickButton(shooterStick, 8);
	Button S9 = new JoystickButton(shooterStick, 9);
	Button S10 = new JoystickButton(shooterStick, 10);
	Button S11 = new JoystickButton(shooterStick, 11);
	Button S12 = new JoystickButton(shooterStick, 12);
	
	
//	DriverStick
	Button D1 = new JoystickButton(driverStick, 1);
	Button D2 = new JoystickButton(driverStick, 2);
	Button D3 = new JoystickButton(driverStick, 3);
	Button D4 = new JoystickButton(driverStick, 4);
	Button D5 = new JoystickButton(driverStick, 5);
	Button D6 = new JoystickButton(driverStick, 6);
	Button D7 = new JoystickButton(driverStick, 7);
	Button D8 = new JoystickButton(driverStick, 8);
	Button D9 = new JoystickButton(driverStick, 9);
	Button D10 = new JoystickButton(driverStick, 10);
			
	public OI(){
		
		//ShooterStick
		S1.whenPressed(new CollectorShoot());
		S1.whenReleased(new CollectorStop());
		S3.whenPressed(new CollectorCollect());
		S4.whenPressed(new CollectorStop());
		S5.whenPressed(new CollectorReverse());
		S5.whenReleased(new CollectorStop());
		S7.whenPressed(new PlaceGearBackup());
		S7.whenReleased(new GearRetract());
		S8.whenPressed(new GearPickupFromFloor());
		S8.whenReleased(new GearRetract());
		S9.whenPressed(new ClimbLowSpeed());
		S9.whenReleased(new ClimberStop());
		S10.whenPressed(new ClimbHighSpeed());
		S10.whenReleased(new ClimberStop());
		// S10 is shooter lowSpeed while held - see SetShooterSpeed
		
		//DriverStick
		D5.whenPressed(new DriveShiftDown());
		D6.whenPressed(new DriveShiftUp());
		D7.whenPressed(new DriveShiftDown());
		D8.whenPressed(new DriveShiftUp());
		//D9.whenPressed(new VisionBackCamera());
		//D10.whenPressed(new VisionFrontCamera());

	}
}
