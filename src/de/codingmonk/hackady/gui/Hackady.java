package de.codingmonk.hackady.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;

import de.codingmonk.hackady.core.HackadySetLoader;
import de.codingmonk.hackady.set.HackadyCategory;
import de.codingmonk.hackady.set.HackadySet;

public class Hackady {
	private static Hackady instance;
	private static Logger logger = Logger.getLogger(Hackady.class);
	private HackadySet hackadySet;
	private ArrayList<CategoryPane> catList;
	private JFrame frame;

	private JPanel categoryPanel;
	private JMenu mnFile;
	private JMenuItem mntmLoadHackadySet;
	private JSeparator separator;
	private JMenuItem mntmQuit;

	
	
	public HackadySet getHackadySet() {
		return hackadySet;
	}


	public static Hackady getInstance() {
		if (instance == null)
			instance = new Hackady();
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hackady window = getInstance();
					//window.loadHackadySet(HackadySetLoader.loadSetFromFile(new File("testSet.xml")));
					window.frame.setVisible(true);
					window.selectUser();
					
				} catch (Exception e) {
					logger.error(e, e);
				}
			}
		});
	}

	protected void selectUser() {
		// TODO Auto-generated method stub
		PlayerDialog.getInstance().setVisible(true);
	}


	/**
	 * Create the application.
	 */
	private Hackady() {
		initialize();

		catList = new ArrayList<CategoryPane>();

	}

	public void loadHackadySet(HackadySet hackadySet) {
		this.hackadySet = hackadySet;
		
		for (HackadyCategory cat : hackadySet.getCategory()) {
			CategoryPane cPane = new CategoryPane();
			cPane.getLblTitle().setText(cat.getTitle());
			cPane.addAnswerList(cat.getAnswers());
			getCategoryPanel().add(cPane);
			catList.add(cPane);

		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				logger.debug("focus gained.");
			}
			@Override
			public void focusLost(FocusEvent arg) {
				logger.debug("focus lost.");
			}
		});
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		logger.debug(dim);
		frame.setBounds(0, 0, dim.width, dim.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		PlayerPanel playerPanel = PlayerPanel.getInstance();
		frame.getContentPane().add(playerPanel, BorderLayout.SOUTH);

		categoryPanel = new JPanel();
		frame.getContentPane().add(categoryPanel, BorderLayout.CENTER);
		categoryPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmLoadHackadySet = new JMenuItem("Load Hackady Set...");
		mntmLoadHackadySet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create a file chooser
				final JFileChooser fc = new JFileChooser();
				 fc.setFileFilter( new FileFilter()
				    {
				      @Override public boolean accept( File f )
				      {
				        return f.isDirectory() ||
				          f.getName().toLowerCase().endsWith( ".xml" );
				      }
				      @Override public String getDescription()
				      {
				        return "HackadySet XML";
				      }
				    } );
				    int state = fc.showOpenDialog( null );
				    if ( state == JFileChooser.APPROVE_OPTION )
				    {
				      File file = fc.getSelectedFile();
				      fc.setVisible(false);
				      Hackady.getInstance().loadHackadySet(HackadySetLoader.loadSetFromFile(file));
				      Hackady.getInstance().frame.repaint();
				      getCategoryPanel().updateUI();
				    }
				    
				
				
				
				
			}
		});
		mnFile.add(mntmLoadHackadySet);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
			}
		});
		mnFile.add(mntmQuit);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getCategoryPanel() {
		return categoryPanel;
	}


	public void startGame() {
		// TODO Auto-generated method stub
		
	}
	
	public void quit() {
		System.exit(0);
	}

}
