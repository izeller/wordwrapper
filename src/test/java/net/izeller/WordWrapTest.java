package net.izeller;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/*
 * @author irene, @date 10/04/16 18:07
 */
public class WordWrapTest {

	WordWrap wordwrap = new WordWrap();
	
	@Test 
	public void enough_length_line() {
		assertThat(wordwrap.wrap("hola", 5), is("hola"));
	}

	@Test 
	public void split_two_words() {
		assertThat(wordwrap.wrap("hola TDD", 5), is("hola\nTDD"));
	}

	@Test 
	public void split_three_words_in_two_lines() {
		assertThat(wordwrap.wrap("hola TDD wordWrap", 8), is("hola TDD\nwordWrap"));
	}
	@Test 
	public void split_three_words_in_three_lines() {
		assertThat(wordwrap.wrap("hola TDD word", 4), is("hola\nTDD\nword"));
	}

	@Test
	public void split_one_word_in_two_lines(){
		assertThat(wordwrap.wrap("holaTDD", 4), is("hola\nTDD"));
	}

	@Test
	public void split_one_word_in_many_lines(){
		assertThat(wordwrap.wrap("holaTDD", 2), is("ho\nla\nTD\nD"));
	}

	@Test
	public void split_word_and_spaces(){
		assertThat(wordwrap.wrap("hola TDD", 3), is("hol\na\nTDD"));
	}


	

}
