package main.util;

public enum Medicinali {
	CASE_1("headache pills");
	
	
	private String value;

	Medicinali(String value) {
		this.value = value;
	}
	
	public String getVal() {
        return value;
    }
	
}
