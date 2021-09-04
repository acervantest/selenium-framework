package com.act.framework.utilities;

import com.act.framework.config.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileName = date.format(formatter);

    private BufferedWriter bufferedWriter = null;

    // CREATE LOG FILE
    public void createLogFile() throws IOException {
        try {
            // CREATE DIRECTORY
            File dir = new File(System.getProperty("user.dir") + Settings.logPath);
            if(!dir.exists()) dir.mkdir();

            // CREATE FILE
            File logFile = new File(dir + "/" + fileName + ".log");
            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

        } catch (Exception e){

        }
    }

    // WRITE MESSAGE WITHIN LOG
    public void write(String message){
        try {

            formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy:HH:MM:SS");
            String dateFormat = date.format(formatter);

            bufferedWriter.write("[ " + dateFormat + " ] " +message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch(Exception e) {

        }
    }
}
