import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
  
public class Encryption { 
    public static void main(String[] args) throws FileNotFoundException, IOException { 

        if (args.length < 2) {
            System.out.println("Must enter two arguments (filename and encryption key)");
            return;
        }

        String filename = args[0];
        int key = Integer.parseInt(args[1]);
        encrypt(filename, key);
    }

    public static void encrypt(String filename, int key) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(filename); 
                             
        // Converting Image into byte array, create an array of same size as Image size
                             
        byte data[] = new byte[fis.available()]; 
        // Read the array 
        fis.read(data);
        performXOR(data, key);
     
        // Opening a file for writing purpose 
        String newFilename = getFilenameWithoutExtension(filename)+"-encrypted.png";
        FileOutputStream fos = new FileOutputStream(newFilename);
                             
        // Writing new byte array value to image which 
        // will Encrypt it. 
                             
        fos.write(data); 
                             
        // Closing file 
        fos.close(); 
        fis.close(); 
        System.out.println("Encyption Done..."); 
    }

    public static String getFilenameWithoutExtension(String filename) {
        int dotIndex = filename.indexOf(".");
        String newFilename = filename.substring(0, dotIndex);
        return newFilename;
    }

    public static void performXOR(byte data[], int key) {
        // Performing an XOR operation on each value of 
        // byte array due to which every value of Image 
        // will change.
        int i = 0;
        for (byte b : data) { 
            data[i] = (byte)(b ^ key); 
            i++; 
        } 
    }
}