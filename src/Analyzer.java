import java.io.IOException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public  List<String> Trim1(String list, char op) {
        List<String> list1 = Arrays.asList(list.split(" "));
        return list1;
    }
    public  List<String> Trim(String code){
        Pattern pat = Pattern.compile("\\w+|[<>(){}]");
        return  pat.matcher(code).results().map(MatchResult::group).collect(Collectors.toList());
    }

//    public String[] tokenize(List<String> list) {
//        String[] tokens = new String[0];
//
//        for (int i = 0; i < list.size(); i++) {
//            List<String> secondArray = Trim(list.get(i), " ;");
//        }
//        return tokens;
//    }

    private boolean specialCharacter(String inputString) {

        String specialCharactersString = "!@#$%&',./:<>?^`|";
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
    private  boolean brackets(char ch){
        if (ch == '(' || ch == ')' || ch =='{' || ch == '}'){
            return true;
        }
        return false;
    }

    public boolean Handler(String st){
        boolean flag = false;
        List<String> st1 = (Trim1(st, ' '));
        String temp = "";
//        st1 = convertList(st1, ";");

//        for (int j = 0; j < st1.size(); j++) {
//            String[] st2 = Trim(st1.get(j), ' ');
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

        for (int i = 0; i < st1.size(); i++) {


            System.out.println(st1.get(i));
            if (map.containsValue(st1.get(i))){
                Node node = new Node(st1.get(i),map.get(st1.get(i)));
                    this.queue.add(node);
                    flag =true;
            }else if (isValid(st1.get(i))){
                Node node = new Node(st1.get(i),"Identifier");
                    this.queue.add(node);
                    flag=true;
            }else {
                for (int j = 0; j < st1.get(i).length(); j++) {
                    // if it is letter
                    if (Character.isLetter(st1.get(i).charAt(j))){
                        temp = temp+ st1.get(i).charAt(j);
                    }
                    //todo case  if it is special character

                    // if the next character is not letter and map contains the value
                    if ( j<=st1.get(i).length()  &&  !Character.isLetter(st1.get(i).charAt(j+1))){
                        if (map.containsValue(temp)){
                            Node node = new Node(temp,map.get(st1.get(i)));
                            this.queue.add(node);
                            flag =true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public void  print(){
        System.out.println(queue.toString());
    }
}
