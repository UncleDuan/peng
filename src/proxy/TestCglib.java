package proxy;

/**
 * Created by pengsel on 2019/3/11.
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeProxyCglib cglib=new BookFacadeProxyCglib();
        BookFacadeCglib bookCglib=(BookFacadeCglib)cglib.getInstance(new BookFacadeCglib());
        bookCglib.addBook();
    }
}
