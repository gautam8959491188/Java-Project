import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class OnlineExamination extends JFrame implements ActionListener
{
JLabel label;
JRadioButton radioButton[]=new JRadioButton[5];
JButton button1,button2;
ButtonGroup groupButton;
int marks=0,question=0,x=1,y=1,now=0;
int m[]=new int[10];	
OnlineExamination(String s)
{
super(s);
label=new JLabel();
add(label);
groupButton=new ButtonGroup();
for(int i=0;i<5;i++)
{
radioButton[i]=new JRadioButton();	
add(radioButton[i]);
groupButton.add(radioButton[i]);
}
button1=new JButton("Next");
button2=new JButton("Bookmark");
button1.addActionListener(this);
button2.addActionListener(this);
add(button1);add(button2);
set();
label.setBounds(30,40,450,20);
radioButton[0].setBounds(50,80,100,20);
radioButton[1].setBounds(50,110,100,20);
radioButton[2].setBounds(50,140,100,20);
radioButton[3].setBounds(50,170,100,20);
button1.setBounds(100,240,100,30);
button2.setBounds(270,240,100,30);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
setLocation(250,100);
setVisible(true);
setSize(600,350);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==button1)
{
if(check())
marks=marks+1;
question++;
set();	
if(question==9)
{
button1.setEnabled(false);
button2.setText("Result");
}
}
if(e.getActionCommand().equals("Bookmark"))
{
JButton bookMark=new JButton("Bookmark"+x);
bookMark.setBounds(480,20+30*x,100,30);
add(bookMark);
bookMark.addActionListener(this);
m[x]=question;
x++;
question++;
set();	
if(question==9)
button2.setText("Result");
setVisible(false);
setVisible(true);
}
for(int i=0,y=1;i<x;i++,y++)
{
if(e.getActionCommand().equals("Bookmark"+y))
{
if(check())
marks=marks+1;
now=question;
question=m[y];
set();
((JButton)e.getSource()).setEnabled(false);
question=now;
}
}
if(e.getActionCommand().equals("Result"))
{
if(check())
marks=marks+1;
question++;
JOptionPane.showMessageDialog(this,"correct ans="+marks);
System.exit(0);
}
}
void set()
{
radioButton[4].setSelected(true);
if(question==0)
{
label.setText("Que1: Which one among these is not a datatype");
radioButton[0].setText("int");radioButton[1].setText("Float");radioButton[2].setText("boolean");radioButton[3].setText("char");	
}
if(question==1)
{
label.setText("Que2: Which class is available to all the class automatically");
radioButton[0].setText("Swing");radioButton[1].setText("Applet");radioButton[2].setText("Object");radioButton[3].setText("ActionEvent");
}
if(question==2)
{
label.setText("Que3: Which package is directly available to our class without importing it");
radioButton[0].setText("swing");radioButton[1].setText("applet");radioButton[2].setText("net");radioButton[3].setText("lang");
}
if(question==3)
{
label.setText("Que4: String class is defined in which package");
radioButton[0].setText("lang");radioButton[1].setText("Swing");radioButton[2].setText("Applet");radioButton[3].setText("awt");
}
if(question==4)
{
label.setText("Que5: Which institute is best for java coaching");
radioButton[0].setText("Utek");radioButton[1].setText("Aptech");radioButton[2].setText("SSS IT");radioButton[3].setText("jtek");
}
if(question==5)
{
label.setText("Que6: Which one among these is not a keyword");
radioButton[0].setText("class");radioButton[1].setText("int");radioButton[2].setText("get");radioButton[3].setText("if");
}
if(question==6)
{
label.setText("Que7: Which one among these is not a class ");
radioButton[0].setText("Swing");radioButton[1].setText("Actionperformed");radioButton[2].setText("ActionEvent");radioButton[3].setText("Button");
}
if(question==7)
{
label.setText("Que8: which one among these is not a function of Object class");
radioButton[0].setText("toString");radioButton[1].setText("finalize");radioButton[2].setText("equals");radioButton[3].setText("getDocumentBase");		
}
if(question==8)
{
label.setText("Que9: which function is not present in Applet class");
radioButton[0].setText("init");radioButton[1].setText("main");radioButton[2].setText("start");radioButton[3].setText("destroy");
}
if(question==9)
{
label.setText("Que10: Which one among these is not a valid component");
radioButton[0].setText("JButton");radioButton[1].setText("JList");radioButton[2].setText("JButtonGroup");radioButton[3].setText("JTextArea");
}
label.setBounds(30,40,450,20);
for(int i=0,j=0;i<=90;i+=30,j++)
radioButton[j].setBounds(50,80+i,200,20);
}
boolean check()
{
if(question==0)
return(radioButton[1].isSelected());
if(question==1)
return(radioButton[2].isSelected());
if(question==2)
return(radioButton[3].isSelected());
if(question==3)
return(radioButton[0].isSelected());
if(question==4)
return(radioButton[2].isSelected());
if(question==5)
return(radioButton[2].isSelected());
if(question==6)
return(radioButton[1].isSelected());
if(question==7)
return(radioButton[3].isSelected());
if(question==8)
return(radioButton[1].isSelected());
if(question==9)
return(radioButton[2].isSelected());
return false;
}
public static void main(String s[])
{
new OnlineExamination("Online Examination Of Java");
}
}