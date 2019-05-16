////////////////////// Yabi93 BETA 3 //////////////////////
/*
 *  Copyright (c) 2005 Thomas Efer
 * 
 * Permission is hereby granted, free of charge, to any
 * person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the
 * Software without restriction, including without
 * limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions
 * of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 * 
*/

/* Changes since BETA 2:
 * Fixed some language-related issues
 * Fixed bugs concerning the size of the befunge sourcecode
 * Programs are now limited to exactly 80x25 characters
 * Renewed and improved help file
 * Included license as comment in sources
*/

/* Changes since BETA 1:
 * Added ContextMenu to Source and Console.
 * Fixed issue of missing "\n" at the end of CharIn.
 * Added multilanguage support.
 * - class LangPack with String variables
 * - commandline parameter parsing 
*/

/* Outlook and TODO for final version:
 * Add a built-in code library containing popular programs
 * Add more languages
 * Sourcecode explanations via comments
 */

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.util.Vector;
import java.lang.reflect.Array;


class LangPack {
	String console_name = "Konsole";
	String filemenu_name = "Datei";
	String newmenu_name = "Neu";
	String openmenu_name = "Öffnen...";
	String saveasmenu_name = "Speichern unter...";
	String exitmenu_name = "Beenden";
	String helpmenu_name = "Hilfe";
	String showhelpmenu_name = "Hilfe anzeigen";
	String aboutmenu_name = "Über...";
	String start_name = "Start";
	String start_alt_name = "Stop";
	String start_desc = "Startet die unverzögerte Programmausführung, oder unterbricht sie.";
	String reset_name = "Reset";
	String reset_desc = "Setzt alle Werte auf ihre Ursprungswetre zurück.";
	String animate_name = "Animation";
	String animate_desc = "Startet die verzögerte Programmausführung, oder unterbricht sie.";
	String anispeed_desc = "Animationsgeschwindigkeit: Stufe";
	String anidefault_desc = "(Standardenstellung)";
	String step_name = "Schritt";
	String step_desc = "Geht einen Schritt weiter, in der Programmausführung.";
	String stack_name = "Stack zeigen";
	String stack_desc = "Öffnet ein Fenster mit dem Inhalt des Stack.";
	String clearconsole_name = "Konsole neu";
	String clearconsole_desc = "Entfernt den Inhalt der Konsole.";
	String consolesize_name = "Konsolengröße";
	String consolesize_desc = "Ändert die Größe des Konsolenbereiches.";
	String opendialog_name = "Befunge-Quelldatei Öffnen";
	String openerror_msg = "\nSCHWERER AUSNAHMEFEHLER BEIM ÖFFNEN DER DATEI!\n";
	String saveasdialog_name = "Befunge-Quelldatei Speichern";
	String saveerror_msg = "\nSCHWERER AUSNAHMEFEHLER BEIM SCHREIBEN DER DATEI!\nDie Datei ist unter Umständen nicht korrekt gepeichert.\n";
	String stackwin_name = "Stack";
	String cut_name = "Auschneiden";
	String copy_name = "Kopieren";
	String paste_name = "Einfügen";
	String clear_name = "Löschen";
	String selectall_name = "Alles auswählen";
	String end_msg = "\n --- Ende --- \n";
	String firstlineerror_msg = "\nFehlerhafte 1. Zeile des Quellcodes! (Endlosschleife)\n";
	String emptystack_msg = "Leer!";
	String stackshort_name = "St";
	String numin_name = "Bitte Zahl eingeben.";
	String programreset_name = "Programmreset";
	String charin_name = "Bitte Zeichen(folge) eingeben.";
	
	LangPack() {
		if (YABI93.yabiLangArg.equals("en") || YABI93.yabiLangArg.equals("english"))
		{	console_name = "Console";
			filemenu_name = "File";
			newmenu_name = "New";
			openmenu_name = "Open...";
			saveasmenu_name = "Save as...";
			exitmenu_name = "Exit";
			helpmenu_name = "Help";
			showhelpmenu_name = "Show help";
			aboutmenu_name = "About...";
			start_name = "Start";
			start_alt_name = "Stop";
			start_desc = "Switches the undelayed program execution on and off.";
			reset_name = "Reset";
			reset_desc = "Resets all relevant values to their defaults.";
			animate_name = "Animation";
			animate_desc = "Switches the delayed program execution on and off.";
			anispeed_desc = "Animation speed: Level";
			anidefault_desc = "(default)";
			step_name = "Step";
			step_desc = "Executes one single command of the program.";
			stack_name = "Show stack";
			stack_desc = "Opens a window showing the stack content.";
			clearconsole_name = "Clear Console";
			clearconsole_desc = "Deletes the content of the console section.";
			consolesize_name = "Console size";
			consolesize_desc = "Changes the height of the console section.";
			opendialog_name = "Open Befunge-Source";
			openerror_msg = "\nWARNING: OPENING THE REQUESTED FILE RESULTED IN AN I/O-EXCEPTION!\n";
			saveasdialog_name = "Save Befunge-Source";
			saveerror_msg = "\nWARNING: SAVING TO THE REQUESTED FILE RESULTED IN AN I/O-EXCEPTION!\nThe file may not be saved correctly.\n";
			stackwin_name = "Stack";
			cut_name = "Cut";
			copy_name = "Copy";
			paste_name = "Paste";
			clear_name = "Clear";
			selectall_name = "Select all";
			end_msg = "\n --- End --- \n";
			firstlineerror_msg = "\nError in first line of sourcecode! (infinite loop)\n";
			emptystack_msg = "Empty!";
			stackshort_name = "St";
			numin_name = "Please insert a number to process.";
			programreset_name = "Program reset";
			charin_name = "Please insert character(s) to process.";
		}
	}
}

class MainWindow extends JFrame implements ActionListener {
	LangPack yabilang = new LangPack();
	JTextArea Source = new JTextArea(25,82);
	JTextArea Console = new JTextArea(10,80);
	JPanel ButtonPanel = new JPanel();
	JButton Run = new JButton();
	JButton Step = new JButton();
	JButton Animate = new JButton();
	JPanel SpeedButtonPanel = new JPanel();
	JButton AniSpeed1 = new JButton();
	JButton AniSpeed2 = new JButton();
	JButton AniSpeed3 = new JButton();
	JButton AniSpeed4 = new JButton();
	JButton Reset = new JButton();
	JButton OpenStack = new JButton();
	JButton ClearConsole = new JButton();
	JButton SizeConsole = new JButton();
	JMenuBar Menubar = new JMenuBar();
	JMenu MFile = new JMenu();
	JMenuItem MNew = new JMenuItem();
	JMenuItem MOpen = new JMenuItem();
	JMenuItem MSave = new JMenuItem();
	JMenuItem MClose = new JMenuItem();
	JMenu MHelp = new JMenu();
	JMenuItem MShowHelp = new JMenuItem();
	JMenuItem MAbout = new JMenuItem();
	Timer AniTimer = new Timer(0,this);
	Timer RunTimer = new Timer(0,this);
	
	StackWindow MyStackWindow = new StackWindow(this); //Init before Simulation!
	Simulation MySimulation = new Simulation(this);
	
	boolean EditMode;
	
	/**Initial Settings**/
	MainWindow(){
		MySimulation.init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(YABI93.versionName);
		setSize(800,600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(400,200));
		setResizable(true);
		AniTimer.setRepeats(true);
		AniTimer.setDelay(600);
		RunTimer.setRepeats(true);
		add(BorderLayout.SOUTH,new JScrollPane(Console));
		 Console.setFont(new Font("Courier New",0,12));
		 Console.setText(YABI93.versionName + "\n~~~~~\n\n");
		 Console.setToolTipText(yabilang.console_name);
		 Console.setSize(200,200);
		 Console.setEditable(false);
		 Console.setLineWrap(true);
		 Console.setDisabledTextColor(Color.BLACK);
		 Console.addMouseListener(new MouseListenerPopUp());
		setJMenuBar(Menubar);
		 Menubar.setBorderPainted(true);
		 Menubar.setVisible(true);
		 Menubar.add(MFile);
		  MFile.setText(yabilang.filemenu_name); 
		  MFile.add(MNew);
		   MNew.setText(yabilang.newmenu_name);
		   MNew.addActionListener(this);
		  MFile.add(MOpen);
		   MOpen.setText(yabilang.openmenu_name);
		   MOpen.addActionListener(this);
		  MFile.add(MSave);
		   MSave.setText(yabilang.saveasmenu_name);
		   MSave.setEnabled(true);
		   MSave.addActionListener(this);
		  MFile.addSeparator();
		  MFile.add(MClose);
		   MClose.setText(yabilang.exitmenu_name);
		   MClose.addActionListener(this);
		 Menubar.add(MHelp);
		  MHelp.setText(yabilang.helpmenu_name);
		  MHelp.add(MShowHelp);
		   MShowHelp.setText(yabilang.showhelpmenu_name);
		   MShowHelp.addActionListener(this);
		  MHelp.addSeparator();
		  MHelp.add(MAbout);
		   MAbout.setText(yabilang.aboutmenu_name);
		   MAbout.addActionListener(this);
		    
		add(new JScrollPane(Source));
         Source.setBorder(BorderFactory.createRaisedBevelBorder()); 
		 Source.setEditable(false);
		 Source.setFont(new Font("Courier New",1,18));
		 Source.setText("<@_,#! #:<\"" + YABI93.versionName + "\"");
		 Source.setForeground(new Color(25,50,50));
		 Source.setSelectionColor(new Color(100,20,20));
		 Source.setSelectedTextColor(new Color(255,200,200));
		 Source.setLineWrap(false);
		 Source.setTabSize(1);
		 Source.addMouseListener(new MouseListenerPopUp());
		 Source.addKeyListener(new KeyListenerManager());
		add(BorderLayout.EAST,ButtonPanel);
		 ButtonPanel.setLayout(new GridLayout(10,1));
		 ButtonPanel.add(Run);
		  Run.setText(yabilang.start_name);
		  Run.setToolTipText(yabilang.start_desc);
		  Run.addActionListener(this);
		 ButtonPanel.add(Reset);
		  Reset.setText(yabilang.reset_name);
		  Reset.setToolTipText(yabilang.reset_desc);
		  Reset.addActionListener(this);
		 ButtonPanel.add(Animate);
		  Animate.setText(yabilang.animate_name);
		  Animate.setToolTipText(yabilang.animate_desc);
		  Animate.addActionListener(this);
		 ButtonPanel.add(SpeedButtonPanel);
		  SpeedButtonPanel.setLayout(new GridLayout(2,2));
		  SpeedButtonPanel.add(AniSpeed1);
		   AniSpeed1.setText("1");
		   AniSpeed1.setToolTipText(yabilang.anispeed_desc + " 1 ");
		   AniSpeed1.addActionListener(this);
		  SpeedButtonPanel.add(AniSpeed2);
		   AniSpeed2.setText("2");
		   AniSpeed2.setToolTipText(yabilang.anispeed_desc + " 1 " + yabilang.anidefault_desc);
		   AniSpeed2.addActionListener(this);
		  SpeedButtonPanel.add(AniSpeed3);
		   AniSpeed3.setText("3");
		   AniSpeed3.setToolTipText(yabilang.anispeed_desc + " 3 ");
		   AniSpeed3.addActionListener(this);
		  SpeedButtonPanel.add(AniSpeed4);
		   AniSpeed4.setText("4");
		   AniSpeed4.setToolTipText(yabilang.anispeed_desc + " 4 ");
		   AniSpeed4.addActionListener(this);
		 ButtonPanel.add(Step);
		  Step.setText(yabilang.step_name);
		  Step.setToolTipText(yabilang.step_desc);
		  Step.addActionListener(this);
		 ButtonPanel.add(new JPanel());
		 ButtonPanel.add(OpenStack);
		  OpenStack.setText(yabilang.stack_name);
		  OpenStack.setToolTipText(yabilang.stack_desc);
		  OpenStack.addActionListener(this);
		 ButtonPanel.add(new JPanel());
		 ButtonPanel.add(ClearConsole);
		  ClearConsole.setText(yabilang.clearconsole_name);
		  ClearConsole.setToolTipText(yabilang.clearconsole_desc);
		  ClearConsole.addActionListener(this);
		 ButtonPanel.add(SizeConsole);
		  SizeConsole.setText(yabilang.consolesize_name);
		  SizeConsole.setToolTipText(yabilang.consolesize_desc);
		  SizeConsole.addActionListener(this);
		setVisible(true);
		MyStackWindow.fitToMainWindow();
		MySimulation.init();
	}

	public void actionPerformed(ActionEvent e) {
	   if (e.getSource()==Run) {AniTimer.stop(); if (RunTimer.isRunning()) {Run.setText(yabilang.start_name); RunTimer.stop(); MySimulation.showMem();MySimulation.updateView();} else {Run.setText(yabilang.start_alt_name);RunTimer.start();};};
	   if (e.getSource()==Reset) {AniTimer.stop();Run.setText(yabilang.start_name);RunTimer.stop();MySimulation.reset();};
	   if (e.getSource()==Animate) {Run.setText(yabilang.start_name);RunTimer.stop(); if (AniTimer.isRunning()) AniTimer.stop(); else AniTimer.start();};
	   if (e.getSource()==Step) {callStep();};
	   if (e.getSource()==OpenStack) {MyStackWindow.setVisible(!MyStackWindow.isVisible());};
	   if (e.getSource()==ClearConsole) {Console.setText(YABI93.versionName + "\n\n");};
	   if (e.getSource()==SizeConsole) {Console.setRows(35-Console.getRows()); ButtonPanel.revalidate();};
	   if (e.getSource()==MNew) {newFile();};
	   if (e.getSource()==MOpen) {openFile();};
	   if (e.getSource()==MSave) {saveFileAs();};
	   if (e.getSource()==MClose) {System.exit(1);};
	   if (e.getSource()==MShowHelp) {MyStackWindow.setVisible(false); YABI93.showHelp();};
	   if (e.getSource()==MAbout) {MyStackWindow.setVisible(false); YABI93.showAbout();};
	   if (e.getSource()==AniTimer && (Source.hasFocus() || MyStackWindow.StackList.hasFocus()) == true) {callStep();};
	   if (e.getSource()==RunTimer) {callRun();};
	   if (e.getSource()==AniSpeed1) {AniTimer.setDelay(1000);};
	   if (e.getSource()==AniSpeed2) {AniTimer.setDelay(600);};
	   if (e.getSource()==AniSpeed3) {AniTimer.setDelay(200);};
	   if (e.getSource()==AniSpeed4) {AniTimer.setDelay(0);};
	   if (e.getSource()!=RunTimer && e.getSource()!=AniTimer) Source.requestFocus();
	}

	boolean checkNonEmpty () {
		return Source.getText().trim().length()!=0;
	}
	
	void callStep() {
		if (checkNonEmpty()) {	if (EditMode==true) {MySimulation.init(); setEditMode(false);} MySimulation.step();} else MySimulation.outputString("\nLeerer Quelltext! - Keine Simulation möglich.\n" );
	}
	
	void callRun() {
		if (checkNonEmpty()) {	if (EditMode==true) {MySimulation.init(); setEditMode(false);} for (int i=0;i<2000 && RunTimer.isRunning();i++) MySimulation.run();} else MySimulation.outputString("\nLeerer Quelltext! - Keine Simulation möglich.\n" );
	}
	
	void newFile() {
		Source.setText(" ");
		MySimulation.init();
		setTitle(YABI93.versionName);
		MySimulation.init();
	}
	
	void openFile() {
		FileDialog openDialog = new FileDialog((Frame)this,yabilang.opendialog_name,FileDialog.LOAD);
		openDialog.setFile("*.bf; *.bef");
		openDialog.setVisible(true);
		if (openDialog.getFile() != null) {
		setTitle(YABI93.versionName + " - " + openDialog.getFile());
		String FileToOpen = openDialog.getDirectory()+openDialog.getFile();
		try {BufferedReader in = new BufferedReader(new FileReader(FileToOpen));
		Source.setText("");
		String readLine,append;
		int lines=0;
	    while((readLine = in.readLine()) != null && lines<25) {
	    	append="";
	    	for (int i=0;i<80;i++) {if (i<readLine.length()) {append+=readLine.charAt(i);} else {append+=" ";};};
	    	Source.append(append+"\n");
	    	lines++;
	      }

		}
		catch (IOException error) {Console.append(yabilang.openerror_msg);};
		MySimulation.init();
		}
		openDialog.dispose();
	}
	
	void saveFileAs() {
		MySimulation.init();
		FileDialog saveAsDialog = new FileDialog((Frame)this,yabilang.saveasdialog_name,FileDialog.SAVE);
		saveAsDialog.setFile("yabi93-file.bf");
		saveAsDialog.setVisible(true);
		if (saveAsDialog.getFile() != null) {
		setTitle(YABI93.versionName + " - " + saveAsDialog.getFile());
		String FileToSave = saveAsDialog.getDirectory()+saveAsDialog.getFile();
		try {BufferedWriter out = new BufferedWriter(new FileWriter(FileToSave));
		String write;
	    write = Source.getText();
	    out.append(write.replaceAll("\n","\r\n"));
	    out.flush();
		}
		catch (IOException error) {Console.append(yabilang.saveerror_msg);};
		}
		saveAsDialog.dispose();
	}
	
	
	void setEditMode (boolean mode) {
		EditMode = mode;
		if (mode == true) {
			Source.setEditable(true);
			Reset.setEnabled(false);
		}
		else {
			Source.setEditable(false);
			Reset.setEnabled(true);	
		}
	}
	
	class MouseListenerPopUp extends MouseAdapter
	{
	       JPopupMenu ContextPopUp = new JPopupMenu();
	       Action Cut, Copy, Paste, Clear, SelectAll;
	       JMenuItem MCut, MCopy, MPaste, MClear, MSelectAll;
	       JTextComponent SourceComponent;

	                                
	       public MouseListenerPopUp()
	       { Cut = new AbstractAction(yabilang.cut_name) { public void actionPerformed(ActionEvent e) { SourceComponent.cut(); MySimulation.init(); } };
	         Copy = new AbstractAction(yabilang.copy_name) { public void actionPerformed(ActionEvent e) { SourceComponent.copy(); } };     
	         Paste = new AbstractAction(yabilang.paste_name) { public void actionPerformed(ActionEvent e) { SourceComponent.paste(); MySimulation.init(); } };
	         Clear = new AbstractAction(yabilang.clear_name) { public void actionPerformed(ActionEvent e) { SourceComponent.replaceSelection(""); MySimulation.init(); } };
	         SelectAll = new AbstractAction(yabilang.selectall_name) { public void actionPerformed(ActionEvent e) { SourceComponent.selectAll(); } };
	         
	         MCut = ContextPopUp.add(Cut);
	         MCopy = ContextPopUp.add(Copy);
	         MPaste = ContextPopUp.add(Paste);
	         MClear = ContextPopUp.add(Clear);
             ContextPopUp.addSeparator();
             MSelectAll = ContextPopUp.add(SelectAll);
	        }
	                                
	        public void mouseClicked(MouseEvent e)
	        {
	              if (e.getModifiers()==InputEvent.BUTTON3_MASK) 
	              {
	                     SourceComponent = (JTextComponent)e.getSource();
	                     SourceComponent.requestFocus();                                        
	                     MCut.setEnabled(SourceComponent.isEnabled() && SourceComponent.isEditable() && SourceComponent.getSelectedText()!=null);
	                     MCopy.setEnabled(SourceComponent.isEnabled() && SourceComponent.getSelectedText()!=null);
	                     MPaste.setEnabled(SourceComponent.isEnabled() && SourceComponent.isEditable() && Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor));
	                     MClear.setEnabled(SourceComponent.isEnabled() && SourceComponent.isEditable() && SourceComponent.getSelectedText()!=null);
	                     MSelectAll.setEnabled(SourceComponent.isEnabled() && !(SourceComponent.getText()==null || SourceComponent.getText().equals("")));
	                     ContextPopUp.show(e.getComponent(),e.getX(), e.getY());
	                }
	         }
	        
	  }
	

	class KeyListenerManager extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
//// Ctrl+Ins / Shift+Ins / Shift+Del
		}

	}

};

class StackWindow extends JFrame {
	JTextArea StackList = new JTextArea();
	MainWindow MyMainWindow;

	StackWindow(MainWindow GivenMainWindow) {
		MyMainWindow=GivenMainWindow;
		LangPack yabilang = MyMainWindow.yabilang;
		setVisible(false);
		setSize(180,500);
		setAlwaysOnTop(true);
		setTitle(yabilang.stackwin_name);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(new JScrollPane(StackList));
		StackList.setFont(new Font("Courier New",1,13));
		 StackList.setTabSize(4);
	}
	
	void fitToMainWindow () {
		setLocation(MyMainWindow.ButtonPanel.getLocation().x-getSize().width-1,MyMainWindow.Menubar.getSize().height+20);
		setSize(getSize().width,MyMainWindow.Source.getSize().height);	
	}
	
}

class HelpWindow extends JFrame {
	static class JAAEditorPane extends JEditorPane {
	    public void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
	          RenderingHints.VALUE_RENDER_QUALITY);
	        super.paintComponent(g2);
	    }
	}

	JEditorPane HelpContent = new JAAEditorPane(); 
	
	HelpWindow() {
		setVisible(false);
		setSize(800,600);
		setTitle("Help / Hilfe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(new JScrollPane(HelpContent));
		 HelpContent.setContentType("text/html");
		 HelpContent.setEditable(false);
		 try {HelpContent.setPage(getClass().getResource("help.htm"));}
		 catch (IOException ex1){};
	}
}

class AboutWindow extends JWindow implements ActionListener{
	JButton AboutOK = new JButton();
	JButton AboutImage = new JButton();
	AboutWindow() {
		setSize(400,300);
		setAlwaysOnTop(true);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-400)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-300)/2);
		add(BorderLayout.SOUTH,AboutOK);
		 AboutOK.setText(". . .");
		 AboutOK.setEnabled(false);
		add(AboutImage);
		 AboutImage.setIcon(new ImageIcon(getClass().getResource("about.jpg")));
		setVisible(true);
	}
	void makeInteractable() {
		setVisible(false);
		AboutOK.addActionListener(this);
		AboutOK.setEnabled(true);
		AboutOK.setText("OK");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==AboutOK) setVisible(false);
	}
}
class MemoryCell{
	long value=(byte)' ';
	boolean isCharFlag=false;
	MemoryCell() {};
	MemoryCell(int i) {value=i;};
	MemoryCell(int i, boolean b) {value=i;isCharFlag=b;};
	MemoryCell(long l) {value=l;};
	MemoryCell(long l, boolean b) {value=l;isCharFlag=b;};
}

class SimStack extends Vector {
	
	void push(MemoryCell mc) {add(new MemoryCell(mc.value, mc.isCharFlag));};
	
	MemoryCell pop() {
		if (size()>0) {
			MemoryCell lying = (MemoryCell)(get(size()-1));
			MemoryCell popped = new MemoryCell (lying.value,lying.isCharFlag);
			remove((int)size()-1);
			return popped;
		}
		else return new MemoryCell(0);
	};
	
	void swap() {
		MemoryCell a = pop();
		MemoryCell b = pop();
		push(a);
		push(b);
	}
	
	void twin() {
		MemoryCell Clone = pop();
		push(Clone); push(Clone);
	}
	
}

class Simulation extends Thread implements Runnable {
	MainWindow MyMainWindow;
	LangPack yabilang;
		
	SimStack Stack = new SimStack();

	static int EAST = 1;
	static int WEST = 2;
	static int SOUTH = 3;
	static int NORTH = 4;
	
	long StartTime=0;	
	
	MemoryCell[][] InitialCells = new MemoryCell[81][25];
	MemoryCell[][] MemoryCells = new MemoryCell[81][25];
	MemoryCell instructionPointer = new MemoryCell();
	int iPx=0, iPy=0;
	int Direction;
	boolean CharReadMode = false;
	boolean Interruption = false;
	boolean End = false;
	boolean Jumpy=false;
	
	Simulation(MainWindow GivenMainWindow) {
		MyMainWindow = GivenMainWindow;
		yabilang = MyMainWindow.yabilang;
	}
	
	public void init() {
		InitialCells = new MemoryCell[81][25];
		int i=0,j=0,k=0;
		String[] RawLines = new String[26];
		RawLines[j]="";
		for (i=0; i<MyMainWindow.Source.getText().length() && j<25;i++) {
			if (MyMainWindow.Source.getText().charAt(i)!='\n') {if (k<81) RawLines[j]+=MyMainWindow.Source.getText().charAt(i); k++;}
			else {k=0; j++; RawLines[j]="";}
		}
		
		for (j=0; j<25;j++) for (i=0; i<81;i++)	{
			if (RawLines[j]!=null && i<RawLines[j].length()) InitialCells[i][j] = new MemoryCell(RawLines[j].charAt(i));
			else InitialCells[i][j] = new MemoryCell();
			}

		reset();
	}

	void reset() {
		MyMainWindow.setEditMode(true);
		End=false;
		Interruption=false;
		CharReadMode=false;
		Jumpy=false;
		Stack.removeAllElements();
		CharInWindow.CharBuffer.removeAllElements();
		instructionPointer=InitialCells[0][0];
		iPx=0;
		iPy=0;
		Direction=EAST;
		readMemFromInit();
		showMem();
		updateView();
	}
	
	void readMemFromInit() {
		for (int i=0; i<(81*25);i++) {
			MemoryCells[i % 81][((i-(i % 81))/81)] = new MemoryCell();
			if (InitialCells[i % 81][((i-(i % 81))/81)]!=null) MemoryCells[i % 81][((i-(i % 81))/81)].value = InitialCells[i % 81][((i-(i % 81))/81)].value;
			else {MemoryCells[i % 81][((i-(i % 81))/81)].value=' ';};
		};
	}
	
	public void run() {
		if (Interruption) {
			showMem();
			updateView();}
		else step();
	}
	
	void step() {
		calc();
		if (End==true) {
			MyMainWindow.AniTimer.stop();
			MyMainWindow.Run.setText(yabilang.start_name);
			MyMainWindow.RunTimer.stop();
			reset();
		}
		move();
		if (MyMainWindow.RunTimer.isRunning()==false && (MyMainWindow.Source.hasFocus() || MyMainWindow.Step.hasFocus() || MyMainWindow.MyStackWindow.StackList.hasFocus())) {showMem(); updateView();} 
	}

	void calc() {
		long val = MemoryCells[iPx][iPy].value;
		int x,y,temp;
		if (CharReadMode==true) {
			if (val=='"') CharReadMode=false;
			else Stack.add(new MemoryCell(val,true));
		}
		else switch ((int)val) {
			case '0' : Stack.add(new MemoryCell(0)); break;
			case '1' : Stack.add(new MemoryCell(1)); break;
			case '2' : Stack.add(new MemoryCell(2)); break;
			case '3' : Stack.add(new MemoryCell(3)); break;
			case '4' : Stack.add(new MemoryCell(4)); break;
			case '5' : Stack.add(new MemoryCell(5)); break;
			case '6' : Stack.add(new MemoryCell(6)); break;
			case '7' : Stack.add(new MemoryCell(7)); break;
			case '8' : Stack.add(new MemoryCell(8)); break;
			case '9' : Stack.add(new MemoryCell(9)); break;
			case '"' : CharReadMode=true; break;
		    case '>' : Direction=EAST; break;
			case '<' : Direction=WEST; break;
			case 'v' : Direction=SOUTH; break;
		 	case '^' : Direction=NORTH; break;
		 	case '?' : Direction=(int)(Math.random()*4+1); break;
		 	case '@' : outputString(yabilang.end_msg); End=true; break;
		 	case '#' : Jumpy=true; break;
		 	case ':' : Stack.twin(); break;
		 	case '\\' : Stack.swap(); break;
		 	case '$' : Stack.pop(); break;
		 	case ',' : output((char)Stack.pop().value); break;
		 	case '.' : outputString(""+(int)Stack.pop().value+" "); break;
		 	case '!' : if (Stack.pop().value==0) Stack.push(new MemoryCell(1)); else Stack.push(new MemoryCell(0)); break;
		 	case '`' : if (Stack.pop().value < Stack.pop().value) Stack.push(new MemoryCell(1)); else Stack.push(new MemoryCell(0)); break;
		 	case '_' : if (Stack.pop().value==0) Direction=EAST; else Direction=WEST; break;
		 	case '|' : if (Stack.pop().value==0) Direction=SOUTH; else Direction=NORTH; break;
		 	case '+' : Stack.push(new MemoryCell((Stack.pop().value+(Stack.pop().value)))); break;
		 	case '-' : Stack.push(new MemoryCell(-(Stack.pop().value)+Stack.pop().value)); break;
		 	case '*' : Stack.push(new MemoryCell((Stack.pop().value*(Stack.pop().value)))); break;
		 	case '/' : temp=(int)Stack.pop().value; if (temp!=0) Stack.push(new MemoryCell((Stack.pop().value)/temp)); else {outputString("Division durch Null"); Stack.push(new MemoryCell(-1));}; break;
		 	case '%' : temp=(int)Stack.pop().value; if (temp!=0) Stack.push(new MemoryCell((Stack.pop().value)%temp)); else {outputString("Division durch Null"); End=true;}; break;
		 	case 'g' :
		 		y = (int)Stack.pop().value;
		 		x = (int)Stack.pop().value;
		 		if (x>=0 && x<80 && y>=0 && y<25) Stack.push(new MemoryCell(MemoryCells[x][y].value));
		 		break;
		 	case 'p' : 
		 		y = (int)Stack.pop().value;
		 		x = (int)Stack.pop().value;
		 		byte v = (byte)Stack.pop().value;
		 		if (x>=0 && x<80 && y>=0 && y<25) MemoryCells[x][y].value=v;
		 		break;
		 	case '&' : showMem();updateView(); new NumInWindow(this); break;
		 	case '~' : showMem();updateView();
		 		if (CharInWindow.BufferIsEmpty()) new CharInWindow(this);
		 		Stack.push(CharInWindow.CharBuffer.pop());
		 		break;
		 	default :;
		}
		if (Jumpy==true) move();
		Jumpy=false;
	}
		
	void move() {
		if (Direction==EAST) iPx=(iPx+1)%80;
		if (Direction==WEST) iPx=(iPx+79)%80;
		if (Direction==SOUTH) iPy=(iPy+1)%25;
		if (Direction==NORTH) iPy=(iPy+24)%25;
		instructionPointer=MemoryCells[iPx][iPy];
		int i=0;
		while (MemoryCells[iPx][iPy].value==' ' && Jumpy==false && CharReadMode==false) {
			if (++i > 80) {outputString(yabilang.firstlineerror_msg); End=true; Jumpy=true;};
			if (Direction==EAST) iPx=(iPx+1)%80;
			if (Direction==WEST) iPx=(iPx+79)%80;
			if (Direction==SOUTH) iPy=(iPy+1)%25;
			if (Direction==NORTH) iPy=(iPy+24)%25;
			instructionPointer=MemoryCells[iPx][iPy];
		}
	}
	
	void updateView() {

		MyMainWindow.Console.setCaretPosition(MyMainWindow.Console.getText().length());
		
		String NewStack = yabilang.stackwin_name+":\n\n";
		if (Stack.isEmpty()) NewStack+=yabilang.emptystack_msg;
		for (int i=Stack.size();i>0 && i+50>=Stack.size();i--) {
			MemoryCell StackElement = (MemoryCell)Stack.get(i-1);
			NewStack+=yabilang.stackshort_name+"#"+i+":	"+StackElement.value;
			if (StackElement.isCharFlag==true) NewStack+="	- \""+(char)StackElement.value+"\"";
			NewStack+="\n";
		}
		MyMainWindow.MyStackWindow.StackList.setText(NewStack);
		MyMainWindow.MyStackWindow.StackList.setCaretPosition(0);

		MyMainWindow.Source.setSelectionStart(iPy*81+iPx);
		MyMainWindow.Source.setSelectionEnd(iPy*81+iPx+1);

	}

	void output(char NewOutput) {
		MyMainWindow.Console.append(Character.toString(NewOutput));
	}
	void outputString(String NewOutput) {
		MyMainWindow.Console.append(NewOutput);
	}
	
	void showMem() {
		String CorrectFormat = "";
		for (int j=0; j<25;j++) {
			for (int i=0; i<81;i++) {
				if (MemoryCells[i][j] != null)	{
					{if (i!= 80) {if (MemoryCells[i][j].value!=(byte)('\r') && MemoryCells[i][j].value!=(byte)('\n') ) CorrectFormat+=(char)MemoryCells[i][j].value; else CorrectFormat+=" ";} else if (j!=24) CorrectFormat+="\n";}
				}
				else CorrectFormat+=" ";
			};
		};
		MyMainWindow.Source.setText(CorrectFormat);
	}

}

class NumInWindow extends JDialog implements ActionListener {
	JButton Reset = new JButton();
	JButton OK = new JButton();
	JTextArea NumberField = new JTextArea();
	Simulation MySimulation;
	
	NumInWindow(Simulation GivenSimulation) {
		MySimulation = GivenSimulation;
		LangPack yabilang = MySimulation.yabilang; 
		setTitle(yabilang.numin_name);
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
  		setAlwaysOnTop(true);
		setSize(400,100);
 		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-400)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-100)/2);
	    Reset = new JButton();
	 	add(BorderLayout.EAST,Reset);
	 	 Reset.setDefaultCapable(true);
	 	 Reset.setText(yabilang.programreset_name);
	 	 Reset.addActionListener(this);
        add(BorderLayout.SOUTH,OK);
 	     OK.setDefaultCapable(true);
 	     OK.setText("OK");
 	     OK.addActionListener(this);
        add(NumberField);
        setVisible(true);
	}
	  		
    public void actionPerformed(ActionEvent e) {
    	String NumString = NumberField.getText().trim();
    	if (e.getSource()==OK) {
    		try {
    			MySimulation.Stack.push(new MemoryCell(Long.parseLong(NumString)));
    			dispose();
    			}
    		catch (NumberFormatException ex) {};
    		
    	}
    	if (e.getSource()==Reset) {
    		MySimulation.End=true;
    		dispose();
    	}
    	
	}
}

class CharInWindow extends JDialog implements ActionListener {
	JButton Reset = new JButton();
	JButton OK = new JButton();
	JTextArea CharacterField = new JTextArea();
	static SimStack CharBuffer = new SimStack();
	Simulation MySimulation;
		
	CharInWindow(Simulation GivenSimulation) {
		MySimulation = GivenSimulation;
		LangPack yabilang = MySimulation.yabilang;
		setTitle(yabilang.charin_name);
	    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
  		setAlwaysOnTop(true);
		setSize(400,100);
 		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-400)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-100)/2);
	    Reset = new JButton();
	 	add(BorderLayout.EAST,Reset);
	 	 Reset.setDefaultCapable(true);
	 	 Reset.setText(yabilang.programreset_name);
	 	 Reset.addActionListener(this);
        add(BorderLayout.SOUTH,OK);
 	     OK.setDefaultCapable(true);
 	     OK.setText("OK");
 	     OK.addActionListener(this);
        add(CharacterField);
        setVisible(true);
	}
  		
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==OK) {
    		CharBuffer.push(new MemoryCell('\n'));
    		String CharString = CharacterField.getText().trim();
    		for (int i=CharString.length()-1;i>=0;i--) {
    			char character = (char)CharString.getBytes()[i];
    			CharBuffer.push(new MemoryCell(character,true));
    		}	
    	}
    	if (e.getSource()==Reset) MySimulation.End=true;
    	dispose();
	}
    
	static boolean BufferIsEmpty() {return CharBuffer.isEmpty();}
}

public class YABI93{

	static String versionName = "Yet Another Befunge93 Interpreter - Beta 3";
	static String yabiLangArg = "de";
	static AboutWindow MyAboutWindow;
	static MainWindow MyMainWindow;
	static HelpWindow MyHelpWindow;
	
    public static void main(String[] args) {
    	MyAboutWindow = new AboutWindow();
    	if (Array.getLength(args) > 0) yabiLangArg = args[0].toLowerCase();
    	MyMainWindow = new MainWindow();
    	MyHelpWindow = new HelpWindow();
    	MyAboutWindow.makeInteractable();
	}

    static void showHelp() {MyHelpWindow.setVisible(true);}
    static void showAbout() {MyAboutWindow.setVisible(true);}
    
}
