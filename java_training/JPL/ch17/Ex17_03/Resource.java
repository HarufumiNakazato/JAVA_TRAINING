package ch17.Ex17_03;

interface Resource {
	void use(Object key, Object... args);
	void release();
}
