import javax.swing.*;
import java.awt.*;

public class pendulumSystem extends JPanel implements Runnable {

    int BALLDIAMETER;
    double THETA;

    int lineLength;

    int HOOKDIAMETER = 10;
    int screenWidth;
    int screenHeight;
    pendulumSystem(int ballDiameter, int theta, int lineLength, int screenwidth, int screenheight){
    this.BALLDIAMETER = ballDiameter;
    this.THETA = theta;
    this.lineLength = lineLength;
    this.screenWidth = screenwidth;
    this.screenHeight = screenheight;
    this.setSize(screenWidth,screenHeight);
    }

    int stringX;
    int stringY;

    int ballX;

    int ballY;
    public void paint(Graphics g)
    {
    g.setColor(Color.BLACK);
    g.fillRect(0,0, screenWidth, screenHeight);
    g.setColor(Color.white);
    g.fillOval(screenWidth/2-HOOKDIAMETER/2, screenHeight/6, HOOKDIAMETER, HOOKDIAMETER);
    stringX = (int) (screenWidth/2 - lineLength*Math.sin((THETA*Math.PI)/180));
    stringY = (int)(screenHeight/6 + HOOKDIAMETER+lineLength*Math.cos((THETA*Math.PI)/180));

    ballX = (int) (stringX - Math.sin((THETA*Math.PI)/180)*BALLDIAMETER/2-BALLDIAMETER/2);
    ballY = (int) (stringY + Math.cos((THETA* Math.PI)/180)*BALLDIAMETER/2 -BALLDIAMETER/2);

    g.drawLine(screenWidth/2, screenHeight/6 + HOOKDIAMETER,stringX, stringY);
    g.fillOval( ballX, ballY , BALLDIAMETER, BALLDIAMETER );
    g.setColor(Color.RED);
    g.drawLine( ballX + BALLDIAMETER/2, ballY + BALLDIAMETER, ballX+BALLDIAMETER/2,  screenHeight/6 + HOOKDIAMETER +lineLength +BALLDIAMETER );
    }



    double g = 9.81;
    double dt = 0.4;
    public void run(){
       while (true)
       {
       updatePosition();

       repaint();
           try
           {
               Thread.sleep(3);
           }
           catch (InterruptedException ex){System.out.println(ex.getCause());}

       }
    }

    double initAngularAcc = 0;
    double finalAngularAcc = 0;
    double initAngularVel = 0;
    double finalAngularVel = 0;

    public void updatePosition ()
    {

       finalAngularAcc = ((-g/(lineLength-BALLDIAMETER/2))*Math.sin((Math.PI*THETA)/180))*dt;
       finalAngularVel += finalAngularAcc*dt ;
       THETA += finalAngularVel*dt;
    }
}
