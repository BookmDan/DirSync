// Daniel Oh 
// Nov 20, 2022

package DirSync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class DirSync {

  private void fileCopy(File src, File dest)throws FileNotFoundException, IOException {
    InputStream in = null;
    OutputStream out = null;

    try {
      in = new FileInputStream(src);
      out = new FileOutputStream(dest);

      byte[] buffer = new byte[1024];
      int lengthOfDir;
      while(( lengthOfDir = in.read(buffer)) > 0)
      {
        out.write(buffer, 0, lengthOfDir);
      }
    }
    finally
    {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
    System.out.println("File copied " + src + " to " + dest);
  }

  public void copyDir(File src, File dest) throws IOException {
    // this.setSrc(src);
    // this.setDest(dest);

    if (src.isDirectory()) {
      if (!dest.exists()) {
        dest.mkdir();
        System.out.println("Directory copied from " + src + " to " + dest);
      }

      // get all subdirectories
      String[] paths = src.list();

      for (String fileName : paths) {
        File srcFile = new File(src, fileName);
        File destFile = new File(dest, fileName);
        // recursive copy to copy each file within src directory
        copyDir(srcFile, destFile);
      } 
    } else {
      fileCopy(src, dest);
    }
  }

  public static void main(String[] args) {
    Scanner scan = null;
    try {
      scan = new Scanner(System.in);
      
      String src = scan.next();
      String dest = scan.next();

      File srcDir = new File("./" + src);
      File destDir = new File("./" + dest);

      if (!srcDir.exists()) {
        srcDir.mkdirs();
        System.out.println("Directory does not exist.");
        System.out.println("New directory created.");
      }
      else {
        DirSync file = new DirSync();
        // calls above method to copy subdirectories in srcDir -> destDir
        file.copyDir(srcDir, destDir);
        System.out.println("Directory synced!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (scan != null) 
        scan.close();
    }
  }
}
