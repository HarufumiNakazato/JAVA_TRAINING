package ch17.Ex17_04;

public class ResourceImpl implements Resource{
	int keyHash;
	boolean needsRelease = false;
	
	ResourceImpl(Object key){
		keyHash = System.identityHashCode(key);
		
		//外部リソースの設定
		needsRelease = true;
		
	}
	public void use(Object key, Object...args){
		if (System.identityHashCode(key) != keyHash)
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
