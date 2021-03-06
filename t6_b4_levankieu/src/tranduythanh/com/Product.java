package tranduythanh.com;
/**
 * Class này để lưu thông tin sản phẩm
 * nó kế thừ từ Goods để lấy mã và tên
 * Tôi cho nó tham chiếu tới Catalog
 * để nó có thể biết được nó thuộc danh mục nào
 * @author drthanh
 *
 */
public class Product extends Goods{
	//Lấy tham chiếu để lập trình cho lẹ
	private Catalog Dmuc;

	public Catalog getDmuc() {
		return Dmuc;
	}

	public void setDmuc(Catalog dmuc) {
		Dmuc = dmuc;
	}

	public Product(String ma, String name, Catalog dmuc) {
		super(ma, name);
		Dmuc = dmuc;
	}

	public Product(String ma, String name) {
		super(ma, name);
	}

	public Product() {
		super();
	}
	
}
