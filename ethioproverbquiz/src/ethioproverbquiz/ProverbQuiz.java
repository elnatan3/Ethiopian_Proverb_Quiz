package ethioproverbquiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class ProverbQuiz implements ActionListener {
	private String name = "";

    public void welcome() {
        name = JOptionPane.showInputDialog(null, "Welcome to Proverb Quiz Game!\nWhat is your first and last name?", "Proverb Quiz Game", JOptionPane.QUESTION_MESSAGE);
        if (name == null || name.trim().equals("")) {
            name = "Player";
        }
        JOptionPane.showMessageDialog(null, "Hello, " + name + "! Please click OK to start the quiz.", "Proverb Quiz Game", JOptionPane.INFORMATION_MESSAGE);
    }
	// Created an array of the questions for the proverb
		String[] proverbQuestions = { "A woman without a man is like a?", "If one is not in a hurry, even?",
				"One who learns?", "When webs of a spider join together?", "One who has not learned to walk?",
				"Pride cannot replace?", "The sky is very near for those who?",
				"What one wishes for is always better than?" };
		// Created a 2d array of the choices for the proverb questions
		String[][] choices = {
				{ "Dog without a cat", "Field without a seed", "Tree without a leaf", "Car without a wheel" },
				{ "An egg will start walking", "Rain will stop", "Water will dry", "Sun will shine" },
				{ "Will learn more", "Is smart", "Will eventually teach", "Knows everything" },
				{ "They can trap a lion", "They can reproduce", "They start to collapse", "They are beautiful" },
				{ "Cannot walk", "Cannot climb a ladder", "Is lazy", "Cannot use GPS" },
				{ "Success", "Pride", "Dinner", "Humbleness" }, { "Fly", "Sit", "Look up", "Laugh" },
				{ "What one has", "What one had", "What his friends wishes for", "All of them" } };

		// Created an array of the correct choices
		char[] correctChoice = { 'B', 'A', 'C', 'A', 'B', 'C', 'B', 'A' };

		char choicePicked;
		char answerForProverb;
		int correctAnswers = 0;
		int totalQuestions = proverbQuestions.length;
		int finalResult;
		int seconds = 10;
		int i;

		JTextField textfield = new JTextField();
		JTextArea textarea = new JTextArea();
		JButton choiceA = new JButton();
		JButton choiceB = new JButton();
		JButton choiceC = new JButton();
		JButton choiceD = new JButton();

		JLabel labelTime = new JLabel();
		JLabel remainingSeconds = new JLabel();
		JTextField rightNumber = new JTextField();
		JTextField percentCorrectAnswer = new JTextField();

		JFrame theFrameForProverb = new JFrame();

		JLabel labelAnswerA = new JLabel();
		JLabel labelAnswerB = new JLabel();
		JLabel labelAnswerC = new JLabel();
		JLabel labelAnswerD = new JLabel();

		// Creates the initial screen and displays the scene and UI for the multiple
		// choice
		public void Proverb() {
			welcome(); // Add this line
		    theFrameForProverb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
			theFrameForProverb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			theFrameForProverb.setSize(650, 650);
			theFrameForProverb.setLayout(null);
			theFrameForProverb.setResizable(false);

			textfield.setBounds(0, 0, 650, 50);
			textfield.setForeground(Color.ORANGE);
			textfield.setFont(new Font("Arial", Font.BOLD, 30));
			textfield.setBorder(BorderFactory.createBevelBorder(1));
			textfield.setHorizontalAlignment(JTextField.CENTER);
			textfield.setEditable(false);

			textarea.setBounds(0, 50, 650, 50);
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);
			textarea.setForeground(Color.black);
			textarea.setFont(new Font("Arial", Font.BOLD, 30));
			textarea.setBorder(BorderFactory.createBevelBorder(1));
			textarea.setEditable(false);

			choiceA.setBounds(0, 100, 100, 100);
			choiceA.setFont(new Font("Times New Roman", Font.BOLD, 35));
			choiceA.setFocusable(false);
			choiceA.addActionListener(this);
			choiceA.setText("A");

			choiceB.setBounds(0, 200, 100, 100);
			choiceB.setFont(new Font("Times New Roman", Font.BOLD, 35));
			choiceB.setFocusable(false);
			choiceB.addActionListener(this);
			choiceB.setText("B");

			choiceC.setBounds(0, 300, 100, 100);
			choiceC.setFont(new Font("Times New Roman", Font.BOLD, 35));
			choiceC.setFocusable(false);
			choiceC.addActionListener(this);
			choiceC.setText("C");

			choiceD.setBounds(0, 400, 100, 100);
			choiceD.setFont(new Font("Times New Roman", Font.BOLD, 35));
			choiceD.setFocusable(false);
			choiceD.addActionListener(this);
			choiceD.setText("D");
	
			labelAnswerA.setBounds(125, 100, 500, 100);
			labelAnswerA.setBackground(new Color(50, 50, 50));
			labelAnswerA.setForeground(Color.blue);
			labelAnswerA.setFont(new Font("Rockwell", Font.PLAIN, 35));

			labelAnswerB.setBounds(125, 200, 500, 100);
			labelAnswerB.setBackground(new Color(50, 50, 50));
			labelAnswerB.setForeground(Color.blue);
			labelAnswerB.setFont(new Font("Rockwell", Font.PLAIN, 35));

			labelAnswerC.setBounds(125, 300, 500, 100);
			labelAnswerC.setBackground(new Color(50, 50, 50));
			labelAnswerC.setForeground(Color.blue);
			labelAnswerC.setFont(new Font("Rockwell", Font.PLAIN, 35));

			labelAnswerD.setBounds(125, 400, 500, 100);
			labelAnswerD.setBackground(new Color(50, 50, 50));
			labelAnswerD.setForeground(Color.blue);
			labelAnswerD.setFont(new Font("Rockwell", Font.PLAIN, 35));

			remainingSeconds.setBounds(535, 510, 100, 100);
			remainingSeconds.setForeground(new Color(255, 0, 0));
			remainingSeconds.setFont(new Font("Times New Roman", Font.BOLD, 60));
			remainingSeconds.setBorder(BorderFactory.createCompoundBorder());
			remainingSeconds.setHorizontalAlignment(JTextField.CENTER);
			remainingSeconds.setText(String.valueOf(seconds));

			labelTime.setBounds(535, 475, 100, 25);
			labelTime.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTime.setHorizontalAlignment(JTextField.CENTER);
			labelTime.setText("Timer");

			rightNumber.setBounds(225, 225, 200, 100);
			rightNumber.setBackground(new Color(25, 25, 25));
			rightNumber.setForeground(new Color(173, 216, 230));
			rightNumber.setFont(new Font("Ink Free", Font.BOLD, 50));
			rightNumber.setBorder(BorderFactory.createBevelBorder(1));
			rightNumber.setHorizontalAlignment(JTextField.CENTER);
			rightNumber.setEditable(false);

			percentCorrectAnswer.setBounds(225, 325, 200, 100);
			percentCorrectAnswer.setBackground(new Color(25, 25, 25));
			percentCorrectAnswer.setForeground(new Color(173, 216, 230));
			percentCorrectAnswer.setFont(new Font("Ink Free", Font.BOLD, 50));
			percentCorrectAnswer.setBorder(BorderFactory.createBevelBorder(1));
			percentCorrectAnswer.setHorizontalAlignment(JTextField.CENTER);
			percentCorrectAnswer.setEditable(false);

			theFrameForProverb.add(labelTime);
			theFrameForProverb.add(remainingSeconds);
			theFrameForProverb.add(labelAnswerA);
			theFrameForProverb.add(labelAnswerB);
			theFrameForProverb.add(labelAnswerC);
			theFrameForProverb.add(labelAnswerD);
			theFrameForProverb.add(choiceA);
			theFrameForProverb.add(choiceB);
			theFrameForProverb.add(choiceC);
			theFrameForProverb.add(choiceD);
			theFrameForProverb.add(textarea);
			theFrameForProverb.add(textfield);
			theFrameForProverb.setVisible(true);

			trackNextQuestion();
		}

		Timer theTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				remainingSeconds.setText(String.valueOf(seconds));
				if (seconds <= 0) {
					answerDisplayed();
				}
			}
		});

		// Keeps track of the next question and if there are more questions it displays
		// the next question from the proverb questions array and the choices from the
		// choices 2d array
		public void trackNextQuestion() {
			if (i >= totalQuestions) {
				results();
			} else {
				textfield.setText("Q " + (i + 1));
				textarea.setText(proverbQuestions[i]);
				labelAnswerA.setText(choices[i][0]);
				labelAnswerB.setText(choices[i][1]);
				labelAnswerC.setText(choices[i][2]);
				labelAnswerD.setText(choices[i][3]);
				theTimer.start();
			}
		}

		//Keeps track of the correct answers to display at the end of the proverb questions
		@Override
		public void actionPerformed(ActionEvent e) {

			choiceA.setEnabled(false);
			choiceB.setEnabled(false);
			choiceC.setEnabled(false);
			choiceD.setEnabled(false);

			if (e.getSource() == choiceA) {
				answerForProverb = 'A';
				if (answerForProverb == correctChoice[i]) {
					correctAnswers++;
				}
			}
			if (e.getSource() == choiceB) {
				answerForProverb = 'B';
				if (answerForProverb == correctChoice[i]) {
					correctAnswers++;
				}
			}
			if (e.getSource() == choiceC) {
				answerForProverb = 'C';
				if (answerForProverb == correctChoice[i]) {
					correctAnswers++;
				}
			}
			if (e.getSource() == choiceD) {
				answerForProverb = 'D';
				if (answerForProverb == correctChoice[i]) {
					correctAnswers++;
				}
			}
			answerDisplayed();
		}
		
		//Displays the correct answer with a different color when a choice is chosen
		public void answerDisplayed() {

			theTimer.stop();

			choiceA.setEnabled(false);
			choiceB.setEnabled(false);
			choiceC.setEnabled(false);
			choiceD.setEnabled(false);

			if (correctChoice[i] != 'A')
				labelAnswerA.setForeground(new Color(255, 0, 0));
			if (correctChoice[i] != 'B')
				labelAnswerB.setForeground(new Color(255, 0, 0));
			if (correctChoice[i] != 'C')
				labelAnswerC.setForeground(new Color(255, 0, 0));
			if (correctChoice[i] != 'D')
				labelAnswerD.setForeground(new Color(255, 0, 0));

			Timer pause = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					labelAnswerA.setForeground(Color.blue);
					labelAnswerB.setForeground(Color.blue);
					labelAnswerC.setForeground(Color.blue);
					labelAnswerD.setForeground(Color.blue);

					answerForProverb = ' ';
					seconds = 10;
					remainingSeconds.setText(String.valueOf(seconds));
					choiceA.setEnabled(true);
					choiceB.setEnabled(true);
					choiceC.setEnabled(true);
					choiceD.setEnabled(true);
					i++;
					trackNextQuestion();
				}
			});

			pause.setRepeats(false);
			pause.start();
		}
		
		// Displays the final results
		public void results() {

			choiceA.setEnabled(false);
			choiceB.setEnabled(false);
			choiceC.setEnabled(false);
			choiceD.setEnabled(false);

			finalResult = (int) ((correctAnswers / (double) totalQuestions) * 100);

			textfield.setText("RESULTS!");
			textarea.setText("");
			labelAnswerA.setText("");
			labelAnswerB.setText("");
			labelAnswerC.setText("");
			labelAnswerD.setText("");

			rightNumber.setText("(" + correctAnswers + "/" + totalQuestions + ")");
			percentCorrectAnswer.setText(finalResult + "%");

			theFrameForProverb.add(rightNumber);
			theFrameForProverb.add(percentCorrectAnswer);

		}
		

	}	
	
