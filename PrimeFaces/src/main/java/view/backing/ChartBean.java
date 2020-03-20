/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author kuadam
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {

    private LineChartModel lineModel;

    /**
     * Creates a new instance of ChartView
     */
    public ChartBean() {
        createLineModel();
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("sin");

        for (int i = 0; i < 360; i++) {
            series1.set(i, Math.sin(Math.toRadians(i)));
        }

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("cos");

         for (int i = 0; i < 360; i++) {
            series2.set(i, Math.cos(Math.toRadians(i)));
        }
        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

    private void createLineModel() {
        lineModel = initLinearModel();
        lineModel.setTitle("Linear Chart");
        lineModel.setLegendPosition("e");
        lineModel.setZoom(true);
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(-5);
        yAxis.setMax(5);
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

}
