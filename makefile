randmst: javafile

javafile: randmst.javafile
	javac randmst.javac

clean:
	rm -rf *.class