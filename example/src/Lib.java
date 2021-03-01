import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    private HashMap<String,Integer> amountWord2;
    private ArrayList<String> tenWord;
    private int rowCount = 0;
    private int charCount = 0;
    private int wordCount = 0;
    
    /*���п��Ƹ�����ʵ����Ŀ����*/
    public void WordCountControl() throws IOException {
        Scanner in = new Scanner(System.in);
        
        System.out.println("������input�ļ�·��:");
        this.inFilename = in.next();
        File f1 = new File(this.inFilename);
        while (!f1.exists()) {
            System.out.println("�Ҳ���·��Ϊ " + this.inFilename + " ���ļ�,����������input�ļ�·��:");
            this.inFilename = in.next();
            f1 = new File(this.inFilename);
        }
        
        System.out.println("������output�ļ�·��:");
        this.outFilename = in.next();
        File f2 = new File(this.outFilename);
        while (!f2.exists()) {
            System.out.println("�Ҳ���·��Ϊ " + this.outFilename + " ���ļ�,����������output�ļ�·��:");
            this.outFilename = in.next();
            f2 = new File(this.outFilename);
        }
        
        //this.inFilename = "C:/Users/����/Desktop/input.txt";
        //this.outFilename = "C:/Users/����/Desktop/output.txt";
        this.setContentAndRowCountByFilename(this.inFilename);
        this.setCharCountByContent(this.content);
        this.setStrGroupByContent(this.content);
        this.setWordGroupByStrGroup(this.strGroup);
        this.setAmountWordByWordGroup(this.wordGroup);
        this.setWordCountByAmountWord(this.getAmountWord());
        this.setTenWordByAmountWord(this.amountWord);
        
        String temporaryData1 = "characters:" + getCharCount() + "\n" + "words:" + getWordCount() + "\n" +
                "lines:" + getRowCount() + "\n";
        ArrayList<String> temporaryData2 = this.tenWord;
        this.outputTofile(this.outFilename, temporaryData1, temporaryData2);
        
        System.out.println("characters:" + getCharCount());
        System.out.println("words:" + getWordCount());
        System.out.println("lines:" + getRowCount());
        for (String s : this.tenWord) {
            System.out.println(s.toLowerCase()+":"+this.amountWord2.get(s));
        }
        
    }
    
    /*ͨ���ļ�·����ȡ1.�ļ��ı�����content;2.�ı�����rowCount;*/
    public void setContentAndRowCountByFilename(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String s;
        
        /*����ÿһ����ȥ�������ٴ���content�в������Ƿ���ҪrowCount++,������⿴��̫���ף������Ϊ���Ĳ������ַ��������Ĳ���ͳ������
                         ʱ�ķǿհ��ַ�,�������Ĳ����С� */
        while((s = br.readLine()) != null) {
                //��s��ȥ����ascii�ַ�
                s = s.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");
                content += s; 
                content += "\n";
                
                if (!s.replaceAll(" ", "").isEmpty()) {
                    rowCount ++;
                }
        }
    }
    
    /*ͨ���ı�����content��ȡ�ַ���CharCount*/
    public void setCharCountByContent(String content) {
        this.charCount = content.length();
    }
    
    /*ͨ���ı�����content��ȡ�ָ��Ĵ�д�ı�����strGroup*/
    public void setStrGroupByContent(String content) {
        this.strGroup = new ArrayList<String>();
        String s = content.toUpperCase();
        String[] ss = s.split("[^a-zA-Z0-9]");
        for (String str : ss) {
            this.strGroup.add(str);
        }
    }
    
    /*ͨ���ָ��Ĵ�д�ı�����strGroup��ȡ��д���ʼ���wordGroup*/
    public void setWordGroupByStrGroup(ArrayList<String> strGroup) {
        this.wordGroup = new ArrayList<String>();
        for(String s : strGroup) {
            if (isUpWord(s)) {
                this.wordGroup.add(s);
            }
        }
    }
    
    /*�ѵ��ʼ���wordGroup��ÿ��������Ϊkey,���ִ�����Ϊvalue�浽amoutWord����*/
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
    
    /*��ȡ��Ƶ��ߵ�ʮ������*/
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
    
    /*�ж�һ���ַ����Ƿ�Ϊ��д����*/
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
       
    public void outputTofile (String filename, String data, ArrayList<String> data2) throws IOException {
        File file = new File(filename);
        FileWriter fileWritter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fileWritter);
        bw.write(data);
        for (String s : data2) {
            bw.write(s.toLowerCase()+":"+this.amountWord2.get(s)+"\n");
        }
        bw.close();
        System.out.println("Output to " + filename + " success");
    }
    
}