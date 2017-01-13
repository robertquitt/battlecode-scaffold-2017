package stinkyplayer;
import battlecode.common.*;

public class ArchonBrain extends Brain {
    public ArchonBrain(RobotController rc) {
    	this.rc = rc;
    }

    /**
     * run() is the method that is called when a robot is instantiated in the
     * Battlecode world. If this method returns, the robot dies! @throws
     **/
    public void run() {
        System.out.println("I'm an archon!");
        while (true) {
            try {
                Direction dir = randomDirection();
                if (rc.canHireGardener(dir) && Math.random() < .1   ) {
                    rc.hireGardener(dir);
                }
                tryMove(randomDirection());
                MapLocation myLocation = rc.getLocation();
                rc.broadcast(0,(int)myLocation.x);
                rc.broadcast(1,(int)myLocation.y);
                Clock.yield();
            } catch (Exception e) {
                System.out.println("Archon Exception");
                e.printStackTrace();
            }
        }
    }
}