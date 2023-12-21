import java.util.Random;
import java.util.Scanner; 

public class Test {
    public static void main(String[] args) {
        int a;
        Scanner Scan_in = new Scanner(System.in); 
        System.out.print("Please input the Number of elements to be inserted into the BST Tree: ");
        a=Scan_in.nextInt();

        BST bst = new BST(); 
        Random random = new Random();
        for(int i=0 ; i < a ; i++){
        bst.insert(random.nextInt(a));
        }
          
        System.out.println("Number of elements inserted: " + bst.size());
        System.out.println("Height of Tree: " + bst.height(bst.getRoot()));

        
        
    }
}
 