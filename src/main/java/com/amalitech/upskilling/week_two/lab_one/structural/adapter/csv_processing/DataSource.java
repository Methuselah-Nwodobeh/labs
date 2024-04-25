package com.amalitech.upskilling.week_two.lab_one.structural.adapter.csv_processing;

import java.io.IOException;
import java.util.List;

public interface DataSource {

    List<String[]> readData() throws IOException;

    void writeData(String data) throws IOException;


}
