import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String> list =  readFile.readfile("test.cpp");
        System.out.println(list.toString());
        Analyzer analyzer = new Analyzer();
        List<String>list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
             List<String> templist =  analyzer.Trim(list.get(i),' ');
            list1.addAll(templist);

        }

        System.out.println(list1.toString());

        for (int i = 0; i <list.size() ; i++) {
            analyzer.Handler(list.get(i));
        }

        analyzer.print();

    }
}