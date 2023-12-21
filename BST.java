public class BST {

public class Node{
private int key; 
private Node parent;
private Node leftChild;
private Node rightChild; 

public Node(){
   key = -1;
   parent = null;
   leftChild = null;
   rightChild = null; 
}

public Node(int key){
this.key = key;
parent = null;
leftChild = null;
rightChild = null; 
}

public Node(int key, Node parent, Node leftChild, Node rightChild){
this.key = key;
this.parent = parent;
this.leftChild = leftChild;
this.rightChild = rightChild;
}

public void setKey(int key){ //setter method
    this.key = key;
}

public int getKey(){ //getter method
    return key; 
}

public void setParent(Node parent){ //setter method
    this.parent = parent;
}
 
public Node getParent(){ //getter method
    return parent; 
}

public void setLeftChild(Node leftChild){ //setter method
    this.leftChild = leftChild;
}
 
public Node getLeftChild(){ //getter Method
    return leftChild; 
}

public void setRightChild(Node rightChild){ //setter method
    this.rightChild = rightChild;
}
 
public Node getRightChild(){ //getter Method
    return rightChild; 
}

}

private Node root;
private int counter;

public Node getRoot(){
return root;
}

BST(){
root = null;
counter = 0;
}

public int size(){ // Returns size
return counter; 
}

public void insert(int key){ // Inserts element
if (root == null){
root = new Node(key);
counter ++;
}
else{
Node current = root; 
Boolean stillInserting = true;
while(stillInserting){
if(key == current.getKey()){
stillInserting = false;
}
else if(key < current.getKey()){
Node leftChild = current.getLeftChild();
if(leftChild != null){
current = leftChild;
}
else{
current.setLeftChild(new Node(key, current, null, null));
stillInserting = false;
this.counter++;
}
}
else{
Node rightChild = current.getRightChild();
if(rightChild != null){
current = rightChild;
}
else{
current.setRightChild(new Node(key, current, null, null));
stillInserting = false;
this.counter++;
}
} 

}
}
}

public void delete(int key){ // Easier for user to call
  deleteNode(root,key);
}



 private Node deleteNode(Node root, int key) { //Standard way to delete got help from https://www.geeksforgeeks.org/deletion-in-binary-search-tree/
  if (root == null)
      return root;
  if (root.key > key) {
      root.leftChild = deleteNode(root.leftChild, key);
      return root;
  } else if (root.key < key) {
      root.rightChild = deleteNode(root.rightChild, key);
      return root;
  }
  counter--;
  if (root.leftChild == null) {
      Node temp = root.rightChild;
      return temp;
  } else if (root.rightChild == null) {
      Node temp = root.leftChild;
      return temp;
  }
  else {
      Node succesor = root;
      Node succ = root.rightChild;
      while (succ.leftChild != null) {
          succesor = succ;
          succ = succ.leftChild;
      }
      if (succesor != root)
          succesor.leftChild = succ.rightChild;
      else
          succesor.rightChild = succ.rightChild;
      root.key = succ.key;
      return root;
  }
  
}

 
public void printInOrder(){ // Easier for user to call
printInOrderMethod(root);
}


private void printInOrderMethod(Node node) { // prints list InOrder
    if (node != null) {
      printInOrderMethod(node.getLeftChild());
      System.out.println(" Traversed " + node.getKey());
      printInOrderMethod(node.getRightChild());
     }
    else if(root == null){
    System.out.println("List is Empty");
    }
  }

 public void printPreOrder(){ // Easier for user to call
  printPreOrderMethod(root);
}

  private void printPreOrderMethod(Node node) { // Prints list in PreOrder
    if (node == null) {
    System.out.println("List is empty");
    }
    else
    {
      System.out.println(" Traversed " + node.getKey());
      printPreOrderMethod(node.getLeftChild());
      printPreOrderMethod(node.getRightChild());  
    }
  }
  
 public void printPostOrder(){ //Easier for user to call
  printPostOrderMethod(root);
}

  private void printPostOrderMethod(Node node){ // Prints list in PostOrder
    if (node == null){ 
    System.out.println("List is empty");
    }
    else{
      printPostOrderMethod(node.getLeftChild());
      printPostOrderMethod(node.getRightChild());
      System.out.println(" Traversed " + node.getKey());
  }

   
}

public int height(Node node) {
    if (node == null) {
      return -1;
    }
    
    return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
  }

}

