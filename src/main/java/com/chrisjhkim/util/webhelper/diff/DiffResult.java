package com.chrisjhkim.util.webhelper.diff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.chrisjhkim.util.FileUtil;

@SuppressWarnings("java:S106")
public class DiffResult {
	private static final String PREFIX_MODIFIED	= "M\t";
	private static final String PREFIX_DELTED 	= "D\t";
	private static final String PREFIX_ADDED 	= "A\t";
	private static final String DIRECTORY_SEPERATOR = "\\";

	
	private Set<String> extractFileSet;
	private Set<String> deletedFileSet;

	public Set<String> getExtractFileSet() {
		return extractFileSet;
	}
	public void setExtractFileSet(Set<String> extractFileSet) {
		this.extractFileSet = extractFileSet;
	}
	public Set<String> getDeletedFileSet() {
		return deletedFileSet;
	}
	public void setDeletedFileSet(Set<String> deletedFileSet) {
		this.deletedFileSet = deletedFileSet;
	}
	public static DiffResult fromDiffFile(String diffFilePath) throws IOException {
		DiffResult result = new DiffResult();
		
		Set<String> extractedSet = new HashSet<>();
		Set<String> deletedSet = new HashSet<>();
		
		
		BufferedReader reader = new BufferedReader(
				new FileReader(diffFilePath)
				);
		String line;
		while ((line = reader.readLine()) != null) {
			if ( line.startsWith(PREFIX_MODIFIED) ) {
				if ( !deletedSet.contains(line.substring(PREFIX_MODIFIED.length()))) {
					extractedSet.add(line.substring(PREFIX_MODIFIED.length()));
				}
				
			}else if ( line.startsWith(PREFIX_ADDED)) {
				if ( !deletedSet.contains(line.substring(PREFIX_ADDED.length()))) {
					extractedSet.add(line.substring(PREFIX_ADDED.length()));
				}
			}else if ( line.startsWith(PREFIX_DELTED)) {
				if ( !extractedSet.contains(line.substring(PREFIX_DELTED.length())) ){
					deletedSet.add(line.substring(PREFIX_DELTED.length()));
				}
			}
		}
		
		reader.close();
		result.setDeletedFileSet(deletedSet);
		result.setExtractFileSet(extractedSet);
		
		return result;
		
	}
	public CopyResult extractUploadFilesTo( String destDir) throws IOException {
		Set<String> fileNotFoundSet = new HashSet<>();
		Set<String> successSet = new HashSet<>();
		
		System.out.println("====== Target List ======");
		for ( String item : this.extractFileSet) {
			System.out.println(item);
		}
		System.out.println();
		
		for ( String item : this.extractFileSet) {
			try {
				FileUtil.copyFile(item , destDir + DIRECTORY_SEPERATOR + item);
				successSet.add(item);
			} catch (FileNotFoundException e) {
				fileNotFoundSet.add(item);
			}
		}
		CopyResult result = new CopyResult(fileNotFoundSet, successSet, this.deletedFileSet);
		return result;
	}
	
	
	public boolean isEmpty() {
		return this.deletedFileSet.isEmpty() && this.extractFileSet.isEmpty();
	}
	



}
