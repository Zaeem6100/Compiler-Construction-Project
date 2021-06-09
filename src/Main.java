import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ReadFile readFile = new ReadFile();
//        List<String> list =  readFile.readfile("test.cpp");
//        System.out.println(list.toString());
        

       Analyzer analyzer = new Analyzer();
//        System.out.println(analyzer.Trim("cout << Hello world "));


        List<String>list1 =  analyzer.Trim("int a=12 ;int b;int c;",' ');
        System.out.println(list1.toString());

//        for (int i = 0; i <list.size() ; i++) {
            analyzer.Handler1("int a ;int b;int c;");
//        }

        analyzer.print();

        System.out.println("\n\n\n\n\n\n\n" +analyzer.getTest());
    }
}