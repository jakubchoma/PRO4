package cz.spsmb.ctvrtak.c_spring.o_groovy_test.main;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class MainTest {
    public static final String FILENAME_CODE_PATH = System.getenv("HOMEDRIVE")+System.getenv("HOMEPATH")+"\\groovytest.groovy";
    public static final    String initGroovyCode =
        "import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.Testable;\n" +
        "class GroovyScriptTest implements Testable {\n" +
        "    String check(String in) {\n" +
        "        ArrayList<String> al =  new ArrayList()\n" +
        "        String[] arr=in.split(\" \")\n" +
        "\n" +
        "\n" +
        "//      zde doplňte kód\n " +
        "\n" +
        "\n" +
        "        return al.join(\" \")\n" +
        "    }\n" +
        "}\n";
    public static void createGroovyTemplateFile(String code) throws IOException {
        FileUtils.writeStringToFile(new File(MainTest.FILENAME_CODE_PATH), code, Charset.forName("UTF-8").toString());
    }

    private String entry;
    private String in;
    private String out;
    private Testable test;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public void setTest(Testable test) {
        this.test = test;
    }
    public String check(){
        return test.check(this.in);
        //System.out.println();
    }

    public boolean isValid() {
        String tmp = test.check(this.in);
        System.out.println(tmp);
        return out.equals(tmp);
    }

}
