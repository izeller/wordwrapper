package net.izeller;

public class WordWrap {

	public String wrap(String line, int lengthLine) {

		return wrap(line, lengthLine, true);
	}

	private String wrap(String line, int lengthLine, boolean findFirstSpaceWithOffset){

		if(enoughSpace(line, lengthLine)){
			return line;
		}

		int indexOfSpace = indexOfFirstSpace(line, lengthLine, findFirstSpaceWithOffset);
		findFirstSpaceWithOffset = indexOfSpace<=lengthLine;
		
		if(indexOfSpace<0 || !findFirstSpaceWithOffset){
			return wrappedLine(line, lengthLine)+
					"\n"+
					wrap(notWrappedLine(line, lengthLine-1), lengthLine, findFirstSpaceWithOffset);
		}
		return wrappedLine(line, indexOfSpace)+
				"\n"+
				wrap(notWrappedLine(line, indexOfSpace), lengthLine);


	}

	private boolean enoughSpace(String line, int lengthLine) {

		return line.length()<=lengthLine;
	}

	private String notWrappedLine(String line, int indexOfSpace) {
		return line.substring(indexOfSpace+1);
	}

	private String wrappedLine(String line, int indexOfSpace) {
		return line.substring(0, indexOfSpace);
	}

	private int indexOfFirstSpace(String line, int lengthLine, boolean findFirstSpaceWithOffset) {
		if(findFirstSpaceWithOffset){
			return line.indexOf(" ", lengthLine-1);
		}else{
			return line.indexOf(" ");
		}
	}

}
