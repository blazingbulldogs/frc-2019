/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.HttpCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.structures.Config;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Solenoids;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Drive driveSubsytem;
  public static Gyro gyroSubsytem;
  public static Solenoids solenoidsSubsytem;

  Robot() {
    if (Config.driveSubsytemEnabled) {
      driveSubsytem = new Drive();
    }
    if (Config.gyroSubsytemEnabled) {
      gyroSubsytem = new Gyro();
    }
    if (Config.solenoidsSubsytemEnabled) {
      solenoidsSubsytem = new Solenoids();
    }
  }

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    if (Config.camerasEnabled) {
      CameraServer cameraServer = CameraServer.getInstance();
      HttpCamera jetsonCamera = new HttpCamera("camera", Config.jetsonIP + "/?action=stream");
      cameraServer.startAutomaticCapture(jetsonCamera);
    }

    new OperatorInput();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test. This runs after the mode specific periodic functions,
   * but before LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}
