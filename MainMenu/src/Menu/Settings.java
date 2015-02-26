package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by andri_000 on 2015.02.25..
 */

public class Settings /*extends WindowHandler*/  {

    private String[] selectableResolutions = {"800x600", "1024x768", "1366x768", "1680x1050", "1920x1080"};
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Dimension current_res = new Dimension(800,600);
    private Dimension desiredDimension = new Dimension(800,600);
    private int desiredResolutionID = 0;
    private WindowHandler caller;

    JFrame settingsFrame = new JFrame("Beállítások");
    JPanel settingsPanel = new JPanel();
    final JComboBox resolution = new JComboBox(selectableResolutions);
    JButton confirm = new JButton("Mentés");
    JButton back = new JButton("Vissza");


    public Settings(WindowHandler caller) {
        this.caller = caller;
        current_res = caller.getDimension();
        settingsPanel.add(back);
        settingsPanel.add(confirm);
        settingsPanel.add(resolution);
        settingsFrame.add(settingsPanel);
        settingsDraw();

        resolution.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                desiredResolutionID = resolution.getSelectedIndex();
                switch (desiredResolutionID) {
                    case 0:
                        desiredDimension.setSize(800, 600);
                        break;
                    case 1:
                        desiredDimension.setSize(1024, 768);
                        break;
                    case 2:
                        desiredDimension.setSize(1366, 768);
                        break;
                    case 3:
                        desiredDimension.setSize(1680, 1050);
                        break;
                    case 4:
                        desiredDimension.setSize(1920, 1080);
                        break;
                }
            }
        });
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dim.getWidth() < desiredDimension.getWidth() || dim.getHeight() < desiredDimension.getHeight()) {
                    JOptionPane.showMessageDialog(null, "Az ön képernyője nem támogatja a választott felbontást", "Felbontás hiba!", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    reDraw();
                    settingsFrame.dispose();
                }

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.dispose();
                reDraw();
            }
        });
    }

    public void settingsDraw() {
        settingsFrame.setVisible(true);
        settingsFrame.setSize((int)current_res.getWidth(),(int)current_res.getHeight());
    }



    public void reDraw(){
        caller.changeResolution(this.desiredDimension);
    }

}



