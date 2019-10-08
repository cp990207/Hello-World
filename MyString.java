package list;

import java.util.Arrays;

public class MyString  {
    private String a;
    private int size;
    public MyString(String a) {
        this.a = a;
        this.size=a.length();
    }

    @Override
    public String toString() {
        return "MyString{" +
                "a='" + a + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public boolean indexOf(MyString pattern)
    {
        int i=0,j=0;
        while(i<size)
        {
            if(a.charAt(i++)==pattern.a.charAt(j))
            {
                if(j<pattern.size-1)
                    j++;
                else
                    return true;
            }
            else {
                i = i-j;
                j = 0;
            }
        }
        return false;
    }
    public int[] get_next(String a)
    {
        int[] next=new int[a.length()];
        next[0]=-1;
        int k=-1;
        for(int i=1;i<a.length();i++)
        {
            if(a.charAt(i)==a.charAt(k+1))
                k++;
            else
                k=-1;
            next[i]=k==-1?0:k;
        }
        return next;
    }
    public int kmp(String b)
    {
        int[] next=get_next(b);
        if(this.a==null||b==null)
        {
            return -1;
        }
        int i=0,j=0;
        while(i<this.a.length()&&j<b.length())
        {
            if(j==-1||b.charAt(j)==this.a.charAt(i))
            {
                i++;
                j++;
            }
            else
                j=next[j];
        }
        if(j==b.length())
            return i-j;
        return -1;
    }
}
