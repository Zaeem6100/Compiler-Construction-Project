import java.util.HashMap;

public class Entry {
    HashMap<String,String> map ;
    public void  InputHashMap(){
        HashMap<String,String> map = new HashMap<>() ;
        map.put("int","keyword");
        map.put("void","keyword");
        map.put("main","keyword");
        map.put("cout","keyword");
        map.put("cin","keyword");
        map.put("+","operator");
        map.put("=","operator");
        map.put("*","operator");
        map.put("<<","operator");
        map.put(">>","operator");
        map.put(";","punctuation");
        map.put("(","punctuation");
        map.put(")","punctuation");
        map.put("{","punctuation");
        map.put(",","punctuation");
        map.put("}","punctuation");
        map.put(" ","delimiters");
        map.put("\t","delimiters");
        map.put("\n","delimiters");
        ReadFile readFile = new ReadFile();
        readFile.writeHashMap(map,"HashMAp.txt");
    }

}