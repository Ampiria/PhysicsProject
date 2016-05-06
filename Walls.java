import sun.plugin2.util.ColorUtil;

import java.awt.*;

/**
 * Created by nigel on 5/5/2016.
 */
public class Walls {
    public static final int WALL
    _HEIGHT = 400;
    public static final int WALL_WIDTH = 80;
    private int xPosition, yPosition;
    private static final Color brown = new Color(108, 42, 1);
    private static final Color darkOrange = new Color(177, 82, 31);
    private static final Color lightBlue = new Color(98, 155, 159);
    private static final Color steel = new Color(166, 180, 181);
    private double Temperature;
    public Type materialType;


    enum Type{

        ALUMINUM ("Aluminum",0.22, Color.lightGray),
        COPPER ("Copper", 0.0932, darkOrange),
        GLASS ("Glass", 0.201, Color.cyan),
        ICE ("Ice", 0.5, lightBlue),
        IRON_STEEL("Iron/Steel", 0.11, steel),
        LEAD("Lead", 0.0311, Color.darkGray),
        WOOD("Wood", 0.401, brown);

        private String material;
        private double specificHeat;
        private Color materialColor;
        Type(String material, double specificHeat, Color materialColor){
            this.material = material;
            this.specificHeat = specificHeat;
            this.materialColor = materialColor;
        }
    }

    public Walls(int xPosition, int yPosition, Type materialType){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.materialType = materialType;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Type getMaterialType() {
        return materialType;
    }

    public void drawWalls(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect(xPosition,yPosition,WALL_WIDTH,WALL_HEIGHT);
        g.setColor(materialType.materialColor);
        g.fillRect(xPosition,yPosition,WALL_WIDTH,WALL_HEIGHT);
    }
}
