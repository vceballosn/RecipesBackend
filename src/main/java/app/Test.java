package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args){
		 int contador =5;
		 int x=6;
		 int y=0;
		contador *= ++x;
		while (x<10) {
			  y += x;
			  x++;
			  System.out.println("x ciclo "+ x);
			}
		//contador++;
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(3);
		
		Stream st = numeros.stream();
		
		System.out.println(" Cuanto numeros hay repetidos "+ st.filter(Predicate.isEqual(3)).count());
		System.out.println(" contador "+contador + " valor de y "+y +" valor de x "+x);
		System.out.println(2+6>>2);
		 
		 
	}

}
