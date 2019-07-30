package ar.com.maxo.readTextFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp{


    Red red;

    public static void main(String args[]) {

    }


    private List<Red> streamReadFile(){

        String filePath = "D://Maxo//repos-git//github-programacionJava//streamsReadTextFile//src//test//resources//";
        String fileName = "wlan-scan-result.txt";
        String fullPath = filePath + fileName;
        List<String> list = new ArrayList<>();
        List<Red> redes = new ArrayList<>();

        try ( BufferedReader br = Files.newBufferedReader( Paths.get( fullPath ) ) ) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());
            Red wifiFounded = null;
            for( String line : list ) {
                if( line.contains("Cell") ){
                    int indexOfCellStr=line.indexOf("Cell");
                    int endOfCellStr="Cell ".length();
                    int indexOfAddresStr=line.indexOf("Address:");
                    int endOfAddresStr="Address: ".length();
                    String wifiNumber = line.substring(indexOfCellStr+endOfCellStr, indexOfAddresStr);
                    String wifiAddrs = line.substring(indexOfAddresStr+endOfAddresStr);
                    if( wifiNumber != null && wifiAddrs != null ){
                        wifiFounded = new Red();
                        wifiFounded.setCell(wifiNumber);
                        wifiFounded.setAddr(wifiAddrs);
                    }
                } else if( wifiFounded != null && line.contains("Frequency") ) {
                    wifiFounded.setFreq( line.contains("2.4") ? 0 : (line.contains("5.0") ? 1 : 2 ) );
                } else if( wifiFounded != null && line.contains("ESSID") ) {
                    int indexOfESSIDStr=line.indexOf("ESSID");
                    int endOfESSIDStr = "ESSID:".length();
                    wifiFounded.setESSID( line.substring(indexOfESSIDStr+endOfESSIDStr) );
                } else if( wifiFounded != null && line.contains("IE: WPA Version 1") ){
                    wifiFounded.setSecured(true);
                    redes.add(wifiFounded);
                    wifiFounded = null;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Redes...");
        redes.stream().forEach(System.out::println);
        return redes;
    }

    private static class Red{
        private String cell;
        private String addr;
        private String ESSID;
        private boolean isSecured;
        private int freq;
        public static final int GHz_2_4 = 0;
        public static final int GHz_5 = 1;

        public Red(){}

        public Red(String cell, String addr, String ESSID){
            setCell(cell);
            setAddr(addr);
            setESSID(ESSID);
        }
        public String getFreq() {
            return (freq == GHz_2_4) ? "2.4Ghz" : ( freq == GHz_5 ? "5Ghz" : "NO_VALUE" );
        }
        public String getAddr() {
            return addr;
        }
        public String getCell(){
            return cell;
        }
        public String getESSID(){
            return ESSID;
        }
        public boolean isSecured() {
            return isSecured;
        }
        public void setAddr(String addr) {
            this.addr = addr;
        }
        public void setCell(String cell) {
            this.cell = cell;
        }
        public void setESSID(String ESSID) {
            this.ESSID = ESSID;
        }
        public void setFreq(int freq) {
            this.freq = freq;
        }
        public void setSecured(boolean secured) {
            isSecured = secured;
        }

        @Override
        public String toString() {
            return "Red [ ESSID: " + getESSID() + ", Addres: " + getAddr()
                    + ", Freq: " + getFreq() + ", Secured: " + isSecured()
                    + " ]\n";
        }
    }

    private static Predicate<String> filterFile(String line){

        return null;
    }

    Predicate<String> Cell = (line) -> line.contains("Cell");
    Predicate<Integer> greaterThanTen = (i) -> i > 10;

    // Creating predicate
    Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
    boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        //System.out.println(result);

    // Calling Predicate method
    boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        //System.out.println(result2);

}