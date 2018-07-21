package org.otfusion.jfreechart;

import com.google.common.io.Resources;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.TickType;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// TODO test this somehow?.
@Component
class JfreeChartExample {

    private static final Color TRANSPARENT = new Color(0f, 0f, 0f, 0f);
    public static final String OUT_FILE_PNG = "./out/file.png";

    void drawChart() throws Exception {
        JFreeChart xyLineChart = ChartFactory.createXYLineChart("", "", "",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, false, false);

        BufferedImage image = ImageIO.read(Resources.getResource("thisone.png"));
//        xyLineChart.setBackgroundImage(image);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(2f));
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesItemLabelsVisible(0, false);
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(Resources.getResource("fonts/Roboto-Medium.ttf").getFile()));
        Font font1 = Font.createFont(Font.TRUETYPE_FONT, new File(Resources.getResource("fonts/Roboto-Regular.ttf").getFile()));
        font = font.deriveFont(10f);

        XYPlot xyPlot = xyLineChart.getXYPlot();
        xyPlot.setBackgroundImage(image);
        xyPlot.setBackgroundPaint(TRANSPARENT);
        xyPlot.setRenderer(renderer);

        NumberAxis labelsInY = new NumberAxis(xyPlot.getRangeAxis().getLabel()) {
            @Override
            public java.util.List refreshTicks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) {
                java.util.List allTicks = super.refreshTicks(g2, state, dataArea, edge);
                java.util.List myTicks = new ArrayList();

                for (Object tick : allTicks) {
                    NumberTick numberTick = (NumberTick) tick;

                    double value = numberTick.getValue();

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            (value == 0.0 || value > 4.0)) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value == 0.5) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "OFF",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value == 1.5) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "ON",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value == 2.5) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "PEPE",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value == 3.5) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "POO",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    myTicks.add(new NumberTick(TickType.MINOR, value, "",
                            numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                            numberTick.getAngle()));
                }

                return myTicks;
            }

            @Override
            protected void drawAxisLine(Graphics2D g2, double cursor, Rectangle2D dataArea, RectangleEdge edge) {
                // NOTHING
            }
        };

        NumberAxis labelsInX = new NumberAxis(xyPlot.getDomainAxis().getLabel()) {

            @SuppressWarnings("unchecked")
            @Override
            public java.util.List refreshTicks(Graphics2D g2, AxisState state,
                                               Rectangle2D dataArea, RectangleEdge edge) {

                java.util.List allTicks = super.refreshTicks(g2, state, dataArea, edge);
                List myTicks = new ArrayList();

                for (Object tick : allTicks) {
                    NumberTick numberTick = (NumberTick) tick;

                    double value = numberTick.getValue();

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            (value == 0 || value == 24)) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "Mid",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value == 12) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "Noon",
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value > 12) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "" + (int) (value - 12),
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    if (TickType.MAJOR.equals(numberTick.getTickType()) &&
                            value < 12) {
                        myTicks.add(new NumberTick(TickType.MINOR, value, "" + (int) (value),
                                numberTick.getTextAnchor(), numberTick.getRotationAnchor(),
                                numberTick.getAngle()));
                        continue;
                    }

                    myTicks.add(numberTick);
                }

                return myTicks;
            }

            @Override
            protected void drawAxisLine(Graphics2D g2, double cursor, Rectangle2D dataArea, RectangleEdge edge) {
                // NOTHING
            }
        };

        SymbolAxis xAxis = new SymbolAxis("Hours",
                new String[]{"MID", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "Noon", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "Mid"});

        SymbolAxis yAxis = new SymbolAxis("Status",
                new String[]{"", "OFF", "OK", "OK2", "OK3"});

        xyPlot.setDomainAxis(labelsInX);
        xyPlot.getDomainAxis().setLowerBound(0d);
        xyPlot.getDomainAxis().setUpperBound(24d);
        xyPlot.getDomainAxis().setTickLabelFont(font);

        xyPlot.setRangeAxis(labelsInY);
        xyPlot.getRangeAxis().setLowerBound(0d);
        xyPlot.getRangeAxis().setUpperBound(4d);
        xyPlot.getRangeAxis().setTickLabelFont(font1.deriveFont(15f));

        Files.createDirectory(Paths.get("out/"));
        ChartUtilities.saveChartAsPNG(new File(OUT_FILE_PNG), xyLineChart, 720, 250);
    }

    private XYDataset createDataset() {
        XYSeries serie = new XYSeries("line");
        serie.add(0d, 3.5d);
        serie.add(10d, 3.5d);
        serie.add(10d, 2.5d);
        serie.add(11.5d, 2.5d);
        serie.add(11.5d, 1.5d);
        serie.add(12d, 1.5d);
        serie.add(12d, 2.5d);
        serie.add(24d, 2.5d);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serie);

        return dataset;
    }

}
