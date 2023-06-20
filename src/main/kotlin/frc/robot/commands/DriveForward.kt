
package frc.robot.commands
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem
import frc.robot.subsystems.IntakeSubsystem

class DriveForward(
    private val subsystem: DriveSubsystem,
    private val speed: Double
):CommandBase() {
    
    init {
        addRequirements(subsystem)
    }

    override fun initialize(){
    } 

    override fun execute(){
        subsystem.drive(speed, 0.0);
    }

    override fun end(interrupted: Boolean){
        subsystem.stop()
    }

    override fun isFinished(): Boolean {
        return false
    }
}
