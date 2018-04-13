package maru.recordfps;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class OLineChart extends JFrame {

    DefaultCategoryDataset data = new DefaultCategoryDataset();

    public OLineChart(){
        JFreeChart chart = ChartFactory.createLineChart("FPS",
                "Seconds[s]",
                "Framerate[FPS]",
                data,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);

        ChartPanel cpanel = new ChartPanel(chart);
        getContentPane().add(cpanel, BorderLayout.CENTER);
    }
}
