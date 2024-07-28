package vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class RoundedButton extends JButton {

    private static final long serialVersionUID = 1L;

    public RoundedButton(String text) {
        super(text);
        setOpaque(false); // Para hacer que el fondo sea transparente
        setContentAreaFilled(false); // Para que el área de contenido no se pinte
        setFocusPainted(false); // Para que no se pinte el borde del foco
        //setBorderPainted(false); // Para que no se pinte el borde
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50));

        // Obtener las dimensiones del texto
        String text = getText();
        int textWidth = g2.getFontMetrics().stringWidth(text);
        int textHeight = g2.getFontMetrics().getAscent();

        // Calcular las coordenadas para centrar el texto
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - g2.getFontMetrics().getDescent();

        // Dibujar el texto centrado
        g2.setColor(getForeground());
        g2.drawString(text, x, y);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No es necesario pintar el borde si setBorderPainted(false) se ha establecido.
    }
}
