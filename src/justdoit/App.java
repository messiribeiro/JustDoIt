/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package justdoit;

import javax.swing.JFrame; 
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author micae
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        

        
        //Instanciando a classe Home
        Home home = new Home();

        //Com o setResizable(false) não deixamos o usuário redimensionar a janela
        home.setResizable(false);

        //Setando oq acontecerá quando o usuário clicar no X, nesse caso, o aplicativo vai fechar
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        home.setLocationRelativeTo(null);

        //Setando a visibilidade do frame Home como true
        home.setVisible(true);
        
        
        
        
        
        
    }
    
}
