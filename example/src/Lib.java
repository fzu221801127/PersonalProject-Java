import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lib {
    private String inFilename;
    private String outFilename;
    private String content;
    private int rowCount = 0;
    private int charCount = 0;
    
    /*���п��Ƹ�����ʵ����Ŀ����*/
    public void WordCountControl() throws IOException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("����������:");
//        String str = in.next();
        
        inFilename = "C:/Users/����/Desktop/new 1.txt";
        outFilename = "C:/Users/����/Desktop/new 2.txt";
//        getContentByFilename(inFilename);
    }
    
    /*ͨ���ļ�·����ȡ�ļ��ı����ݲ�����content�в��ó��ı�����rowCount*/
//    public void getContentByFilename(String filename) throws IOException {
//        FileReader fr = new FileReader(filename);
//        BufferedReader br = new BufferedReader(fr);
//        String s;
//        /*����ÿһ�д���content�в�rowCount++*/
//        while((s = br.readLine()) != null) {
//                content += s; 
//                rowCount ++;
//        }
//    }
    
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
    
}
