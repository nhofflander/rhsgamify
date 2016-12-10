
//food for thought ideas if some one picks this program up
/*
make windows scale horazontally with longer text strings

save location that the windows were last at

fix cancel giving a blank string

add icon

rename variables for pepole to see code betters

add more comments

remove things that dont do anything

add file input for names of members

add file output for names of members

dont listen to more suggestions... jk

*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Gamify extends JFrame implements ActionListener
{


	//screen dimensions
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	private static int tNum = 3;//number of teams *edit1* making static forces the variable to not reset randomly :P

	private static ArrayList<String> people = new ArrayList<String>();
	private static ArrayList<String> teamList = new ArrayList<String>();

	int teamHold;

	static int frameWidth = 150;


	String members = "";


	private static JFrame displayMembers = new JFrame(); //displays the members currently in the array *edit* temp might be able to remove *edit 2* dont remove

	private static JPanel memberPanel = new JPanel();

	//stuff for team gen
	private static JFrame displayTeams = new JFrame("Teams");




	private static JButton addTeamMember = new JButton("Add a new team member"); //add a new team member

	private static JButton generateTeams = new JButton("Generate teams"); //generate teams

	private static JButton exit = new JButton("Exit"); //exit

	private static JButton numberOfTeams = new JButton("Number of teams");





	public static void makeWindow()
	{



		JFrame mainScreen = new JFrame("Main Menu"); //The window that opens when the programs starts
		mainScreen.setVisible(true);
		mainScreen.setSize(650, 450);
		mainScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainScreen.setResizable(false);
		mainScreen.setLocationRelativeTo(null);


		//exit
		String exitTool = "Close the program";
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		exit.setToolTipText(exitTool);


		//add team member
		String memberTool = "Add a new team member";
		mainScreen.add(addTeamMember, BorderLayout.EAST);
		addTeamMember.addActionListener(new Gamify());
		addTeamMember.setToolTipText(memberTool);


		//add title to people added display
		JLabel addMemberTitle = new JLabel("People:", JLabel.LEFT);
		addMemberTitle.setSize(150,15);
		addMemberTitle.setLocation(0,4);
		memberPanel.add(addMemberTitle);






		//team number
		String numberTool = "Input the number of teams to be created";
		mainScreen.add(numberOfTeams, BorderLayout.WEST);
		numberOfTeams.addActionListener(new Gamify());
		numberOfTeams.setToolTipText(numberTool);

		//generate teams
		String genTool = "Randomly generate the teams";
		mainScreen.add(generateTeams, BorderLayout.SOUTH);
		generateTeams.addActionListener(new Gamify());
		generateTeams.setToolTipText(genTool);

		//adding exit
		mainScreen.add(exit, BorderLayout.NORTH);
		exit.addActionListener(new Gamify());

		displayMembers.setResizable(false);
		displayTeams.setResizable(false);

		//extra test
		//for sound







	}

	public void actionPerformed(ActionEvent e)
	{


		if(e.getSource() == addTeamMember)
		{


			//visibility stoof
			displayMembers.setVisible(true);
			displayTeams.setVisible(false);




			memberPanel.setLayout(null);
			memberPanel.setOpaque(true);


			String newMember = JOptionPane.showInputDialog(null, "Enter the name of the new team member.");
			people.add(newMember);




			JLabel teamMembers = new JLabel(newMember,JLabel.LEFT);
			teamMembers.setSize(frameWidth,15);
			teamMembers.setLocation(0,(((people.size()-1)*15)+4+15));//optimize with teh maths
			memberPanel.add(teamMembers);


			displayMembers.setContentPane(memberPanel);
			displayMembers.setSize(frameWidth, (60+(15*people.size())));

			displayMembers.setLocation((dim.width/2 -displayMembers.getSize().width/2)+250, (dim.height/2-displayMembers.getSize().height/2)-20);


		}//if

		if(e.getSource() == generateTeams)
		{//generate the teams


			//visibility stoof
			displayMembers.setVisible(false);
			displayTeams.setVisible(true);

			JPanel disPanel = new JPanel();


			//System.out.println(tNum);//DEBUG FOR TNUM

			disPanel.setLayout(null);
			disPanel.setOpaque(true);



			teamHold = 0;

			teamList.clear();

			teamList.addAll(people);

			Collections.shuffle(teamList);







			//add the team numbers
			for(int x = 0; x< tNum; x++){
				JLabel tooth  = new JLabel(("Team #"+(x+1)),JLabel.LEFT);
				tooth.setSize(frameWidth,15);
				tooth.setLocation((frameWidth*x),0);

				disPanel.add(tooth);

			}






			//add the names
			for(int p = 0; p < teamList.size(); p++)
			{
				if(teamHold >= tNum){
					teamHold = 0;
				}


				JLabel namePanel = new JLabel(teamList.get(p));
				namePanel.setSize(frameWidth,15);
				namePanel.setLocation((teamHold*frameWidth),(15+ ((p/tNum)*15)));

				disPanel.add(namePanel);

				teamHold++;
			}


			displayTeams.setContentPane(disPanel);
			displayTeams.setPreferredSize( new Dimension( 640, 480 ) );
			displayTeams.validate();
			displayTeams.repaint();



			if(teamList.size() % tNum == 0){
				displayTeams.setSize((frameWidth*tNum), (55 + (teamList.size()/tNum*15)));
			}
			else{
				displayTeams.setSize((frameWidth*tNum), (70 + (teamList.size()/tNum*15)));
			}


			displayTeams.setLocation((dim.width/2 -displayTeams.getSize().width/2), (dim.height/2+80));




		}//if

		if(e.getSource() == exit)
		{
			System.exit(0);
		}//if

		if(e.getSource() == numberOfTeams)
		{
			//visibility stoof
			displayMembers.setVisible(false);
			displayTeams.setVisible(false);


			String teamNumberString = JOptionPane.showInputDialog(null,"How many teams should be generated?", tNum);
			try
			{
				tNum = Integer.parseInt(teamNumberString);
				//System.out.println(tNum);//this is debug line for tNum catching

			}//try
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Please Enter a number");
			}//catch
		}//else
	}//actionPerformed


	public static void main(String [] args){
		makeWindow();

	}


}//class
