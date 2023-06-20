package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import edu.wpi.first.wpilibj2.command.button.Trigger
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup
import edu.wpi.first.wpilibj2.command.WaitCommand
import frc.robot.commands.Autos
import frc.robot.commands.ExampleCommand
import frc.robot.commands.XboxDrive
import frc.robot.commands.IntakeRun
import frc.robot.commands.IntakeStop
import frc.robot.commands.IntakeSetSpeed
import frc.robot.commands.DriveForward
import frc.robot.commands.DriveForward
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem
import frc.robot.subsystems.IntakeSubsystem
import kotlin.sequences.sequence


class RobotContainer {

    private val exampleSubsystem = ExampleSubsystem()

    private val driverController = CommandXboxController(Constants.OperatorConstants.kDriverControllerPort)
    
    private val driveSubsystem = DriveSubsystem()

    private val intakeSubsystem = IntakeSubsystem()

    init {
        configureBindings()

        driveSubsystem.defaultCommand = XboxDrive(driveSubsystem, driverController)
    }


    private fun configureBindings() {

driverController.a().onTrue(IntakeRun(IntakeSubsystem())) // full speed
driverController.a().onFalse(IntakeStop(IntakeSubsystem())) // sotp
driverController.axisGreaterThan(4, 0.1).onTrue(IntakeSetSpeed(intakeSubsystem, driverController)) // percise speed

    }

 
    val autonomousCommand: Command
        get() {
            // An example command will be run in autonomous
            return Commands.sequence(

                ParallelCommandGroup(
                DriveForward(driveSubsystem,0.3).withTimeout(10.0),
                IntakeRun(intakeSubsystem)),

                ParallelRaceGroup(
                DriveForward(driveSubsystem,0.3),
                WaitCommand(5.0)),

                DriveForward(driveSubsystem,0.3).withTimeout(15.0),

                IntakeStop(intakeSubsystem)

            )
        }

}