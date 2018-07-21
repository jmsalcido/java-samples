package org.otfusion.jfreechart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private final JfreeChartExample jfreeChartExample;

    public App(JfreeChartExample jfreeChartExample) {
        this.jfreeChartExample = jfreeChartExample;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            jfreeChartExample.drawChart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("DONE, check: " + JfreeChartExample.OUT_FILE_PNG);
    }
}
