import javax.swing.*;
import java.awt.*;

public class PokemonCard {
    String name;
    String type;
    String attack;
    String description;
    int attackPower;
    int hp;
    ImageIcon pokemonImg;
    JButton pokemonButton;
   public PokemonCard(String name, String type, String attack, int attackPower, int hp,ImageIcon img, String description){
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.attackPower = attackPower;
        this.hp = hp;
        this.pokemonImg = img;
        this.description = description;
    }
    public String getName(){
        return name;
    }
    public String getType(){
       return type;
    }
    public String getAttack(){
        return attack;
    }
    public int getAttackPower(){
       return attackPower;
    }
    public int getHP(){
        return hp;
    }

    public String toString(){
       String nameStr = "[Name: " + name + "]\n";
       String typeStr = "[Type: " + type + "]\n";
       String attackStr = "[Attack: " + attack + "]\n";
       String attackPwrStr = "[Attack Power: " + attackPower + "]\n";
       String hpStr = "[HP: " + hp + "]";
       return nameStr + typeStr + attackStr + attackPwrStr + hpStr;
    }
    public ImageIcon scaleImg(ImageIcon img, int width, int height){
        ImageIcon icon = img;
        Image scaledImg = icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        return icon;
    }

    public ImageIcon getPokemonImg(){
       return pokemonImg;
    }
    public JButton getButton(Color color){
       pokemonButton = new JButton();
       pokemonButton.setIcon(scaleImg(pokemonImg,95,95));
       pokemonButton.setPreferredSize(new Dimension(100,100));
       pokemonButton.setBorder(BorderFactory.createLineBorder(color,5));
       return pokemonButton;
    }


}
