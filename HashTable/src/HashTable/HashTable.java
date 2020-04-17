package HashTable;


import java.util.TreeMap;

/**
 *  采用链地址法的哈希表  线性表 每个下标对应一个 TreeMap
 *  例如哈希函数是MOD7  则9存入的时候 存到下标为2的TreeMap中  16存入的时候也是对应的下标为2的TreeMap中
 *   8则是对应的下标为1的TreeMap中
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0 ; i < M ; i ++)
            hashtable[i] = new TreeMap<>();
    }

    public HashTable(){
        this(initCapacity);
    }

    /**
     * 计算hash值
     * @param key
     * @return
     */
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 添加
     * @param key
     * @param value
     */
    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        // if(!hashtable[hash(key)].containsKey(key)){
        if(!map.containsKey(key)){
            map.put(key, value);
            size ++;

            if(size >= upperTol * M)
                resize(2 * M);
        }
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;

            if(size <= lowerTol * M && M > initCapacity)
                resize(M / 2);
        }
        return ret;
    }

    /**
     * 跟新键值对
     * @param key
     * @param value
     */
    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    /**
     * 判断是否存在key
     * @param key
     * @return
     */
    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    /**
     * 获取key对应的value
     * @param key
     * @return
     */
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    /**
     * 扩容
     * @param newM
     */
    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0 ; i < newM ; i ++)
            newHashTable[i] = new TreeMap<>();

        for(int i = 0 ; i < M ; i ++)
            for(K key: hashtable[i].keySet())
                newHashTable[hash(key)].put(key, hashtable[i].get(key));

        this.M = newM;
        this.hashtable = newHashTable;
    }
}
