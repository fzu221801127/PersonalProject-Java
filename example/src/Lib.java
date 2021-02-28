import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Lib {
    private String inFilename;
    private String outFilename;
    private String content = "";
    private ArrayList<String> strGroup;
    private ArrayList<String> wordGroup;
    private HashMap<String,Integer> amountWord;
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
        setAmountWordByWordGroup(this.wordGroup);
        
        System.out.println("characters:\n" + getCharCount());
        System.out.println("words:\n");
        System.out.println("lines:\n" + getRowCount());
        System.out.println("content:\n" + getContent());
        
        System.out.println("strGroup:");
        for (String s : this.strGroup) {
            System.out.println(s);
        }
        System.out.println("wrodGroup:");
        for (String s : this.wordGroup) {
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
        this.strGroup = new ArrayList<String>();
        String s = content.toUpperCase();
        String[] ss = s.split("[^a-zA-Z0-9]");
        for (String str : ss) {
            this.strGroup.add(str);
        }
    }
    
    /*通过分割后的大写文本内容strGroup获取大写单词集合wordGroup*/
    public void setWordGroupByStrGroup(ArrayList<String> strGroup) {
        this.wordGroup = new ArrayList<String>();
        for(String s : strGroup) {
            if (isUpWord(s)) {
                this.wordGroup.add(s);
            }
        }
    }
    
    /*把单词集合wordGroup的每个单词作为key,出现次数作为value存到amoutWord里面*/
    public void setAmountWordByWordGroup(ArrayList<String> wordGroup) {
        this.amountWord = new HashMap<String,Integer>();
        for (String string : wordGroup) {
            if(!amountWord.containsKey(string)){
                amountWord.put(string,1);
            }else{
                amountWord.put(string, amountWord.get(string).intValue()+1);
            }
        }
    }
    
    /*判断一个字符串是否为大写单词*/
    public boolean isUpWord(String s) {
        if (s.length() >= 4) {
            char s1 = s.charAt(0);
            char s2 = s.charAt(1);
            char s3 = s.charAt(2);
            char s4 = s.charAt(3);
            if (s1 >= 'A' && s1 <= 'Z' && s2 >= 'A' && s2 <= 'Z' && s3 >= 'A' && s3 <= 'Z' && 
                    s4 >= 'A' && s4 <= 'Z')
            {
                return true;
            } else {
                return false;
            }
        } else {
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
    
    public ArrayList<String> getStrGroup() {
        return this.strGroup;
    }
    
    public ArrayList<String> getWordGroup(){
        return this.wordGroup;
    }
    
    public HashMap<String,Integer> getAmountWord(){
        return this.amountWord;
    }
    
    public void clear() {
        this.inFilename = null;
        this.outFilename = null;
        this.content = "";
        this.rowCount = 0;
        this.charCount = 0;
        this.strGroup = null;
        this.wordGroup = null;
        this.amountWord = null;
    }
    
}
