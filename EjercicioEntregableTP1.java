public class EjercicioEntregableTP1 {
	public static void main (String[] args) {
		MySimpleLinkedList lista= new MySimpleLinkedList();
		MySimpleLinkedList listaRTA= new MySimpleLinkedList();
		int valorUmbral=10;
		System.out.println("--------------------------------------------");

		System.out.println("LISTA CON SUBSECUENCIAS");

	/*
		lista.insertFront(3);
		lista.insertFront(2);
		lista.insertFront(1);
		lista.print(2);
		valorUmbral=10;
		
		
		listaRTA=obtener_lista_suma_numeros_subsecuencias_contiguas_por_numero_dado(valorUmbral,lista);
		System.out.println("");

		System.out.println("LISTA FINAL CON LA SUMA DE LAS SUBSECUENCIAS");
		
		listaRTA.print(0); 
		
		//valorUmbral=2;
		//lista.print(1);
		 
		System.out.println("");

		System.out.println("--------------------------------------------");
	
	*/	
	
	/*
		lista.insertFront(3);
		lista.insertFront(2);
		lista.insertFront(1);
		lista.print(2);
		valorUmbral=2;
		
		listaRTA=obtener_lista_suma_numeros_subsecuencias_contiguas_por_numero_dado(valorUmbral,lista);
		System.out.println("");

		System.out.println("LISTA FINAL CON LA SUMA DE LAS SUBSECUENCIAS");
		
		listaRTA.print(1); 
		
		System.out.println("");

		System.out.println("--------------------------------------------");
	
	*/
		
	/*	
		
		lista.insertFront(28);
		lista.insertFront(14);
		lista.insertFront(19);
		lista.insertFront(7);
		lista.insertFront(2);
		lista.insertFront(5);
		lista.insertFront(3);
		lista.print(6);

		 valorUmbral=10;
		 
		listaRTA=obtener_lista_suma_numeros_subsecuencias_contiguas_por_numero_dado(valorUmbral,lista);
		System.out.println("");

		System.out.println("LISTA FINAL CON LA SUMA DE LAS SUBSECUENCIAS");
		listaRTA.print(1);

		System.out.println("");

		System.out.println("--------------------------------------------");
	 
	 */
		
	/*	
		lista.insertFront(28);
		lista.insertFront(14);
		lista.insertFront(15);
		lista.insertFront(7);
		lista.insertFront(2);
		lista.insertFront(4);
		lista.insertFront(5);
		lista.insertFront(3);	
		lista.print(7);

		valorUmbral=15;
		listaRTA=obtener_lista_suma_numeros_subsecuencias_contiguas_por_numero_dado(valorUmbral,lista);
		System.out.println("");

		System.out.println("LISTA FINAL CON LA SUMA DE LAS SUBSECUENCIAS");
		listaRTA.print(3);


		System.out.println("");

		System.out.println("--------------------------------------------");
	*/	  	
	}

	public  static MySimpleLinkedList obtener_lista_suma_numeros_subsecuencias_contiguas_por_numero_dado(int valorUmbral,MySimpleLinkedList lista){
		//Este metodo tiene una complejidad de O(n) donde n es la cantidad de elementos de la lista recibida por parametro.
		MySimpleLinkedList listaRTA= new MySimpleLinkedList();
		MyIterator iterador = lista.iterator();
		int sumaSec=0;
		int numeroActual=0; 	
		while(iterador.hasNext()) {
			numeroActual=iterador.get();
			//Con esta condicion voy salteando los valores mayores al valor dado(umbral).
			if(numeroActual<=valorUmbral) {
				sumaSec+=numeroActual;
				//Con esta condicion si la suma es mayor al  valor dado, inserto al final de la lista a devolver restandole el valor actual que ya se lo habia sumado anteriormente y comienzo una suma nueva con el numeroActual.
				if(sumaSec>valorUmbral) {
					listaRTA.insertBack(sumaSec-numeroActual);
					sumaSec=numeroActual;
				}
			}
			else {
				//Con esta condicion controlo que elementos no contiguos se sumen para generar un subconjunto de elementos no contiguos, y reinicio la sumaSec. 
				//ej: umbral: 8 , [2] ->[9] ->[3]. Con este if evitamos que devuelva como lista resultado ->[5] en vez de [2]->[3] .
				if(sumaSec!=0) {
					listaRTA.insertBack(sumaSec);
					sumaSec=0;
				}
			}
			iterador.move();
		}
		//Con esta condicion verifico en caso de terminar la lista y tener la suma de una sublista acumulada, agregarla.
		if(sumaSec!=0) {
			listaRTA.insertBack(sumaSec);
		}
		return listaRTA;
	}
}