KC=		kotlinc
KFLAG=		-cp
LIB=	lib/programas

all:	\
	$(LIB)/Clase.class\
	$(LIB)/Subclase.class\
	ManejadorMetodosKt.class\
		
$(LIB)/Clase.class: $(LIB)/Clase.kt
	$(KC) $(KFLAG) $(LIB): $(LIB)/Clase.kt

$(LIB)/Subclase.class: $(LIB)/Subclase.kt
	$(KC) $(KFLAG) $(LIB): $(LIB)/Subclase.kt

ManejadorMetodosKt.class: ManejadorMetodos.kt 
	$(KC) $(KFLAG) .:$(LIB) ManejadorMetodos.kt
	
clean:
	rm -rf *.class $(LIB)/*.class $(LIB)/META-INF 