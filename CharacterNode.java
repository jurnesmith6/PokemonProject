import javax.swing.*;
import java.awt.*;

public class CharacterNode {
    String characterName;
    ImageIcon characterImg;

    CharacterNode(String characterName, ImageIcon characterImg){
        this.characterName = characterName;
        this.characterImg = characterImg;
    }

    public ImageIcon getCharacterICon(){
        return scaleImg(characterImg,150,100);
    }

    public ImageIcon scaleImg(ImageIcon img, int width, int height){
        ImageIcon icon = img;
        Image scaledImg = icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        return icon;
    }

}
