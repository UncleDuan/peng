package threadpool.thread.product;

/**
 * ��Ʒ��
 */
class Product {
	private int id;// ��Ʒid
	private String name;// ��Ʒ����

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "(��ƷID��" + id + " ��Ʒ���ƣ�" + name + ")";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
