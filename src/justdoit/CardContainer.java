/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package justdoit;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextArea;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Cursor;




/**
 *
 * @author micae
 */
public class CardContainer {
    JPanel padding = new JPanel();
    JPanel newTaskCard = new JPanel();
    boolean done = false;

    boolean selected = false;

    public CardContainer(String title, String description, JPanel cardsContainer) {
        padding.add(newTaskCard);
        padding.setPreferredSize(new Dimension(170, 90));
        padding.setLayout(new FlowLayout(FlowLayout.CENTER));
        padding.setBackground(new java.awt.Color(211, 220, 255));
        padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));


        
        Font titleFont = new Font("Segoe UI Black", Font.PLAIN, 11);
        Font descriptionFont = new Font("Segoe UI Emoji", Font.PLAIN, 10);
        Font timeFont = new Font("Segoe UI Emoji", Font.PLAIN, 9);

        
        
        JTextArea newTitle = new JTextArea();
        newTitle.setFont(titleFont);
        
        
        
        JTextArea newDescription = new JTextArea();
        newDescription.setFont(descriptionFont);

        
        
        //estilizando newTaskCard
        
        newTaskCard.setLayout(new BoxLayout(newTaskCard, BoxLayout.Y_AXIS));
        newTaskCard.setPreferredSize(new Dimension(160, 80));
        newTaskCard.setBackground(null);

        
        
        newTaskCard.setForeground(new java.awt.Color(255, 255, 255));
        newTaskCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        newTitle.setText(title);
        newTitle.setLineWrap(true);
        newDescription.setLineWrap(true);
        
        newDescription.setText(description);
        
        newTitle.setBackground(null);
        newDescription.setBackground(null);
        newTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        
        
        newTaskCard.add(newTitle);
        newTaskCard.add(newDescription);
        
        //pegando a hora
        
        LocalDate data = LocalDate.now();
        // Formata a data no formato desejado
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDate = data.format(formatadorData);

        // Obtém a hora atual
        LocalTime hora = LocalTime.now();
        // Formata a hora no formato desejado
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
        String formatedHour = hora.format(formatadorHora);
        
        JLabel time = new JLabel();
        
        time.setText(formatedDate + " - " + formatedHour);
        time.setFont(timeFont);
        newTaskCard.add(time);
        
       
        

    }
    
    public void delete(JPanel cardsContainer) {
        if(selected) {
            cardsContainer.remove(padding);
            cardsContainer.revalidate();
            cardsContainer.repaint();
        }
    }
    
    public void done() {
        if(selected) {
            this.padding.setBackground(new java.awt.Color(226, 255, 226));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 153)));
            this.selected = false;
            this.done = true;
        }
        
    }
    protected void selected () {
        
        if(!this.done) {
            this.padding.setBackground(new java.awt.Color(185, 183, 255));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
            this.selected = true;
        }else {
            this.padding.setBackground(new java.awt.Color(173, 255, 173));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153)));
            this.selected = true;

        }
        
    }
    
    protected void unselected() {
        
        if(!done) {
            this.padding.setBackground(new java.awt.Color(211, 220, 255));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));
            this.selected = false;
        }else {
            this.padding.setBackground(new java.awt.Color(226, 255, 226));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 153)));
            this.selected = false;
        }
        
    }
    
    public JPanel getNewTaskCard() {
        return padding;
    }
}
