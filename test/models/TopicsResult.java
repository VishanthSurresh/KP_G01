package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test method will be used to test the search results.
 * @author Heet Patel
 * */
public class TopicsResult {
    @Test
    public void test(){
        Topics tp=new Topics();
        tp.setFull_name("pp");
        assertTrue(tp.getFull_name()=="pp");
    }
    @Test
    public void constructorTest(){
        Topics top = new Topics();
        assertNotNull(top);
    }
    @Test
    public void constructorTestt(){
        Topics top = new Topics("l");
        assertTrue(top.getFull_name()=="l");
    }
}