package frc.robot.structures;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.OperatorInput;

public class DriveJoystick extends Joystick {
  public DriveJoystick(int port) {
    super(port);
  }

  public double getScaledX() {
    return OperatorInput.scale(super.getX());
  }

  public double getScaledY() {
    return OperatorInput.scale(super.getY());
  }

  public double getScaledZ() {
    return OperatorInput.scale(super.getZ());
  }
}