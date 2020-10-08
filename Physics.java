public class Physics  {

    public void deflect(Ball a, Ball b) {
        // The position and speed of each of the two balls in the x and y axis before
        // collision.
        // YOU NEED TO FILL THESE VALUES IN AS APPROPRIATE...
        /*for (int x = 0; x < 15; x++)  
                            {  
                                for (int j = x + 1; j < 15; j++)  
                                {  
                                    if (GameArena.newBalls[x].collides(GameArena.newBalls[j]))  
                                    {
                                        System.out.println("Colour ball Collided");
                                        deflect(GameArena.newBalls[x], GameArena.newBalls[j]);

                                    }
                                }
                            }*/
        double xPosition1, xPosition2, yPosition1, yPosition2;
        double xSpeed1, xSpeed2, ySpeed1, ySpeed2;

        xSpeed1 = a.getXSpeed();
        ySpeed1 = a.getYSpeed();
        xSpeed2 = b.getXSpeed();
        ySpeed2 = b.getYSpeed();
        /*
         * if (a.getXSpeed() < 0.1){ xSpeed1 = 0; } else if (a.getYSpeed() < 0.1){
         * ySpeed1 = 0; } else if (a.getXSpeed() > -0.1){ xSpeed1 = 0; } else if
         * (a.getYSpeed() > -0.1){ ySpeed1 = 0; } else if (b.getXSpeed() < 0.1){ xSpeed2
         * = 0; } else if (b.getYSpeed() < 0.1){ ySpeed2 = 0; } else if (b.getXSpeed() >
         * -0.1){ xSpeed2 = 0; } else if (b.getYSpeed() > -0.1){ ySpeed2 = 0; }
         */

        System.out.println(xSpeed1);
        System.out.println(ySpeed1);
        System.out.println(xSpeed2);
        System.out.println(ySpeed2);

        xPosition1 = a.getXPosition();
        yPosition1 = a.getYPosition();
        xPosition2 = b.getXPosition();
        yPosition2 = b.getYPosition();

        // Calculate initial momentum of the balls... We assume unit mass here.
        double p1InitialMomentum = Math.sqrt(xSpeed1 * xSpeed1 + ySpeed1 * ySpeed1);
        double p2InitialMomentum = Math.sqrt(xSpeed2 * xSpeed2 + ySpeed2 * ySpeed2);
        // calculate motion vectors
        double[] p1Trajectory = { xSpeed1, ySpeed1 };
        double[] p2Trajectory = { xSpeed2, ySpeed2 };
        // Calculate Impact Vector
        double[] impactVector = { xPosition2 - xPosition1, yPosition2 - yPosition1 };
        double[] impactVectorNorm = normalizeVector(impactVector);
        // Calculate scalar product of each trajectory and impact vector
        double p1dotImpact = Math.abs(p1Trajectory[0] * impactVectorNorm[0] + p1Trajectory[1] * impactVectorNorm[1]);
        double p2dotImpact = Math.abs(p2Trajectory[0] * impactVectorNorm[0] + p2Trajectory[1] * impactVectorNorm[1]);
        // Calculate the deflection vectors - the amount of energy transferred from one
        // ball to the other in each axis
        double[] p1Deflect = { -impactVectorNorm[0] * p2dotImpact, -impactVectorNorm[1] * p2dotImpact };
        double[] p2Deflect = { impactVectorNorm[0] * p1dotImpact, impactVectorNorm[1] * p1dotImpact };
        // Calculate the final trajectories
        double[] p1FinalTrajectory = { p1Trajectory[0] + p1Deflect[0] - p2Deflect[0],
                p1Trajectory[1] + p1Deflect[1] - p2Deflect[1] };
        double[] p2FinalTrajectory = { p2Trajectory[0] + p2Deflect[0] - p1Deflect[0],
                p2Trajectory[1] + p2Deflect[1] - p1Deflect[1] };
        // Calculate the final energy in the system.
        double p1FinalMomentum = Math
                .sqrt(p1FinalTrajectory[0] * p1FinalTrajectory[0] + p1FinalTrajectory[1] * p1FinalTrajectory[1]);
        double p2FinalMomentum = Math
                .sqrt(p2FinalTrajectory[0] * p2FinalTrajectory[0] + p2FinalTrajectory[1] * p2FinalTrajectory[1]);

        // Scale the resultant trajectories if we've accidentally broken the laws of
        // physics.
        double mag = (p1InitialMomentum + p2InitialMomentum) / (p1FinalMomentum + p2FinalMomentum);
        // Calculate the final x and y speed settings for the two balls after collision.
        xSpeed1 = p1FinalTrajectory[0] * mag;
        ySpeed1 = p1FinalTrajectory[1] * mag;
        xSpeed2 = p2FinalTrajectory[0] * mag + 0.001;
        ySpeed2 = p2FinalTrajectory[1] * mag + 0.001;

        while (xSpeed1 != 0 && ySpeed1 != 0 && xSpeed2 != 0 && ySpeed2 != 0) {
            a.move();
            b.move();

            a.setXSpeed(xSpeed1);
            a.setYSpeed(ySpeed1);

            b.setXSpeed(xSpeed2);
            b.setYSpeed(ySpeed2);
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (a.getXPosition() < 110)
                xSpeed1 = -a.getXSpeed();
            if (a.getXPosition() > 1840)
                xSpeed1 = -a.getXSpeed();
            if (a.getYPosition() < 170)
                ySpeed1 = -a.getXSpeed();
            if (a.getYPosition() > 925)
                ySpeed1 = -a.getYSpeed();
            
            if (b.getXPosition() < 110)
                xSpeed2 = -b.getXSpeed();
            if (b.getXPosition() > 1840)
                xSpeed2 = -b.getXSpeed();
            if (b.getYPosition() < 170)
                ySpeed2 = -b.getXSpeed();
            if (b.getYPosition() > 925)
                ySpeed2 = -b.getYSpeed();

            xSpeed1 = xSpeed1 * 0.95;
            ySpeed1 = ySpeed1 * 0.95;
            xSpeed2 = ySpeed2 * 0.95;
            ySpeed2 = ySpeed2 * 0.95;

            if (xSpeed1 > 0 && ySpeed1 > 0){
                if (xSpeed1 < 0.1){ 
                    xSpeed1 = 0;
                    }
                    else if (ySpeed1 < 0.1){
                        ySpeed1 = 0;
                    }
            }
            else if (xSpeed1 < 0 && ySpeed1 > 0 ){
                if (xSpeed1 > -0.1){ 
                    xSpeed1 = 0;
                    }
                    else if (ySpeed1 < 0.1){
                        ySpeed1 = 0;
                    }
            }
            else if (xSpeed1 < 0 && ySpeed1 < 0){
                if (xSpeed1 > -0.1){ 
                    xSpeed1 = 0;
                    }
                    else if (ySpeed1 > -0.1){
                        ySpeed1 = 0;
                    }
            }
            else if (xSpeed1 > 0 && ySpeed1 < 0){
                if (xSpeed1 < 0.1){ 
                    xSpeed1 = 0;
                    }
                    else if (ySpeed1 > -0.1){
                        ySpeed1 = 0;
                    }
            }
            else if (xSpeed2 > 0 && ySpeed2 > 0){
                if (xSpeed2 < 0.1){ 
                    xSpeed2 = 0;
                    }
                    else if (ySpeed2 < 0.1){
                        ySpeed2 = 0;
                    }
            }
            else if (xSpeed2 < 0 && ySpeed2 > 0 ){
                if (xSpeed2 > -0.1){ 
                    xSpeed2 = 0;
                    }
                    else if (ySpeed2 < 0.1){
                        ySpeed2 = 0;
                    }
            }
            else if (xSpeed2 < 0 && ySpeed2 < 0){
                if (xSpeed2 > -0.1){ 
                    xSpeed2 = 0;
                    }
                    else if (ySpeed2 > -0.1){
                        ySpeed2 = 0;
                    }
            }
            else if (xSpeed2> 0 && ySpeed2 < 0){
                if (xSpeed2 < 0.1){ 
                    xSpeed2 = 0;
                    }
                    else if (ySpeed2 > -0.1){
                        ySpeed2 = 0;
                    }
            }

        }

    }
    /**
     * Converts a vector into a unit vector.
     * Used by the deflect() method to calculate the resultnt direction after a collision.
     */
    private double[] normalizeVector(double[] vec)
    {
        double mag = 0.0;
        int dimensions = vec.length;
        double[] result = new double[dimensions];
        for (int i=0; i < dimensions; i++)
        mag += vec[i] * vec[i];
        mag = Math.sqrt(mag);
        if (mag == 0.0)
        {
            result[0] = 1.0;
            for (int i=1; i < dimensions; i++)
            result[i] = 0.0;
        }
            else
            {
            for (int i=0; i < dimensions; i++)
                result[i] = vec[i] / mag;
        }
        return result;
    }
}