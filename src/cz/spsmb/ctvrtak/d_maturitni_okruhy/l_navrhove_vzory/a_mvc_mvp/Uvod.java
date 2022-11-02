package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.a_mvc_mvp;

import de.codecentric.centerdevice.javafxsvg.SvgImageLoaderFactory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

/***
 * GUI aplikace zajištuje 3 úkoly:
 * - Akceptace vstupů od uživatele,
 * - vlastní zpracování vstupů,
 * - zobrazení výstupu.
 *
 * GUI aplikace obsahuje 2 základní druhy kódu:
 * - doménový kód (domain code), který se zabývá vlastními daty a pravidly jejich zpracování,
 * - prezentační kód (presentation code), který se zabývá interakcí programu s uživatelem.

 * Rozdělení tohoto kódu na tyto 2 části pak snadno umožní vytvořit webovou a desktopovou aplikaci, neboť
 * doménový kód pro obě aplikace může zůstat stejný.
 *
 * Model-view-controller (MVC) návrhový vzor (pattern) je jeden z nejstarších a nejoblíbenějších návrhových
 * vzorů. Skládá se z těchto částí:
 * - model (doménový kód) - modelování reálného problému zpracování a uložení dat.
 * - pohled a řadič (view, controller) - prezentační kód, kde řadič (controller) akceptuje data od uživatele
 *   a rozhodne se, co s nimi udělá. Pohled (view) pak zobrazí výstup na obrazovku. Každý pohled má svůj řadič
 *   a naopak. Každý zobrazený objekt (např. tlačítka, návěští, grafy, ...) na obrazovce, tzv. widget je pohled,
 *   který má svůj řadič. U GUI aplikace je běžné, že používá více párů pohled-řadič.
 *
 *   Model není potřeba nijak přizpůsobovat pohledu a řadiči, naopak však ano. Řadič posílá modelu data,
 *   pro modifikaci stavu modelu. Pohled by měl být vždy sesynchronizován s modelem tak, že model informuje
 *   pohled o změnách jeho stavu tak, aby vždy zobrazoval aktuální data (návrhový vzor observer).
 *
 * Model-view-presenter (MVP) - pasivní mód
 * Dnes moderní operační systémy kombinují funkci pohledu a řadiče do jednoho prvku - tzv. presenteru.
 *
 * Model-view-presenter (MVP) - aktivní mód
 * Moderní widgety též podporují data binding, což pomáhá velmi snadno synchronizovat pohled s modelem.
 * V MVC má každý widget na obrazovce pohledem a má svůj řadič. V případě MVP je pohled sloučením několika widgetů.
 * Pohled tak sbírá vstupy od uživatele a předává je presenteru. Hlavním úkolem pohledu je tak zobrazení dat z modelu.
 * Jakmile presenter modifikuje model, je pohled aktualizován.
 */
public class Uvod extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //TODO: Vybereme všechny obrázky z classpath pomocí reflexe
        List<String> pathImageList = new ArrayList<>();
        pathImageList.add("a_mvc_process.svg");
        pathImageList.add("b_mvc_process2.png");
        pathImageList.add("c_mvp_process_passive.svg");
        pathImageList.add("d_mvp_process_active.svg");

        Image im = new Image(pathImageList.iterator().next());
        //SVGPath svgp = new SVGPath();
        ImageView iv = new ImageView(im);
        VBox vb = new VBox(iv);
        Scene scene = new Scene(vb);
        iv.setUserData(pathImageList);
        iv.fitWidthProperty().bind(scene.widthProperty());
        iv.fitHeightProperty().bind(scene.heightProperty());
        /*iv.fitHeightProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                iv.setImage(new Image((String) iv.getUserData()));
            }
        });*/
        iv.requestFocus();
        iv.setOnKeyPressed(new EventHandler<KeyEvent>() {
            List<String> lt = (List<String>)iv.getUserData();
            int idx = 0;
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if(key == KeyCode.LEFT){
                    if(--idx<0){
                        idx=lt.size()-1;
                    }
                } else if(key == KeyCode.RIGHT){
                    if(++idx >= lt.size()) {
                        idx = 0;
                    }
                }
                iv.setImage(new Image(lt.get(idx)));
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // přidání podpory svg jako dalšího typu pro třídu Image, více na https://github.com/codecentric/javafxsvg
        SvgImageLoaderFactory.install();
        //SvgImageLoaderFactory.install(new PrimitiveDimensionProvider());
        Application.launch(args);
    }
}
