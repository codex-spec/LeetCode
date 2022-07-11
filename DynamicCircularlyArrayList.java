public class DynamicCircularlyArrayList<E> implements List<E> {
    
    protected int size = 0;
    public E[] data;
    //protected E tail = data[size-1];

    public DynamicCircularlyArrayList() {this(10);}

    public DynamicCircularlyArrayList(int cap) {
        data = (E[]) new Object[cap];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size  == 0;
    }

    public void checkIndex(int i) throws IndexOutOfBoundsException{
        if(i < 0 || i > data.length) {
            throw new IndexOutOfBoundsException("the index " + i + "is not within the Lists range");
        }
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i);
        if(size == data.length) {
            resize(2 * data.length);
        }
        if(i == size-1) {
        data[size-1] = e;
        //tail = data[size-1];
        }else {
        for(int k = size-1; k > i; k--) {
            data[k+1] = data[k];
        }
        data[i] = e;
        }
        size++;
    }

    public void resize(int newlen) {
        E[] newData = (E[]) new Object[newlen];
        for(int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i);
        E tmp = data[i];
        if(isEmpty()) throw new IndexOutOfBoundsException("cannot remove anything from an empty array");
        for(int j = i; j < size-1; j++) {
            data[j] = data[j+1];
        }
        data[size()-1] = null;
        size--;
        return tmp;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i);
        if(isEmpty()) return null;
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i);
        E tmp = data[i];
        data[i] = e;
        return tmp;
    }

    public static void main(String[] args) {
        CircularlyArrayList<Integer> cl1 = new CircularlyArrayList<Integer>(15);
        int p = 999999999;
        for(int k = 0; k < 15; k++) {
            cl1.add(k, p);
            p/=4;
        }

        for(int j = 0; j < cl1.size; j++) {
            System.out.print(" " + cl1.get(j));
        }

    }
}