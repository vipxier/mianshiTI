package Week1;

public class CircleQueue
{
    private int[] queue;
    private int start;
    private int end;
    private int size;
    private int currentFront;
    private int currentRear;

    public CircleQueue(int size)
    {
        this.size = size;
        this.queue = new int[size];
        this.start = 0;
        this.end = size - 1;
        this.currentFront = 0;
        this.currentRear = 0;

    }

    public int front()
    {
        return queue[currentFront];
    }

    public int rear()
    {
        return queue[currentRear];
    }

    public void enQueue(int target)
    {
        if (currentRear+1 == currentFront  || (currentRear + 1 == this.size && currentFront == 0 ))
        {
           System.out.println("Queue is full!");
           return;
        }
        
        if(currentRear == this.size-1 && currentFront != 0)
        {
            currentRear = 0;
            queue[currentRear] = target;
            return;
        }
        
        currentRear += 1;
        queue[currentRear] = target;
    }
    
    public int deQueue() {
        int value = queue[currentFront];

        if (currentFront == currentRear)
        {
            queue[currentFront] = 0;
        }
        else
        {
            if(currentFront == this.size -1 && currentRear != 0)
            {
                queue[currentFront] = 0;
                currentFront = 0;
            }
            else
            {
                queue[currentFront] = 0;
                currentFront++;
            }
        }
        return value;
        
    }
}
