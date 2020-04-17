package UF;

/**
 * 并查集接口
 */
public interface UF {
    /**
     * 获取当前并查集中 集合的数量
     * @return
     */
    int getSize();

    /**
     * 判断p和q是否在同一个集合里
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 将p,q放在同一个集合里
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}
