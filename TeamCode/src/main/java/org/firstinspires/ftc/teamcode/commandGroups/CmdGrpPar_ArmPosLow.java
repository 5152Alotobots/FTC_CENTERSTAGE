package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystem.arm.SubSys_Arm;
import org.firstinspires.ftc.teamcode.subsystem.arm.commands.Cmd_SubSys_Arm_RotateAndExtend;
import org.firstinspires.ftc.teamcode.subsystem.hand.SubSys_Hand;
import org.firstinspires.ftc.teamcode.subsystem.hand.commands.Cmd_SubSys_Hand_RotateWristToPosition;

public class CmdGrpPar_ArmPosLow extends ParallelCommandGroup
{
    private SubSys_Arm subSysArm;
    private SubSys_Hand subSysHand;
    private Telemetry telemetry;

    public CmdGrpPar_ArmPosLow(SubSys_Arm subSysArm, SubSys_Hand subSysHand, Telemetry telemetry) {
        this.subSysArm = subSysArm;
        this.subSysHand = subSysHand;
        this.telemetry = telemetry;

        addCommands(
                new Cmd_SubSys_Arm_RotateAndExtend(
                        subSysArm,
                        telemetry,
                        () -> 29.5,
                        () -> 40
                ),
                new Cmd_SubSys_Hand_RotateWristToPosition(
                        subSysHand,
                        telemetry,
                        () -> 50
                )
        );
        addRequirements(subSysArm, subSysHand);
    }

}
