package frc.robot.structures;

/**
 * Settings used across the project.
 */
public final class Config {
  // Whether or not to use USB cameras
  public static final boolean camerasEnabled = true;

  public static final String jetsonIP = "http://10.53.32.12:5800";

  // Enable certain subsytems
  public static final boolean driveSubsytemEnabled = true;
  public static final boolean solenoidsSubsytemEnabled = true;
  public static final boolean gyroSubsytemEnabled = false;
}