package view;
/*
import javax.swing.*;
import java.awt.*;
import java.io.File;

import controller.Controller;
import model.Player;
import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;
import tiled.view.MapRenderer;
import tiled.view.OrthogonalRenderer;

/**
 * Created by andrea on 2016-04-18.
 */
/*
public class WorldViewer{
    public static void main(String[] arguments) throws Exception{
        Controller controller = new Controller();
        Player player = new Player();
        controller.addObserver(player);

        File tmxFile = new File("core/assets/maps/hubbeneditsand.tmx");
        TMXMapReader mapReader = new TMXMapReader();
        Map world = mapReader.readMap(String.valueOf(tmxFile));

        JScrollPane panel = new JScrollPane(new WorldView(world, player));
        panel.setBorder(null);
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JFrame frame = new JFrame("C.R.A.P - the Game");
        frame.addKeyListener(controller.listener);
        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.requestFocus();
        frame.setVisible(true);
    }
}

class WorldView extends JPanel{
    private Map world;
    private Player player;
    private MapRenderer renderer;

    public WorldView(Map world, Player player){
        this.world = world;
        this.player = player;
        this.renderer = createRenderer(world);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        for(MapLayer layer: world){
            if(layer instanceof TileLayer){
                renderer.paintTileLayer(g2d, (TileLayer) layer);
            }
        }
    }

    private static MapRenderer createRenderer(Map world){
        return new OrthogonalRenderer(world);
    }
}
*/