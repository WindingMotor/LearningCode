
package frc.robot.commands
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.DriveSubsystem

class IntakeStop(
    private val subsystem: 
):CommandBase(){
    
    init {
        addRequirements(subsystem)
    }

    override fun initialize(){} 

    override fun execute(){
        subsystem.IntakeRun(0.0)
        
    }

    override fun end(interrupted: Boolean) {}

    override fun isFinished(): Boolean {
        return true
    }
}
