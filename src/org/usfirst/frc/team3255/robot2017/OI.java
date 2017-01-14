package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

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
	public Joystick driverStick = null;
	public Joystick shooterStick = null;
	
	public OI(){
		driverStick = new Joystick(RobotMap.JOYSTICK_DRIVER);
		shooterStick = new Joystick(RobotMap.JOYSTICK_SHOOTER);
		
	}
}
