import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ComboBoxValues extends JFrame {
	Airports airport = new Airports();
    FlightSchedule flight = new FlightSchedule();
    Flight flight1;
    Time time;
    
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel5;
    private JPanel panel6;
    private JTextField text;
    private JTextArea text1;
    private JTextField text2;
    private JTextField text3;
    private JTextArea text5;
    
    
 
    JComboBox combo;
    JComboBox combo2;
    JComboBox combo3;
    JComboBox combo4;
    JComboBox combo5;
    JComboBox combo6;
    JComboBox combo7;
    JComboBox combo8;// panel2 2
    JComboBox combo9; // panel2 2
    
    JButton Start; // panel2 2
    JButton Pause;// panel2 2
    JButton Stop;// panel2 2
    JButton Resume;
    JButton display; // panel 3 3
    JButton saveToDisk;
    JButton addAir;
    


    public static void main(String[] args) {
    	
    
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComboBoxValues frame = new ComboBoxValues();
                    frame.setSize(600, 600);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public ComboBoxValues() {
    	
        JTabbedPane tappedPane = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3=new JPanel();
        panel5=new JPanel();
        panel6=new JPanel();
        Thread t=new Thread(new TimeThread());
  
        
     
        
        tappedPane.add(panel2,"Set Time");
        tappedPane.add(panel1,"Control Flights");
        tappedPane.add(panel3,"Display");
        tappedPane.add(panel5, "Flight Logs");
        tappedPane.add(panel6, "Add Airport");
        
        add(tappedPane);
        
        
        
        // setContentPane(panel1);
        tappedPane.setBackground(Color.DARK_GRAY);
        panel1.setBackground(Color.DARK_GRAY);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.DARK_GRAY);
       
        panel5.setBackground(Color.DARK_GRAY);
        panel6.setBackground(Color.DARK_GRAY);
        
        
        
        panel1.setLayout(new GridLayout(4, 4));
        setTitle("Flight Tracker");
        panel5.setLayout(new GridLayout(25,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        combo8=new JComboBox();
        combo8.addItem("Hour");
        for(int i=0;i<24;i++)
        {
            combo8.addItem(i);
        }
        panel2.add(combo8,BorderLayout.LINE_START);
        combo9=new JComboBox();
        combo9.addItem("Minute");
        for(int i=0;i<60;i++)
        {
            combo9.addItem(i);
        }
        panel2.add(combo9,BorderLayout.LINE_START);
        combo7 = new JComboBox();
        combo7.addItem("Airline Codes");
        for (int i = 300; i <= 310; i++) {
            combo7.addItem(i);
        }
        Start =new JButton("Start"); // PANEL 2
        Pause =new JButton("Pause");
        Stop =new JButton("Stop");
        Resume=new JButton("Resume");
        panel2.add(Start,BorderLayout.SOUTH);
        panel2.add(Pause,BorderLayout.SOUTH);
        panel2.add(Resume,BorderLayout.SOUTH);
        panel2.add(Stop,BorderLayout.SOUTH); // PANEL 2
        
        
        
        
        panel1.add(combo7, BorderLayout.LINE_START);
        combo = new JComboBox();
        combo.addItem("Departure Airports");
        for(int i=0;i<airport.getSayac()+5;i++) {
        	combo.addItem(airport.alListe(i));
        	System.out.println("asd");
        }
        panel1.add(combo, BorderLayout.LINE_START);
        combo2 = new JComboBox();
        combo2.addItem("Arrival Airports");
        for(int i=0;i<airport.getSayac()+5;i++) {
        	combo2.addItem(airport.alListe(i));
        	System.out.println("asd");
        }
        panel1.add(combo2, BorderLayout.LINE_START);
        combo3 = new JComboBox();
        combo3.addItem("Departure Hour");
        for (int i = 0; i <= 23; i++)
            combo3.addItem(i);
        panel1.add(combo3, BorderLayout.CENTER);
        combo4 = new JComboBox();
        combo4.addItem("Departure Minute");
        for (int i = 0; i <= 59; i++)
            combo4.addItem(i);
        panel1.add(combo4, BorderLayout.CENTER);
        combo5 = new JComboBox();
        combo5.addItem("Arrival Hour ");
        for (int i = 0; i <= 23; i++)
            combo5.addItem(i);
        panel1.add(combo5, BorderLayout.LINE_END);
        combo6 = new JComboBox();
        combo6.addItem("Arrival Min");
        for (int i = 0; i <= 59; i++)
            combo6.addItem(i);
        panel1.add(combo6, BorderLayout.LINE_END);
        
        
        
        JButton add = new JButton("Add"); // PANEL 1
        panel1.add(add, BorderLayout.WEST); // PANEL 1
        display =new JButton("Display");
        saveToDisk=new JButton("SaveToDisc");
        panel3.add(saveToDisk);
        panel3.add(display,BorderLayout.NORTH);
       
        
        JButton addAir = new JButton("Add Airport"); // PANEL 1
        text3 = new JTextField("Write Here");
        
        panel6.add(text3);
        panel6.add(addAir);

        pack();
        display.addActionListener(new ActionListener() { // DISPLAY BUTONU ICIN ACTIONLISTENER
            @Override
            public void actionPerformed(ActionEvent e) {
               
            	for(Flight aflight : flight.getList()) {
            		text5=new JTextArea(aflight.toString());
               panel3.add(text5);
               panel3.revalidate();
           	panel3.repaint();
            	}
               
            }
        });

        saveToDisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                	for(Flight aflight : flight.getList()) {
                        File dosya = new File("/Users/Bkrc/Desktop/dosya.txt");
                        FileWriter yazici = new FileWriter(dosya, true);
                        BufferedWriter yaz = new BufferedWriter(yazici);
                        yaz.write(aflight.toString());
                        yaz.write("\n");
                        yaz.close();
                        System.out.println("Ekleme islemi Basarali");
                	}}
                catch(IOException a)
                {
                    a.printStackTrace();
                }

            }
        });
        
        addAir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String ekle=  text3.getText();
               combo.addItem(ekle);
               combo2.addItem(ekle);
            }});

        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int hour = (int) (combo8.getSelectedItem());
                int min = (int) (combo9.getSelectedItem());
                time = new Time(hour,min,1);
                t.start();

            }});

        Pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time.setStat(0);
            }});

        Resume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time.setStat(1);
            }});

        Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }});

        

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String AirlineCode = (combo7.getSelectedItem().toString());
                String Departure = (combo.getSelectedItem().toString());
                String Arrival = (combo2.getSelectedItem().toString());
                Integer DepartureHour = (Integer)(combo3.getSelectedItem());
                int DepartureMin = (int) (combo4.getSelectedItem());
                int ArrivalHour = (int) (combo5.getSelectedItem());
                int ArrivalMin = (int) (combo6.getSelectedItem());
                Airline airline= new Airline(AirlineCode);
                int status = 2; // S = Scheduled C = Cancelled
                flight1 = new Flight(airline,status, Departure, DepartureHour,DepartureMin,Arrival,ArrivalHour,ArrivalMin);
                int flightNumber = 100 + (int) (Math.random() * 300);
                flight.addFlight(flight1);
                text5=new JTextArea(flight1.toString());
                //flight.display();
                //f.start();
                (new Thread(new FlightThread(flight1))).start();
            }

        });

    }

    public class TimeThread implements Runnable {
        private AtomicInteger timeinint=new AtomicInteger(0);
       
        @Override
        public void run() {
            System.out.println("Starting " );
            int x= time.getHour()*60+time.getmin();
            timeinint.set(x);

            try {
                while(1==1) {
                    while(time.getStat()==1) {
                        timeinint.incrementAndGet();
                        System.out.println("saat="+ ((timeinint.get()-(timeinint.get()%60))/60) + ":" + (timeinint.get()%60) );
                        time.setHour(((timeinint.get()-(timeinint.get()%60))/60));
                        time.setmin((timeinint.get()%60));
                        Thread.sleep(1000);
                        
                        String title = (Integer.toString(time.getHour())+":"+Integer.toString(time.getmin()));
                        TitledBorder border = BorderFactory.createTitledBorder(title);
                        border.setTitleColor(Color.WHITE);
                        
                        panel6.setBorder(border);
                        panel6.revalidate();
                        panel6.repaint();
                        panel1.setBorder(border);
                        panel1.revalidate();
                        panel1.repaint();
                        panel2.setBorder(border);
                        panel2.revalidate();
                        panel2.repaint();
                        panel3.setBorder(border);
                        panel3.revalidate();
                        panel3.repaint();
                        panel5.setBorder(border);
                        panel5.revalidate();
                        panel5.repaint();
                    }
                    time.setmin((timeinint.get()%60));
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }

        }}

    public class FlightThread implements Runnable {
        
    	int i,j,k,l,m;
    	
    	public Flight flight1;
    	
    	public FlightThread(Flight flight1) {
    		this.flight1=flight1;
    	}
    	
    	public void getInfo(Flight flight) {

            System.out.println(" "+flight.getStatus() );
        }

        public void run() {
        	i=j=k=l=m=0;
            System.out.println("Flight Scheculed" );
            try {
            	
                
                while(flight1.getStatus()==2) {
                	if(i==0) {
                	
                	text2=new JTextField();
                	text2.setBackground(Color.gray);
                	text2.setText(flight1.getDepartureairport()+"--"+flight1.getArrivalairport()+"  "+flight1.getDeparturehour()+
                    		":"+flight1.getDeparturemin()+" flight is Scheculed"+"  Expected Landing time:"+flight1.getArrivalhour()+":"+flight1.getArrivalmin()+"   Time:  "+Integer.toString(time.getHour())+":"+Integer.toString(time.getmin())+"   ");
                	panel5.add(text2);
                	panel5.revalidate();
                	panel5.repaint();}
                	
                	i=1;
                    int x=time.getHour()*60+time.getmin();
                    int y=flight1.getDeparturehour()*60+flight1.getDeparturemin();
                    if(x>=y)
                        flight1.setStatus(3);
                    Thread.sleep(1000);

                }

                while(flight1.getStatus()==3) {
                	if(j==0) {
             
                	text2=new JTextField();
                	text2.setBackground(Color.green);
                	text2.setText(flight1.getDepartureairport()+"--"+flight1.getArrivalairport()+"  "+flight1.getDeparturehour()+
                    		":"+flight1.getDeparturemin()+" plane is on the air."+"  Expected Landing time:"+flight1.getArrivalhour()+":"+flight1.getArrivalmin()+"   Time:  "+Integer.toString(time.getHour())+":"+Integer.toString(time.getmin())+"   ");
                	panel5.add(text2);
                	panel5.revalidate();
                	panel5.repaint();}
                	
                	j=1;
                	int x=time.getHour()*60+time.getmin();
                    int y=flight1.getArrivalhour()*60+flight1.getArrivalmin();
                    if(x>=y-10)
                    flight1.setStatus(4);
                    Thread.sleep(1000);

                }

                while(flight1.getStatus()==4) {
                    int x=time.getHour()*60+time.getmin();
                    int y=flight1.getArrivalhour()*60+flight1.getArrivalmin();
                    if(k==0) {
                    text2=new JTextField();
                	text2.setBackground(Color.orange);
                	text2.setSelectedTextColor(Color.WHITE);
                    text2.setText(flight1.getDepartureairport()+"--"+flight1.getArrivalairport()+"  "+flight1.getDeparturehour()+
                    		":"+flight1.getDeparturemin()+" plane is about to land." + "  Expected Landing time:"+flight1.getArrivalhour()+":"+flight1.getArrivalmin()+"   Time:  "+Integer.toString(time.getHour())+":"+Integer.toString(time.getmin())+"   ");
                	panel5.add(text2);
                	panel5.revalidate();
                	panel5.repaint();}k=1;
                	
               
                    
                
                    if(x>=y)
                        flight1.setStatus(5);
                    Thread.sleep(1000);
                }
                if(flight1.getStatus()==5) {
                	
                	text2=new JTextField();
                	text2.setBackground(Color.blue);
                	text2.setText(flight1.getDepartureairport()+"--"+flight1.getArrivalairport()+"  "+flight1.getDeparturehour()+
                    		":"+flight1.getDeparturemin()+" plane landed"+"  Expected Landing time:"+flight1.getArrivalhour()+":"+flight1.getArrivalmin()+"   Time:  "+Integer.toString(time.getHour())+":"+Integer.toString(time.getmin())+"   ");
                	panel5.add(text2);
                	panel5.revalidate();
                	panel5.repaint();
                }

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }}
    }
}