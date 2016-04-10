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
    
    @Test 
    public void split_three_words_in_two_lines() {
       assertThat(wrap("hola TDD wordWrap", 8), is("hola TDD\nwordWrap"));
    }
    @Test 
    public void split_three_words_in_three_lines() {
       assertThat(wrap("hola TDD word", 4), is("hola\nTDD\nword"));
    }
    
    @Test
    public void split_one_word_in_two_lines(){
    	 assertThat(wrap("holaTDD", 4), is("hola\nTDD"));
    }
    
    @Test
    public void split_one_word_in_many_lines(){
    	 assertThat(wrap("holaTDD", 2), is("ho\nla\nTD\nD"));
    }
    public String wrap(String line, int lengthLine){
    	
    	if(line.length()>lengthLine){
    		int indexOfSpace = indexOfFirstSpace(line, lengthLine);
    		if(indexOfSpace<0){
    			return wrappedLine(line, lengthLine)+
    					"\n"+
    					wrap(notWrappedLine(line, lengthLine-1), lengthLine);
    		}
    		return wrappedLine(line, indexOfSpace)+
    				"\n"+
    				wrap(notWrappedLine(line, indexOfSpace), lengthLine);
    	}else{
    		return line;	
    	}
    	
    }
    
    private String notWrappedLine(String line, int indexOfSpace) {
		return line.substring(indexOfSpace+1);
	}

	private String wrappedLine(String line, int indexOfSpace) {
		return line.substring(0, indexOfSpace);
	}

	private int indexOfFirstSpace(String line, int lengthLine) {
		return line.indexOf(" ", lengthLine-1);
	}


}
