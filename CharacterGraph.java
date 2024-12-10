import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CharacterGraph {

    ArrayList<CharacterNode> nodeArray;
    int[][] matrix;

    int size;

    CharacterGraph(int size){
        this.size = size;
        matrix = new int[size][size];
        nodeArray = new ArrayList<>();
        loadGraph();
    }

    public void addNode(String characterName, ImageIcon characterImg){
        CharacterNode newNode = new CharacterNode(characterName, characterImg);
        nodeArray.add(newNode);
    }

    public void addEdge(int src, int dst){
        matrix[src][dst] = 1;
        matrix[dst][src] = 1;

    }
    public void loadGraph(){
        addNode("ash",new ImageIcon("Images/AshIcon.png"));
        addNode("Brock",new ImageIcon("Images/BrockIcon.png"));
        addNode("Misty",new ImageIcon("Images/MistyIcon.png"));
        addNode("Proffessor Oak",new ImageIcon("Images/Dr.OakIcon.png"));
        addNode("Jessie",new ImageIcon("Images/JessieIcon.png"));
        addNode("James",new ImageIcon("Images/JamesIcon.png"));

        addEdge(0,1);
        addEdge(0,2);
        addEdge(0,3);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,3);
        addEdge(4,5);
    }

    public CharacterNode getNode (int index){
        return nodeArray.get(index);
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public boolean checkEdge(int src, int dst){
        if(matrix[src][dst] == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public void printGraph(){

        for(CharacterNode node: nodeArray) {
            System.out.print(node.characterName + " ");
        }
        System.out.println();
        for(int i = 0; i < matrix.length; ++i){
            System.out.print(nodeArray.get(i).characterName + " ");
            for(int j = 0; j < matrix[i].length; ++j){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }


}
