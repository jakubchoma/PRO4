package cz.spsmb.ctvrtak.d_maturitni_okruhy.n_prace_se_soubory.nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 * Java NIO (Non-blocking IO) je pokračováním Java IO API, které pracuje s proudy bytů (byte streams)
 * a proudy znaků (character streams). Java NIO však namísto proudů pracuje rovnou s buffery, ve kterých je možné se
 * libovolně pohybovat.
 * Zásadní přínosy opproti Java NIO:
 *
 * Neblokující operace - může být provedena např. tak, že vlákno požádá kanál o načtení dat do bufferu. Při procesu
 *                       načítání těchto dat může vlákno pokračovat v dalších činnostech.
 * Koncept selektorů   - selektor je objekt, který může monitorovat události vícero datových kanálů (connection opened,
 *                       data arrived, ...)
 *
 *       https://jenkov.com/tutorials/java-nio/index.html
 *
 */
public class AUvod {
    public static void main(String[] args) throws IOException {
        String content;
        // Rozhraní Path reprezentuje cestu ve souborovém systému. Může tak odkazovat absolutní, či relativní cestou na
        // soubor, či adresář.
        // Pro vytvoření instance využijeme tovární metodu get:
        Path path = Paths.get("c:\\data\\myfile.txt");
        Path sourcePath      = Paths.get("data/logging.properties");
        Path destinationPath = Paths.get("data/logging-copy.properties");

        // Třída Files poskytuje několik statických metod pro manipulaci se soubory:
        boolean pathExists = Files.exists(path);
        Path newDir = Files.createDirectory(path);
        Files.copy(sourcePath, destinationPath);
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        // Třída BasicFileAttributes poskytuje další informace (čas vytvoření, ...) o daném souboru, resp. adresáři:
        BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class);

        //Možnost načtení souboru do Stringu pomocí Files.readAllBytes (https://www.digitalocean.com/community/tutorials/java-read-file-to-string)
        content = new String(Files.readAllBytes(path));

        // Totéž pomocí třídy Scanner
        Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name());
        content = scanner.useDelimiter("\\A").next();
        scanner.close();

    }
}
