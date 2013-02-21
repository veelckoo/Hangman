package hangman;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class Hangman extends javax.swing.JFrame {
    private static String letter, word;
    private static int wrongNum, correctNum, random;
    private static String[] correctLetters;    
    private static ArrayList<String> wordsList; 
    private long number;
    private static final String FILE = "words.txt";
    
    public  void Initialize(){
        aButton.setSelected(false);
        bButton1.setSelected(false);
        cButton2.setSelected(false);
        dButton3.setSelected(false);
        eButton4.setSelected(false);
        fButton5.setSelected(false);
        gButton6.setSelected(false);
        hButton7.setSelected(false);
        iButton1.setSelected(false);
        jButton2.setSelected(false);
        kButton3.setSelected(false);
        lButton4.setSelected(false);
        mButton5.setSelected(false);
        nButton6.setSelected(false);
        oButton7.setSelected(false);
        pButton8.setSelected(false);
        qButton2.setSelected(false);
        rButton3.setSelected(false);
        sButton4.setSelected(false);
        tButton5.setSelected(false);
        uButton7.setSelected(false);
        vButton6.setSelected(false);
        wButton8.setSelected(false);
        xButton9.setSelected(false);
        yButton9.setSelected(false);
        zButton10.setSelected(false);
        
        Random ran = new Random();
        letter = "";
        word = "";
        wrongNum = 0; 
        correctNum = 0;
        word = wordsList.get(ran.nextInt(wordsList.size()));
        System.out.println("word list size:" + wordsList.size());
        System.out.println("random number: " + ran.nextInt(wordsList.size()));
       
        //initialize empty word with underscores
        correctLetters = new String[word.length()];
        for(int i=0; i<correctLetters.length;i++){
            correctLetters[i] = "_";
        }
        
        DisplayWord();
        DisplayHangman(wrongNum);
   }
 
   private static void GetWords(String inputFile) {
       wordsList = new ArrayList<String>();
       System.out.println("Creating words list");
      
       File input = new File(inputFile);
       FileInputStream in = null;
       try {
            in = new FileInputStream(input);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
       int byteRead;
       String str = "";
       try {
           while((byteRead = in.read()) != -1) {
                if (byteRead == 13) {
                    wordsList.add(str);
                    in.read();
                    str="";
                }else{
                    str +=""+(char)byteRead;
                }
            }
        } catch (IOException ex) {
            System.out.println("Cant read file");
        }
   }

    public String actionPerformed(ActionEvent evt) { 
        String cmd = evt.getActionCommand(); 
        return cmd;
    } 

    public void ButtonPress (String aLetter) {
            System.out.println(aLetter);
            CheckLetter(aLetter);
            //TODO add button sounds
    }

    public void DisplayHangman(int number) {
       
        //System.out.println("Displaying hangman");
        //System.out.println(number + " wrong answers");
        ImageIcon icon = new ImageIcon(getClass().getResource("/hangman/hangman0.png"));
        imageLabel.setIcon(icon);
        switch(number){
           case 0 : icon = new ImageIcon(getClass().getResource("/hangman/hangman0.png"));
                    imageLabel.setIcon(icon);
                    break;
           case 1 : icon = new ImageIcon(getClass().getResource("/hangman/hangman1.png"));
                    imageLabel.setIcon(icon);
                    break;
           case 2 : icon = new ImageIcon(getClass().getResource("/hangman/hangman2.png"));
                    imageLabel.setIcon(icon);
                    break;
           case 3 : icon = new ImageIcon(getClass().getResource("/hangman/hangman3.png"));
                    imageLabel.setIcon(icon);
                    break;
           case 4 : icon = new ImageIcon(getClass().getResource("/hangman/hangman4.png"));
                    imageLabel.setIcon(icon);
                    break;
           case 5 : icon = new ImageIcon(getClass().getResource("/hangman/hangman5.png"));
                    imageLabel.setIcon(icon);
                    break;
           case 6 : icon = new ImageIcon(getClass().getResource("/hangman/hangman6.png"));
                    imageLabel.setIcon(icon);
                    break;
        }
    }

    public void DisplayWord() {
        //System.out.println("Displaying word");
        String output= "";
        for(String i:correctLetters){
            output = output + i + " ";
        //    System.out.print(i+" ");
        }
        //System.out.println("THAT  will be put inside field " + output);
        wordField.setText(output);
       
        
    }

    public void CheckGameOver() {
        System.out.println("Checking if Game is over");
        if(wrongNum == 6){
            //System.out.println("You lose!");
              MsgBox msg = new MsgBox(false, word);
              msg.setVisible(true);
              msg.setDefaultCloseOperation(HIDE_ON_CLOSE);
              Initialize();
        }else if(correctNum == word.length()){
            //System.out.println("You win!");
             MsgBox msg = new MsgBox(true, word);
             msg.setVisible(true);
             msg.setDefaultCloseOperation(HIDE_ON_CLOSE);
             Initialize();
        }
        
    }

    public void CheckLetter(String aLetter) {
        boolean wasCorrect = false;
        for (int i=0; i<word.length(); i++){
            if (word.toLowerCase().charAt(i) == aLetter.toLowerCase().charAt(0)){
                correctLetters[i] = aLetter;
                wasCorrect = true;
                correctNum++;
                System.out.println("Correct!");
            }
        }    
        if(!wasCorrect){    
                wrongNum++;
                System.out.println("Wrong!");    
        }  
      DisplayHangman(wrongNum);
      DisplayWord();
      CheckGameOver();
  }
    

  
    /**
     * Creates new form Hangman
     */
    public Hangman() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xButton9 = new javax.swing.JToggleButton();
        nButton6 = new javax.swing.JToggleButton();
        oButton7 = new javax.swing.JToggleButton();
        kButton3 = new javax.swing.JToggleButton();
        pButton8 = new javax.swing.JToggleButton();
        mButton5 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JToggleButton();
        iButton1 = new javax.swing.JToggleButton();
        lButton4 = new javax.swing.JToggleButton();
        wButton8 = new javax.swing.JToggleButton();
        sButton4 = new javax.swing.JToggleButton();
        uButton7 = new javax.swing.JToggleButton();
        rButton3 = new javax.swing.JToggleButton();
        vButton6 = new javax.swing.JToggleButton();
        tButton5 = new javax.swing.JToggleButton();
        qButton2 = new javax.swing.JToggleButton();
        zButton10 = new javax.swing.JToggleButton();
        yButton9 = new javax.swing.JToggleButton();
        aButton = new javax.swing.JToggleButton();
        hButton7 = new javax.swing.JToggleButton();
        eButton4 = new javax.swing.JToggleButton();
        dButton3 = new javax.swing.JToggleButton();
        cButton2 = new javax.swing.JToggleButton();
        bButton1 = new javax.swing.JToggleButton();
        gButton6 = new javax.swing.JToggleButton();
        fButton5 = new javax.swing.JToggleButton();
        wordField = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        xButton9.setText("X");
        xButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButton9ActionPerformed(evt);
            }
        });

        nButton6.setText("N");
        nButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButton6ActionPerformed(evt);
            }
        });

        oButton7.setText("O");
        oButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oButton7ActionPerformed(evt);
            }
        });

        kButton3.setText("K");
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        pButton8.setText("P");
        pButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButton8ActionPerformed(evt);
            }
        });

        mButton5.setText("M");
        mButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("J");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        iButton1.setText("I");
        iButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iButton1ActionPerformed(evt);
            }
        });

        lButton4.setText("L");
        lButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lButton4ActionPerformed(evt);
            }
        });

        wButton8.setText("W");
        wButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wButton8ActionPerformed(evt);
            }
        });

        sButton4.setText("S");
        sButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButton4ActionPerformed(evt);
            }
        });

        uButton7.setText("U");
        uButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uButton7ActionPerformed(evt);
            }
        });

        rButton3.setText("R");
        rButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButton3ActionPerformed(evt);
            }
        });

        vButton6.setText("V");
        vButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButton6ActionPerformed(evt);
            }
        });

        tButton5.setText("T");
        tButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButton5ActionPerformed(evt);
            }
        });

        qButton2.setText("Q");
        qButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qButton2ActionPerformed(evt);
            }
        });

        zButton10.setText("Z");
        zButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zButton10ActionPerformed(evt);
            }
        });

        yButton9.setText("Y");
        yButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yButton9ActionPerformed(evt);
            }
        });

        aButton.setText("A");
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });

        hButton7.setText("H");
        hButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hButton7ActionPerformed(evt);
            }
        });

        eButton4.setText("E");
        eButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eButton4ActionPerformed(evt);
            }
        });

        dButton3.setText("D");
        dButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButton3ActionPerformed(evt);
            }
        });

        cButton2.setText("C");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });

        bButton1.setText("B");
        bButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButton1ActionPerformed(evt);
            }
        });

        gButton6.setText("G");
        gButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gButton6ActionPerformed(evt);
            }
        });

        fButton5.setText("F");
        fButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fButton5ActionPerformed(evt);
            }
        });

        wordField.setEditable(false);
        wordField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        wordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFieldActionPerformed(evt);
            }
        });

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/hangman0.png"))); // NOI18N

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wordField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(oButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(qButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(wButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(wordField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(iButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(oButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButton9ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_xButton9ActionPerformed

    private void nButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButton6ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_nButton6ActionPerformed

    private void oButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oButton7ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_oButton7ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_kButton3ActionPerformed

    private void pButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButton8ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_pButton8ActionPerformed

    private void mButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButton5ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_mButton5ActionPerformed

    private void iButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iButton1ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_iButton1ActionPerformed

    private void lButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lButton4ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_lButton4ActionPerformed

    private void wButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wButton8ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_wButton8ActionPerformed

    private void sButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButton4ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_sButton4ActionPerformed

    private void uButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uButton7ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_uButton7ActionPerformed

    private void vButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButton6ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_vButton6ActionPerformed

    private void tButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButton5ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_tButton5ActionPerformed

    private void qButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qButton2ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_qButton2ActionPerformed

    private void zButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zButton10ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_zButton10ActionPerformed

    private void yButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yButton9ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_yButton9ActionPerformed

    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_aButtonActionPerformed

    private void hButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hButton7ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_hButton7ActionPerformed

    private void eButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eButton4ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_eButton4ActionPerformed

    private void dButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButton3ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_dButton3ActionPerformed

    private void gButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gButton6ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_gButton6ActionPerformed

    private void fButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fButton5ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_fButton5ActionPerformed

    private void bButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButton1ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_bButton1ActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_cButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButton3ActionPerformed
        letter = actionPerformed(evt);
        ButtonPress(letter);
    }//GEN-LAST:event_rButton3ActionPerformed

    private void wordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFieldActionPerformed
        
    }//GEN-LAST:event_wordFieldActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
       Initialize();
       //aButton.setSelected(false);
        
    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
               
            @Override
            public void run() {
                new Hangman().setVisible(true);
                Hangman hm = new Hangman();
                GetWords(FILE);
                hm.Initialize();           
                
            }
        });
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aButton;
    private javax.swing.JToggleButton bButton1;
    private javax.swing.JToggleButton cButton2;
    private javax.swing.JToggleButton dButton3;
    private javax.swing.JToggleButton eButton4;
    private javax.swing.JToggleButton fButton5;
    private javax.swing.JToggleButton gButton6;
    private javax.swing.JToggleButton hButton7;
    private javax.swing.JToggleButton iButton1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JToggleButton jButton2;
    private javax.swing.JToggleButton kButton3;
    private javax.swing.JToggleButton lButton4;
    private javax.swing.JToggleButton mButton5;
    private javax.swing.JToggleButton nButton6;
    private javax.swing.JToggleButton oButton7;
    private javax.swing.JToggleButton pButton8;
    private javax.swing.JToggleButton qButton2;
    private javax.swing.JToggleButton rButton3;
    private javax.swing.JToggleButton sButton4;
    private javax.swing.JButton startButton;
    private javax.swing.JToggleButton tButton5;
    private javax.swing.JToggleButton uButton7;
    private javax.swing.JToggleButton vButton6;
    private javax.swing.JToggleButton wButton8;
    private javax.swing.JTextField wordField;
    private javax.swing.JToggleButton xButton9;
    private javax.swing.JToggleButton yButton9;
    private javax.swing.JToggleButton zButton10;
    // End of variables declaration//GEN-END:variables


}
