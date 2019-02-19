package frc.robot.controls;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.controls.OperatorInput;

public final class DriveJoystick extends Joystick {
  public DriveJoystick(int port) {
    super(port);
  }

  /**
   * Get the scaled x position of the HID.
   *
   * @return the scaled x position of the HID
   */
  public final double getScaledX() {
    return OperatorInput.scale(super.getX());
  }

  /**
   * Get the scaled y position of the HID.
   *
   * @return the scaled y position of the HID
   */
  public final double getScaledY() {
    return OperatorInput.scale(super.getY());
  }

  /**
   * Get the scaled z position of the HID.
   *
   * @return the scaled z position of the HID
   */
  public final double getScaledZ() {
    return OperatorInput.scale(super.getZ());
  }

  /**
   * Get the scaled value of the axis.
   *
   * @param axis the axis to read, starting at 0
   * @return the scaled value of the axis
   */
  public final double getScaledAxis(int axis) {
    return OperatorInput.scale(super.getRawAxis(axis));
  }
}