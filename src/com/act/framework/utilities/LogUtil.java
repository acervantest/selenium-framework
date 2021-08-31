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

    //Create log file
    public void createLogFile() throws IOException {
        try {
            //create directory
            //File dir = new File(System.getProperty("user.dir") + File.separator + "logs" + File.separator);
            File dir = new File(System.getProperty("user.dir") + Settings.logPath);
            if(!dir.exists()) dir.mkdir();

            //create file
            File logFile = new File(dir + "/" + fileName + ".log");
            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

        } catch (Exception e){

        }
    }

    //write message within the log
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
