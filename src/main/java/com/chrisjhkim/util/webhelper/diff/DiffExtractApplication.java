package com.chrisjhkim.util.webhelper.diff;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.chrisjhkim.util.FileUtil;

@SuppressWarnings("java:S106")
public class DiffExtractApplication {

	private static final String DEFAULT_DIFF_FILE_NAME = "diff.log";
	private static final String DEFAULT_TARGET_DIR = "extracted";
	private static final String DIRECTORY_SEPERATOR = "\\";
	

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("");
		String currentFullDir = System.getProperty("user.dir") ;
		
		System.out.println("Working Directory = " + currentFullDir);
		System.out.println("Target Directory = " + currentFullDir);
		
		
		String fullDirFileName = getDiffFileName(args, currentFullDir);
		
		DiffResult diffData = DiffResult.fromDiffFile(fullDirFileName);
		
		if ( diffData.isEmpty() ) {
			printDiffFormInstruct();
		}else {
			// COPY FILE
			
			String destDirectory = currentFullDir + "\\" + DEFAULT_TARGET_DIR;
			CopyResult copyResult = diffData.extractUploadFilesTo(destDirectory);
			
			// PRINT RESULT
			copyResult.printResult();
		}
	}

	private static String getDiffFileName(String[] args, String currentFullDir)
			throws IOException, FileNotFoundException {
		String fullDirFileName;
		if ( args != null && args.length != 0 ) {
			System.out.println("diff File = "+ args[0]);
			if ( !FileUtil.fileExists(args[0])) {
				printUsage();
				throw new FileNotFoundException("diff File not exists");
			}
			fullDirFileName = currentFullDir + DIRECTORY_SEPERATOR + args[0];
		}else {
			fullDirFileName = currentFullDir + DIRECTORY_SEPERATOR + DEFAULT_DIFF_FILE_NAME;
			if ( !FileUtil.fileExists(fullDirFileName)) {
				printUsage();
				throw new FileNotFoundException("default diff file not exists ("+DEFAULT_DIFF_FILE_NAME+")");
			}
			System.out.println("diff File = default file("+DEFAULT_DIFF_FILE_NAME+")");
		}
		System.out.println("");
		return fullDirFileName;
	}
	
	private static void printDiffFormInstruct() {
		System.out.println("");
		System.out.println("there is nothing to extract");
		System.out.println("diff file might be in bad form.");
		System.out.println("");
		System.out.println("usage : git log --name-status --no-merges");
		System.out.println("        위의 명령어를 통해서 최근 몇개의 내용에서 추출해야 하는지 확인 한 후 아래의 @@@에 그 숫자를 넣은 명령어를 실행");
		System.out.println("        git log -p -@@@ --name-status --no-merges");
		System.out.println("");
		
	}
	private static void printUsage() {
		System.out.println("diff file not found. ");
		System.out.println("");
		System.out.println("usage : java -jar [diff file name]");
		System.out.println("");
		System.out.println("        or ");
		System.out.println("");
		System.out.println("        set diff file name to \"diff.log\" and then  ");
		System.out.println("        java -jar");
		System.out.println("");
	}
}
