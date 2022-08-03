KC=		kotlinc
KFLAG=		-cp
LIB=	lib/programas

all:	\
	$(LIB)/Atomo.class\
	$(LIB)/Variable.class\
	$(LIB)/Estructura.class\
	$(LIB)/Regla.class\
	SimuladorPrologKt.class\
		
$(LIB)/Atomo.class: $(LIB)/Atomo.kt
	$(KC) $(KFLAG) $(LIB): $(LIB)/Atomo.kt

$(LIB)/Variable.class: $(LIB)/Variable.kt
	$(KC) $(KFLAG) $(LIB): $(LIB)/Variable.kt

$(LIB)/Estructura.class: $(LIB)/Estructura.kt
	$(KC) $(KFLAG) $(LIB): $(LIB)/Estructura.kt

$(LIB)/Regla.class: $(LIB)/Regla.kt
	$(KC) $(KFLAG) $(LIB): $(LIB)/Regla.kt

SimuladorPrologKt.class: SimuladorProlog.kt 
	$(KC) $(KFLAG) .:$(LIB) SimuladorProlog.kt
	
clean:
	rm -rf *.class $(LIB)/*.class $(LIB)/META-INF 