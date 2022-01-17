import java.util.Iterator;
public class MyIterator implements Iterator<Integer>{
	private Node cursor;
	public MyIterator(Node node) {
		this.cursor= node;
	}
	@Override
	public boolean hasNext() {
		//Pregunto si tengo proximo. O(1)
		return this.cursor !=null;
	}
	@Override
	public Integer next() {
		//Obtengo la info de donde este cursor, y apunto al proximo. O(1)
		Integer info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return info;
	}
	public Integer get() {
		//Obtengo la info donde este cursor. O(1)
		return this.cursor.getInfo();
	}
	public void move() {
		//Apunto al proximo. O(1)
		this.cursor = this.cursor.getNext();
	}
}