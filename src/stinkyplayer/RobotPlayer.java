package stinkyplayer;
import battlecode.common.*;

public strictfp class RobotPlayer {
    private static Brain brain;

    /**
     * run() is the method that is called when a robot is instantiated in the
     * Battlecode world. If this method returns, the robot dies! @throws
     **/
    public static void run(RobotController rc) {
        switch (rc.getType()) {
            case ARCHON:
                brain = new ArchonBrain(rc);
                break;
            case SOLDIER:
                brain = new SoldierBrain(rc);
                break;
            case GARDENER:
                brain = new GardenerBrain(rc);
                break;
            case LUMBERJACK:
                brain = new LumberjackBrain(rc);
                break;
            case TANK:
                break;
            case SCOUT:
                break;
        }
        brain.run();
    }
}