package xin.val1ant;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void handle() {

        String path = "C:\\Users\\Xbear\\Desktop\\ArtConcurrentBook";
        Set<String> types = new HashSet<>();
        types.add("txt");
        types.add("java");
        Main.handle(path,types);

    }
}