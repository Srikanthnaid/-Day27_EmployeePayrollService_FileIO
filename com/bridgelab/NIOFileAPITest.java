package com.bridgelab;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class NIOFileAPITest {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		/**
		 * check file exists
		 */
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		/**
		 * delete file and check file not exists
		 */
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		Path p = Paths.get(HOME + "/playDelete.txt");
		Assert.assertFalse(Files.exists(p));
		Files.createFile(p);
		Assert.assertTrue(Files.exists(p));
		Files.delete(p);
		Assert.assertFalse(Files.exists(p));

		/**
		 * create directory
		 */
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		/**
		 * / create File
		 */
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		/**
		 * List files, Directories as well as Files with Extension
		 */
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);

	}

	@Test
	public void givenDirectoryWhenWatchedListAllTheActivites() throws IOException {
		Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new Java8WatchServiceExample(dir).processEvents();
	}

}