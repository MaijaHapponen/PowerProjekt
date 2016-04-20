package model;

import controller.Controller;

import javax.swing.*;

/**
 * Created by Lisa on 14/04/16.
 */
public class Main {
    public static void main(String[] args){
        Controller controller = new Controller();
        Player player = new Player();
        controller.addObserver(player);

        JFrame frame = new JFrame("Key Listener YOLO!");
        frame.setSize(300,150);
        JPanel panel = new JPanel();

        frame.add(panel);
        panel.addKeyListener(controller.listener);


        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.requestFocus();
        frame.setVisible(true);
    }
}
