package ch17.Ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs; 
	boolean shutdown = false;
	
	public ResourceManager(){
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>,Resource>();
	}
	
	public synchronized void shutdown(){
		if(!shutdown){
			shutdown = true;

		}
	}
	
	public synchronized Resource getResource(Object key){
		if(shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key,queue);
		refs.put(ref,res);
		
		while(refs.size() != 0) {
			Reference<?> qref = queue.poll();
			Resource qres = refs.get(qref);
			qres.release();
		}
		
		return res;
	}
}
