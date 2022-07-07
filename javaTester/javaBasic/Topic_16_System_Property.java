package javaBasic;

import java.io.File;

public class Topic_16_System_Property {
	public static final String PROJECT_PATH = System.getProperty("user.dir");

	// Window /Mac/ Linux
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";

	public static final String OS_NAME = System.getProperty("os.name");

	public static void main(String[] args) {
		System.out.println(PROJECT_PATH);
		System.out.println(UPLOAD_FILE_FOLDER);
		System.out.println(OS_NAME);
	}
}
