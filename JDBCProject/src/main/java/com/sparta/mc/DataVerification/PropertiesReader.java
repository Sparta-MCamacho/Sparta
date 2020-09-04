package com.sparta.mc.DataVerification;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PropertiesReader {

    //Data expected from properties file
    String csvFilePath;
    String databaseAddress;
    String username;
    String password;
    BufferedReader bufferedReader;

    //Constructor which reads the data from the file and closes the reader object once done
    public PropertiesReader() throws IOException, ArrayIndexOutOfBoundsException {

        bufferedReader = new BufferedReader(new FileReader("src/main/resources/Properties"));

        csvFilePath = bufferedReader.readLine().split("=")[1].replace(" ","");
        databaseAddress = bufferedReader.readLine().split("=")[1].replace(" ","");
        username = bufferedReader.readLine().split("=")[1].replace(" ","");
        password = bufferedReader.readLine().split("=")[1].replace(" ","");
        bufferedReader.close();

    }

    //Getter and setter methods:

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public String getDatabaseAddress() {
        return databaseAddress;
    }

    public void setDatabaseAddress(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
}
