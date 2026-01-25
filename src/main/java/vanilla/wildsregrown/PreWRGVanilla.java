package vanilla.wildsregrown;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class PreWRGVanilla implements PreLaunchEntrypoint {

    private static final URL splashURL = PreWRGVanilla.class.getResource("/assets/wrg_vanilla/icon.png");
    public static JFrame frame;

    public void onPreLaunch() {
        try {
            this.initSplashscreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initSplashscreen() throws IOException {
        frame = new JFrame("Minecraft");

        assert splashURL != null;
        BufferedImage image = ImageIO.read(splashURL);

        int w = image.getWidth()/2, h = image.getHeight()/2;

        ImageIcon icon = new ImageIcon(image.getScaledInstance(w, h, Image.SCALE_SMOOTH));

        Color t = new Color(0,0,0,0);
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setBackground(t);
        label.setSize(w, h);
        label.setIcon(icon);
        label.setOpaque(true);

        frame.getContentPane().setBackground(t);
        frame.setType(Window.Type.UTILITY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setUndecorated(true);
        frame.setBackground(t);
        frame.setContentPane(label);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

}