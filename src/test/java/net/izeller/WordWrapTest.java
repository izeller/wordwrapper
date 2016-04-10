package net.izeller;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/*
 * @author irene, @date 10/04/16 18:07
 */
public class WordWrapTest {
	
    @Test 
    public void enough_length_line() {
       assertThat(wrap("hola", 5), is("hola"));
    }
    
    @Test 
    public void split_two_words() {
       assertThat(wrap("hola TDD", 5), is("hola\nTDD"));
    }
    public String wrap(String line, int lengthLine){
    	return line;
    }
}
