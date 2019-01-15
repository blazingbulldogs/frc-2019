/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;

  private final AnalogGyro m_gyro = new AnalogGyro(RobotMap.gyro);
  private MecanumDrive m_robotDrive;
  private final Joystick m_joystick = new Joystick(RobotMap.joystick);

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

    // Set the gyroscope to 0
    m_gyro.calibrate();
    // Since `gyro` is sendable, we can pass it in to `add()` and forget about it
    Shuffleboard.getTab("Driving").add("Gyro", m_gyro).withWidget(BuiltInWidgets.kGyro);

    // Add one camera to the camera server
    CameraServer.getInstance().startAutomaticCapture();

    // Motor controllers
    PWMVictorSPX frontLeft = new PWMVictorSPX(RobotMap.victorSPXFrontLeft);
    PWMVictorSPX backLeft = new PWMVictorSPX(RobotMap.victorSPXBackLeft);
    PWMVictorSPX frontRight = new PWMVictorSPX(RobotMap.victorSPXFrontRight);
    PWMVictorSPX backRight = new PWMVictorSPX(RobotMap.victorSPXBackRight);

    // Invert the left motors
    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    // Set the robot drive
    m_robotDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    // Adjust sensitivity of joysticks
    final double multiplier = 1;

    final double x = m_joystick.getX() * multiplier;
    final double y = m_joystick.getY() * multiplier;
    final double z = m_joystick.getZ() * multiplier;

    m_robotDrive.driveCartesian(x, y, z, m_gyro.getAngle());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
