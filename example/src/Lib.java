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
    
    /*���п��Ƹ�����ʵ����Ŀ����*/
    public void WordCountControl() throws IOException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("����������:");
//        String str = in.next();
        
        inFilename = "C:/Users/����/Desktop/input.txt";
        outFilename = "C:/Users/����/Desktop/output.txt";
        setContentByFilename(inFilename);
        setCharCount();
        System.out.println("characters:\n" + getCharCount());
        System.out.println("words:\n");
        System.out.println("lines:\n" + getRowCount());
        System.out.println("content:\n" + getContent());
    }
    
    /*ͨ���ļ�·����ȡ�ļ��ı����ݲ�����content�в��ó��ı�����rowCount*/
    public void setContentByFilename(String filename) throws IOException {
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
    
    //ͨ���ַ���content�õ��ı��ַ���charCount
    public void setCharCount() {
        this.charCount = this.content.length();
    }
    
}
