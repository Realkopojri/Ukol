/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhistory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vondr
 */
public class MyHistory {

    ArrayList<String> list = new ArrayList<String>();

    public MyHistory(String fileName) {

    }

    public void read() throws IOException {
        // načte soubor fileName do paměti, skončí výjimkou pokud soubor nejde načíst
        Scanner s = new Scanner(new File("fileName"));
        while (s.hasNext()) {
            if (list.contains(s)) {
            } else {
                list.add(s.next());
            }
        }
        s.close();
    }

    public void save() throws IOException {
        // zapíše obsah paměti do souboru, skončí výjimkou pokud soubor nejde uložit
        // pokud soubor již existuje, přepíše jej
        String tmp = list.toString();
        PrintWriter pw = new PrintWriter(new FileOutputStream("fileName"));
        pw.write(tmp);
        pw.close();
    }

    public void addLine(String str) {
        // přidá řádek str do paměti pokud tam ještě není,
        // duplicitní řádky ignoruje.
        if (list.contains(str)) {
        } else {
            list.add(str);
        }
    }

    public String toString() {
        // vrátí řetězec obsahující všechny řádky
        return list.toString();
    }
}
