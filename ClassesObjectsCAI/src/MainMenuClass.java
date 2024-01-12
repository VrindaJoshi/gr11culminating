import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenuClass extends JFrame implements ActionListener {

	// colors
	static final Color BEIGE = new Color(227, 228, 219);
	static final Color GRAY = new Color(205, 205, 205);

	static JPanel mainPanel = new JPanel();
	static JPanel sidePanel = new JPanel();

	static JLabel welcomeLabel = new JLabel("welcome");
	private JLabel textLabel = new JLabel(
			"<html>In this CAI (Computer-Assisted Instruction) application, you will learn all about classes and objects. In the past, we have learned about data types such as String, int, double, and boolean, but now you will be able to create and use your own data type (an object)! You will explore the concept of Object-Oriented Programming (OOP), and how using objects in your code will be very useful. You will be learning many new terms, and you can access a glossary through the menu bar at the top.</html>");
	static JLabel highlightedLabel = new JLabel("before we get started, create your avatar!");

	private ImageIcon circleIcon = new ImageIcon("images/blank.png");
	private JLabel circle = new JLabel(
			new ImageIcon(circleIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
	private JPanel topPanel = new JPanel();

	static JButton nextStep = new JButton("create avatar");

	static JLabel avatarInfo = new JLabel("");

	static String hairPNG = "";

	static boolean avatarCreated = false;

	public MainMenuClass() {

		// set size of frame
		setSize(1366, 766);
		setTitle("Education Class");

		// set up main panel
		mainPanel.setBounds(0, 0, 1366, 766);
		mainPanel.setBackground(BEIGE);
		mainPanel.setLayout(null);
		add(mainPanel);

		// set up panel w content
		setTopPanel();

		setSidePanel();

		setVisible(true);
	}

	private void setSidePanel() {

		// set up blank panel
		sidePanel.setBounds(50, 50, 250, 616);
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sidePanel.setLayout(null);
		mainPanel.add(sidePanel);

		nextStep.setBounds(40, 616 - 125, 160, 75);
		nextStep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		nextStep.setBackground(GRAY);
		nextStep.addActionListener(this);
		sidePanel.add(nextStep);

		avatarInfo.setBounds(40, 210, 200, 200);
		avatarInfo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		sidePanel.add(avatarInfo);

		circle.setBounds(25, 50, 200, 200);
		sidePanel.add(circle);

	}

	private void setTopPanel() {

		// set up blank panel
		topPanel.setBounds(300, 50, 916, 616);
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setLayout(null);
		mainPanel.add(topPanel);

		// set title
		welcomeLabel.setBounds(50, 60, 1000, 100);
		welcomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 100));
		topPanel.add(welcomeLabel);

		// set text
		textLabel.setBounds(50, 100, 700, 400);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		topPanel.add(textLabel);

		// set bottom text
		highlightedLabel.setBounds(50, 450, 700, 50);
		highlightedLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		topPanel.add(highlightedLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (avatarCreated == false) {
			new AvatarBuilder();
		} else {
			new EducationClass();
		}

	}

	public static void changeScreen() {

		changeScreenValues();

	}

	private static void changeScreenValues() {

		chooseHairImage();

		JLabel hairImg = new JLabel(new ImageIcon(
				new ImageIcon(hairPNG).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		JLabel faceImg = new JLabel(new ImageIcon(
				new ImageIcon("images/avatar/blankFace.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));

		String titletext = "welcome, " + AvatarBuilder.userAvatar.getName().toLowerCase();

		welcomeLabel.setText(titletext);
		highlightedLabel.setText("let’s start learning!");
		nextStep.setText("start learning");

		avatarInfo.setText(
				"<html>name: " + AvatarBuilder.userAvatar.getName() + "<br>age: " + AvatarBuilder.userAvatar.getAge()
						+ "<br>gender: " + AvatarBuilder.userAvatar.getGender().toLowerCase() + "<br>hair color: "
						+ AvatarBuilder.userAvatar.getHairColor().toLowerCase() + "</html>");
		
		hairImg.setBounds(25, 50, 200, 200);
		sidePanel.add(hairImg);
		
		faceImg.setBounds(25, 50, 200, 200);
		sidePanel.add(faceImg);

	}

	private static void chooseHairImage() {

		if (AvatarBuilder.userAvatar.getGender() == "Male" || AvatarBuilder.userAvatar.getGender() == "Other") {

			if (AvatarBuilder.userAvatar.getHairColor() == "Brown") {
				hairPNG = "images/avatar/maleBrownHair.png";
			} else if (AvatarBuilder.userAvatar.getHairColor() == "Blonde") {
				hairPNG = "images/avatar/maleBlondeHair.png";
			}

		} else {

			if (AvatarBuilder.userAvatar.getHairColor() == "Brown") {
				hairPNG = "images/avatar/femaleBrownHair.png";
			} else if (AvatarBuilder.userAvatar.getHairColor() == "Blonde") {
				hairPNG = "images/avatar/femaleBlondeHair.png";
			}

		}

	}
}
