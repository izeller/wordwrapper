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
    
    public String wrap(String line, int lengthLine){
    	return line;
    }
}
