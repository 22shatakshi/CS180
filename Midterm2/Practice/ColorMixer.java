import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorMixer {
    public static Color[] readFile(String fileName) {
        int lineNumber = 0;
        String line = "";
        ArrayList<Integer> values = new ArrayList<>(); 
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            
            while (true) {
                line = bfr.readLine();
                if (line == null) 
                    break;
                else {
                    values.add(Integer.valueOf(line));
                    lineNumber++;
                }
            }
            bfr.close();
            if (lineNumber % 3 != 0)
                return null;
            else {
                Color[] colors = new Color[lineNumber/3];
                for(int i = 0; i < lineNumber/3; i++) {
                    for (int j=0; j < values.size(); j+=3) {
                        int red = values.get(j);
                        int green = values.get(j+1);
                        int blue = values.get(j+2);
                        colors[i] = new Color(red, green, blue);
                    }  
                }
                return colors;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean writeFile(Color[] colors, String fileName) {
        try {
            File f = new File(fileName);
            FileOutputStream fos = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(fos);
            if (f.isDirectory()) {
                pw.close();
                throw new Exception();
            }
            for (int i = 0; i < colors.length; i++) {
                if (i == colors.length - 1)
                    pw.print(colors[i].toString());
                else
                    pw.println(colors[i].toString());
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name of the color map.");
        String fileInputName = scan.nextLine();
        if(readFile(fileInputName) == null) {
            readFile(fileInputName);
            System.out.println("Either the file doesn't exist or the file is in the wrong format!");
        }
        else {
            System.out.println("Enter the filename to output the colors to.");
            String fileOutputName = scan.nextLine();
            if(writeFile(readFile(fileInputName), fileOutputName)) {
                writeFile(readFile(fileInputName), fileOutputName);
                System.out.println("The file was written to!");
            }
            else {
                writeFile(readFile(fileInputName), fileOutputName);
                System.out.println("There was an error writing to the file.");
            }
        }
    }
}