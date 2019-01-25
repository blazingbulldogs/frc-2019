package frc.robot.structures;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.OperatorInput;
import frc.robot.RobotMap;

public class Logger {
  private ShuffleboardTab tab = Shuffleboard.getTab("Driving");
  public static final DriveJoystick driveJoystick = new DriveJoystick(RobotMap.joystick);
  private final NetworkTableEntry joystickData = tab.add("Joystick Output", new double[] { 0, 0, 0 })
      .withWidget(BuiltInWidgets.kGraph).getEntry();

  private final NetworkTableEntry joyTabX = tab.add("Joystick X", 0).withWidget(BuiltInWidgets.kNumberBar).getEntry();
  private final NetworkTableEntry joyTabY = tab.add("Joystick Y", 0).withWidget(BuiltInWidgets.kNumberBar).getEntry();
  private final NetworkTableEntry joyTabZ = tab.add("Joystick Z", 0).withWidget(BuiltInWidgets.kNumberBar).getEntry();

  /**
   * Log joystick values using a graph on Shuffleboard.
   * 
   * @param joystick Joystick to log
   */
  public final void logJoystick(DriveJoystick joystick) {
    final double x = joystick.getScaledX();
    final double y = joystick.getScaledY();
    final double z = OperatorInput.scale(OperatorInput.triggerTurn());

    double[] joystickValues = new double[] { x, y, z };

    this.joystickData.setDoubleArray(joystickValues);

    this.joyTabX.setDouble(x);
    this.joyTabY.setDouble(y);
    this.joyTabZ.setDouble(z);
  }
}