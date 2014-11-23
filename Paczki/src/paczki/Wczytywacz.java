/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Antah
 */
public class Wczytywacz {
    public static int loadGen0() throws FileNotFoundException, IOException{
      String s = WireworldGUI.textFieldData.getText();
      File file;
      Scanner in;
      try{
          file = new File(s);
          in = new Scanner(file);
      } catch(Exception ex) {
          JOptionPane.showMessageDialog(frame,
                            "Couldn't open file. Try restarting and checking file name.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
          return 0;
      }
      int w, h, n;
      
      w = in.nextInt();
      h = in.nextInt();
      
      Generation.initialize(w, h);
      
      for(int i = 0; i < Generation.height; i++){
          for(int j = 0; j < Generation.width; j++){
              try{
                  n = in.nextInt();
                  switch(n) {
                  case 0: Generation.tabA[i][j] = new EmptyCell();
                        break;
                  case 1: Generation.tabA[i][j] = new Conductor();
                        break;
                  case 2: Generation.tabA[i][j] = new Tail();
                        break;
                  case 3: Generation.tabA[i][j] = new Head();
                      break;
              }
              } catch(Exception ex) {
                  Generation.tabA[i][j] = new EmptyCell();
              }
          }
      }
      return 1;
  }
    public static void openFileChooser(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File path = chooser.getSelectedFile();
        WireworldGUI.textFieldData.setText(path.getPath());
        System.out.println(WireworldGUI.textFieldData.getText());
    }
}
