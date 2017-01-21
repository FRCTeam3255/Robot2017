package org.usfirst.frc.team3255.robot2017;

import org.usfirst.frc.team3255.robot2017.commands.ClimberClimb;
import org.usfirst.frc.team3255.robot2017.commands.ClimberSetSpeed;
import org.usfirst.frc.team3255.robot2017.commands.ClimberStop;
import org.usfirst.frc.team3255.robot2017.commands.CollectorCollect;
import org.usfirst.frc.team3255.robot2017.commands.CollectorStop;
import org.usfirst.frc.team3255.robot2017.commands.ShooterMultiShot;

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
	Button S3 = new JoystickButton(shooterStick, 3);
	Button S4 = new JoystickButton(shooterStick, 4);
	Button S11 = new JoystickButton(shooterStick, 11);
	Button S12 = new JoystickButton(shooterStick, 12);
			
	public OI(){
		
		//ShooterStick
		S1.whileHeld(new ShooterMultiShot());
		S3.whenPressed(new CollectorCollect());
		S4.whenPressed(new CollectorStop());
		S11.whenPressed(new ClimberStop());
		S12.whenPressed(new ClimberClimb());

	}
}
