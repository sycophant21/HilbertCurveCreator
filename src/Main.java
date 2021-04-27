import javax.swing.*;
import javax.vecmath.Vector2d;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int order = new Scanner(System.in).nextInt();
        int numberOfBlocks = (int) Math.pow(2, order);
        int totalIndices = numberOfBlocks * numberOfBlocks;
        Vector2d[] firstOrderCurve = new Vector2d[4];
        firstOrderCurve[0] = new Vector2d(0,0);
        firstOrderCurve[1] = new Vector2d(0,1);
        firstOrderCurve[2] = new Vector2d(1,1);
        firstOrderCurve[3] = new Vector2d(1,0);
                //{{0, 0}, {0, 1}, {1, 1}, {1, 0}}
        Panel panel = new Panel(firstOrderCurve);
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Hilbert");
        jFrame.add(panel);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //jFrame.setSize(770, 795);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        HilbertCreator hilbertCreator = new HilbertCreator(panel, new Vector2d[] {new Vector2d(0,0), new Vector2d(0,1), new Vector2d(1,1), new Vector2d(1,0)}, order, numberOfBlocks, totalIndices);
        hilbertCreator.createCurve();
        //panel.repaint();
    }
}
