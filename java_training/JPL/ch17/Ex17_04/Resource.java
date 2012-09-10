package ch17.Ex17_04;

interface Resource {
	void use(Object key, Object... args);
	void release();
}
