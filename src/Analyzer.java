import java.io.IOException;
import java.util.*;

public class Analyzer {
    public Queue<Node> queue = new LinkedList<>();
    private HashMap<String, String> map;

    public Analyzer() throws IOException, ClassNotFoundException {
        ReadFile readFile = new ReadFile();
        map = readFile.read_Hashmap("HashMAp.txt");
    }

    public  List<String> Trim(String st,char op){
        List<String> list = new LinkedList<>();
        String st1 = "";
        for (int i = 0; i <st.length(); i++) {
            st1 = st1 + st.charAt(i);
            if(st.charAt(i) == op){
                list.add(st1);
                st1 ="";
            }
        }
        return list;
    }

//    public String[] Trim1(String list, String op) {
//        String[] list1 = list.split(" ");
//        return list1;
//    }

//    public String[] tokenize(List<String> list) {
//        String[] tokens = new String[0];
//
//        for (int i = 0; i < list.size(); i++) {
//            List<String> secondArray = Trim(list.get(i), " ;");
//        }
//        return tokens;
//    }

    private boolean specialCharacter(String inputString) {

        String specialCharactersString = "!@#$%&',./:<>?[]^`|";
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (specialCharactersString.contains(Character.toString(ch))) {
//                System.out.println(inputString+ " contains special character");
                break;
            } else if (i == inputString.length() - 1) {
                return true;
            }

        }
        return false;
    }

    // check if identifier is valid
    private boolean isValid(String str) {
        if (!((str.charAt(0) >= 'a' && str.charAt(0) <= 'z') || (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') || str.charAt(0) == '_')) {
            return false;
            //invalid
        }
        for (int i = 1; i < str.length(); i++) {
            if (!((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                    || (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    || str.charAt(i) == '_'))
                return false;
        }
        // String is a valid identifier
        return true;
    }

    private List<String> convertList(List<String> st1, String op) {
        for (int j = 0; j < st1.size(); j++) {
            StringBuilder str2 = new StringBuilder();
            str2.append(st1.get(j) + op);
            st1.set(j, str2.toString());
        }
        return st1;
    }

//    public boolean Handler(String st){
//        boolean flag = false;
//        List<String> st1 = Arrays.asList(Trim(st, ";"));
////        st1 = convertList(st1, ";");
//
//        for (int j = 0; j < st1.size(); j++) {
//            String[] st2 = Trim(st1.get(j), "\\s");
//
//            for (int i = 0; i < st2.length-1; i++) {
//                if (map.containsValue(st2[i])) {
//                    Node node = new Node(st2[i], map.get(st2[i]));
//                    this.queue.add(node);
//                }
//                else if (isValid(st2[i])) {
//                    Node node = new Node(st2[i],"Identifier");
//                    this.queue.add(node);
//                }
//            }
//        }
//
//        return flag;
//    }
}
