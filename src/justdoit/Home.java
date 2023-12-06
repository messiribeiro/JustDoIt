/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package justdoit;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


/**
 *
 * @author micae
 */
public class Home extends javax.swing.JFrame {

    //Nessa linha eu tô criando um vetor chamado instances que armazena valores do tipo CardContainer.. CardContainer é a classe que eu criei pra criar novos cards
    private static List<CardContainer> instances = new ArrayList<>();
    
    
    /**
     * Creates new form Home1
     */
    public Home() {
        initComponents();
        addButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);
        editButton.setFocusPainted(false);
        

        //Nessa parte eu estou adicionando o evento addMouseListener ao appContainer para verificar quando o usuário clicou no appContainer
        appContainer.addMouseListener(new MouseAdapter() {
        @Override
            //Nessa parte eu tô fazendo com q o appContainer fique em foco.
            //Eu fiz isso pra que quando o usuário clique no Texto pra editar e depois clique fora dele, o foco saia do Texto e vá para o appContainer, fazendo com q ele pare de editar o texto
            public void mouseClicked(MouseEvent e) {
                appContainer.requestFocusInWindow();
            }
        });
        
       

        
        
        
       
    }
    

    //Aqui eu criei um método pra criar uma nova Task(tarefa)
    public static void addNewTask(String title, String description, Home home) {
        //Nessa primeira linha eu instancio a classe CardContainer
        //Essa classe é a classe que cria um nova cartãozinho pra task
        CardContainer cardContainer = new CardContainer(title, description, home.cardsContainer);
        
        //Nessa linha eu tô adicinando a instância cardContainer ao vetor instances.. isso vai acontecer toda vez que essa função for executada, ou seja, sempre q o usuário
        //criar uma nova task, a instancia da classe criada vai ser adicionada ao vetor instances.
        instances.add(cardContainer);


        //Nessa linha eu tô criando uma variável do tipo JPanel (JPanel é aquele container branco que tu coloca na aba desing)
        //Eu atribuo à variável newTask cardContainer.getNewTaskCard(). Esse método vai me retornar o cartãozinho da task.
        JPanel newTaskCard = cardContainer.getNewTaskCard();
        

        //aqui é aquele mesmo esquema q eu fiz lá em cima com a parada do foco, mas dessa vez é o no newTaskCard, que é o cartãozinho
        newTaskCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newTaskCard.requestFocusInWindow();
            }
        });
        



        //Nessa parte eu tô adicionando um evento de mouseListener para verificar quando o usuário vai clicar no newTaskCard(que é o cartãozinho)
        newTaskCard.addMouseListener(new MouseAdapter() {    
             @Override
                
                public void mouseClicked(MouseEvent e) {
                    //Quando ele clicar, eu vou verficar se a variável selected dentro da classe cardContainer (que é a classe que cria o cartãozinho) é true ou false
                    if(cardContainer.selected) {
                        //Se for true eu chamo o método unselected() que vai deselecionar o cartãozinho
                        cardContainer.unselected();

                        // se for falso, significa que o cartãozinho não tá selecionado, por isso, eu chamo o método selected() para selecionar ele
                    }else cardContainer.selected();
                }
        });
        
        //Finalmente, nessa linha, eu tô adicionando o newTaskCard ao meu container que guarda todos os cartõezinhos, ou seja, eu tô acidionando mais um cartão 
        home.cardsContainer.add(newTaskCard);
        
        //Essas duas linhas server para atualizar o container dos cartõeszinhos
        home.cardsContainer.revalidate();
        home.cardsContainer.repaint();

        //Aqui nessa linha eu tô setando a visibilidade da mensagem "suas tasks aparecerão aqui" como false 
        home.message.setVisible(false);

        //e nessa eu tô setando a visibilidade do texto "Tasks" como true, pra q ele aparece assim que a frase de cima sumir
        home.h1.setVisible(true);
        
        

        Color h1Color = new Color(90, 90, 90);
        home.h1.setForeground(h1Color);

        //Essa parte tem a ver a estilização.. mas aqui eu tô setando o layout do cardsContainer como flex alinhando os elementos da esquerda pra direita.. dessa forma os cartões serão
        //adicionados da esquerda pra direita e de cima pra baixo.
        home.cardsContainer.setLayout(new FlowLayout(FlowLayout.LEFT));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appContainer = new javax.swing.JPanel();
        cardsContainer = new javax.swing.JPanel();
        message = new javax.swing.JLabel();
        menuContainer = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        h1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(598, 399));

        appContainer.setBackground(new java.awt.Color(234, 234, 234));
        appContainer.setMinimumSize(new java.awt.Dimension(598, 399));

        cardsContainer.setBackground(new java.awt.Color(234, 234, 234));
        cardsContainer.setMaximumSize(new java.awt.Dimension(352, 763));
        cardsContainer.setMinimumSize(new java.awt.Dimension(352, 763));

        message.setForeground(new java.awt.Color(54, 54, 54));
        message.setText("Suas Tasks Aparecerão aqui :)");
        cardsContainer.add(message);

        menuContainer.setBackground(new java.awt.Color(248, 248, 248));
        menuContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        addButton.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        addButton.setForeground(new java.awt.Color(79, 79, 79));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/justdoit/assets/plus.png"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(79, 79, 79));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/justdoit/assets/trash.png"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        editButton.setForeground(new java.awt.Color(79, 79, 79));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/justdoit/assets/check.png"))); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuContainerLayout = new javax.swing.GroupLayout(menuContainer);
        menuContainer.setLayout(menuContainerLayout);
        menuContainerLayout.setHorizontalGroup(
            menuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuContainerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(menuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        menuContainerLayout.setVerticalGroup(
            menuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuContainerLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(135, 135, 135));
        jLabel1.setText("JUST DO IT");

        h1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        h1.setForeground(new java.awt.Color(234, 234, 234));
        h1.setText("Tasks");

        javax.swing.GroupLayout appContainerLayout = new javax.swing.GroupLayout(appContainer);
        appContainer.setLayout(appContainerLayout);
        appContainerLayout.setHorizontalGroup(
            appContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appContainerLayout.createSequentialGroup()
                .addComponent(menuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(appContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appContainerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(h1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(appContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appContainerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)))
                        .addGap(10, 10, 10))))
        );
        appContainerLayout.setVerticalGroup(
            appContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(menuContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(appContainerLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(h1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        //essa função sera executada quando o botão de editar for clicado
        //É aqui que a gente usa o vetor que a gente criou pra guardar todas as instancias da classe CardContainer que foram criadas.
        //Com esse for a gente percorre todo o vetor, e pra cada elemento dentro do vetor a gente executa alguma coisa
        for(CardContainer instance: instances) {
            //essa coisa é isso aqui
            //nessa linha a gente chama o método done() de dentro da classe que tá guardada dentro do vetor. A gente armazenou instancias da classe CardContainer,
            //então a gente tá chamando o método done de dentro da classe cardContainer, só que pra todas as instancias, já que percorremos todo o vetor. Meio confuso mas dá pra entender
            instance.done();
        }
    }//GEN-LAST:event_editButtonActionPerformed

    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        //Aqui a gente tá fazendo a msm coisa que na função acima, só que pro botão de deletar
        for(CardContainer instance: instances) {
            instance.delete(cardsContainer);
        }
        
        
        
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        NewTask newTask = new NewTask();
        newTask.home = this;
        newTask.setVisible(true);
        
        
        
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel appContainer;
    private javax.swing.JPanel cardsContainer;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel h1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel menuContainer;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
