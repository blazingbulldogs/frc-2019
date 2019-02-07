package frc.robot.structures;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.OperatorInput;
import frc.robot.RobotMap;

public class Logger {
  // Use random number to create new tabs when debugging
  public static final ShuffleboardTab tab = Shuffleboard.getTab(Double.toString(Math.random()));
  // public static final ShuffleboardTab tab = Shuffleboard.getTab("Driving");
  public static final DriveJoystick driveJoystick = new DriveJoystick(RobotMap.joystick);
  private final NetworkTableEntry joystickData = tab
      .add("Joystick Output", new double[] { 0, 0, 0 })
      .withPosition(11, 0)
      .withSize(2, 2)
      .withWidget(BuiltInWidgets.kGraph)
      .getEntry();

  private final NetworkTableEntry joyX = tab
      .add("Joystick X", 0)
      .withPosition(0, 2)
      .withWidget(BuiltInWidgets.kNumberBar)
      .getEntry();
  private final NetworkTableEntry joyY = tab
      .add("Joystick Y", 0)
      .withPosition(0, 3)
      .withWidget(BuiltInWidgets.kNumberBar)
      .getEntry();
  private final NetworkTableEntry joyZ = tab
      .add("Joystick Z", 0)
      .withPosition(0, 4)
      .withWidget(BuiltInWidgets.kNumberBar)
      .getEntry();

  /**
   * Log joystick values using a graph on Shuffleboard.
   * 
   * @param joystick Joystick to log
   */
  public final void logJoystick(DriveJoystick joystick) {
    final double x = joystick.getScaledAxis(JoystickPorts.rightXAxis);
    final double y = joystick.getScaledAxis(JoystickPorts.rightYAxis);
    final double z = OperatorInput.scale(OperatorInput.triggerTurn());

    double[] joystickValues = new double[] { x, y, z };

    this.joystickData.setDoubleArray(joystickValues);

    this.joyX.setDouble(x);
    this.joyY.setDouble(y);
    this.joyZ.setDouble(z);
  }
}