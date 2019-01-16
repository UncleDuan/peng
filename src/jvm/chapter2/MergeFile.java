package jvm.chapter2;

import java.io.*;

/**
 * Created by ionolab-DP on 2019/1/2.
 * 交替合并a.txt和b.txt文件中的单词。
 */
public class MergeFile {
    public static void main(String[] args) throws IOException {
        MyFileManager myFileManagerA=new MyFileManager("C:\\Users\\ionolab-DP\\IdeaProjects\\interview\\a.txt","\\s");
        MyFileManager myFileManagerB=new MyFileManager("C:\\Users\\ionolab-DP\\IdeaProjects\\interview\\b.txt","\\s");
        FileWriter fileWriter=new FileWriter("c.txt");
        String aWord=null;
        String bWord=null;
        while ((aWord= myFileManagerA.nextWord())!=null){
            fileWriter.write(aWord+" ");
            bWord=myFileManagerB.nextWord();
            if (bWord!=null){
                fileWriter.write(bWord+" ");
            }
        }
        fileWriter.close();
    }
}

class MyFileManager{
    String[] words=null;
    int pos=0;
    public MyFileManager(String filename,String regex) throws IOException {
        File f= new File(filename);
        FileReader fileReader=new FileReader(f);
        char[] buf=new char[(int)f.length()];
        int len=fileReader.read(buf);
        String results=new String (buf,0,len);
        words=results.split(regex);
        fileReader.close();
    }

    public String nextWord(){
        if (pos==words.length){
            return null;
        }
        return words[pos++];
    }
}
