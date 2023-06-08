package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.robot.commands.Autos
import frc.robot.commands.ExampleCommand
import frc.robot.commands.XboxDrive
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem


class RobotContainer {

    private val exampleSubsystem = ExampleSubsystem()

    private val driverController = CommandXboxController(Constants.OperatorConstants.kDriverControllerPort)
    
    private val driveSubsystem = DriveSubsystem()

    init {
        configureBindings()

        driveSubsystem.defaultCommand = XboxDrive(driveSubsystem, driverController)
    }


    private fun configureBindings() {


        
    }


    val autonomousCommand: Command
        get() {
            // An example command will be run in autonomous
            return Autos.exampleAuto(exampleSubsystem)
        }

}
