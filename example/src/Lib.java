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
    
    /*���п��Ƹ�����ʵ����Ŀ����*/
    public void WordCountControl() throws IOException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("����������:");
//        String str = in.next();
        
        inFilename = "C:/Users/����/Desktop/input.txt";
        outFilename = "C:/Users/����/Desktop/output.txt";
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
        String s = content.toUpperCase();
        this.strGroup = s.split("[^a-zA-Z0-9]");
    }
    
    public void setWordGroupByStrGroup(String[] strGroup) {
        
    }

    /*�ж�һ���ַ����Ƿ�Ϊ��д����*/
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
