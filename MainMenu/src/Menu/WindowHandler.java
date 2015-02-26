package Menu;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by andri_000 on 2015.02.25..
 */
public class WindowHandler extends JFrame {

    Dimension dim = new Dimension(800,600);

    ImageIcon top;
    ImageIcon secondFromTop;
    ImageIcon thirdFromTop;
    ImageIcon fourthFromTop;

    private JFrame mainFrame = null;
    private JPanel mainPanel = null;


    private JButton newGame;
    private JButton settings;
    private JButton highscore;
    private JButton exit;

    public WindowHandler(){
        setPanel();
        setFrame();
        setMenuItems();
        menuLoader();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void setFrame(){
        mainFrame = new JFrame("Phoebe Project");
        mainFrame.setSize((int)dim.getWidth(),(int)dim.getHeight());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (mainPanel != null){
            mainFrame.add(mainPanel);
        }
    }

    private void setPanel(){
        mainPanel = new JPanel();
    }

    private void setMenuItems(){
        newGame = new JButton("Új játék");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Új játékot kezdtél");
            }
        });

        settings = new JButton("Beállítások");
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeSettings();

            }
        });



        highscore = new JButton("Eredménytábla");
        highscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Highscore lesz");
                //loadHighscore();
            }
        });

        exit = new JButton("Kilépés");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void reconstructor(){
        mainFrame.setSize(dim);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void menuLoader(){
        mainPanel.add(newGame);
        mainPanel.add(settings);
        mainPanel.add(highscore);
        mainPanel.add(exit);
    }

    public void changeResolution(Dimension newRes){
        dim = newRes;
        reconstructor();
    }

    public void makeSettings(){
        Settings settingsMenu = new Settings(this);
        settingsMenu.settingsDraw();
        mainFrame.setVisible(false);
    }

    public Dimension getDimension(){
        return dim;
    }
}
