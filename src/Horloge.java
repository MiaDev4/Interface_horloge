import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Horloge extends JFrame {
    private ArrayList<HourDisplay> dis;
    private  Box b;
    public Horloge(){
        this.dis=new ArrayList<HourDisplay>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.b = new Box(BoxLayout.Y_AXIS);
        this.add(this.b);
    }

    //renvoi l'heure courante
    public static int getHour(){
        return LocalDateTime.now().getHour();
    }
    //renvoi la minute courante
    public static int getMinute(){
        return LocalDateTime.now().getMinute();
    }
    //renvoie la seconde coorante
    public static int getSeconde(){
        return LocalDateTime.now().getSecond();
    }
    public void addHourDisplay(HourDisplay hd){
        this.b.add(hd.getComponent());
        this.dis.add(hd);
        this.pack();
        this.repaint();
    }
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                for (HourDisplay hd:this.dis)
                    hd.oneSecondMore();
            }
        }
    }
}
