import java.util.TimerTask;

public class updateStuff extends TimerTask {
    public void run() {
        MainScreen.insideTemperature = MainScreen.sidePanel.insidetempslide.getValue()-(MainScreen.wall1.materialType.thermalConductivity*MainScreen.sidePanel.outsidetempslide.getValue()-MainScreen.wall1.materialType.thermalConductivity*MainScreen.sidePanel.insidetempslide.getValue())/MainScreen.wall2.materialType.thermalConductivity;
        OutputPanel.intemp.setText(Double.toString(MainScreen.insideTemperature));

        OutputPanel.heatratelabel.setText(Double.toString(MainScreen.rateOfHeatTransfer()));

        OutputPanel.totalheatlabel.setText(Double.toString(MainScreen.totalHeatTransfered()));

        OutputPanel.netheatlabel.setText(Double.toString(MainScreen.netHeatTransfered()));
    }
}
