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




/**
 *
 * @author micae
 */
public class CardContainer {

    //Aqui eu tô inicializando as variáveis que vou utilizar
    JPanel padding = new JPanel();
    JPanel newTaskCard = new JPanel();
    boolean done = false;
    boolean selected = false;

    //Aqui eu estou criando o construtor da classe, ou seja, a função que vai ser iniciada quando a classe for instanciada 
    public CardContainer(String title, String description, JPanel cardsContainer) {

        //Essa parte é toda de estilização - não precisa se apegar nisso aqui

        //Aqui eu tô criando a estilização das fontes
        Font titleFont = new Font("Segoe UI Black", Font.PLAIN, 11);
        Font descriptionFont = new Font("Segoe UI Emoji", Font.PLAIN, 10);
        Font timeFont = new Font("Segoe UI Emoji", Font.PLAIN, 9);

        
        //Aqui eu tô criando um textare, que vai ser o textarea do título
        JTextArea newTitle = new JTextArea();
        newTitle.setFont(titleFont);
        
        
        //Aqui eu tô criando o textarea da descrição
        JTextArea newDescription = new JTextArea();
        newDescription.setFont(descriptionFont);


        //Estilizando o cartãozinho (aqui o container pai é o padding);
        padding.add(newTaskCard);
        padding.setPreferredSize(new Dimension(170, 90));
        padding.setLayout(new FlowLayout(FlowLayout.CENTER));
        padding.setBackground(new java.awt.Color(211, 220, 255));
        padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));

        

        //estilizando newTaskCard(ela é a parte de dentro do cartãozinho)
        
        newTaskCard.setLayout(new BoxLayout(newTaskCard, BoxLayout.Y_AXIS));
        newTaskCard.setPreferredSize(new Dimension(160, 80));
        newTaskCard.setBackground(null);
        newTaskCard.setForeground(new java.awt.Color(255, 255, 255));
        newTaskCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        //aqui eu tô setando o title e o description recebidos por parâmetro ao newTitle, e ao newDescription que foi a variavél que a gente criou lá em cima
        newTitle.setText(title);
        newDescription.setText(description);


        //isso aqui é estilização também.. pra fazer o texto quebrar a linha quando chegar no final do container
        newTitle.setLineWrap(true);
        newDescription.setLineWrap(true);
        
        //mais estilização
        newTitle.setBackground(null); // tirando o background do title
        newDescription.setBackground(null); //tirando o background do description

        //Setando o tipo de cursor que vai aparecer quando o usuário passar o mouse por cima, do título e da descrição. Nesse caso, o cursor de texto
        newTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        newDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));  
  
        
        //por fim, eu tu adicionando o newTitle e o newDescription ao newTaskCard, que é o novo cartão criado
        newTaskCard.add(newTitle);
        newTaskCard.add(newDescription);
        
        
        
        //Não precisa se prender nessa parte, tô só pegando a hora atual

        LocalDate data = LocalDate.now();
        // Formata a data no formato desejado
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDate = data.format(formatadorData);

        // Obtém a hora atual
        LocalTime hora = LocalTime.now();
        // Formata a hora no formato desejado
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
        String formatedHour = hora.format(formatadorHora);
        

        //Aqui eu crio um label de texto com o nome time
        JLabel time = new JLabel();
        
        //Aqui eu seto nele a data e a hora
        time.setText(formatedDate + " - " + formatedHour);

        //Nessa linha eu seto a fonte que já foi definida lá em cima
        time.setFont(timeFont);

        //Por fim, eu adiciono também a variável time ao novo cartão 
        newTaskCard.add(time);
    }


    //Nessa parte eu lido com a parte de selecionar, desselecionar, deletar e marcar como concluída
    

    //nessa primeira de deletar eu verifico primeiro se o selected é verdadeiro, pq se ele for verdadeiro significa que o cartão foi selecionado, portando eu tenho q deletá-lo
    public void delete(JPanel cardsContainer) {
        if(selected) {
            //aqui eu simplesmente removo o cartãozinho que é o padding
            cardsContainer.remove(padding);

            //e aqui eu atualizo o cardContainer
            cardsContainer.revalidate();
            cardsContainer.repaint();
        }
    }
    
    //No caso do done, se ele marcar como concluída eu vou simplesmente mudar ele de cor
    public void done() {
        //verifico primeiro se o cartão tá selecionado
        if(selected) {

            //essa parte é estilização
            this.padding.setBackground(new java.awt.Color(226, 255, 226));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 153)));

            //e por fim eu tô mudando o selected pra false e o done pra verdadeiro.. no done a gente tá guardando a informação de q o card foi marcado como concluído ou não
            this.selected = false;
            this.done = true;
        }
        
    }

    //esse é o método que vai selecionar o cartão
    protected void selected () {
        //pra selecionar ele eu apenas mudo ele de cor
        //como o cartão tem duas versões, a versão não consluída e a versão concluída, ele vai trocar de cor de duas formas diferentes
        //então a gente tem que verficiar se o cartão está marcado como concluído ou não

        if(!this.done) {
            //se o done for falso a gente muda ele pra um roxo mais escuro
            this.padding.setBackground(new java.awt.Color(185, 183, 255));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
            this.selected = true;
        }else {
            //se o done for verdadeir, ele foi marcado como concluído, então a gente um verde mais escuro
            this.padding.setBackground(new java.awt.Color(173, 255, 173));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153)));
            
            // não esquecendo de mudar o selected para true, já q ele foi clicado
            this.selected = true; 

        }
        
    }
    
    //a parte de desselecionar é muito semelhante, a gete só vai trocar as cores de lugar e mnudar o selected para false, já que o usuário desselecionou
    protected void unselected() {
        
        if(!done) {
            //se done for false, o cartão não vou marcado como conluído, então a gente muda ele pra cor roxa clara
            this.padding.setBackground(new java.awt.Color(211, 220, 255));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));
            this.selected = false;
        }else {
            //se done for true, o cartão foi marcado como concluído, então a gente muda ele pra cor roxa clara
            this.padding.setBackground(new java.awt.Color(226, 255, 226));
            this.padding.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 153)));
            this.selected = false;
        }
        
    }


    //Por fim, esse método get retorna o cartãozinho.. a gente usa esse método lá na classe home pra pegar o cartão e adicionar ao container cardsContainer.
    public JPanel getNewTaskCard() {
        return padding;
    }
}
