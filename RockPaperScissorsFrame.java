import javax.swing.*;
import java.awt.*;

public class RockPaperScissorsFrame extends JFrame {

    private JTextField PlayerWins, ComputerWins, Ties;
    private JTextArea Results;

    public RockPaperScissorsFrame() {

        //GAME TITLE
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //GAME PANELS
        add(createGamePanel(), BorderLayout.CENTER);
        add(createStatsPanel(), BorderLayout.NORTH);
        add(createResultsPanel(), BorderLayout.SOUTH);

        //FRAME SIZE
        setSize(650, 400);
        setVisible(true);
    }
        //METHOD - ROCK PAPER SCISSORS BUTTONS
           private JPanel createGamePanel(){
            JPanel GamePanel = new JPanel();
            GamePanel.setBorder(BorderFactory.createTitledBorder("Rock Paper Scissors Game"));

            //BUTTONS
            JButton RockButton = new JButton("Rock");
            JButton PaperButton = new JButton("Paper");
            JButton ScissorsButton = new JButton("Scissors");
            JButton QuitButton = new JButton("Quit");

            RockButton.addActionListener(e -> PlayGame("Rock"));
            PaperButton.addActionListener(e -> PlayGame("Paper"));
            ScissorsButton.addActionListener(e -> PlayGame("Scissors"));
            QuitButton.addActionListener(e -> System.exit(0));

            GamePanel.add(RockButton);
            GamePanel.add(PaperButton);
            GamePanel.add(ScissorsButton);
            GamePanel.add(QuitButton);

            return GamePanel;
        }
        //PLAYING GAME
        private void PlayGame(String PlayerChoice) {
            String[] choices = {"Rock", "Paper", "Scissors"};
            String ComputerChoice = choices[(int) (Math.random() * choices.length)];

            String Result;
            if (PlayerChoice.equals(ComputerChoice)) {
                Result = "It's A Tie!";
                updateStats("Tie");
            } else if (
                    (PlayerChoice.equals("Rock") && ComputerChoice.equals("Scissors")) ||
                    (PlayerChoice.equals("Paper") && ComputerChoice.equals("Rock")) ||
                    (PlayerChoice.equals("Scissors") && ComputerChoice.equals("Paper"))
            ) {
                Result = "Player Wins! " + PlayerChoice + " Beats " + ComputerChoice;
                updateStats("Player");
            } else {
                Result = "Computer Wins! " + ComputerChoice + " Beats " + PlayerChoice;
                updateStats("Computer");
            }
            Results.append(Result + "\n");
        }
        //UPDATE
        private void updateStats(String Winner){
        int playerWins = Integer.parseInt(PlayerWins.getText());
        int computerWins = Integer.parseInt(ComputerWins.getText());
        int ties = Integer.parseInt(Ties.getText());

        if (Winner.equals("Player")){
            PlayerWins.setText(String.valueOf(playerWins + 1));
        }else if (Winner.equals("Computer")){
            ComputerWins.setText(String.valueOf(computerWins + 1));
        }else {
            Ties.setText(String.valueOf(ties + 1));
        }
    }
        //STATS PANEL
        private JPanel createStatsPanel(){
        JPanel StatsPanel = new JPanel();
        StatsPanel.add(new JLabel("Game Stats"));

        PlayerWins = new JTextField("0",5);
        PlayerWins.setEditable(false);
        StatsPanel.add(new JLabel("Player Wins"));
        StatsPanel.add(PlayerWins);

        ComputerWins = new JTextField("0",5);
        ComputerWins.setEditable(false);
        StatsPanel.add(new JLabel("Computer Wins"));
        StatsPanel.add(ComputerWins);

        Ties = new JTextField("0",5);
        Ties.setEditable(false);
        StatsPanel.add(new JLabel("Ties"));
        StatsPanel.add(Ties);

        return StatsPanel;
    }
        //RESULTS PANEL
        private JPanel createResultsPanel(){
        JPanel ResultsPanel = new JPanel();

        Results = new JTextArea(5,25);
        Results.setEditable(false);
        JScrollPane resultsScrollPane = new JScrollPane(Results);

        ResultsPanel.add(new JLabel("Results"));
        ResultsPanel.add(resultsScrollPane);

        return ResultsPanel;
        }

        public static void main(String[] args) {
        new RockPaperScissorsFrame();
        }

}
