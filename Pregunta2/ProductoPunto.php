<?php
echo "INICIO DEL PROGRAMA DE PRODUCTO PUNTO ENTRE 2 VECTORES";
echo "\n";
echo "\nIngrese la longitud de los arreglos: ";
fscanf(STDIN, "%d\n", $number);


echo "\nA continuacion ingrese cada elemento del Primer Vector";


for ($i = 0; $i < $number; $i++) {
    $j = $i + 1;
    echo "\nIngrese el elemento ".$j.": ";
    fscanf(STDIN, "%d\n", $array1[$i]);
}
  
echo "\nA continuacion ingrese cada elemento del Segundo Vector";


for ($i = 0; $i < $number; $i++) {
    $j = $i + 1;
    echo "\nIngrese el elemento ".$j.": ";
    fscanf(STDIN, "%d\n", $array2[$i]);
}

echo "\n[calculando el producto punto...]";
$producto = 0; 
for ($i = 0; $i < $number; $i++) {
    $producto += $array1[$i] * $array2[$i]; 
} 
echo "\n[calculando el producto punto...]";

echo "\nResultado del Producto Punto: ";
echo json_encode($producto);
echo "\n";

echo "\nFIN DEL PROGRAMA";
echo "\n";
?>