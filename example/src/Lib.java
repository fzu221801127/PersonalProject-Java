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
        setContentByFilename(inFilename);
        setCharCount();
        System.out.println("characters:\n" + getCharCount());
        System.out.println("words:\n");
        System.out.println("lines:\n" + getRowCount());
        System.out.println("content:\n" + getContent());
    }
    
    /*通过文件路径获取文件文本内容并传入content中并得出文本行数rowCount*/
    public void setContentByFilename(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String s;
        
        /*读出每一行先去除中文再存入content中并决定是否需要rowCount++,这边题意看不太明白，我理解为中文不计入字符数即中文不算统计行数
                         时的非空白字符,即纯中文不算行。 */
        while((s = br.readLine()) != null) {
                //从s中去除非ascii字符
                s = s.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");
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
