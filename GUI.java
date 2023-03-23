import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {

    public GUI() throws InterruptedException {

        JFrame frame = new JFrame();
        Box vb = Box.createVerticalBox();

        /*Init here for the constructor of the JLabel
        */
        Instant now = Instant.now();

        DateTimeFormatter weekDayFormat = DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("e").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
        DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("LLLL").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("y").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());

        JLabel text = new JLabel("Today is :");
        JLabel dayInfo = new JLabel("");
        JLabel timeInfo = new JLabel("");

        /*Space between elements
        */
        JLabel empty = new JLabel(" ");
        empty.setFont(new Font(empty.getFont().getName(), empty.getFont().getStyle(), 100));
        JLabel emptyBis = new JLabel(" ");
        emptyBis.setFont(new Font(emptyBis.getFont().getName(), emptyBis.getFont().getStyle(), 20));


        text.setFont(new Font(timeInfo.getFont().getName(), timeInfo.getFont().getStyle(), 30));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);

        dayInfo.setFont(new Font(dayInfo.getFont().getName(), dayInfo.getFont().getStyle(), 40));
        dayInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        timeInfo.setFont(new Font(timeInfo.getFont().getName(), timeInfo.getFont().getStyle(), 40));
        timeInfo.setAlignmentX(Component.CENTER_ALIGNMENT);


        vb.add(empty);
        vb.add(text);
        vb.add(emptyBis);
        vb.add(dayInfo);
        vb.add(emptyBis);
        vb.add(timeInfo);

        frame.add(vb, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("When am I right now ???");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setResizable(false);

        while(true) {
            //Delay
            TimeUnit.SECONDS.sleep(1);

            //Update
            now = Instant.now();
            dayInfo.setText(weekDayFormat.format(now) + " " + monthFormat.format(now) + " " + dayFormat.format(now) + ", " + yearFormat.format(now));
            timeInfo.setText(timeFormat.format(now));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new GUI();
    }
}
