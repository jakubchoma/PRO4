package cz.spsmb.ctvrtak.d_maturitni_okruhy.n_prace_se_soubory.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Java IO bylo kompletně rozebráno ve 3. ročníku. Pracuje se zde s proudy znaků nebo bytů.
 *
 */
public class AUvod {
    public static void main(String[] args) throws IOException {
        String fileName = "a.txt";
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
    }
}
