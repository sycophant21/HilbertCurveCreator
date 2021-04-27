import javax.swing.*;
import javax.vecmath.Vector2d;
import java.awt.*;

public class Panel extends JPanel {
    private Vector2d[] vector2ds;
    private boolean isCompleted = false;

    public Panel(Vector2d[] vector2ds) {
        this.vector2ds = vector2ds;
    }

    public void setVector2ds(Vector2d[] vector2ds) {
        this.vector2ds = vector2ds;
    }

    @Override
    protected void paintComponent(Graphics g) {
        isCompleted = false;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1440, 770);
        g.setColor(Color.WHITE);
        for (int i = 1; i < vector2ds.length; i++) {
            g.drawLine((int) vector2ds[i - 1].x, (int) vector2ds[i - 1].y, (int) vector2ds[i].x, (int) vector2ds[i].y);
        }
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
