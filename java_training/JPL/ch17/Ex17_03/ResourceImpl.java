package ch17.Ex17_03;

import java.lang.ref.*;

public class ResourceImpl implements Resource{
	boolean needsRelease = false;
	private WeakReference<Object> key;
	
	ResourceImpl(Object key){
		this.key = new WeakReference<Object>(key);
		//外部リソースの設定
		needsRelease = true;
		
	}
	public void use(Object key, Object...args){
		//keyが同じかどうかをチェックして違ったら使用できない
		if(!this.key.equals(key))
			throw new IllegalArgumentException("wrong key");
		//リソースの使用
	}
	
	public synchronized void release(){
		if(needsRelease){
			needsRelease = false;
			//リソースの解放
		}
	}
}
