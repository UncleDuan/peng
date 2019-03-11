package datastructure.search;

/**
 * Created by pengsel on 2019/1/28.
 */
public class HashTable {
    public static final int NULLKEY=Integer.MAX_VALUE;
    public static final int HASHSIZE=11;


    private int[] elem;
    private int count;

    public int[] getElem() {
        return elem;
    }

    public void setElem(int[] elem) {
        this.elem = elem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HashTable(){
        this.elem=new int[HASHSIZE];
        for (int i=0;i<HASHSIZE;i++){
            elem[i]=NULLKEY;
        }
    }

    /**
     * 散列函数
     * @param key 关键字
     * @return 散列函数
     */
    public int hash(int key){
        return key%HASHSIZE;
    }

    /**
     * 插入关键字进散列表
     * @param key
     */
    public void insertHash(int key){
        int addr=hash(key);
        while (this.getElem()[addr]!=NULLKEY){
            //开放定址法的线性探测
            addr=(addr+1)%HASHSIZE;
        }
        this.getElem()[addr]=key;
        this.setCount(this.getCount()+1);
    }

    public boolean searchHash(int key){
        int addr=hash(key);
        while (this.getElem()[addr]!=key){
            //开放定址法的线性探测
            addr=(addr+1)%HASHSIZE;
            //探测到NULLKEY仍没有找到，或者循环到原点
            if (this.getElem()[addr]==NULLKEY||addr==hash(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashTable myHashTable=new HashTable();
        myHashTable.insertHash(12);
        myHashTable.insertHash(67);
        System.out.println(myHashTable.searchHash(12));
        System.out.println(myHashTable.searchHash(100));
        System.out.println(myHashTable.searchHash(23));
    }
}
