public class MySimpleLinkedList implements Iterable<Integer> {
	protected Node first;
	protected Node last;
	protected int size;
	public MySimpleLinkedList() {
		this.first = null;
		this.size=0;
		this.last=null;
	}
	public void insertFront(Integer o) { 
		//O(1)
		Node tmp= new Node(o,first);
		this.first=tmp;
		if(this.last==null) {
			this.last=first;
		}
		size++;
	}
	public void insertBack(Integer o) { 
		//O(1)
		if(this.first==null) {
			insertFront(o);
		}else {
			Node tmp= new Node(o,null);
			size++;
			this.last.setNext(tmp);//VERIFICAR
			this.last=tmp;
		}
	}
	public Integer getLast() {
		//O(1)
		if(this.last!=null) {
			return this.last.getInfo();
		}
		return null;
	}
	public Integer getFirst() {
		//O(1)
		if(this.first!=null) {
			return this.first.getInfo();
		}
		return null;
	}
	public Integer get(int index) {
		//O(n) donde n es la cantidad de elementos a recorrer.

		if((index<=getSize()-1)&&(index>=0)) {
			int contador=0;
			Node pos=first;
			Integer aux=pos.getInfo();
			while(contador!=index) {
				pos=pos.getNext();
				aux=pos.getInfo();
				contador++;
			}
			if(contador==index) {
				return aux;
			}	
		}
		else {
			System.out.println("El index ingresado es menor a 0 o mayor al getSize(). index= "+index);
			return null;
		}
		return null;
	}
 	public Integer extractFront() {
		//O(1)
		if(!this.isEmpty()) {
			size--;
			int aux=this.first.getInfo();

			if(this.last.equals(this.first)) {
		//		this.first.setNext(null); no es necesario ya que al ser el mismo elemento y no tener otro adelante su siguiente apunta a null
		//		this.last.setNext(null); 
				this.first=null;
				this.last=null;
			}
			else {
				this.first=this.first.getNext();
			}			
			return aux;
		}
		else {
			return null;
		}
 	}

	public Integer extractLast() {	
		//O(n),donde n es la cantidad de elementos a recorrer hasta llegar al anteultimo para setearle que su next=null.
		if(!isEmpty()) {		
		Node ultimo=this.first;
			if(this.last.equals(this.first)) {
				//ultimo=this.first;
				this.first=null;
				this.last=first;
				size--;
				return ultimo.getInfo();
			}	
			else {
				Node anteUltimo=ultimo;
				
				while(ultimo.getNext()!=null) {
					anteUltimo=ultimo;
					ultimo=ultimo.getNext();
				}	
				if(ultimo.getNext()==null) {
					anteUltimo.setNext(null);
					size--;
					this.last=anteUltimo;
					return ultimo.getInfo();
					//return last.getInfo();
				}	
			}	
		}
		return null;
	}
	public boolean isEmpty() {
		//O(1)  	
		return this.first==null;
	}
	public int getSize() {
		//O(1)
		return this.size;
	}

	public void deleteIndex(Integer index) {	
		//O(n), donde n es la cantidad de elementos a recorrer en la lista.
		if(!isEmpty()) {
			if(index==0) {
				if(this.last.equals(this.first)) {
					this.first=this.first.getNext();
					this.last=this.first;
				}
				size--;	
			}
			else {
				if(size>index) {
					int  contador=0;
					Node aux=first;
					while(contador<index-1) {
						aux=aux.getNext();
						contador++;
					}
					aux.setNext(aux.getNext().getNext());
					if(contador==index-1) {
						this.last=aux;
					}
					size--;
				}
			}	
		}
	}	
	public Integer indexOf(Integer o) { 
		//O(n), donde n es la cantidad de elementos a recorrer en la lista.
		Node aux=this.first;
		int index=0;
		
		if(aux!=null) {
			while((aux.getInfo()!=o)&&(aux!=null)&&(index<=getSize())) {
				if(aux.getNext()!=null) {
					aux=aux.getNext();
					System.out.println("asd2");
				}
				index++;
	
			}	
			if(aux.getInfo()==o) {
				return index;
			}else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}	
	public void insertIndex(int index,int info) {
		// O(n),donde  n es la cantidad de elementos a recorrer en la lista.
		if(index==0) {
			insertFront(info);
		}
		else if(index<size-1) {
			Node ultimo=this.first.getNext();
			Node anteUltimo=this.first;
			int contador=0;
			while(contador<index-1) {				
				anteUltimo=anteUltimo.getNext();
				ultimo=anteUltimo.getNext();
				contador++;
				size++;
			}
			Node tmp= new Node(info,ultimo);
			System.out.println(tmp.getInfo());
			anteUltimo.setNext(tmp);
			this.last=ultimo;
		}
		else {	
			insertBack(info);	
		}
	}
	public void print(int n) {
		//O(n) donde n son los elementos a recorrer empezando desde el inicio hasta llegar a ese index.
		Node aux = first; 
		if((n>=0)&&(n<getSize())) {
			for(int i=0;i<=n;i++) {
				System.out.print(" -> [ "+aux.getInfo()+" ]");
				aux = aux.getNext();
			} 
		}
		else {
			System.out.println("Error, si n es menor a 0 o mayor al getSize() no imprime. (n="+n+")");
		}
	}
	@Override
	public MyIterator iterator() {
		return new MyIterator(this.first);
	}
}