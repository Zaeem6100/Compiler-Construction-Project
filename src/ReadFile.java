import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadFile {

    public List readfile(String filename) throws IOException {
        List<String> list = new ArrayList();
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
            list.add(line);
        }
        fr.close();
        return list;
    }

    public HashMap<String, String> read_Hashmap(String filepath) throws IOException, ClassNotFoundException {
        HashMap<String, String> map = new HashMap<>();
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        map = (HashMap<String, String>) objectIn.readObject();
        System.out.println("The Object has been read from the file");
        objectIn.close();
        return map;
    }

    public void writeHashMap(HashMap<String, String> map, String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(map);
            objectOut.close();
            System.out.println("The Object  was successfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Token_Write(StringBuilder buffer, String filename) {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}