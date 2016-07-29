import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * author: 龚细军
 * class-aim:
 */


class LruCache extends LinkedHashMap {
    private static final long serialVersionUID = 1L;
    private int maxElements = 5; //default size is 5

    public int getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(int maxElements) {
        this.maxElements = maxElements;
    }

    public LruCache() {
    }

    public LruCache(int maxElements) {
        super(16,0.75f,true);
        this.maxElements = maxElements;
    }

    /**
     * if size > maxElements remove this old entry and
     * add new entry
     *
     * @param eldest
     * @return true or false
     */
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > this.maxElements;
    }
}

public class Main {
    public static void main(String args[]) {
        int _case, _size;
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            _case = reader.nextInt();
            _size = reader.nextInt();
            LruCache cache = new LruCache(_size);
            for (int i = 0; i < _case; i++) {
                String url = reader.next();
                if (cache.get(url) == null) {
                    System.out.println("Internet");
                    cache.put(url, 1);
                } else {
                    System.out.println("cache");
                }
            }

        }
    }

}
