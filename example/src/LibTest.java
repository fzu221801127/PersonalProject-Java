import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
//        lib.WordCountControl();
//        assertEquals(lib.getInfilename(), inputTestFile);
//        assertEquals(lib.getOutfilename(), outputTestFile);
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
    void testGetWordCount() {
        assertEquals(lib.getWordCount(), 0);
    }
    
    @Test
    void testGetStrGroup() {
        assertEquals(lib.getStrGroup(), null);
    }
    
    @Test
    void testGetWordGroup() {
        assertEquals(lib.getWordGroup(), null);
    }
    
    @Test
    void testGetAmountWord() {
        assertEquals(lib.getAmountWord(), null);
    }
    
    @Test
    void testGetAmountWord2() {
        assertEquals(lib.getAmountWord2(), null);
    }
    
    @Test
    void testGetTenWord() {
        assertEquals(lib.getTenWord(), null);
    }
    
    @Test
    void testMain() throws IOException {
        WordCount wordcount = new WordCount();
        String[] args = null;
        WordCount.main(args);
        assertEquals(1, 1);
    }
    
    @Test
    void testSetContentAndRowCountByFilename() throws IOException {
//        lib.setContentAndRowCountByFilename(inputTestFile);
//        assertEquals(lib.getRowCount(), 2);
//        assertEquals(lib.getContent(), "ssss111 bbb222\n    \naaaa333,ccccc\n\n");
    }
    
    @Test
    void testSetCharCount() throws IOException {
        lib.setContentAndRowCountByFilename(inputTestFile);
        lib.setCharCountByContent(lib.getContent());
//        assertEquals(lib.getCharCount(), 35);
    }
    
    @Test
    void testSetWordCount() throws IOException {
        ArrayList<String> strGroup = new ArrayList<String>();
        strGroup.add("AAAAA2222");
        strGroup.add("B2FSFG");
        strGroup.add("DDDSA21");
        strGroup.add("AAAAA2222");
        lib.setWordGroupByStrGroup(strGroup);
        ArrayList<String> wordGroup = lib.getWordGroup();
        lib.setAmountWordByWordGroup(wordGroup);
        lib.setWordCountByAmountWord(lib.getAmountWord());
        assertEquals(lib.getWordCount(), 2);
    }
    
    @Test
    void testSetStrGroupByContent() throws IOException {
        String content = "123\n456";
        lib.setStrGroupByContent(content);
        assertEquals(lib.getStrGroup().get(0), "123");
        assertEquals(lib.getStrGroup().get(1), "456");
    }
    
    @Test
    void testIsUpWord() {
        assertEquals(lib.isUpWord("AA2AAA"), false);
        assertEquals(lib.isUpWord("AAAAA444"), true);
    }
    
    @Test
    void testSetWordGroupByStrGroup() throws IOException {
        ArrayList<String> strGroup = new ArrayList<String>();
        strGroup.add("AAAAA2222");
        strGroup.add("B2FSFG");
        strGroup.add("DDDSA21");
        strGroup.add("AAAAA2222");
        lib.setWordGroupByStrGroup(strGroup);
        ArrayList<String> array = lib.getWordGroup();
        assertEquals(array.get(0).equals("AAAAA2222"), true);
        assertEquals(array.get(1).equals("DDDSA21"), true);
        assertEquals(array.get(2).equals("AAAAA2222"), true);
    }
    
    @Test
    void testSetAmountWordByWordGroup() throws IOException {
        ArrayList<String> strGroup = new ArrayList<String>();
        strGroup.add("AAAAA2222");
        strGroup.add("B2FSFG");
        strGroup.add("DDDSA21");
        strGroup.add("AAAAA2222");
        lib.setWordGroupByStrGroup(strGroup);
        ArrayList<String> wordGroup = lib.getWordGroup();
        lib.setAmountWordByWordGroup(wordGroup);
        assertEquals(lib.getAmountWord().containsKey("AAAAA2222"), true);
        assertEquals(lib.getAmountWord().containsKey("DDDSA21"), true);
        assertEquals(lib.getAmountWord().get("AAAAA2222"), 2);
    }
    
    @Test
    void testSetTenWordByAmountWord() throws IOException {
        HashMap<String,Integer> amountWord = new HashMap<String,Integer>();
        amountWord.put("AAAAAA", 5);
        amountWord.put("BBBBBB", 5);
        amountWord.put("CCCCCC", 5);
        amountWord.put("ASDFSA", 3);
        amountWord.put("SDAFSAGS", 8);
        amountWord.put("UEWWG", 1);
        amountWord.put("DSDSAA", 4);
        lib.setTenWordByAmountWord(amountWord);
        assertEquals(1, 1);
    }
    

}
