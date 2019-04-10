package sample.lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class FlowerAnimation extends JPanel implements ActionListener {

    private static int maxWidth;
    private static int maxHeight;

    private double flowerCenterPoints[][] = {
            {-50, -50},
            {50, -50},
            {70, 0},
            {0, 40},
            {-70, 0}
    };

    private int flowerPetalsPoints[][] = {
            {-70, 0},
            {-100, 100},
            {0, 40},
            {100, 100},
            {70, 0},
            {160, -50},
            {50, -50},
            {0, -150},
            {-50, -50},
            {-160, -50}
    };

    Timer timer;
    // Для анімації повороту
    private double angle = 0;

    // Для анімації руху
    private double[] currentPosition;
    private double squareWidth = 370;
    private double rotationSquareX0 = (maxWidth - squareWidth) / 2;
    private double rotationSquareY0 = (maxWidth - squareWidth) / 2;
    private double rotationSquareX1 = maxWidth - (maxWidth - squareWidth) / 2;
    private double rotationSquareY1 = maxHeight - (maxWidth - squareWidth) / 2;

    public FlowerAnimation() {
        timer = new Timer(10, this);
        timer.start();
        currentPosition = new double[]{
                rotationSquareX0,
                rotationSquareY0
        };
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering params
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        // Set background color
        g2d.setBackground(Color.RED);
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        // Draw the main Frame
        drawBorder(g2d);
        g2d.translate((double) maxWidth / 2 + currentPosition[0], (double) maxHeight / 2 + currentPosition[1]);
        g2d.rotate(angle);
        drawFlower(g2d);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new FlowerAnimation());

        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    private Point squareMovement(double px, double py, double sx0, double sy0, double sx1, double sy1) {
        Point resultMovement = new Point();
        if (px <= sx1 && px > sx0 && py == sy0) {
            resultMovement.setLocation(-1, 0);
        } else if (px == sx0 && py >= sy0 && py < sy1) {
            resultMovement.setLocation(0, 1);
        } else if (px >= sx0 && px < sx1 && py == sy1) {
            resultMovement.setLocation(1, 0);
        } else if (px == sx1 && py <= sy1 && py > sy0) {
            resultMovement.setLocation(0, -1);
        } else {
            resultMovement.setLocation(0, 0);
        }
        return resultMovement;
    }

    public void actionPerformed(ActionEvent e) {
        Point moveVector = squareMovement(currentPosition[0], currentPosition[1], rotationSquareX0, rotationSquareY0, rotationSquareX1, rotationSquareY1);

        currentPosition[0] = currentPosition[0] + moveVector.getX();
        currentPosition[1] = currentPosition[1] + moveVector.getY();

        angle += 0.01;

        repaint();
    }

    private void drawBorder(Graphics2D g2d) {
        BasicStroke basicStroke = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(basicStroke);
        g2d.drawRect(10, 10, maxWidth - 20, maxHeight - 20);
    }

    private void drawFlower(Graphics2D g2d) {
        //Draw Flower Petals
        g2d.setColor(Color.YELLOW);
        Polygon petals = new Polygon();
        for (int[] point : flowerPetalsPoints) {
            petals.addPoint(point[0], point[1]);
        }
        g2d.fillPolygon(petals);

        //Draw Flower Stalk
        BasicStroke stalk = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stalk);
        g2d.drawLine(0, 40, 0, 120);

        //Set flower center
        GeneralPath center = new GeneralPath();
        center.moveTo(flowerCenterPoints[0][0], flowerCenterPoints[0][1]);
        for (int k = 1; k < flowerCenterPoints.length; k++)
            center.lineTo(flowerCenterPoints[k][0], flowerCenterPoints[k][1]);
        center.closePath();

        //Draw flower center
        GradientPaint gp = new GradientPaint(
                5, 25,
                Color.BLUE,
                20, 2,
                Color.CYAN,
                true
        );
        g2d.setPaint(gp);
        g2d.fill(center);
    }

}