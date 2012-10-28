
/*
 * Copyright (C) 2012 RICOH Co., Ltd. All rights reserved.
 */

import java.util.*;
/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class. 
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {


	private  LimitedQueue<Runnable> queue;
	private PoolWorker[] threads;
	private Thread.State state = Thread.State.NEW;

	class LimitedQueue<E> extends LinkedList<E> {
	        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private int limit;

	        public LimitedQueue(int limit) {
	            this.limit = limit;
	        }

	        @Override
	        public boolean add(E o) {
	            super.add(o);
	            //while (size() > limit) { super.remove(); }
	            return true;
	        }
	    }
    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {
    	if(queueSize < 1 || numberOfThreads < 1)
    		throw new IllegalArgumentException();
    	queue = new LimitedQueue<Runnable>(queueSize);
    	threads = new PoolWorker[numberOfThreads];
    	for(int i = 0;i < numberOfThreads;i++)
    		threads[i] = new PoolWorker();   		
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
    	if(state == Thread.State.RUNNABLE)
    		throw new IllegalStateException();
    	
    	for(int i = 0;i < threads.length; i++) {
    		threads[i].start();
    	}
    	state = Thread.State.RUNNABLE;
    }   

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
	public void stop() {
		if(state != Thread.State.RUNNABLE)
			throw new IllegalStateException();
    	for(int i = 0;i < threads.length; i++) {
    		while(threads[i].getState() != Thread.State.TERMINATED)
    			threads[i].interrupt();
    	}
    	state = Thread.State.TERMINATED;
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread.
     * 
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
    	if(runnable == null)
    		throw new NullPointerException();
    	if(state != Thread.State.RUNNABLE)
    		throw new IllegalStateException();
    	synchronized(queue){
    		queue.add(runnable);
    		queue.notifyAll();
    	}
    }
    private class PoolWorker extends Thread {
    	private boolean stopFrag;
        public void run() {
            Runnable r;
            this.stopFrag = false;
            while (true) {
            	synchronized(queue) {
                    while (queue.isEmpty()) {
                        try
                        {
                            queue.wait();
                        }
                        catch (InterruptedException ignored)
                        {
                        	System.out.println("interrupted()");
                        	this.stopFrag = true;
                        	break;
                        }
                    }
                    if(this.stopFrag)
                    	break;
                    
                    r = queue.removeFirst();
                }
                // If we don't catch RuntimeException, // the pool could leak threads
                try {
                	r.run();
                }
                catch (RuntimeException e) {
                    // You might want to log something here
                }
            }
        }
    }
}
