package ch17.Ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs; 
	final Thread reaper;
	boolean shutdown = false;
	
	public ResourceManager(){
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>,Resource>();
		reaper = new ReaperThread();
		reaper.start();
	}
	
	public synchronized void shutdown(){
		if(!shutdown){
			shutdown = true;
			reaper.interrupt();
		}
	}
	
	public synchronized Resource getResource(Object key){
		if(shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key,queue);
		refs.put(ref,res);
		return res;
	}
	
	public class ReaperThread extends Thread{
		public void run(){
			// äÑÇËçûÇ‹ÇÍÇÈÇ‹Ç≈é¿çs
			while(true){
				try{
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized(ResourceManager.this){
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				}
				catch(InterruptedException ex){
					break;
				}
			}
		}
		public void interrupt(){
			while(true)
				if(refs.size() == 0)
					break;
			super.interrupt();
		}
	}
}
