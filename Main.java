import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main {


    public static class Action implements ActionListener , KeyListener {
        public static void stopGame (){
            r = false;
            l= false;
            u=false;
            d=false;
            stop = false;
            labelGame.setText("GAME OVER");


        }
        public static void leng(int len){

            if (r) {
                for (int i = len; i > 0; i--) {
                    if (i == 1)
                        label[i].setLocation(label[i - 1].getX() - 25, label[i - 1].getY());
                    else
                        label[i].setLocation(label[i - 1].getX(), label[i - 1].getY());
                }
            } else if (l) {
                for (int i = lengthS; i > 0; i--){
                    if (i == 1)
                        label[i].setLocation(label[i-1].getX()+25,label[i -1].getY());
                    else
                        label[i].setLocation(label[i-1].getX(),label[i -1].getY());
                }

            } else if (u) {
                for (int i = lengthS; i > 0; i--){
                    if (i == 1)
                        label[i].setLocation(label[i-1].getX(),label[i -1].getY()+25);
                    else
                        label[i].setLocation(label[i-1].getX(),label[i -1].getY());
                }


            } else if (d) {
                for (int i = lengthS; i > 0; i--) {
                    if (i==1)
                        label[i].setLocation(label[i-1].getX(),label[i -1].getY()-25);
                    else
                        label[i].setLocation(label[i-1].getX(),label[i -1].getY());
                }

            }
            frame.repaint();
            frame.revalidate();
        }
        public static void eat(){



            label1.setBounds(xy[x],xy[y],25,25);
            x = randomX.nextInt(0,17);
            y = randomy.nextInt(0,17);
            label[lengthS +1]=new JLabel();
            label[lengthS +1].setIcon(imageIconsn);
            label[lengthS +1].setBackground(Color.black);


            label[lengthS +1].setOpaque(true);
            label[lengthS +1].setBounds(label[lengthS].getX(),label[lengthS].getY(),25,25);
            frame.add( label[lengthS +1]);
            lengthS++;
            labellen.setText("Eating: " +(lengthS-2));
            labeleat.setText("Length: " +lengthS);


        }
        static JFrame frame=new JFrame();
        static JLabel label [] = new JLabel[1000];
        static ImageIcon imageIconri = new ImageIcon("rightmouth.png");
        static ImageIcon imageIconup = new ImageIcon("upmouth.png");
        static ImageIcon imageIconle = new ImageIcon("leftmouth.png");
        static ImageIcon imageIcondo = new ImageIcon("downmouth.png");
        static ImageIcon imageIconen = new ImageIcon("enemy.png");
        static ImageIcon imageIconsn = new ImageIcon("snakeimage.png");
        static ImageIcon imageIcontx = new ImageIcon("snaketitle.jpg");


        static Random randomX = new Random();
        static Random randomy = new Random();
        static int x = randomX.nextInt(0,17);
        static  int y = randomy.nextInt(0,17);

        static JPanel paneltext = new JPanel();
        static JLabel  labelText = new JLabel();



        static JLabel label1 = new JLabel();
        static  int [] xy = {100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500};


        static boolean r = false;
        static boolean l = false;
        static boolean u = false;
        static boolean d = false;
        static  int lengthS = 2;
        static boolean stop = true;


        static  JLabel labelColorCr = new JLabel() ;
        static JLabel labelColorBl = new JLabel() ;
        static  JLabel labelColorWh = new JLabel() ;

        static  JLabel labellen = new JLabel() ;
        static  JLabel labeleat = new JLabel() ;
        static  JLabel labelGame = new JLabel() ;


        Action() {
            labellen.setBounds(700,5,100,60);
            labellen.setForeground(Color.white);
            labellen.setFont(new Font("Arial", Font.BOLD, 15));
            labellen.setText("Eating: " +(lengthS-2));
            frame.add(labellen);

            labeleat.setBounds(700,10,100,90);
            labeleat.setForeground(Color.white);
            labeleat.setFont(new Font("Arial", Font.BOLD, 15));
            labeleat.setText("Length: " +lengthS);
            frame.add(labeleat);

            frame.setSize(850, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);

            labelText.setIcon(imageIcontx);
            paneltext.setBounds(15,15,805 ,65);
            paneltext.add(labelText);
            frame.add(paneltext);

            labelGame.setForeground(Color.red);
            labelGame.setFont(new Font("Arial", Font.BOLD, 70));
            labelGame.setBounds(170, 300, 600, 100);
            frame.add(labelGame);





            label[0]=new JLabel();

            label[0].setIcon(imageIconri);
            label[0].setBackground(Color.black);


            label[0].setOpaque(true);
            label[0].setBounds(75,100,25,25);
            frame.add(label[0]);

            frame.addKeyListener(this);

            label1.setIcon(imageIconen);
            label1.setOpaque(true);
            label1.setBounds(150,150,25,25);
            label1.setBackground(Color.black);
            frame.add(label1);

            Timer timer = new Timer(100,this);
            timer.start();
            labelColorBl.setBounds(17,92,801,650);
            labelColorBl.setBackground(Color.black);
            labelColorBl.setOpaque(true);
            frame.add(labelColorBl);

            labelColorWh.setBounds(15,90,805,654);
            labelColorWh.setBackground(Color.white);
            labelColorWh.setOpaque(true);
            frame.add(labelColorWh);

            labelColorCr.setBounds(0,0,850,800);
            labelColorCr.setBackground(Color.darkGray);
            labelColorCr.setOpaque(true);
            frame.add(labelColorCr);
            frame.setVisible(true);

            label[1]=new JLabel();
            label[1].setIcon(imageIconsn);
            label[1].setBackground(Color.black);



            label[1].setOpaque(true);
            label[1].setBounds(label[0].getX()-25,label[0].getY(),25,25);
            frame.add( label[1]);


            label[2]=new JLabel();
            label[2].setIcon(imageIconsn);
            label[2].setBackground(Color.black);


            label[2].setOpaque(true);
            label[2].setBounds(label[1].getX()-25,label[1].getY(),25,25);
            frame.add( label[2]);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.revalidate();
            frame.repaint();
            if (r){
                label[0].setIcon(imageIconri);
                label[0].setLocation(label[0].getX()+25,label[0].getY());
                for (int i = lengthS; i > 0; i--){
                    if(label[0].getX()+25 == label[i].getX()
                    && label[0].getY() == label[i].getY() ){
                        stopGame();
                        break;

                    }
                }

                if (label[0].getX() >=785){
                    label[0].setLocation((label[0].getX()*0)+50,label[0].getY());

                }
                if (label[0].getX() == label1.getX() && label[0].getY() == label1.getY()
                || label[0].getX() == label1.getX()-10 && label[0].getY() == label1.getY()-10
                ||label[0].getX() == label1.getX()+10 && label[0].getY() == label1.getY()+10){
                  eat();

                }
               leng(lengthS);
                frame.revalidate();
                frame.repaint();
            } else if (l) {
                label[0].setIcon(imageIconle);
                label[0].setLocation(label[0].getX()-25,label[0].getY());

                for (int i = lengthS; i > 0; i--){
                    if(label[0].getX()-25 == label[i].getX()
                            && label[0].getY() == label[i].getY() ){
                        stopGame();
                        break;
                    }
                }

                if (label[0].getX() <=20){
                    label[0].setLocation(label[0].getX()+750,label[0].getY());
                }
                if (label[0].getX() == label1.getX() && label[0].getY() == label1.getY()
                        || label[0].getX() == label1.getX()-10 && label[0].getY() == label1.getY()-10
                        ||label[0].getX() == label1.getX()+10 && label[0].getY() == label1.getY()+10){
                    eat();


                }
               leng(lengthS);
                frame.revalidate();
                frame.repaint();
            } else if (u) {
                label[0].setLocation(label[0].getX(),label[0].getY()-25);
                for (int i = lengthS; i > 0; i--){
                    if(label[0].getX() == label[i].getX()
                            && label[0].getY()-25 == label[i].getY() ){
                        stopGame();
                        break;
                    }
                }
                label[0].setIcon(imageIconup);


                if (label[0].getY() <=75){
                    label[0].setLocation(label[0].getX(),label[0].getY()+600);
                }
                if (label[0].getX() == label1.getX() && label[0].getY() == label1.getY()
                        || label[0].getX() == label1.getX()-10 && label[0].getY() == label1.getY()-10
                        ||label[0].getX() == label1.getX()+10 && label[0].getY() == label1.getY()+10){
                    eat();


                }

             leng(lengthS);
                frame.revalidate();
                frame.repaint();

            } else if (d) {
                label[0].setLocation(label[0].getX(),label[0].getY()+25);
                for (int i = lengthS; i > 0; i--){
                    if(label[0].getX() == label[i].getX()
                            && label[0].getY()+25 == label[i].getY() ){
                        stopGame();
                        break;
                    }
                }
                label[0].setIcon(imageIcondo);

                if (label[0].getY() >=725){
                label[0].setLocation(label[0].getX(),(label[0].getY()*0)+125);
            }
                if (label[0].getX() == label1.getX() && label[0].getY() == label1.getY()
                        || label[0].getX() == label1.getX()-10 && label[0].getY() == label1.getY()-10
                        ||label[0].getX() == label1.getX()+10 && label[0].getY() == label1.getY()+10){
                    eat();
                }
               leng(lengthS);
                frame.revalidate();
                frame.repaint();

            }
            frame.add(labelColorBl);
            frame.add(labelColorWh);
            frame.add(labelColorCr);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (stop) {
                switch (e.getKeyCode()) {
                    case 37 -> {
                        if (r) {
                            l = false;
                        } else {
                            l = true;
                            r = false;
                        }

                        u = false;
                        d = false;
                    }
                    case 38 -> {
                        if (d) {
                            u = false;
                        } else {
                            u = true;
                            d = false;
                        }
                        l = false;
                        r = false;
                    }
                    case 39 -> {
                        if (l) {
                            r = false;
                        } else {
                            l = false;
                            r = true;
                        }

                        u = false;
                        d = false;
                    }
                    case 40 -> {
                        if (u) {
                            d = false;
                        } else {
                            u = false;
                            d = true;
                        }

                        l = false;
                        r = false;

                    }
                }
            }

            if(!d&&!u&&!r&&!l&&e.getKeyChar() == KeyEvent.VK_SPACE){
                label[0].setBounds(75,100,25,25);
                label[1].setBounds(label[0].getX()-25,label[0].getY(),25,25);
                label[2].setBounds(label[1].getX()-25,label[1].getY(),25,25);


                for (int i = lengthS ;i >2;i--){
                    frame.remove( label[i]);
                }
                lengthS = 2;
                labelGame.setText("");
                labellen.setText("eating: " +(lengthS-2));
                labeleat.setText("length: " +lengthS);
                frame.revalidate();
                frame.repaint();
                stop = true;
                label[0].setIcon(imageIconri);



            }
        }

        @Override
        public void keyReleased(KeyEvent e) {


        }
    }
    public static void main(String[] args) {

        new Action();

    }
}