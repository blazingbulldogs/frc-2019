/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ActivateAllSolenoids;
import frc.robot.commands.ActivateSolenoid;
import frc.robot.commands.DeactivateAllSolenoids;
import frc.robot.commands.DeactivateSolenoid;
import frc.robot.structures.Config;
import frc.robot.structures.DriveJoystick;
import frc.robot.structures.JoystickPorts;

public class OperatorInput {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  // joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

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

  public static final DriveJoystick driveJoystick = new DriveJoystick(RobotMap.joystick);

  /**
   * This class is the glue that binds the controls on the physical operator
   * interface to the commands and command groups that allow control of the robot.
   */
  public OperatorInput() {
    if (Config.solenoidsSubsytemEnabled) {
      final JoystickButton aButton = new JoystickButton(driveJoystick, JoystickPorts.aButton);
      final JoystickButton bButton = new JoystickButton(driveJoystick, JoystickPorts.bButton);
      final JoystickButton xButton = new JoystickButton(driveJoystick, JoystickPorts.xButton);
      final JoystickButton yButton = new JoystickButton(driveJoystick, JoystickPorts.yButton);

      aButton.whenPressed(new ActivateSolenoid(Robot.solenoidsSubsytem.randomSolenoid1));
      aButton.whenReleased(new DeactivateSolenoid(Robot.solenoidsSubsytem.randomSolenoid1));
      
      bButton.whenPressed(new ActivateAllSolenoids());
      bButton.whenReleased(new DeactivateAllSolenoids());

      xButton.whenPressed(new ActivateSolenoid(Robot.solenoidsSubsytem.randomSolenoid1));
      yButton.whenPressed(new DeactivateSolenoid(Robot.solenoidsSubsytem.randomSolenoid1));
    }
  }

  /**
   * Get output from the left and right triggers that is in the ranges of the
   * z-axis from a controller.
   */
  public static final double triggerTurn() {
    final double leftTrigger = driveJoystick.getRawAxis(JoystickPorts.leftTriggerAxis);
    final double rightTrigger = driveJoystick.getRawAxis(JoystickPorts.rightTriggerAxis);

    if (leftTrigger != 0) {
      // Left trigger in use
      return leftTrigger * -1;
    } else {
      // Right trigger in use
      return rightTrigger;
    }
  }

  /**
   * Scales a value to be more precise at lower values. Used for driving.
   * 
   * @return scaled value
   */
  public static double scale(double value) {
    return Math.signum(value) * scaleHelper(Math.abs(value));
  }

  /**
   * Used internally for scaling values.
   * 
   * @return partially scaled value
   */
  private static double scaleHelper(double value) {
    return Math.min(1.0, Math.pow(2, value) - 1);
  }
}
