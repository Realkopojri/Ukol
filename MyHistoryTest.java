/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhistory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author vondr
 */
public class MyHistoryTest {

    private MyHistory h;
    Path p;

    @Before
    public void prepare() throws IOException {
        p = Files.createTempFile(null, null);
        h = new MyHistory(p.toString());
    }

    @Test
    public void write0() {
        try {
            h.save();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void write1() {
        try {
            h.addLine("ahoj");
            h.save();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void write2() {
        try {
            h.addLine("ahoj");
            h.addLine("ahoj");
            h.addLine("ahoj");
            h.save();
        } catch (Exception e) {
            fail();
        }
    }

    @After
    public void reset() {
        File f = new File(p.toString());
        f.delete();
    }

}
