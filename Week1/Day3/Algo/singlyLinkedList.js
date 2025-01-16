/**
 * A class to represents a single item of a SinglyLinkedList that can be
 * linked to other Node instances to form a list of linked nodes.
 */
class Node {
    /**
     * Constructs a new Node instance. Executed when the 'new' keyword is used.
     * @param {any} data The data to be added into this new instance of a Node.
     *    The data can be anything, just like an array can contain strings,
     *    numbers, objects, etc.
     * @returns {Node} This new Node instance is returned automatically without
     *    having to be explicitly written (implicit return).
     */
    constructor(data) {
      this.data = data;
      /**
       * This property is used to link this node to whichever node is next
       * in the list. By default, this new node is not linked to any other
       * nodes, so the setting / updating of this property will happen sometime
       * after this node is created.
       *
       * @type {Node|null}
       */
      this.next = null;
    }
  }
  
  /**
   * This class keeps track of the start (head) of the list and to store all the
   * functionality (methods) that each list should have.
   */
  class SinglyLinkedList {
    /**
     * Constructs a new instance of an empty linked list that inherits all the
     * methods.
     * @returns {SinglyLinkedList} The new list that is instantiated is implicitly
     *    returned without having to explicitly write "return".
     */
    constructor() {
      /** @type {Node|null} */
      this.head = null;
    }
  
    /**
     * Determines if this list is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {
      // TODO: your code here
      //if the head is null return true else return false
      return this.head === null;
    }
  
    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * - Time: O(n) linear, n = length of list.
     * - Space: O(1) constant.
     * @param {any} data The data to be added to the new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBack(data) {
      //create a const of type Node and pass it the data given in the parameter to create a node
      const newBack = new Node(data);
  
      //check if the list is empty add the created node to the head and return the instance (this)
      if (this.isEmpty()) {
        this.head = newBack;
        return this;
      }
      //else create a new variable initialized to the head
      let runner = this.head;
      // looping while the next node of current node is not null
      while (runner.next !== null) {
          // set the current node to its next node
        runner = runner.next;
      }
      //if we reach the end of the list
      //add the created node to the next of the current node and return the instance (this)
      runner.next = newBack;
      return this;
    }
  
    /**
     * Creates a new node with the given data and inserts it at the back of
     * this list.
     * - Time: O(n) linear, n = length of list.
     * - Space: O(n) linear due to the call stack.
     * @param {any} data The data to be added to the new node.
     * @param {?Node} runner The current node during the traversal of this list
     *    or null when the end of the list has been reached.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackRecursive(data, runner = this.head) {
      //check if the singly linked list is empty, create a new node using the given data and add it to the head and return the instance (this)
      if (this.isEmpty()) {
        this.head = new Node(data);
        return this;
      }
  
      //check if the next of the runner node is null, create a new node using the given data and add it to the next of the runner node and return the instance (this)
      if (runner.next === null) {
        runner.next = new Node(data);
        return this;
      }
      //else return the recursion of the function using the same data but the runner will point on the next not the head
      return this.insertAtBackRecursive(data, runner.next);
    }
  
    /**
     * Calls insertAtBack on each item of the given array.
     * - Time: O(n * m) n = list length, m = arr.length.
     * - Space: O(1) constant.
     * @param {Array<any>} vals The data for each new node.
     * @returns {SinglyLinkedList} This list.
     */
    insertAtBackMany(vals) {
      for (const item of vals) {
        this.insertAtBack(item);
      }
      return this;
    }
  
    /**
     * Converts this list into an array containing the data of each node.
     * - Time: O(n) linear.
     * - Space: O(n).
     * @returns {Array<any>} An array of each node's data.
     */
    toArr() {
      const arr = [];
      let runner = this.head;
  
      while (runner) {
        arr.push(runner.data);
        runner = runner.next;
      }
      return arr;
    }

    listlength(){
        let count=1
        let begin = this.head;
        // looping while the next node of current node is not null
        while (begin.next !== null) {
            // set the current node to its next node
          begin = begin.next;
          count++
        }
        return count 
    }
    insertAtFront(data){
        const newnode= new Node(data)
        newnode.next=this.head
        return this ;
        }
    removehead(){
        if(this.isEmpty){
            return null
        }
        const temp=this.head;
        this.head=this.head.next ;
        return temp 
    }   
    average(){
        let runner=this.head
        let sum=0;
        let count=0
        while(runner){
            sum=+runner.data
            count++
            runner=runner.next 
        }
        return sum/count 
    } 
  
  removeback(){
    let runner=this.head ;
    if(runner===null){
      return "List Is empty"
    }
    if (this.listlength()===1){
    
    return this.removehead()
  }
    while(runner.next.next!=null){
      runner=runner.next   ;
      

    }
    var tempdata=runner.next.data ;
    runner.next=null ;
    return tempdata ;
  }
  contains(){

  }

secondtolast(){
  let runner=this.head;
  if (runner===null ||runner.next===null){
    return null
  }
  let count=0 ;
  while (count<this.listlength()-2){
    runner=runner.next ;
    count ++;
  }
  return runner.data ;
}

removeval(val){
  if (this.isEmpty()){
    return false
  }
  let runner=this.head ;
  let trigger=false ;
  for(let i=0;i<this.listlength()-2;i++){
    if (runner.data===val){
      trigger=true ;
    }
    if (trigger){
      runner.next=runner.next.next
    }
   runner=runner.next ;  
  }
  return true

}




concat(addlist){
  let trigger=false
  let runner=this.head 
  if(runner===null){
    this.head=addlist.head ;
    return this
  }
  while (trigger===false){
    if (runner.next===null){
      runner.next=addlist.head ;
      trigger=true ;
    }
    runner=runner.next ;
  }
  return this
}






}
  const emptyList = new SinglyLinkedList();
  console.log(emptyList.secondtolast());
  const singleNodeList = new SinglyLinkedList().insertAtBackMany([1]);
  console.log(singleNodeList.secondtolast()) ;
  const biNodeList = new SinglyLinkedList().insertAtBackMany([1, 2]);
  const firstThreeList = new SinglyLinkedList().insertAtBackMany([1, 2, 3]);
  const secondThreeList = new SinglyLinkedList().insertAtBackMany([4, 5, 6]);
  
  const unorderedList = new SinglyLinkedList().insertAtBackMany([
    -5, -10, 4, -3, 6, 1, -7, -2,
  ]);
  
  /* node 4 connects to node 1, back to head */
  const perfectLoopList = new SinglyLinkedList().insertAtBackMany([1, 2, 3, 4]);
  perfectLoopList.head.next.next.next = perfectLoopList.head;
  
  /* node 4 connects to node 2 */
  const loopList = new SinglyLinkedList().insertAtBackMany([1, 2, 3, 4]);
  loopList.head.next.next.next = loopList.head.next;
  
  const sortedDupeList = new SinglyLinkedList().insertAtBackMany([
    1, 1, 1, 2, 3, 3, 4, 5, 5,
  ]);
  
  // Print your list like so:
  console.log(firstThreeList.toArr());
  console.log("*********************")
  console.log(secondThreeList.listlength());


  const tetslist=new SinglyLinkedList().insertAtBackMany([10,20,30,40]) ;
  console.log("initial test",tetslist.toArr()) ;
  console.log(tetslist.removeval(20)) ;
  console.log("initial test",tetslist.toArr()) ;
  console.log(tetslist.secondtolast()) ;

  const removeback=tetslist.removeback()
  console.log("After remove Back () : ",tetslist.toArr(),"|| Removed data :",removeback) ;

  const tetslist1=new SinglyLinkedList().insertAtBackMany([7]) ;
  console.log("initial test",tetslist1.toArr()) ;
  const removeback1=tetslist1.removeback()
  console.log("After remove Back () : ",tetslist1.toArr(),"|| Removed data :",removeback1) ;

 singleNodeList.concat(emptyList);
 console.log(singleNodeList.toArr());