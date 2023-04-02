
import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.TestCollection
import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.WelcomeScreen
import cz.spsmb.ctvrtak.c_spring.o_groovy_test.main.MainTest


beans {
    code_1 =
            "    String check(String in) {\n" +
                    "        ArrayList<String> al =  new ArrayList()\n" +
                    "        String[] arr=in.split(\" \")\n" +
                    "\n" +
                    "\n" +
                    "//      zde doplňte kód\n " +
                    "\n" +
                    "\n" +
                    "        return al.join(\" \")\n" +
                    "    }\n";
    testCollection1(TestCollection){
        grvCode = code_1
        difficulty = 1.0
        testCollection = [
                ref("t1_0"), ref("t1_1"), ref("t1_2"), ref("t1_3"), ref("t1_4"), ref("t1_5"),
        ]
    }
    testCollection2(TestCollection){
        grvCode = code_1
        difficulty = 1.3
        testCollection = [
                //ref("t2_0"), ref("t2_1"), ref("t2_2"), ref("t2_3")
                ref("t2_2"), ref("t2_3"), ref("t2_4"), ref("t2_5")
        ]
    }
    testCollection3(TestCollection){
        grvCode = code_1
        difficulty = 2
        testCollection = [
                ref("t3_0"), ref("t3_1"), ref("t3_2"), ref("t3_3")
        ]
    }
    testCollection4(TestCollection){
        grvCode =
                "\n" +
                        "\n" +
                        "//      zde doplňte kód\n" +
                        "\n" +
                        "\n" +
                        "    String check(String in) {\n" +
                        "        ArrayList<String> al =  new ArrayList()\n" +
                        "        String[] arr=in.split(\" \")\n" +
                        "        for(int i=0; i<arr.length; i+=2) {\n" +
                        "           int a = Integer.parseInt(arr[i]);\n" +
                        "           int b = Integer.parseInt(arr[i+1]);\n" +
                        "           al.add(rec(a, b));\n" +
                        "        }\n" +
                        "        return al.join(\" \")\n" +
                        "    }\n";
        difficulty = 1.1
        testCollection = [
                ref("t4_0"), ref("t4_1"), ref("t4_2"), ref("t4_3")
        ]
    }
    testCollection5(TestCollection){
        grvCode = code_1
        difficulty = 1
        testCollection = [
                ref("t5_0"),ref("t5_1"),ref("t5_2"),ref("t5_3")
        ]
    }
    testCollection6(TestCollection){
        grvCode = code_1
        difficulty = 1
        testCollection = [
                //ref("t6_0"),ref("t6_1"),ref("t6_2"),
                ref("t6_3")
        ]
    }
    testCollection7(TestCollection){
        grvCode = code_1
        difficulty = 2
        testCollection = [
                ref("t7_0"), ref("t7_1"), ref("t7_2"), ref("t7_3"), ref("t7_4")
        ]
    }
    testCollection8(TestCollection){
        grvCode =
                "    String check(String in) {\n" +
                        "\n" +
                        "\n" +
                        "//      zde doplňte kód\n " +
                        "\n" +
                        "\n" +
                        "    }\n";
        difficulty = 3
        testCollection = [
                ref("t8_0"), ref("t8_1"), ref("t8_2"), ref("t8_3"), ref("t8_4")
        ]
    }
    testCollection9(TestCollection){
        imports =
                "import java.time.LocalDate;\n" +
                "import java.time.LocalTime;\n" +
                "import java.time.LocalDateTime;\n" +
                "import java.time.format.DateTimeFormatter;\n" +
                "import java.time.temporal.ChronoUnit;\n"

        grvCode = code_1
        difficulty = 1
        testCollection = [
                ref("t9_0"), ref("t9_1"), ref("t9_2"), ref("t9_3"), ref("t9_4")
        ]
    }
    testCollection(TestCollection){
        grvCode =
                "private static final String PATH = System.getenv(\"HOMEDRIVE\")+System.getenv(\"HOMEPATH\")+\"\\\\\";\n" +
                "    String check(String in) {\n" +
                "        ArrayList<String> al =  new ArrayList()\n" +
                "        String[] arr=in.split(\" \")\n" +
                "\n" +
                "\n" +
                "//      zde doplňte kód\n " +
                "\n" +
                "\n" +
                "/*\n" +
                "for(String n: arr){\n" +
                "    Path p = Path.of(PATH+n+\".txt\")\n" +
                "    al.add(new String(Files.readString(p)))\n" +
                "} \n" +
                "*/\n" +
                "        return al.join(\" \")\n" +
                "    }\n";
        imports =
                "import java.nio.file.Files;\n" +
                "import java.nio.file.Path;\n" +
                "import java.net.URI;\n"
        difficulty = 2
        testCollection = [
                //ref("t10_0"), ref("t10_1")
                ref("t10_0")
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
        inp = "1 1 2 3 4 5 6 7 7 7 8 9 9 10"
        out = "2 4 6 8 10"
    }
    t2_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o cyklus, který výstupní seznam al naplní lichými čísly vstupního pole arr."
        inp = "1 2 2 2 3 4 4 5 6 6 7 8 8 9 10"
        out = "1 3 5 7 9"
    }
    t2_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí největší prvek ve vstupním poli arr."
        inp = "1 2 3 4 555 6 7 8 9 10"
        out = "555"
    }
    t2_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí nejmenší prvek ve vstupním poli arr."
        inp = "1 2 3 4 5 6 7 -8 9 10"
        out = "-8"
    }
    t2_4(MainTest) {
        id = 4
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí v pořadí druhý největší prvek ve vstupním poli arr."
        inp = "1 2 3 44 555 6 7 8 9 10"
        out = "44"
    }
    t2_5(MainTest) {
        id = 5
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí v pořadí druhý nejmenší prvek ve vstupním poli arr."
        inp = "1 2 -73 4 5 6 7 -8 9 -9"
        out = "-9"
    }

    t3_0(MainTest) {
        id = 0
        entry = "Doplňte metodu String check(String in) o algoritmus, který naplní výstupní seznam al vzestupně seřazenými prvky vstupního pole arr."
        inp = "1 0 2 999 3 8 4 7 5 6"
        out = "0 1 2 3 4 5 6 7 8 999"
    }
    t3_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o algoritmus, který naplní výstupní seznam al sestupně seřazenými prvky vstupního pole arr."
        inp = "1 0 2 999 3 8 4 7 5 6"
        out = "999 8 7 6 5 4 3 2 1 0"
    }
    t3_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o algoritmus, který\n" +
                "1. seřadí vstupní pole dle velikosti do nového pole int[] tmp,\n" +
                "2. naplní výstupní seznam al vzestupně největším a každým v pořadí druhým prvkem seřazeného pole tmp."
        inp = "1 0 2 999 3 8 4 7 5 6"
        out = "999 7 5 3 1"
    }
    t3_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o algoritmus, který\n" +
                "1. seřadí vstupní pole dle velikosti do nového pole int[] tmp,\n" +
                "2. naplní výstupní seznam al vzestupně nejmenším a každým v pořadí druhým prvkem seřazeného pole tmp."
        inp = "1 0 2 999 3 8 4 7 5 6"
        out = "0 2 4 6 8"
    }

    t4_0(MainTest) {
        id = 0
        entry = "Rekurze, mocnina: Víte, že platí x[n] =\n" +
                "                                        1; pro n=0, \n" +
                "                                        x * x[n-1]; pro n>0.\n" +
                " Vytvořte rekurzivní metodu rec(int x, int n)," +
                " která bude vracet n-tou mocninu čísla x tak, aby zbytek kódu pro následující vstup (formát x0, n0, x1, n1, x2, n2,...) vypsal x^n."
        inp = "2 1 2 4 2 7"
        out = "2 16 128"
    }
    t4_1(MainTest) {
        id = 1
        entry = "Rekurze, největší společný dělitel : Víte, že platí NSD(A, B) = \n" +
                "                                                               A; pro A=B,\n" +
                "                                                               NSD(A-B, B); pro A>B,\n" +
                "                                                               NSD(A, B-A); pro B>A.\n" +
                "Vytvořte rekurzivní metodu rec(int A, int B), která bude vracet nejmenší společný dělitel čísel A a B pro následující vstup (formát A0, B0, A1, B1, ...). " +
                "Zbytek kódu se postará o správný výpis nejmenších společných dělitelů."
        inp = "10 20 18 27"
        out = "10 9"
    }
    t4_2(MainTest) {
        id = 2
        entry = "Rekurze, aritmetická posloupnost od 1 : Víte, že platí ap(d, k) = \n" +
                "                                                               1; pro k=0,\n" +
                "                                                               d + ap(d, k-1); k > 0\n" +
                "Vytvořte rekurzivní metodu rec(int d, int k), která bude vracet k-tý člen aritmetické posloupnosti s diferencí d, kde první člen je 1 (formát d0, k0, d1, k1, ...). " +
                "Zbytek kódu se postará o správný výpis aritmetické posloupnosti."
        inp = "1 1 7 2"
        out = "2 15"
    }
    t4_3(MainTest) {
        id = 3
        entry = "Rekurze, geometrická posloupnost od 1 : Víte, že platí gp(q, k) = \n" +
                "                                                               1; pro k=0,\n" +
                "                                                               q * gp(q, k-1); k > 0\n" +
                "Vytvořte rekurzivní metodu rec(int q, int k), která bude vracet k-tý člen gemoterické posloupnosti s kvocientem q, kde první člen je 1 (formát q0, k0, q1, k1, ...). " +
                "Zbytek kódu se postará o správný výpis geometrické posloupnosti."
        inp = "1 1 7 2"
        out = "1 49"
    }
    t5_0(MainTest) {
        id = 0
        entry = "Doplňte metodu String check(String in) o algoritmus, který naplní seznam al dvojkovou reprezentací vstupních čísel v osmičkovém fotmátu"
        inp = "014 077 023 055 063"
        out = "1100 111111 10011 101101 110011"
    }
    t5_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o algoritmus, který naplní seznam al osmičkovou  reprezentací vstupních čísel v binárním fotmátu"
        inp = "1100 111111 10011 101101 110011"
        out = "14 77 23 55 63"
    }
    t5_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o algoritmus, který naplní seznam al šestkovou  reprezentací vstupních čísel v hexadecimálním fotmátu"
        inp = "AF 6F AB DE AD BE EF"
        out = "451 303 443 1010 445 514 1035"
    }
    t5_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o algoritmus, který převede vstupní znaky na číslo a to vypíše v hexadecimálním fotmátu"
        inp = "A h o j"
        out = "41 68 6f 6a"
    }
    t6_0(MainTest) {
        id = 0
        entry = "Doplňte metodu String check(String in) o cyklus, který pomocí TERNÁRNÍHO OPERÁTORU" +
                " naplní seznam al řetězcem \"sudá\", nebo \"lichá\" dle vstupních čísel."
        inp = "12 34 84 98 101 345235"
        out = "sudá sudá sudá sudá lichá lichá"
    }
    t6_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o cyklus, který pomocí TERNÁRNÍHO OPERÁTORU" +
                " naplní seznam al řetězcem \"muž\", nebo \"žena\" dle vstupních jmen. Končí-li jméno na znak" +
                " \"a\" jde o ženu jinak o muže."
        inp = "Jana Pavel Miroslava Jiří Kateřina Lenka Jaroslav Petra"
        out = "žena muž žena muž žena žena muž žena"
    }
    t6_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o cyklus, který pomocí TERNÁRNÍHO OPERÁTORU" +
                " naplní seznam al absolutní hodnotou vstupních čísel tak, že platí: \n" +
                " |a| =  a pro a >= 0, \n" +
                "     = -a pro a < 0 ."
        inp = "6 -3 8 -90 47 -788"
        out = "6 3 8 90 47 788"
    }
    t6_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o cyklus, který pomocí TERNÁRNÍHO OPERÁTORU" +
                " naplní seznam al řetězcem \"ráno\", \"dopoledne\", \"odpoledne\", nebo \"večer\" dle vstupních hodin." +
                " 0-8: ráno, 9-12: dopoledne, 13-16: odpoledne, 17-23 večer."
        inp = "11 23 9 13 8 4 0"
        out = "dopoledne večer dopoledne odpoledne ráno ráno ráno"
    }
    t7_0(MainTest) {
        id = 0
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí aritmetický průměr vstupního " +
                "pole arr. Pro výpočet použijte datový typ float."
        inp = "33 88 11 23 9 13 8 4 1 5"
        out = "19.5"
    }
    t7_1(MainTest) {
        id = 1
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí geometrický průměr vstupního pole arr. " +
                "Geometrický průměr je definován jako n-tá odmocnina součinu všech n čísel. " +
                "Použijte funkci Math.pow(soucin, 1.0/n). " +
                "Pro výpočet použijte datový typ float."
        inp = "33 88 11 23 9 13 8 4 1 5"
        out = "10.323864565239498"
    }
    t7_2(MainTest) {
        id = 2
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí medián vstupního pole arr." +
                "Medián je definován jako prostřední hodnota vzestupně seřazeného pole. Pokud má pole " +
                "sudý počet prvků (tento případ), jedná se o aritmetický průměr hodnot na místech n/2-1 a n/2. " +
                "Pro výpočet použijte datový typ float."
        inp = "33 88 11 23 9 13 8 4 1 5"
        out = "10"
    }
    t7_3(MainTest) {
        id = 3
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí dolní kvintil vstupního pole arr. " +
                "Dolní kvintil je definován tak že 20%% hodnot v poli je menších (nebo rovných) hodnotě " +
                "dolního kvintilu a 80%% hodnot je větších (nebo rovných)."
        inp = "33 88 11 23 9 13 8 4 1 5"
        out = "4"
    }
    t7_4(MainTest) {
        id = 4
        entry = "Doplňte metodu String check(String in) o algoritmus, který vrátí harmonický průměr vstupního pole arr. " +
                "Harmonický průměr je definován jako podíl počtu čísel a součtu jejich převrácených hodnot. " +
                "Pro výpočet použijte datový typ float."
        inp = "33 88 11 23 9 13 8 4 1 5"
        out = "5.157062927407182"
    }
    t8_0(MainTest) {
        id = 0
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který ze vstupního řetězce vybere každý 2. znak a" +
                " uloží ho do výstupního řetězce, který metoda vrátí."
        inp = "Tohle je groovy simple test."
        out = "ol egov ipets."
    }
    t8_1(MainTest) {
        id = 1
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který ze vstupního řetězce vybere první polovinu znaků," +
                " ty uloží do výstupního řetězce a přidá k němu tentýž řetězec pozpátku. Použijte 2 instance třídy StringBuffer," +
                " kde jedna bude sloužit pro použití metody .reverse()."
        inp = "groovy"
        out = "groorg"
    }
    t8_2(MainTest) {
        id = 2
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který ze vstupní řetězec zkopíruje do výstupního" +
                " bez samohlásek a,e,i,o,u. K definici samohlásek použijte inicializovaný seznam: " +
                " List<String> souhl = Arrays.asList(\"a\", \"e\", \"i\", \"y\", \"o\", \"u\") ."
        inp = "simple groovy test is best"
        out = "smpl grv tst s bst"
    }
    t8_3(MainTest) {
        id = 3
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který ze vstupní řetězec zkopíruje do výstupního" +
                " bez souhlásek. K definici samohlásek použijte inicializovaný seznam: " +
                " List<String> souhl = Arrays.asList(\"a\", \"e\", \"i\", \"y\", \"o\", \"u\") ."
        inp = "simple groovy test is best"
        out = "ie ooy e i e"
    }
    t8_4(MainTest) {
        id = 4
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který každou hodnotu znaku vstupního řetězce posune o 1 a" +
                " uloží ho do výstupního řetězce, který metoda vrátí. Tzv. Caesarova šifra."
        inp = "Ahoj lidi!"
        out = "Bipk!mjej\""
    }
    t8_13_dobrovolne(MainTest) {
        id = 13
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který ze vstupní řetězec zkopíruje do výstupního" +
                " tak, že otočí pořadí samohlásek a,e,i,o,u. K definici samohlásek použijte inicializovaný seznam: " +
                " List<String> souhl = Arrays.asList(\"a\", \"e\", \"i\", \"y\", \"o\", \"u\") ."
        inp = "tohle je fajn škola"
        out = "tahlo ja fejn škelo"
    }
    t8_14_dobrovolne(MainTest) {
        id = 14
        entry = "Práce s řetězci a třída StringBuffer. Doplňte metodu String check(String in) o algoritmus, který ze vstupní řetězec zkopíruje do výstupního" +
                " tak, že otočí pořadí souhlásek. K definici samohlásek použijte inicializovaný seznam: " +
                " List<String> souhl = Arrays.asList(\"a\", \"e\", \"i\", \"y\", \"o\", \"u\") ."
        inp = "tohle je fajn škola"
        out = "tahlo ja fejn škelo"
    }
    t9_0(MainTest) {
        id = 0
        entry = "Datum a čas. Načtěte data z pole Stringů arr do instance třídy LocalDate pomocí tovární statické metody " +
                "LocalDate.parse(String in). Přičtěte pomocí metody plus(n, ChronoUnit.MONTHS) jeden měsíc a výsledek " +
                "přidejte do výstupního seznamu al."
        inp = "2022-03-30 2022-03-31 2022-05-01 2022-08-31"
        out = "2022-04-30 2022-04-30 2022-06-01 2022-09-30"
    }
    t9_1(MainTest) {
        id = 1
        entry = "Datum a čas. Načtěte data z pole Stringů arr do instance třídy LocalDate pomocí tovární statické metody " +
                "LocalDate.parse(String in). Vyrobte instanci třídy LocalDateTime pomocí tovární statické metody " +
                "LocalDateTime.of(LocalDate ld, LocalTime lt)  Jako lt použijte čas 14:00:01 a výsledek " +
                "přidejte do výstupního seznamu al."
        inp = "2022-03-30 2022-03-31 2022-05-01 2022-08-31"
        out = "2022-03-30T14:00:01 2022-03-31T14:00:01 2022-05-01T14:00:01 2022-08-31T14:00:01"
    }
    t9_2(MainTest) {
        id = 2
        entry = "Datum a čas. Načtěte data z pole Stringů arr do instance třídy LocalTime pomocí tovární statické metody " +
                "LocalTime.parse(String in). Odečtěte pomocí metody minus(n, ChronoUnit.MINUTES) 45 minut a výsledek " +
                "přidejte do výstupního seznamu al."
        inp = "15:30 17:22 18:01 22:22 23:23"
        out = "14:45 16:37 17:16 21:37 22:38"
    }
    t9_3(MainTest) {
        id = 3
        entry = "Datum a čas. Načtěte data z pole Stringů arr do instance třídy LocalDate pomocí tovární statické metody " +
                "LocalDate.parse(String in). Pomocí statické metody ChronoUnit.DAYS.between(LocalDate date1, LocalDate date2) " +
                "zjistěte, kolik zbývá dnů do Vánoc 2023 jednotlivých datumů. Tyto počty přidejte " +
                "do výstupního seznamu al."
        inp = "2023-03-30 2023-03-31 2023-05-01 2023-08-31"
        out = "269 268 237 115"
    }
    t9_4(MainTest) {
        id = 4
        entry = "Datum a čas. Načtěte data z pole Stringů arr do instance třídy LocalDate pomocí tovární statické metody " +
                "LocalDate.parse(String in). Vypište tyto datumy pomocí ve formátu např.: 31.října,2023 pomocí metody " +
                "date.format(DateTimeFormatter.ofPattern(\"...\") a výsledek " +
                "přidejte do výstupního seznamu al."
        inp = "2023-03-30 2023-03-31 2023-05-01 2023-08-31"
        out = "30.března,2023 31.března,2023 01.května,2023 31.srpna,2023"
    }
    t10_0(MainTest) {
        id = 0
        entry = "Soubory. NUTNÉ ODKOMENTOVAT SPODNÍ ČÁST KÓDU DOLE !!! Slouží pro kontrolu vytvořených souborů.\n" +
                "Vytvořte ve adresáři pojmenovaném konstantou PATH soubory s názvem, který odvodíte z jmen v poli arr tak, " +
                "že přidáte \".txt\" k tomuto jménu. Pomocí Files.write(path, jmeno.getBytes()) zapište do těchto " +
                "souborů jejich jména bez koncovky. Samotný soubor vytvoříte ponocí Files.createFile(path). " +
                "Případně můžete ověřovat existenci souboru pomocí Files.exists(path). Případně půžete prvně existující " +
                "soubory vymazat pomocí Files.delete(path)"
        inp = "prvniSoubor druhySoubor tretiSoubor"
        out = "prvniSoubor druhySoubor tretiSoubor"
    }
    t10_1(MainTest) {
        id = 1
        entry = "Soubory. Pomocí Files.readString(Path.of(ClassLoader.getSystemResource(String jmeno).toURI())) načtěte z resource " +
                "složky v GST testu soubory, které jsou dány prvky vstupního pole arr. " +
                "Postupně je přečtěte a přečtený řetězec přidejte do kolekce al."
        inp = "prvniSoubor.txt druhySoubor.txt tretiSoubor.txt"
        out = "Já snad i odmaturuji 😂😂😂 Spolužák snad i odmaturuje 😂😂😂 Všichni snad i odmaturujeme 😂😂😂"
    }
    //2022-04-30T11:36:38.051628200
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
                " je zakázáno spouštět test 2x"
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
