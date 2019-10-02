package list;
import java.util.concurrent.Callable;
public class CirDoublyList<T> {
    public DoubleNode<T> head;
    public CirDoublyList()
    {
        this.head=new DoubleNode<T>();
        this.head.prev=this.head;
        this.head.next=this.head;
    }
    public CirDoublyList(CirDoublyList<T> other) {
        this();
        DoubleNode<T> p = other.head.next;
        DoubleNode<T> q = head;
        while (p != other.head) {
            DoubleNode<T> pnew = new DoubleNode<T>(p.data);
            pnew.next = q.next;
            pnew.prev = q;
            q.next = pnew;
            q = q.next;
            p = p.next;
        }
    }
    public CirDoublyList(T[] values){
            this();
            for(int i=0;i<values.length;i++)
            {
                this.insert(values[i]);
            }
        }

    public boolean isEmpty()
    {
        return this.head.next==this.head;
    }
    public DoubleNode<T> insert(int i,T x)
    {
        if(x==null)
            throw  new  NullPointerException("x==null");
        DoubleNode<T>front=this.head;
        for(int j=0;front.next!=this.head&&j<i;j++)
        {
            front=front.next;
        }
        DoubleNode<T> q=new DoubleNode<T>(x,front,front.next);
        front.next.prev=q;
        front.next=q;
        return q;
    }
    public DoubleNode<T> insert(T x)
    {
        if(x==null)
        {throw new NullPointerException("x==null");}
        DoubleNode<T> q=new DoubleNode<T>(x,head.prev,head);
        head.prev.next=q;
        head.prev=q;
        return q;
    }
    public String toPreviousString()
    {
        String str="";
        DoubleNode<T> p=head.prev;
        while(p!=head)
        {
           str=str+p.toString();
           p=p.prev;
        }
        return str;
    }
    public T removeLast()
    {
        if(this.isEmpty())
            return null;
        DoubleNode<T> p=head.prev;
        head.prev=p.prev;
        p.prev.next=head;
        return p.data;
    }
    public void removeAll(CirDoublyList<T> pattern)
    {
        DoubleNode<T> p=head.next;
        DoubleNode<T> q=pattern.head.next;
        DoubleNode<T> start;
        while(p!=head)
        {
            if(p.equals(q))
            {
                start=p;
                while(q!=pattern.head)
                {
                    if(p.equals(q))
                    {
                        p=p.next;
                        q=q.next;
                    }
                    else
                        break;
                }
                if (q==pattern.head)
                {
                    start.prev.next=p;
                    p.prev=start.prev;
                    q=pattern.head.next;
                }
                else
                {
                    q=pattern.head.next;
                }
            }
            p=p.next;
        }
    }
}
