package cz.spsmb.ctvrtak.d_maturitni_okruhy.n_prace_se_soubory.io;

import java.io.*;
import java.util.Scanner;

/**
 * Java IO bylo kompletně rozebráno ve 3. ročníku. Pracuje se zde s proudy znaků nebo bytů.
 *
 */
public class AUvod {
    public static void main(String[] args) throws IOException {
        String fileName = "a.txt";
        String str = "Hello";
        String content;

        // možnost načtení souboru do Stringu pomocí BufferedReader:
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        content = stringBuilder.toString();
        System.out.println(content);

        // možnost načtení souboru do Stringu pomocí FileInputStream:
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();
        content = sb.toString();
        System.out.println(content);

        // možnost načtení souboru do Stringu pomocí FileInputStream a třídy Scanner:
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        content = scanner.useDelimiter("\\A").next();
        scanner.close();
        System.out.println(content);

        // Zápis:

        // možnost záisu Stringu do souboru pomocí třídy BufferedWriter:
        BufferedWriter writer = new BufferedWriter(new FileWriter("w.txt"));
        writer.write(str);
        writer.close();

        // možnost záisu Stringu do souboru pomocí třídy PrintWriter:
        PrintWriter printWriter = new PrintWriter(new FileWriter("w.txt"));
        printWriter.print(str);
        //printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();

        //Další možnosti:

        //FileOutputStream
        //DataOutputStream
        //RansdomAccessFile
        //FileChanell

    }
}
