
public class RingBuffer {
	
	int front;
	int back;
	int length;
	int MaxCapacity;
	double[] buffer;

    /**
     * create an empty ring buffer, with given max capacity
     *
     * @param capacity max capacity
     */
    public RingBuffer(int capacity) {
    	front = 0;
    	back = 0;
    	length = 0;
    	MaxCapacity = capacity;
    	buffer = new double[capacity];
//    	System.out.println("created buffer");
    	
    }

    /**
     * return number of items currently in the buffer
     *
     * @return number of items
     */
    public int size() {
    	return length;
    }

    /**
     * is the buffer empty (size equals zero)?
     *
     * @return <code>true</code> if buffer is empty
     */
    public boolean isEmpty() {
    	return back==front;
    }	
    
    /**
     * is the buffer full (size equals capacity)?
     *
     * @return <code>true</code> if the buffer is full
     */
    public boolean isFull() {
    	return length==MaxCapacity;
    }

    /**
     * add item x to the end
     *
     * @param x a <code>double</code> 
     */
    public void enqueue(double x) {
    	back = (back + 1) % MaxCapacity;
    	if (back==front){
    		front = (front + 1) % MaxCapacity;
    	}
    	buffer[back] = x;
    	//System.out.println("enqueue");
    }

    /**
     * delete and return item from the front
     *
     * @return a <code>double</code> value
     */
    public double dequeue(){
    	double temp = buffer[front];
    	
    	front = (front + 1) % MaxCapacity;
//    	System.out.println("dequeue");
    	return temp;
    }
    
    /**
     * return (but do not delete) item from the front
     *
     * @return front of queue
     */
    double peek() {
		return buffer[front];
    }


}