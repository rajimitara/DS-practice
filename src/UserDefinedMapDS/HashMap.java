package UserDefinedMapDS;

import java.util.ArrayList;
import java.util.List;


public class HashMap<K,V> {
	int size = 64;
	ArrayList<LinkedList<K,V>> map;
	
	public HashMap(int size) {
		map = new ArrayList<LinkedList<K,V>>(size);
		for(int i=0;i<size;i++)
			map.add(null);
	}
	public HashMap() {
		map = new ArrayList<LinkedList<K,V>>(this.size);
		for(int i=0;i<this.size;i++)
			map.add(null);
	}
	
	public V get(int key) {
		LinkedList<K,V> linkedList =  map.get(new Integer(key).hashCode() % size);
		if(linkedList == null)
			return null;
		
		if(linkedList.next== null && linkedList.getKey().equals(key))
			return (V) linkedList.getValue();

		while(linkedList.next!=null){
			if(linkedList.getKey().equals(key))
				return (V) linkedList.getValue();
			linkedList = linkedList.next;	
		}
		return null;
	}

	public void put(K key, V val) {
		int hashCode = (key).hashCode() % size;
		LinkedList<K,V> linkedList = null;
		if(!map.isEmpty())
			linkedList = map.get(hashCode);
		
		if(linkedList == null){
			map.add(hashCode, new LinkedList<K,V>(key, val));
		}else{
			while(linkedList.next != null)
				linkedList = linkedList.next;
			linkedList.next =  new LinkedList<K,V>(key, val);
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
class LinkedList<K,V>{
	K key;
	V val;
	LinkedList<K,V> next = null;
	
	LinkedList(K key,V val){
		this.key = key;
		this.val = val;
		this.next = null;
	}
	
	K getKey(){
		return this.key;
	}
	
	V getValue(){
		return this.val;
	}
}