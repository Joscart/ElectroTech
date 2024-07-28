package vista;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

class BackgroundPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    public BackgroundPanel(String fileName) {
    	try {
        backgroundImage = new ImageIcon(fileName).getImage();
    } catch (Exception e) {
        e.printStackTrace();
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
