package stinkyplayer;
import battlecode.common.*;

public class GardenerBrain extends Brain {
    public GardenerBrain(RobotController rc) {
    	this.rc = rc;
    }

    /**
     * run() is the method that is called when a robot is instantiated in the
     * Battlecode world. If this method returns, the robot dies! @throws
     **/
    @SuppressWarnings("unused")
    public void run() {
        System.out.println("I'm a gardener!");
        while (true) {
            try {
                int xPos = rc.readBroadcast(0);
                int yPos = rc.readBroadcast(1);
                MapLocation archonLoc = new MapLocation(xPos,yPos);

                Direction dir = randomDirection();

                if (rc.canBuildRobot(RobotType.SOLDIER, dir) && Math.random() < .1) {
                    rc.buildRobot(RobotType.SOLDIER, dir);
                } else if (rc.canBuildRobot(RobotType.LUMBERJACK, dir) && Math.random() < .01 && rc.isBuildReady()) {
                    rc.buildRobot(RobotType.LUMBERJACK, dir);
                }

                tryMove(randomDirection());

                Clock.yield();

            } catch (Exception e) {
                System.out.println("Gardener Exception");
                e.printStackTrace();
            }
        }
    }
}