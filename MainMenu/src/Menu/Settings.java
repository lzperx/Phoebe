package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by andri_000 on 2015.02.25..
 */

public class Settings extends WindowHandler  {

    private String[] selectableResolutions = {"800x600", "1024x768", "1366x768", "1680x1050", "1920x1080"};
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int newResWidth;
    private int newResHeight;
    private int[] current_res = {200, 200};
    private int desiredResolutionID = 0;

    JFrame settingsFrame = new JFrame("Beállítások");
    JPanel settingsPanel = new JPanel();
    final JComboBox resolution = new JComboBox(selectableResolutions);
    JButton confirm = new JButton("Mentés");
    JButton back = new JButton("Vissza");


    public Settings() {

        settingsPanel.add(back);
        settingsPanel.add(confirm);
        settingsPanel.add(resolution);
        settingsFrame.add(settingsPanel);
        settingsDraw();

        resolution.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                desiredResolutionID = resolution.getSelectedIndex();
                if (desiredResolutionID == 0) {
                    newResWidth = 800;
                    newResHeight = 600;
                } else if (desiredResolutionID == 1) {
                    newResWidth = 1024;
                    newResHeight = 768;
                } else if (desiredResolutionID == 2) {
                    newResWidth = 1366;
                    newResHeight = 768;
                } else if (desiredResolutionID == 3) {
                    newResWidth = 1680;
                    newResHeight = 768;
                } else if (desiredResolutionID == 4) {
                    newResWidth = 1920;
                    newResHeight = 1080;
                }
            }
        });
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((dim.getWidth() < newResWidth) || (dim.getHeight() < newResHeight)) {
                    JOptionPane.showMessageDialog(null, "Az ön képernyője nem támogatja a választott felbontást", "Felbontás hiba!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    current_res[0] = newResWidth;
                    current_res[1] = newResHeight;
                    reDraw();
                }

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.setVisible(false);
            }
        });
    }

    public void settingsDraw() {
        settingsFrame.setVisible(true);
        settingsFrame.setSize(200, 200);
    }



    public void reDraw(){
        super.changeResolution(current_res);
    }

}



