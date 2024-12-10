import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharactersPanel extends JPanel implements ActionListener {
    JLabel title;
    JButton homeButton;

    CharactersPanel(){

        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(75,100));
        titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        titlePanel.setBackground(new Color(0xFC90919C, true));
        title = new JLabel("Character Friend Graph");
        title.setFont(new Font("Roboto",Font.PLAIN,20));
        title.setForeground(new Color(0x0A6906));
        title.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xFC90919C));
        buttonPanel.setPreferredSize(new Dimension(75,0));
        homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(75,25));
        ImageIcon homeIcon = scaleImg(new ImageIcon("Images/HomeIcon.png"),15,15);
        homeButton.setIcon(homeIcon);

        buttonPanel.add(homeButton);

        titlePanel.add(buttonPanel, BorderLayout.WEST);

        add(titlePanel,BorderLayout.NORTH);

        JPanel graphPanel = new JPanel(new BorderLayout());
        graphPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        graphPanel.setBackground(new Color(0x0A6906));

        JPanel topCharacterListPanel = new JPanel(new GridLayout(1,6));
        topCharacterListPanel.setBackground(new Color(0x0A6906));
        topCharacterListPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));

        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(100,100));
        topCharacterListPanel.add(label);

        CharacterGraph charGraph = new CharacterGraph(6);

        for(int i = 0; i < charGraph.size; ++i){
            JLabel characterLabel = new JLabel(charGraph.getNode(i).getCharacterICon());

            topCharacterListPanel.add(characterLabel);
        }

        graphPanel.add(topCharacterListPanel, BorderLayout.NORTH);


        JPanel sideCharacterListPanel = new JPanel(new GridLayout(6,1));
        sideCharacterListPanel.setPreferredSize(new Dimension(150,0));
        sideCharacterListPanel.setBackground(new Color(0x0A6906));
        sideCharacterListPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));

        for(int i = 0; i < charGraph.size; ++i){
            JLabel characterLabel = new JLabel(charGraph.getNode(i).getCharacterICon());
            characterLabel.setPreferredSize(new Dimension(100,100));
            characterLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            sideCharacterListPanel.add(characterLabel);
        }

        graphPanel.add(sideCharacterListPanel, BorderLayout.WEST);


        JPanel matrixPanel = new JPanel(new GridLayout(6,6));

        matrixPanel.setBackground(new Color(0x0A6906));

        int[][] charMatrix = charGraph.getMatrix();

        for(int i = 0; i < charMatrix.length; ++i ){
            for(int j = 0; j < charMatrix[i].length; ++j){
                JLabel friendLabel = new JLabel();
                if(charMatrix[i][j] == 1)
                    friendLabel.setText("Friend");
                friendLabel.setPreferredSize(new Dimension(150,100));
                friendLabel.setHorizontalAlignment(JLabel.CENTER);
                friendLabel.setFont(new Font("Roboto",Font.PLAIN,30));
                matrixPanel.add(friendLabel);
            }
        }

        graphPanel.add(matrixPanel);

        add(graphPanel, BorderLayout.CENTER);

    }

    public ImageIcon scaleImg(ImageIcon img, int width, int height){
        ImageIcon icon = img;
        Image scaledImg = icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

