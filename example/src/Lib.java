import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lib {
    private String inFilename;
    private String outFilename;
    private String content = "";
    private String[] strGroup;
    private String[] wordGroup;
    private int rowCount = 0;
    private int charCount = 0;
    
    /*集中控制各函数实现题目需求*/
    public void WordCountControl() throws IOException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入命令:");
//        String str = in.next();
        
        inFilename = "C:/Users/谷雨/Desktop/input.txt";
        outFilename = "C:/Users/谷雨/Desktop/output.txt";
        setContentAndRowCountByFilename(this.inFilename);
        setCharCountByContent(this.content);
        setStrGroupByContent(this.content);
        setWordGroupByStrGroup(this.strGroup);
        
        System.out.println("characters:\n" + getCharCount());
        System.out.println("words:\n");
        System.out.println("lines:\n" + getRowCount());
        System.out.println("content:\n" + getContent());
        
        System.out.println("strGroup:\n");
        for (String s : this.strGroup) {
            System.out.println(s);
        }
    }
    
    /*通过文件路径获取1.文件文本内容content;2.文本行数rowCount;*/
    public void setContentAndRowCountByFilename(String filename) throws IOException {
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
    
    /*通过文本内容content获取字符数CharCount*/
    public void setCharCountByContent(String content) {
        this.charCount = content.length();
    }
    
    /*通过文本内容content获取分割后的大写文本内容strGroup*/
    public void setStrGroupByContent(String content) {
        String s = content.toUpperCase();
        this.strGroup = s.split("[^a-zA-Z0-9]");
    }
    
    public void setWordGroupByStrGroup(String[] strGroup) {
        
    }

    /*判断一个字符串是否为大写单词*/
    public boolean isUpWord(String s) {
        char s1 = s.charAt(0);
        char s2 = s.charAt(1);
        char s3 = s.charAt(2);
        char s4 = s.charAt(3);
        if (s1 >= 'A' && s1 <= 'Z' && s2 >= 'A' && s2 <= 'Z' && s3 >= 'A' && s3 <= 'Z' && 
                s4 >= 'A' && s4 <= 'Z')
        {
            return true;
        }else {
            return false;
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
    
}
