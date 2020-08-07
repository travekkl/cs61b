/**
 *  Nbody is a class that will run a simulation.
 */

public class NBody {
	/**
	 * readRadius takes a string, and returns a double corresponding to the radius
	 * of the universe in that file.
	 */
	public static double readRadius(String s) {
		In in = new In(s);
		in.readInt();
		return in.readDouble();
	}
    
    /**
     * readPlanets takes a string and returns an array of Planets corresponding
     * to the planets in the file.
     */
    public static Planet[] readPlanets(String s) {
        //In inLength = new In(s);
        //String[] sArray = inLength.readAllLines();
        //System.out.println(sArray.length);
    	//Planet[] planetsArray = new Planet[sArray.length]; 
    	In in = new In(s);
    	int len = in.readInt();
    	in.readDouble();
    	Planet[] planetsArray = new Planet[len];
    	int cnt = 0;
        try {
	    	while((!in.isEmpty()) && (cnt < len)) {
	    		for(int i = 0; i < 5; i++) {
	    	        double xxPos = in.readDouble();
	    		    double yyPos = in.readDouble();
	    		    double xxVel = in.readDouble();
	    		    double yyVel = in.readDouble();
	    		    double mass  = in.readDouble();
	    		    String imgFileName = in.readString();
	    		    planetsArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
	    		    cnt++;
	    		}

	    	}
        }
        catch (Exception e) {
        }

    	return planetsArray;

    }

    public static void main(String[] args) {
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];

        double radius = readRadius(filename);
    	Planet[] planetsArray = readPlanets(filename);

        String Screen = "images/starfield.jpg";
		StdDraw.setScale(-1 * radius, radius);
		/* Clears the drawing window. */
		StdDraw.clear();
		/* Stamps three copies of advice.png in a triangular pattern. */
		StdDraw.picture(0, 0, Screen);

		for (Planet planet: planetsArray) {
			planet.draw();
		}
		StdDraw.show();
        //StdDraw.pause(10000);
		StdDraw.enableDoubleBuffering();

		double time = 0;
		while(time < T) {
			StdDraw.clear();
			StdDraw.picture(0, 0, Screen);
			for (Planet planet: planetsArray) {
			    double forceX = planet.calcNetForceExertedByX(planetsArray);
			    double forceY = planet.calcNetForceExertedByY(planetsArray);
			    planet.update(dt, forceX, forceY);
			    planet.draw();
			    //System.out.print(forceX);
			    //System.out.println(forceY);
		    }
		    StdDraw.show();
		    //StdDraw.pause(10);
		    time += dt;
		}
        StdOut.printf("%d\n", planetsArray.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planetsArray.length; i++) {
        	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        		          planetsArray[i].xxPos, planetsArray[i].yyPos, planetsArray[i].xxVel,
        		          planetsArray[i].yyVel, planetsArray[i].mass, planetsArray[i].imgFileName);
        }

    }

}