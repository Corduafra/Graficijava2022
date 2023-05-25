package it.fra;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*
        uso jfreechart per rappresentare graficamente de dati
        i passi da fare indipendentemente dal grafico sono sempre:
        1)creare un insime (dataset) di dati da rappresentare (esempio incassi)
        2) creare un oggetto di tipo JfreeChart
        3) rappresentare i dati
         */

              //esempio grafico a torta usando un DefaultPieDataset

        // creo un oggetto DefaultPieDataset
        DefaultPieDataset graficotorta=new DefaultPieDataset();

        // imposto i valori per i diversi elementi del dataset
        //imposto i tre valori
        graficotorta.setValue("a",50);
        graficotorta.setValue("B",75);
        graficotorta.setValue("C",90);

        //creo il grafico
        /*
        per creare i grafici si deve usare la classe JFreeChart richiamando il metodo create
         */
        JFreeChart grafico= ChartFactory.createPieChart("prezzo computer",
                graficotorta // dataset contenente i dati
                ,true, //mostra la legenda
               true, // mostra il toolips
                false ); // se dobbiamo generare un url del grafico

        // Rappresentare i dati nel grafico
        try {
            ChartUtilities.saveChartAsJPEG(new File("vendite.jpg"),grafico,500,300);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // CREAO UN GRAFICO A BARRE
        // ESEMPIO: goal realizzati da 4 giocatori
        //1) creare un dataset per il grafio a barre

        DefaultCategoryDataset datasetbarre=new DefaultCategoryDataset();

        // carico i dati nel dataset (contenitore dei dati)
        datasetbarre.setValue(10,"goal","giocaroteA");
        datasetbarre.setValue(7,"goal","giocaroteB");
        datasetbarre.setValue(18,"goal","giocarotec");

        //creo il grafico a barre utilizzando il metodo statico
        JFreeChart graficobarre=ChartFactory.createBarChart(
                "comparazione goal 2022",
                "calciatori",
                "goal realizzato",
                datasetbarre, //dataset con i dati
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        try {
            ChartUtilities.saveChartAsJPEG(new File("reti2022.jpg"),graficobarre,500,500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // app
        // react molto più performati di angular
        // libreria  esterna angular si adatta sia a android che ios
        //                   ionic molto grafica ma poca logica
        //                    javascipt


        //GRAFICO LINEARE xy chart
        XYSeries series= new XYSeries("grafico X e Y");

        //creare i punti x e y
        series.add(1,-5);
        series.add(1,3);
        series.add(4,10);

        //aggiungo i punti al dataset
        XYSeriesCollection datasetxy= new XYSeriesCollection();
        datasetxy.addSeries(series); // aggiungo la serie al dataset

        // generare il grafico
        JFreeChart graficoXY= ChartFactory.createXYLineChart(
                "Grafico X Y",
                "Etichetta x",
                "etichetta y",
                datasetxy
        );

        try {
            ChartUtilities.saveChartAsJPEG(new File("graficoXY.jpg"),graficoXY,500,500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}