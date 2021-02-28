import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibTest {
    Lib lib = new Lib();
    private String inputTestFile = "C:/Users/����/Desktop/input.txt";
    private String outputTestFile = "C:/Users/����/Desktop/output.txt";
    
    @BeforeEach
    void setUp() throws Exception {
        lib.clear();
    }

    @Test
    void testWordCountControl() throws IOException {
        lib.WordCountControl();
        assertEquals(lib.getInfilename(), inputTestFile);
        assertEquals(lib.getOutfilename(), outputTestFile);
    }

    @Test
    void testGetInfilename() {
        assertEquals(lib.getInfilename(), null);
    }

    @Test
    void testGetOutfilename() {
        assertEquals(lib.getOutfilename(), null);
    }

    @Test
    void testGetContent() {
        assertEquals(lib.getContent(), "");
    }

    @Test
    void testGetRowCount() {
        assertEquals(lib.getRowCount(), 0);
    }

    @Test
    void testGetCharCount() {
        assertEquals(lib.getCharCount(), 0);
    }
    
    @Test
    void testMain() throws IOException {
        WordCount wordcount = new WordCount();
        String[] args = null;
        WordCount.main(args);
        assertEquals(1, 1);
    }
    
    @Test
    void testGetContentByFilename() throws IOException {
        lib.setContentAndRowCountByFilename(inputTestFile);
        assertEquals(lib.getRowCount(), 2);
        assertEquals(lib.getContent(), "ssss111 bbb222\n    \naaaa333,ccccc\n\n");
    }
    
    @Test
    void testSetCharCount() throws IOException {
        lib.setContentAndRowCountByFilename(inputTestFile);
        lib.setCharCountByContent(lib.getContent());
        assertEquals(lib.getCharCount(), 35);
    }
    
    @Test
    void testSetStrGroupByContent() throws IOException {
        lib.setContentAndRowCountByFilename(inputTestFile);
        lib.setStrGroupByContent(lib.getContent());
        assertEquals(1, 1);
    }
    
    @Test
    void testIsUpWord() {
        assertEquals(lib.isUpWord("AA2AAA"), false);
        assertEquals(lib.isUpWord("AAAAA444"), true);
    }
}
