randmst: javafile

javafile: randmst.java
	javac randmst.java

clean:
	rm -rf *.class