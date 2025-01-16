//? resources: https://www.geeksforgeeks.org/binary-search-tree-data-structure/
/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
class BSTNode {
  /**
   * Constructs a new instance of a BST node.
   * @param {number} data The integer to store in the node.
   */
  constructor(data) {
    this.data = data;
    /**
     * These properties are how this node is connected to other nodes to form
     * the tree. Similar to .next in a SinglyLinkedList except a BST node can
     * be connected to two other nodes. To start, new nodes will not be
     * connected to any other nodes, these properties will be set after
     * the new node is instantiated.
     *
     * @type {BSTNode|null}
     */
    this.left = null;
    /** @type {BSTNode|null} */
    this.right = null;
  }
}

/**
 * Represents an ordered tree of nodes where the data of left nodes are <= to
 * their parent and the data of nodes to the right are > their parent's data.
 */
class BinarySearchTree {
  constructor() {
    /**
     * Just like the head of a linked list, this is the start of our tree which
     * branches downward from here.
     *
     * @type {BSTNode|null}
     */
    this.root = null;
  }

  //TODO
  /**
   * Determines if this tree is empty.
   * - Time: O(?).
   * - Space: O(?).
   * @returns {boolean} Indicates if this tree is empty.
   */
  isEmpty() {
    //TODO: your code here
    if (this.right===null && this.left===null)
      return true
    else 
      return false 
  }

  /**
   * Retrieves the smallest integer data from this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} current The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {number} The smallest integer from this tree.
   */
  min(current = this.root) {
    let temp=this.root ;
    let trigger=false 
    while (trigger===false){
      if (temp.left===null){
        trigger=true ;
        return temp.data
      }
      temp=temp.left ;
    }
    //TODO: your code here
  }

  // !EXTRA
  /**
   * Retrieves the smallest integer data from this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} current The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {number} The smallest integer from this tree.
   */
  minRecursive(current = this.root) {
    //TODO: your code here
    if (current.left===null){
      return current.data
    }
    else
      return this.minRecursive(current=current.left)
    
  }

  /**
   * Retrieves the largest integer data from this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} current The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {number} The largest integer from this tree.
   */
  max(current = this.root) {
    //TODO: your code here
    let temp=this.root ;
    let trigger=false 
    while (trigger===false){
      if (temp.right===null){
        trigger=true ;
        return temp.data
      }
      temp=temp.right ;
    }
  }

  //   !EXTRA
  /**
   * Retrieves the largest integer data from this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} current The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {number} The largest integer from this tree.
   */
  maxRecursive(current = this.root) {
    //TODO: your code here
    if (current.right===null){
      return current.data
    }
    else
      return this.maxRecursive(current=current.right)
    
  }

  // Logs this tree horizontally with the root on the left.
  print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
    if (!node) {
      return;
    }

    spaceCnt += spaceIncr;
    this.print(node.right, spaceCnt);

    console.log(
      " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
        `${node.data}`
    );

    this.print(node.left, spaceCnt);
  }


  contain(val){
    if (this.root.data===val)
      return true
    let current=this.root
      while(current!=null){
        if (current.data<val){
          current=current.right  
        }
        else current=current.left 
        if (current===null)
          return false
        if (current.data===val){
          return true 
        }
      }
  }

  insert(newval){
    const  nod=new BSTNode ;
      nod.data=newval ;
      let trigger=false
      let runner=this.head
      while(trigger===false){
        if(runner.next===null){
          runner.next=nod.head
          nod.next=null
          trigger=true
        }
        if (runner.data<nod.data){
          runner=runner.right ;
        }
        if(runner.data>nod.data){
          runner=runner.left ;
        }
      }

  }





  }





const emptyTree = new BinarySearchTree();
const oneNodeTree = new BinarySearchTree();
oneNodeTree.root = new BSTNode(10);
oneNodeTree.print()
console.log("min of one node tree: ", oneNodeTree.min());
console.log("max of one node tree: ", oneNodeTree.max());
/* twoLevelTree
        root
        10
      /   \
    5     15
*/
const twoLevelTree = new BinarySearchTree();
twoLevelTree.root = new BSTNode(10);
twoLevelTree.root.left = new BSTNode(5);
twoLevelTree.root.right = new BSTNode(15);
twoLevelTree.print()
console.log("min of two nodes tree: ", twoLevelTree.min());
console.log("max of two nodes tree: ", twoLevelTree.max());
/* threeLevelTree 
        root
        10
      /   \
    5     15
  / \    / \
2   6  13  
*/
const threeLevelTree = new BinarySearchTree();
threeLevelTree.root = new BSTNode(10);
threeLevelTree.root.left = new BSTNode(5);
threeLevelTree.root.left.left = new BSTNode(2);
threeLevelTree.root.left.right = new BSTNode(6);
threeLevelTree.root.right = new BSTNode(15);
threeLevelTree.root.right.left = new BSTNode(13);
threeLevelTree.print()
console.log("min of three nodes tree: ", threeLevelTree.min());
console.log("max of three nodes tree: ", threeLevelTree.max());
console.log("*******************************")
console.log("min of three nodes tree: ", threeLevelTree.minRecursive())

console.log("max of three nodes tree: ", threeLevelTree.maxRecursive());
console.log(threeLevelTree.contain(15))
console.log(threeLevelTree.contain(100))

console.log("****************************************")

const testtree=new BinarySearchTree();
testtree.insert(10);
testtree.insert(5);
testtree.insert(15);
testtree.insert(3);
testtree.insert(7);
testtree.insert(12);
testtree.insert(7);

testtree.print()