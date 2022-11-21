package DirSync;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;

public class DirSync {
  private static String src;
  private static String dest;

  // default 
  public void copyDir() {
    copyDir(getSrc(), getDest(), true);
  }

  public void copyDir(String src, String dest, boolean overWrite) {
    this.setSrc(src);
    this.setDest(dest);

    Directory

  }

  public static void main(String[] args) {


    String[] paths;
    try {
      File file = new File("./temp1/tempFile.java");
      // get all subdirectories
      paths = file.list(); // list method returns array of strings of file directories
      
      if (!src.exists()) {
        System.out.println("directory does not exist.");

      }
      else {

      }
      HashMap<String, String> subDir2 = new HashMap<String, String>();

      for(String path : paths){
        // store, copy src path files into dest path 
       subDir2.put(dest, path);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  // parse files 

  // source 

  // destination


  // call or return 

  // copy files 
  // copy dir

}
