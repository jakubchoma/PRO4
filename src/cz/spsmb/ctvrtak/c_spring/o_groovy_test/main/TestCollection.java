package cz.spsmb.ctvrtak.c_spring.o_groovy_test.main;

import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.util.List;
import java.util.Random;

public class TestCollection {
    private List<MainTest> testCollection;
    public void setTestCollection(List<MainTest> testCollection) {
        this.testCollection = testCollection;
    }


    public MainTest getRandomTest(){
        Random rnd = new Random();
        rnd.setSeed(LocalTime.now().toNanoOfDay());
        return testCollection.get(rnd.nextInt(testCollection.size()));
    }
}
