import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MyThreadFactory {
	
	//Atributos necesarios para la factory
	private int counter;
	private String name;
	private List<String> stats;
	
	//constructor
	public MyThreadFactory(String name){
		counter=0;
		this.name=name;
		stats=new ArrayList<String>();	
	}
	
	//Metodo que crea un objeto hilo usando un objeto Runnable
	
	public Thread newThread(Runnable r){
		//creacion del nuevo objeto hilo
		Thread t=new Thread(r, name+"-Thread_"+counter);
		counter++;
		//actualiza las estadisticas de la Factory
		stats.add(String.format("Created Thread %d with name %s on %s\n", t.getId(), t.getName(),new Date()));
		return t;
	}
	
	public String getStats(){
		StringBuffer buffer=new StringBuffer();
		Iterator<String> it=stats.iterator();
		
		while(it.hasNext()){
			buffer.append(it.next());
		}
		
		return buffer.toString();
	}
}
