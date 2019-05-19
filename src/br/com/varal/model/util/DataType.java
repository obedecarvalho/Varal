package br.com.varal.model.util;

public enum DataType {
	INTEGER, REAL, TEXT, BLOB, NULL;
	
	public boolean isInteger() {
		return INTEGER.equals(this);
	}
	
	public boolean isReal() {
		return REAL.equals(this);
	}
	
	public boolean isBlob() {
		return BLOB.equals(this);
	}
	
	public boolean isText() {
		return TEXT.equals(this);
	}
}
