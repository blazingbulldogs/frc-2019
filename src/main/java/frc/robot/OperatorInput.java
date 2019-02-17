/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.solenoids.ActivateAllSolenoids;
import frc.robot.commands.solenoids.DeactivateAllSolenoids;
import frc.robot.commands.solenoids.duo.ActivateAllDoubleSolenoids;
import frc.robot.commands.solenoids.duo.DeactivateAllDoubleSolenoids;
import frc.robot.structures.Config;
import frc.robot.structures.DriveJoystick;
import frc.robot.structures.JoystickPorts;
import frc.robot.subsystems.Drive;
import frc.robot.commands.GyroZero;;

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
      final JoystickButton leftBmp = new JoystickButton(driveJoystick, JoystickPorts.leftBumper);
      final JoystickButton rightBmp = new JoystickButton(driveJoystick, JoystickPorts.rightBumper);

      rightBmp.whenPressed(new ActivateAllSolenoids());
      rightBmp.whenReleased(new DeactivateAllSolenoids());

      leftBmp.whenPressed(new ActivateAllDoubleSolenoids());
      leftBmp.whenReleased(new DeactivateAllDoubleSolenoids());
    }
    if (Config.gyroSubsytemEnabled) {
      final JoystickButton bButton = new JoystickButton(driveJoystick, JoystickPorts.bButton);

      bButton.whenPressed(new GyroZero());
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
   * Scales a value to be more precise at lower values. Used for driving. Cubes
   * the joystick value.
   * 
   * @return scaled value
   */
  public static double scale(double value) {
    // Cube the value
    return Math.pow(value, 3);
  }
}
