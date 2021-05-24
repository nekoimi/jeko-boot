package me.nekoimi.start.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author nekoimi  2021/3/2 下午4:33
 */
public class Banner {
    // banner made by https://www.bootschool.net/ascii
    public static final String DEFAULT_BANNER_NAME = "banner.txt";

    public static void show() {
        URL url = Thread.currentThread().getContextClassLoader().getResource(DEFAULT_BANNER_NAME);
        if (url == null) {
            return;
        }

        try {
            Path path = Paths.get(url.toURI());
            Files.lines(path).forEach(System.out::println);
        } catch (URISyntaxException | IOException ex) {
            // ignore
        }
    }
}
