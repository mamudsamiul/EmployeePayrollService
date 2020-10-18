package com.capgemini.payrolltest;

import org.junit.Test;

import com.capgemini.employeepayrollservice.FileUtils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class PayrollTest {
	private static String HOME = System.getProperty("user.home") + "/Desktop/test";;
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		// Check File exists
		Path homePath = Paths.get(HOME);
		assertTrue(Files.exists(homePath));
		System.out.println(homePath);

		// Delete file and check file does not exist
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		assertTrue(Files.notExists(playPath));

		// Create a directory
		Files.createDirectory(playPath);
		assertTrue(Files.exists(playPath));

		// Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			assertTrue(Files.exists(tempFile));
		});

		// List files, directories as well as files with extensions
		System.out.println("Files.list");
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		System.out.println("Files.newDirectory");
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		System.out.println("Files.newDirectory with temp");
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().contains("temp"))
				.forEach(System.out::println);
	}
}
