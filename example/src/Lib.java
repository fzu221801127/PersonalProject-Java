import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Lib {
    private String inFilename;
    private String outFilename;
    private String content = "";
    private ArrayList<String> strGroup;
    private ArrayList<String> wordGroup;
    private HashMap<String,Integer> amountWord;
    private HashMap<String,Integer> amountWord2;
    private ArrayList<String> tenWord;
    private int rowCount = 0;
    private int charCount = 0;
    private int wordCount = 0;
    
    /*集中控制各函数实现题目需求*/
    public void WordCountControl() throws IOException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入命令:");
//        String str = in.next();
        
        this.inFilename = "C:/Users/谷雨/Desktop/input.txt";
        this.outFilename = "C:/Users/谷雨/Desktop/output.txt";
        this.setContentAndRowCountByFilename(this.inFilename);
        this.setCharCountByContent(this.content);
        this.setStrGroupByContent(this.content);
        this.setWordGroupByStrGroup(this.strGroup);
        this.setAmountWordByWordGroup(this.wordGroup);
        this.setWordCountByAmountWord(this.getAmountWord());
        this.setTenWordByAmountWord(this.amountWord);
        
        System.out.println("characters:" + getCharCount());
        System.out.println("words:" + getWordCount());
        System.out.println("lines:" + getRowCount());
        for (String s : this.tenWord) {
            System.out.println(s+":"+this.amountWord2.get(s));
        }
//        System.out.println("------------------------------");
//        for (String s : this.amountWord2.keySet()) {
//            System.out.println(s+":"+this.amountWord2.get(s));
//        }
        
//        System.out.println("content:" + getContent());
        
//        System.out.println("strGroup:");
//        for (String s : this.strGroup) {
//            System.out.println(s);
//        }
//        System.out.println("wrodGroup:");
//        for (String s : this.wordGroup) {
//            System.out.println(s);
//        }
        
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
        this.amountWord2 = new HashMap<String,Integer>();
        for (String string : wordGroup) {
            if(!amountWord.containsKey(string)){
                amountWord.put(string,1);
            }else{
                amountWord.put(string, amountWord.get(string).intValue()+1);
            }
        }
        for (String string : wordGroup) {
            if(!amountWord2.containsKey(string)){
                amountWord2.put(string,1);
            }else{
                amountWord2.put(string, amountWord2.get(string).intValue()+1);
            }
        }
    }
    
    public void setWordCountByAmountWord(HashMap<String,Integer> amountWord) {
        this.wordCount = amountWord.size();
    }
    
    public void setTenWordByAmountWord(HashMap<String,Integer> amountWord) {
        this.tenWord = new ArrayList<String>();
        String maxWord = "";
        if (amountWord.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                for (String s : amountWord.keySet()) {
                     if (maxWord.isEmpty()) {
                         maxWord = s;
                     }
                     else {
                         if (amountWord.get(maxWord) < amountWord.get(s)) {
                             maxWord = s;
                         }
                         else if (amountWord.get(maxWord) > amountWord.get(s)) {}
                         else if (amountWord.get(maxWord) == amountWord.get(s)){
                             if (maxWord.compareTo(s) > 0) {
                                 maxWord = s;
                             }
                             else {}
                         }
                     }
                }
                amountWord.remove(maxWord);
                this.tenWord.add(maxWord);
                maxWord = "";
            }
        }
        else {
            int size = amountWord.size();
            for (int i = 0; i < size; i++) {
                for (String s : amountWord.keySet()) {
                    if (maxWord.isEmpty()) {
                        maxWord = s;
                    }
                    else {
                        if (amountWord.get(maxWord) < amountWord.get(s)) {
                            maxWord = s;
                        }
                        else if (amountWord.get(maxWord) > amountWord.get(s)) {}
                        else if (amountWord.get(maxWord) == amountWord.get(s)){
                            if (maxWord.compareTo(s) > 0) {
                                maxWord = s;
                            }
                            else {}
                        }
                    }
               }
               amountWord.remove(maxWord);
               this.tenWord.add(maxWord);
               maxWord = "";
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
    
    public int getWordCount() {
        return this.wordCount;
    }
    
    public ArrayList<String> getStrGroup() {
        return this.strGroup;
    }
    
    public ArrayList<String> getWordGroup(){
        return this.wordGroup;
    }
    
    public ArrayList<String> getTenWord(){
        return this.tenWord;
    }
    
    public HashMap<String,Integer> getAmountWord(){
        return this.amountWord;
    }
    
    public HashMap<String,Integer> getAmountWord2(){
        return this.amountWord2;
    }
    
    public void clear() {
        this.content = "";
        this.wordCount = 0;
        this.rowCount = 0;
        this.charCount = 0;
        this.strGroup = null;
        this.wordGroup = null;
        this.amountWord = null;
        this.amountWord2 = null;
        this.tenWord = null;
    }
       
}
