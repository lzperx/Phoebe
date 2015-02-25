package Menu;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by andri_000 on 2015.02.25..
 */
public class WindowHandler extends JFrame {

    int width = 800;
    int height = 600;

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
        mainFrame.setSize(width,height);
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
                Settings settingsMenu = new Settings();
                settingsMenu.settingsDraw();
                mainFrame.setVisible(false);

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

    private void menuLoader(){
        mainPanel.add(newGame);
        mainPanel.add(settings);
        mainPanel.add(highscore);
        mainPanel.add(exit);
    }

    public void changeResolution(int[] newRes){
        width = newRes[0];
        height = newRes[1];
        mainFrame.setSize(width,height);
    }


}
