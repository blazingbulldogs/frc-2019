/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Ports;

/*
 * Drive subsystem - controls the wheels to move the robot
 *
 * Overview of how we drive straight: we have access to a PID, which is a system
 * that hones in an input on a target value using an output. The input is taken
 * from the encoders and can be either displacement or velocity; the output is
 * fed to the motors. But instead of running left and right in two separate
 * PIDs, we target a rotation and a displacement (auto) or velocity (teleop). To
 * do this we use virtual encoders as PID inputs and virtual motors and PID
 * outputs. Keep reading and this will make more sense.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  final private static Encoder encoderRight = new Encoder(Ports.rightEncoderChannelA, Ports.rightEncoderChannelB,
      Ports.rightEncoderReverse, Encoder.EncodingType.k4X);
  final private static Encoder encoderLeft = new Encoder(Ports.leftEncoderChannelA, Ports.leftEncoderChannelB,
      Ports.leftEncoderReverse, Encoder.EncodingType.k4X);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
