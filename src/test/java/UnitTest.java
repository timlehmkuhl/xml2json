import JSON.JSON2XML_ST;
import XML.GenerateJson;
import org.junit.Test;
import org.stringtemplate.v4.ST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void test() throws Exception {
        ST json2xml = JSON2XML_ST.run("./src/main/resources/example.json");
        ST xml2json = GenerateJson.run("", json2xml.render(), false);
        System.out.println(json2xml.render());
        System.out.println();
        System.out.println(xml2json.render());
        assertEquals(fileToStr("./src/main/resources/example.json"), xml2json.render());
    }

    @Test
    public void test2() throws Exception {
        ST json2xml = JSON2XML_ST.run("./src/main/resources/example2.json");
        ST xml2json = GenerateJson.run("", json2xml.render(), false);
        System.out.println(json2xml.render());
        System.out.println();
        System.out.println(xml2json.render());
        assertEquals(fileToStr("./src/main/resources/example2.json"), xml2json.render());
    }

    public static String fileToStr(String ort) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(ort));
        return new String(encoded, Charset.defaultCharset());
    }

}
