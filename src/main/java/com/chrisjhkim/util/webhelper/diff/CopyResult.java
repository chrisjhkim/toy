package com.chrisjhkim.util.webhelper.diff;

import java.util.HashSet;
import java.util.Set;

public class CopyResult {
	Set<String> fileNotFoundSet = new HashSet<>();
	Set<String> successSet = new HashSet<>();
	Set<String> deletedSet = new HashSet<>();
	public CopyResult(Set<String> fileNotFoundSet, Set<String> successSet, Set<String> deletedFileSet) {
		super();
		this.fileNotFoundSet = fileNotFoundSet;
		this.successSet = successSet;
		this.deletedSet = deletedFileSet;
		
	}
	public Set<String> getFileNotFoundSet() {
		return fileNotFoundSet;
	}
	public Set<String> getSuccessSet() {
		return successSet;
	}
	public void printResult() {
		System.out.println("====== File not found ======");
		for ( String notFoundItem : this.fileNotFoundSet) {
			System.out.println(notFoundItem);
		}
		System.out.println();
		
		System.out.println("====== File extracted ======");
		for ( String item : this.successSet) {
			System.out.println(item);
		}
		System.out.println();
		
		System.out.println("====== Deleted items ======");
		StringBuilder sb = new StringBuilder();
		for ( String item : this.deletedSet) {
			System.out.println(item);
			sb.append(item);
			sb.append(' ');
		}
		System.out.println("");
		System.out.println("====== Linux file remove command ======");
		System.out.println("rm " + sb.toString());
		
		System.out.println();
	}
}