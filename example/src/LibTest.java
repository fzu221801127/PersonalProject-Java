import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibTest {
    Lib lib = new Lib();
    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testWordCountControl() throws IOException {
        lib.WordCountControl();
        assertEquals(lib.getInfilename(), "C:/Users/π»”Í/Desktop/new 1.txt");
        assertEquals(lib.getOutfilename(), "C:/Users/π»”Í/Desktop/new 2.txt");
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
        assertEquals(lib.getContent(), null);
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

}
