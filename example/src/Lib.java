import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lib {
    private String inFilename;
    private String outFilename;
    private String content = "";
    private int rowCount = 0;
    private int charCount = 0;
    
    /*集中控制各函数实现题目需求*/
    public void WordCountControl() throws IOException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入命令:");
//        String str = in.next();
        
        inFilename = "C:/Users/谷雨/Desktop/input.txt";
        outFilename = "C:/Users/谷雨/Desktop/output.txt";
        getContentByFilename(inFilename);
        setCharCount();
        System.out.println("lines:\n" + getRowCount());
        System.out.println("characters:\n" + getCharCount());
        System.out.println("content:\n" + getContent());
    }
    
    /*通过文件路径获取文件文本内容并传入content中并得出文本行数rowCount*/
    public void getContentByFilename(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String s;
        /*读出每一行存入content中并rowCount++*/
        while((s = br.readLine()) != null) {
                content += s; 
                content += "\n";
                if (!s.replaceAll(" ", "").isEmpty()) {
                    rowCount ++;
                }
        }
    }
    
    public String getInfilename() {
        return this.inFilename;
    }
    
    public String getOutfilename() {
        return this.outFilename;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public int getRowCount() {
        return this.rowCount;
    }
    
    public int getCharCount() {
        return this.charCount;
    }
    
    public void clear() {
        this.inFilename = null;
        this.outFilename = null;
        this.content = "";
        this.rowCount = 0;
        this.charCount = 0;
    }
    
    //通过字符串content得到文本字符数charCount
    public void setCharCount() {
        this.charCount = this.content.length();
    }
    
}
