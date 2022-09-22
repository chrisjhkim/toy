package com.chrisjhkim.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	
	public static void doCopy() throws IOException {
		String originFilePath = "D:\\workspace\\dreamsign-web\\diff 추출\\origin.txt";
		String destinationFilePath =  "D:\\workspace\\dreamsign-web\\diff 추출\\output.txt";
		copyFile(originFilePath, destinationFilePath);
	}

	
	public static void copyFile(String originFilePath, String dest) throws IOException  {
		// 1. 원본 File, 복사할 File 준비
		File file = new File(originFilePath);
		File newFile = new File(dest);
		// 2. FileInputStream, FileOutputStream 준비
		
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw e;
		}
		FileOutputStream output;
		try {
			output = new FileOutputStream(newFile);
		} catch (FileNotFoundException e) {
			makeDir(dest.substring(0, dest.lastIndexOf('/')));
			output = new FileOutputStream(newFile);
		}
		// 3. 한번에 read하고, write할 사이즈 지정
		byte[] buf = new byte[1024];
		// 4. buf 사이즈만큼 input에서 데이터를 읽어서, output에 쓴다.
		int readData;
		while ((readData = input.read(buf)) > 0) {
			output.write(buf, 0, readData);
		}
		// 5. Stream close
		input.close();
		output.close();
		
	}
	
	public static void makeDir(String dir) throws IOException {
//		new File(dir).mkdir();
		Files.createDirectories(Paths.get(dir));

	}
	public static boolean fileExists(String string) throws IOException {
		return new File(string).exists();
	}
}
