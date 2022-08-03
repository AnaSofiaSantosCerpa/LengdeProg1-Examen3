KC=		kotlinc
KFLAG=		-cp
GLIB=	ve/usb/libGrafo

all:	\
	$(GLIB)/Lado.class\
	$(GLIB)/Arista.class\
	$(GLIB)/Secuencia.class\
	$(GLIB)/Pila.class\
	$(GLIB)/Cola.class\
	$(GLIB)/Color.class\
	$(GLIB)/Grafo.class\
	$(GLIB)/GrafoNoDirigido.class\
	$(GLIB)/Busqueda.class\
	$(GLIB)/BFS.class\
	$(GLIB)/DFS.class\
	MainKt.class\

$(GLIB)/Lado.class: $(GLIB)/Lado.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Lado.kt

$(GLIB)/Arista.class: $(GLIB)/Arista.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Arista.kt

$(GLIB)/Secuencia.class: $(GLIB)/Secuencia.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Secuencia.kt

$(GLIB)/Pila.class: $(GLIB)/Pila.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Pila.kt

$(GLIB)/Cola.class: $(GLIB)/Cola.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Cola.kt

$(GLIB)/Grafo.class: $(GLIB)/Grafo.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Grafo.kt

$(GLIB)/GrafoNoDirigido.class: $(GLIB)/GrafoNoDirigido.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/GrafoNoDirigido.kt

$(GLIB)/Busqueda.class: $(GLIB)/Busqueda.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Busqueda.kt

$(GLIB)/BFS.class: $(GLIB)/BFS.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/BFS.kt

$(GLIB)/DFS.class: $(GLIB)/DFS.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/DFS.kt	

$(GLIB)/Color.class: $(GLIB)/Color.kt
	$(KC) $(KFLAG) $(GLIB): $(GLIB)/Color.kt

MainKt.class: Main.kt 
	$(KC) $(KFLAG) .:$(GLIB) Main.kt	

clean:
	rm -rf *.class $(GLIB)/*.class $(GLIB)/META-INF 
