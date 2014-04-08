package com.xebia.mower;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import org.junit.Test;

public class MainMowerTest {

    @Test
    public void testMainMower() throws IOException {
        String[] input = Files.readAllLines(
                FileSystems.getDefault().getPath("src/main/resources",
                        "input.txt"), Charset.defaultCharset()).toArray(
                new String[] {});
        MainMower.main(input);
    }

}
