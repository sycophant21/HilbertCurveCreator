import javax.vecmath.Vector2d;

public class HilbertCreator {
    private final Panel panel;
    private final Vector2d[] firstOrderCurve;
    private final int order;
    private final int numberOfBlocks;
    private final int totalIndices;

    public HilbertCreator(Panel panel, Vector2d[] firstOrderCurve, int order, int numberOfBlocks, int totalIndices) {
        this.panel = panel;
        this.firstOrderCurve = firstOrderCurve;
        this.order = order;
        this.numberOfBlocks = numberOfBlocks;
        this.totalIndices = totalIndices;
    }

    public void createCurve() throws InterruptedException {
        Vector2d[] vector2ds = new Vector2d[totalIndices];
        double length = 770.0 / numberOfBlocks;
        for (int i = 0 ; i < totalIndices ; i++) {
            vector2ds[i] = hilbert(i);
            vector2ds[i].setX(vector2ds[i].x * length);
            vector2ds[i].setY(vector2ds[i].y * length);
            vector2ds[i].add(new Vector2d(length/2, length/2));
/*            while (!panel.isCompleted()) {
                if (panel.isCompleted()) {
                    break;
                }
            }*/
        }
        Vector2d[] vector2ds1 = new Vector2d[vector2ds.length];
        System.arraycopy(vector2ds, 0, vector2ds1, 0, vector2ds.length);
        panel.setVector2ds(vector2ds1);
        panel.repaint();
    }
    private Vector2d hilbert(int i) {
        int index = i & 3;
        Vector2d vector2d = new Vector2d(firstOrderCurve[index].x, firstOrderCurve[index].y);
        for (int j = 1 ; j < order ; j++) {
            i = i >>> 2;
            index = i & 3;
            vector2d = something(index, vector2d, Math.pow(2,j));
        }
        return vector2d;
    }

    private Vector2d something(int index, Vector2d source, double length) {
        Vector2d temp = new Vector2d(source.x, source.y);
        if (index == 0) {
            double tempo = temp.x;
            temp.setX(temp.y);
            temp.setY(tempo);
        }
        else if (index == 1) {
            temp.y+=length;
        }
        else if (index == 2) {
            temp.x+=length;
            temp.y+=length;
        }
        else if (index == 3) {
            double tempo = length - 1 - temp.x;
            temp.x = length - 1 - temp.y;
            temp.y = tempo;
            temp.x+=length;
        }
        return temp;
    }
}
