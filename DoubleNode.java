package list;
public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> prev,next,head;
    public DoubleNode(T data,DoubleNode<T>prev,DoubleNode<T>next)
    {
        this(data);
        this.prev=prev;
        this.next=next;
    }
    public DoubleNode(T data)
    {
          this();
          this.data=data;
    }
    public DoubleNode()
    {
        prev=null;
        next=null;
    }
    public String toString() {
        return data.toString();
    }
    public boolean equals(DoubleNode<T> others)
    {
        if(others.data.equals(this.data))
        {return true;}
        else
        {return false;}
    }
}
