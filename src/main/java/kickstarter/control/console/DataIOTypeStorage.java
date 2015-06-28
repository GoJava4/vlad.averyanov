package kickstarter.control.console;

import kickstarter.view.Reader;
import kickstarter.view.Writer;

public class DataIOTypeStorage {
	
	private Reader reader;
	private Writer writer;
	
	public DataIOTypeStorage(Reader reader,	Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public Reader getReader() {
		return reader;
	}

	public Writer getWriter() {
		return writer;
	}
}
