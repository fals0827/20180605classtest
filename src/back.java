import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class back extends JFrame{
    private Container cp ;
    private ImageIcon iconShip = new ImageIcon("shipl.png");
    private ImageIcon iconShipr = new ImageIcon("shipr.png");
    private ImageIcon iconBoom = new ImageIcon("12.png");
    private ImageIcon iconBoomr = new ImageIcon("12r.png");
    private JPanel jpn = new JPanel();
    private JLabel jlbShip = new JLabel();
    private JLabel jlbBoom = new JLabel();
    private Timer t1 ;

    public back () {
        this.init();
    }

    private void init () {
        this.cp = this.getContentPane();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(50,50,960,720);
        cp.add(jpn);
        jpn.setLayout(null);
        jpn.add(jlbShip);
        jpn.add(jlbBoom);

        Image img = iconShip.getImage();
        Image img2 = img.getScaledInstance(120,100,Image.SCALE_SMOOTH);
        iconShip.setImage(img2);

        Image img3 = iconShipr.getImage();
        Image img4 = img3.getScaledInstance(120,100,Image.SCALE_SMOOTH);
        iconShipr.setImage(img4);

        Image img5 = iconBoom.getImage();
        Image img6= img5.getScaledInstance(80,40,Image.SCALE_SMOOTH);
        iconBoom.setImage(img6);

        Image img7 = iconShip.getImage();
        Image img8 = img7.getScaledInstance(80,40,Image.SCALE_SMOOTH);
        iconBoomr.setImage(img8);

        jlbShip.setBounds(540,560,120,100);
        jlbShip.setIcon(iconShip);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                switch (keyEvent.getKeyCode()){
                    case 37 :
                        jlbShip.setIcon(iconShip);
                        jlbShip.setLocation(jlbShip.getX() - 2 , jlbShip.getY());
                        break;
                    case 39 :
                        jlbShip.setIcon(iconShipr);
                        jlbShip.setLocation(jlbShip.getX() + 2 , jlbShip.getY());
                        break;
                    case 32 :
                        jpn.add(jlbBoom);
                        jlbBoom.setBounds(jlbShip.getX() + 10 , jlbShip.getY() , 80 , 40);
                        jlbBoom.setIcon(iconBoom);
                        t1.start();
                        break;
                }
            }
        });

        t1 = new Timer(5, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jlbBoom.getY() <= -20){
                    jpn.remove(jlbBoom);
                    repaint();
                    t1.stop();
                }else {
                    jlbBoom.setLocation(jlbBoom.getX() , jlbBoom.getY() - 2);
                }
            }
        });
    }
}
