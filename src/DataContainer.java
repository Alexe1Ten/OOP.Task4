import java.lang.reflect.Array;
import java.util.Arrays;

public class DataContainer<T> {
    private static final int capacity = 10;
    private T[] data;
    private int size = 0;

    public DataContainer(Class<T> t) {
        @SuppressWarnings("unchecked")
        final T[] data = (T[]) Array.newInstance(t, capacity);
        this.data = data;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Ошибка! Выход за пределы DataContainer");
        }
    }

    public T get(int index) {
        return data[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < data.length; i++) {
            data[i - 1] = data[i];
        }
        data = Arrays.copyOf(data, data.length - 1);
        size--;
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                i = data.length;
            } else {
                stringBuilder.append(data[i]).append(",");
            } 
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    
}
