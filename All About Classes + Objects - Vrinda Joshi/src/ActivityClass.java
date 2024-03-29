
// ACITIVIY CLASS
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class ActivityClass extends JFrame implements ActionListener {

	// colors
	static final Color PINK = Color.decode("#FFE1E1");
	static final Color GRAY = new Color(205, 205, 205);

	// panels
	static JPanel mainPanel = new JPanel();
	static JPanel sidePanel = new JPanel();
	static JPanel topPanel = new JPanel();

	static int currentCake = 1;
	static int perfectCakes = 0;
	static boolean finishedGame = false;

	static boolean takenOrder = false;

	// 1st text panel
	private static JLabel gameIntro = new JLabel(
			"<html>OBJECTIVE: You've been hired by <i>Cake Instances</i>, the new cafe in town! You've been hired as a cashier and baker, and will have to take orders and make cakes. The cafe has a great reputation, so make sure to make the best cakes in town! The cafe is a bit big, so you will have to find your way around yourself. <br><br>"
					+ "HOW TO PLAY: Create instances of the <i>Cake</i> class, based on the cakes the customers want. Use the arrow keys to move around the store.</html>");

	// second screen elements
	private static JLabel constLabel = new JLabel(
			"<html>here's the recipe for a basic cake! modify <br>it to make the perfect cake for your customer!!</html>");
	private static JLabel cakeConstructor = new JLabel(new ImageIcon("images/cake.png"));

	// order, image of order
	private static JLabel order = new JLabel();

	// headers
	private static JLabel welcomeLabel = new JLabel("Cake Artist");
	private static JLabel headerLabel = new JLabel();

	// kitchen resources + fields
	private static JLabel cakeInstructions = new JLabel();
	private static JTextField answerField = new JTextField();
	private static JButton nextStep = new JButton("Start Training");
	private static JButton nextStep2 = new JButton("Bake");
	private static JButton nextStep3 = new JButton("Continue");
	private static JButton nextStep4 = new JButton("Quiz");
	private String[] whichOne = { "first", "second", "third" };
	private JTabbedPane tabbedPane = new JTabbedPane();
	private ImageIcon icon = createImageIcon("cakeIcon.png");
	private JComponent panel1 = makeTextPanel();
	private JComponent panel2 = makeTextPanel();
	private String[] answerArray = {
			"Cake cake1 = new Cake(\"Vanilla\", \"Strawberry\", \"Cream Cheese\", \"Pastel Pink\", 2, \"Baby Shower\", true);",
			"Cake cake2 = new Cake(\"Chocolate\", \"Caramel\", \"Italian Buttercream\", \"Periwinkle Blue\", 3, \"Birthday\", true);",
			"Cake cake2 = new Cake(\"Lemon\", \"Vanilla\", \"Lemon Buttercream\", \"Yellow\", 3, \"50th Anniverary\", true);" };

	// used in training
	private JLabel filler = new JLabel("here you will find your customer's order");

	// good or bad cake?
	static boolean gradeCake;

	// constructor method to set up frame
	public ActivityClass() {

		// construct frame
		setSize(1366, 766);
		setName("All About Objects+ + Classes");

		// used to save memory
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// intro screen
		setIntro();

		// menubar
		setMenuBar();

		// key listener for board so user can move
		setLayout(null);

		// set visible
		setVisible(true);

	}

	// first frame setup
	private void setIntro() {

		// set up blank panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.setBackground(PINK);
		mainPanel.setLayout(null);
		add(mainPanel);

		// set up blank panel
		topPanel.setBounds(50, 50, 1166, 616);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		// set title
		welcomeLabel.setBounds(40, 40, 900, 130);
		welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(130f));
		topPanel.add(welcomeLabel);

		// game intro
		gameIntro.setBounds(80, 150, 450, 350);
		gameIntro.setFont(MainMenuClass.inter.deriveFont(15f));
		topPanel.add(gameIntro);

		// button
		nextStep.setBounds(800, 300, 200, 50);
		nextStep.setFont(MainMenuClass.inter.deriveFont(15f));
		nextStep.setBackground(PINK);
		nextStep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trainingPanel();
			}
		});
		topPanel.add(nextStep);

	}

	// second frame setup
	private void trainingPanel() {

		welcomeLabel.setText("welcome to the kitchen!");
		welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(60f));

		constLabel.setBounds(20, 0, 400, 40);
		constLabel.setFont(MainMenuClass.inter.deriveFont(15f));
		panel1.add(constLabel);

		cakeConstructor.setBounds(20, 40, 445, 235);
		panel1.add(cakeConstructor);

		// TABBED PANE:
		// https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/tabbedpane.html
		tabbedPane.addTab("Basic Cake Recipe", icon, panel1, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		filler.setBounds(100, 0, 300, 40);
		filler.setHorizontalAlignment(JLabel.CENTER);
		filler.setFont(MainMenuClass.inter.deriveFont(15f));
		panel2.add(filler);

		tabbedPane.addTab("Customer's Order", icon, panel2, null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		tabbedPane.setBounds(50, 170, 500, 350);
		topPanel.add(tabbedPane);

		// text on the side
		gameIntro.setText(
				"<html>Welcome to the kitchen! Here you will bake all the cakes for your customers. The resources on the side will help you along the way.");
		gameIntro.setBounds(650, 80, 350, 350);
		gameIntro.setFont(MainMenuClass.inter.deriveFont(20f));

		// button
		nextStep.setBounds(800, 450, 200, 50);
		nextStep.setText("continue");
		nextStep.setFont(MainMenuClass.inter.deriveFont(15f));
		nextStep.setBackground(PINK);
		nextStep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				JOptionPane.showMessageDialog(topPanel,
						"Someone just entered the store! Looks like you got your first customer! ", "!!!",
						JOptionPane.INFORMATION_MESSAGE);
				setCustomer();
				welcomeLabel.setText("make your " + whichOne[currentCake - 1] + " customer's order!");
				new Board();
			}
		});

		topPanel.revalidate();
		topPanel.repaint();
	}

	// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/TabbedPaneDemo.java
	protected static JComponent makeTextPanel() {
		// crates a new panel
		JPanel panel = new JPanel(false);
		panel.setLayout(null);
		panel.setBackground(Color.white);

		return panel;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		// creates icon foe the tab (shows a mini cake)
		java.net.URL imgURL = ActivityClass.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	// -------------------------------------------------------

	// set kitchen to make order
	private void setCustomer() {

		topPanel.removeAll();

		panel2.removeAll();

		topPanel.add(tabbedPane);

		order = new JLabel(new ImageIcon(new ImageIcon("images/orders/order" + currentCake + ".png").getImage()
				.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)));
		order.setBounds(0, 0, 500, 300);
		panel2.add(order);

		headerLabel.setBounds(40, 40, 1000, 130);
		headerLabel.setFont(MainMenuClass.italiana.deriveFont(60f));
		headerLabel.setText("make your " + whichOne[currentCake - 1] + " customer's order!");
		topPanel.add(headerLabel);

		cakeInstructions
				.setText("<html>create the cake in the box below! name the cake <i>cake" + currentCake + "<i>!</html>");
		cakeInstructions.setBounds(600, 250, 400, 30);
		cakeInstructions.setFont(MainMenuClass.inter.deriveFont(15f));
		topPanel.add(cakeInstructions);

		answerField.setBounds(600, 290, 450, 60);
		answerField.setBorder(BorderFactory.createLineBorder(Color.black));
		answerField.setFont(MainMenuClass.inter.deriveFont(15f));
		topPanel.add(answerField);

		// button
		nextStep2.setBounds(600, 400, 100, 60);
		nextStep2.setFont(MainMenuClass.inter.deriveFont(15f));
		nextStep2.setBackground(PINK);
		if (currentCake == 1) {
			nextStep2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// check cake
					if (answerArray[currentCake - 1].equals(answerField.getText())) {
						gradeCake = true;
						perfectCakes++;
					} else
						gradeCake = false;
					JOptionPane.showMessageDialog(topPanel, "Time to serve your customer!", "Finished Baking",
							JOptionPane.INFORMATION_MESSAGE);
					welcomeBackPanel();
					answerField.setText(""); // clears the text field for next round
					new Board();
				}
			});
		}
		topPanel.add(nextStep2);

		topPanel.revalidate();
		topPanel.repaint();
	}

	// menu bar
	private void setMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu mMenu = new JMenu("Home");
		JMenu mEdu = new JMenu("Learn");
		JMenu mActivity = new JMenu("Play");
		JMenu mQuiz = new JMenu("Quiz");

		// menu bar - used like buttons
		mMenu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				new MainMenuClass();
				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});

		mEdu.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				new EducationClass();
				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});

		mQuiz.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				if (CAIApp.activityDone == true) {
					new QuizClass();
					dispose();
				} else
					JOptionPane.showMessageDialog(topPanel, "Complete the activty to take the quiz!",
							"Before you move on..", JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});

		menuBar.add(mMenu);
		menuBar.add(mEdu);
		menuBar.add(mActivity);
		menuBar.add(mQuiz);

		setJMenuBar(menuBar);
	}

	// panel that brings user back, so board does not need to be revalidated, js
	// closed
	private void welcomeBackPanel() {

		// if 3 rounds are not up
		if (currentCake != 3) {

			panel2.removeAll();
			currentCake++;

			topPanel.remove(cakeInstructions);
			topPanel.remove(order);
			topPanel.remove(answerField);
			topPanel.remove(nextStep2);
			topPanel.remove(headerLabel);

			welcomeLabel.setText("welcome back to the kitchen!");
			welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(60f));
			topPanel.add(welcomeLabel);

			// text on the side
			gameIntro.setText(
					"<html>Great work! I anticipate that we will be having more customers as the day goes by.</html>");
			gameIntro.setBounds(650, 80, 350, 350);
			gameIntro.setFont(MainMenuClass.inter.deriveFont(20f));
			topPanel.add(gameIntro);

			// button
			nextStep3.setBounds(800, 450, 200, 50);
			nextStep3.setFont(MainMenuClass.inter.deriveFont(15f));
			nextStep3.setBackground(PINK);
			nextStep3.removeActionListener(this);
			nextStep3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					takenOrder = false;
					new Board();
					setCustomer();
					System.out.println(currentCake);

				}
			});

			topPanel.add(nextStep3);

			topPanel.revalidate();
			topPanel.repaint();

			// if done
		} else {
			try {
				Thread.sleep(1000); // wait a tinyyy bit
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// end the game (show results)
			endGame();
		}

	}

	// show results
	private void endGame() {

		topPanel.removeAll();

		// header
		welcomeLabel.setText("your results..");
		welcomeLabel.setFont(MainMenuClass.italiana.deriveFont(60f));
		topPanel.add(welcomeLabel);

		gameIntro.setText("<html>Great work! You served " + perfectCakes
				+ " perfect cakes! That's sadly the end of your baking career for now, and your next step is to complete the quiz.</html>");
		gameIntro.setBounds(40, 200, 350, 350);
		gameIntro.setFont(MainMenuClass.inter.deriveFont(20f));
		topPanel.add(gameIntro);

		nextStep4.setBounds(800, 450, 200, 50);
		nextStep4.setText("continue");
		nextStep4.setFont(MainMenuClass.inter.deriveFont(15f));
		nextStep4.setBackground(PINK);
		nextStep4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// calls quiz
				new QuizClass();
				dispose();
			}
		});

		topPanel.add(nextStep4);

		topPanel.revalidate();
		topPanel.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// unused

	}

}