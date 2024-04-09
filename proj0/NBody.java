public class NBody
{
	public static double readRadius(String path)
	{
		In in = new In(path);
		in.readInt();
		return in.readDouble();
	}
	public static Planet[] readPlanets(String path)
	{
		In in = new In(path);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] planets= new Planet[num];
		for(int i=0;i<num;i++)
		{
			double xp = in.readDouble();
			double yp = in.readDouble();
			double vx = in.readDouble();
			double vy = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xp, yp, vx, vy, m, img);	
		}
		return planets;
	}
	public static void main(String[] args)
	{
		double T = new Double(args[0]);
		double dt = new Double(args[1]);
		String filename = args[2];
		Planet[] p = readPlanets(filename);
		double radius = readRadius(filename);
		double time = 0;
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius,radius);
		while(time<=T)
		{
			double[] xForces = new double[p.length];
			double[] yForces = new double[p.length];
			for(int i=0;i<p.length;i++)
			{
				xForces[i] = p[i].calcNetForceExertedByX(p);
				yForces[i] = p[i].calcNetForceExertedByY(p);
			}
			for(int i=0;i<p.length;i++)
			{
				p[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(Planet q:p)
			{
				q.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time=time+dt;
		}

	}
}