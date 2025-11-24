import javax.swing.*;
import java.awt.*;

public class HeurFormat extends Horloge  {

    public HeurFormat(String titre){
        Timer timer = new Timer(1000,e->repaint());
        timer.start();
        this.setTitle(titre);
        this.setSize(500,600);

    }
    public void paint(Graphics g) {
        int b = 10;

        g.setColor(new Color(187, 210, 225));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        g.drawString(getHour()+":"+getMinute()+":"+getSeconde(),20,40);

        ((Graphics2D) g).setStroke(new BasicStroke(4.0f));
        g.drawOval(b, b, this.getWidth() - 2 * b, this.getHeight() - 2 * b);

        int x = this.getWidth() / 2,
                y = this.getHeight() / 2,
                r = (this.getWidth() - 2 * b) / 2;

        for (int i = 0; i < 12; i++) {
            double a = i * Math.PI * 2 / 12;
            g.drawLine(
                    (int) (x + 0.95 * r * Math.sin(a)),
                    (int) (y - 0.95 * r * Math.cos(a)),
                    (int) (x + 1.05 * r * Math.sin(a)),
                    (int) (y - 1.05 * r * Math.cos(a))
            );
        }
        double ah = Math.PI * 2 * (getHour() % 12) / 12;
        double am = Math.PI * 2 * getMinute() / 60;
        double as = Math.PI * 2 * getSeconde() / 60;

        ((Graphics2D) g).setStroke(new BasicStroke(5.0f));
        g.drawLine(
                x, y,
                (int) (x + 0.7 * r * Math.sin(ah)),
                (int) (y - 0.7 * r * Math.cos(ah))
        );

        ((Graphics2D) g).setStroke(new BasicStroke(3.0f));
        g.setColor(new Color(120, 120, 120));
        g.drawLine(
                x, y,
                (int) (x + 0.85 * r * Math.sin(am)),
                (int) (y - 0.85 * r * Math.cos(am))
        );

        ((Graphics2D) g).setStroke(new BasicStroke(1.0f));
        g.drawLine(
                x, y,
                (int) (x + r * Math.sin(as)),
                (int) (y - r * Math.cos(as))
        );
    }


}
