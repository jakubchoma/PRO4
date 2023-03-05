
import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.TestCollection
import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.WelcomeScreen
import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.MainTest

beans {
    testCollection(TestCollection){
        difficulty = 1.0
        testCollection = [
                ref("t1_0"), ref("t1_1"), ref("t1_2"), ref("t1_3"), ref("t1_4"), ref("t1_5"),
        ]
    }
    testCollection2(TestCollection){
        difficulty = 1.3
        testCollection = [
                ref("t2_0"), ref("t2_1"), ref("t2_2"), ref("t2_3")
        ]
    }
    t1_0(MainTest) {
        id = 0
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní nultým, pátým a devátým prvkem vstupního pole arr."
        inp = "1 2 3 4 5 6 7 8 9 10"
        out = "1 6 10"
    }
    t1_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní posledními 3 prvky vstupního pole arr od zadu."
        inp = "1 2 3 4 5 6 7 8 9 10"
        out = "10 9 8"
    }
    t1_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní nultým a každým 3. indexem  vstupního pole arr."
        inp = "1 2 3 4 555 6 7 8 9 10"
        out = "1 4 7 10"
    }
    t1_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní nultým a každým 4. prvkem ve vstupním poli arr."
        inp = "1 2 3 4 5 6 7 -8 9 10"
        out = "1 5 9"
    }
    t1_4(MainTest) {
        id = 4
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní nultým a pak každým 2. prvkem ve vstupním poli arr od zadu."
        inp = "1 2 3 4 5 6 7 8 9 10"
        out = "10 8 6 4 2"
    }
    t1_5(MainTest) {
        id = 5
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní nultým a pak každým 4. prvkem ve vstupním poli arr od zadu."
        inp = "1 2 3 4 5 6 7 8 9 10"
        out = "10 6 2"
    }

    t2_0(MainTest) {
        id = 0
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní sudými čísly vstupního pole arr."
        inp = "1 2 3 4 5 6 7 8 9 10"
        out = "2 4 8 10"
    }
    t2_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní lichými čísly vstupního pole arr."
        inp = "1 2 3 4 5 6 7 8 9 10"
        out = "1 3 5 7 9"
    }
    t2_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní jedním největším prvkem ve vstupním poli arr."
        inp = "1 2 3 4 555 6 7 8 9 10"
        out = "555"
    }
    t2_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní jedním nejmenším prvkem ve vstupním poli arr."
        inp = "1 2 3 4 5 6 7 -8 9 10"
        out = "-8"
    }

    welcomeScreen(WelcomeScreen){
        messages = [
        " Vítej v Groovy Simple Testu ! ",
        " Pravidla:",
        " - řeší se vždy otázka zadaná nahoře pomocí editovatelného okna uprostřed, ",
        " - vstupem je String, který se pomocí metody split rozdělí na pole Stringů, ",
        " - výstup se ukládá do seznamu, který se pak pomocí metody .join(\" \") převádí na string, který se porovnává,",
        " - pro přidání prvku do výstupního pole slouží al.add(x) - zapiš si !,",
        " - v poli Stringů jsou čísla, které je možné převést na int pomocí Integer.valueOf(arr[i]) - zapiš si!, ",
        " - naopak, pokud mám int a potřebuji ho převést na int (nutné pro výstup), použiji Integer.toString(x) - zapiš si!, ",
        " - čas na známku 4 je max. 300 sekund, limity na ost. známky (zbývající čas): {210, 140, 70 }, ",
        " - máš 3 volné pokusy, ostatní jsou zpoplatněny 10 sekundami každý, ",
        " - test je ukončen ulpynutím časovače (známka 5), nebo úspěšným vyřešením, ",
        " - výsledný kód v případě známek 1-4 musí vždy zkontrolovat učitel !"
        ]
        fontSize = 20
    }
    cheatingWarningScreen(WelcomeScreen){
        messages = [
        "Tohle je za 5,",
        " je vvýslovně zakázáno spouštět test 2x"
        ]
        fontSize = 110
    }
}
    /*
    Alternatively, we can use the GroovyScriptEngine class to execute Groovy scripts. GroovyScriptEngine is provided by Groovy itself, and there's no dependency on Spring to use it.

This class supports reloading the scripts automatically whenever there's a change. In addition, it also loads all the classes that depend on it.

There are two ways to execute the script. In the first approach, we get a GroovyObject and execute the script by calling invokeMethod():

GroovyScriptEngine engine = new GroovyScriptEngine(ResourceUtils.getFile("file:src/main/resources/")
.getAbsolutePath(), this.getClass().getClassLoader());
Class<GroovyObject> joinerClass = engine.loadScriptByName("StringJoiner.groovy");
GroovyObject joiner = joinerClass.newInstance();

Object result = joiner.invokeMethod("join", new Object[]{"Mr.", "Bob"});
assertEquals("Mr.Bob", result.toString());
Copy
In the second approach, we can call the Groovy script directly. We use the Binding class to pass variables to the Groovy script:

Binding binding = new Binding();
binding.setVariable("arg1", "Mr.");
binding.setVariable("arg2", "Bob");
Object result = engine.run("StringJoinerScript.groovy", binding);
assertEquals("Mr.Bob", result.toString());
     */
