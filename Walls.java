import sun.plugin2.util.ColorUtil;

import java.awt.*;

/**
 * Created by nigel on 5/5/2016.
 */
public class Walls {
    public static final int WALL_HEIGHT = 400;
    public static final int WALL_WIDTH = 80;
    public static final int WALL_DEPTH = 4;
    private int xPosition, yPosition;
    private static final Color brown = new Color(108, 42, 1);
    private static final Color darkOrange = new Color(177, 82, 31);
    private static final Color lightBlue = new Color(98, 155, 159);
    private static final Color steel = new Color(166, 180, 181);
    private double Temperature;
    public Type materialType;


    enum Type{

        ALUMINUM ("Aluminum",0.22, Color.lightGray, 2700, 205),
        COPPER ("Copper", 0.0932, darkOrange, 8940,385 ),
        GLASS ("Glass", 0.201, Color.cyan, 5000, 0.8),
        ICE ("Ice", 0.5, lightBlue, 917, 1.6),
        IRON_STEEL("Iron/Steel", 0.11, steel, 7850, 50.2),
        LEAD("Lead", 0.0311, Color.darkGray, 11340, 34.7),
        WOOD("Wood", 0.401, brown, 510, 0.26);

        private String material;
        public double specificHeat, thermalConductivity;
        private Color materialColor;
        private int density;
        Type(String material, double specificHeat, Color materialColor, int density, double thermalConductivity){
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