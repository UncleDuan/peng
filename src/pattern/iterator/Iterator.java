package pattern.iterator;

/**
 * 迭代器模式：
 * 提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。
 */
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
