import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibTest {
    Lib lib = new Lib();
    @BeforeEach
    void setUp() throws Exception {
        lib.clear();
    }

    @Test
    void testWordCountControl() throws IOException {
        lib.WordCountControl();
        assertEquals(lib.getInfilename(), "C:/Users/π»”Í/Desktop/input.txt");
        assertEquals(lib.getOutfilename(), "C:/Users/π»”Í/Desktop/output.txt");
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
        lib.getContentByFilename("C:/Users/π»”Í/Desktop/input.txt");
        assertEquals(lib.getRowCount(), 3);
        assertEquals(lib.getContent(), "sss bbb\n\naaa\n");
    }
    
}
