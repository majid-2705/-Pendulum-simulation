import javax.swing.*;
import java.awt.*;

public class simulationFrame extends JFrame {
    pendulumSystem ps;
    simulationFrame(){


        this.setSize(600,500);
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(null);
        panelContainer.setSize(getSize());
        ps = new pendulumSystem(30,50, 150, getWidth(), getHeight());

        panelContainer.add(ps);
        this.add(panelContainer);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(ps).start();
        setVisible(true);
    }


}
