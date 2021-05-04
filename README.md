# pruebaBarcode
Ejemplo de generación de códigos de barra 1D y 2D utilizando REST y diferentes librerías

## Generación de código de barra

### Librerías

- **Barbecue:** último update en 2007. Permite generar EAN-13 sin proveer dígito de control previamente calculado. Genera códigos de barra 1D.
- **Barcode4j:** último update en 2012. Permite generar EAN-13 sin proveer dígito de control previamente calculado. Genera códigos de barra 1D y 2D (no QR).
- **ZXing:** último update en 2020. Librería estándar en java para QR. Para generar EAN-13 es necesario proveer el dígito de control junto a los 12 dígitos restantes. Genera códigos de barra 1D y 2D.

### Formatos de códigos de barra

#### Códigos de barra 1D:

- **EAN-13:** Máximo 12 dígitos a codificar. Si la librería no calcula el dígito de control es necesario calcularlo. Este dígito sirve para controlar posibles errores en el código. Solo admite números. Utilizado en códigos de productos (ej supermercados).
- **Code 128:** Longitud de texto variable. Admite todos los caracteres ASCII. También posee chequeo de errores. Se utiliza en paquetería y logística.

#### Códigos de barra 2D:

- **PDF417:** Código de barras 2D compuesto por códigos de 1D stackeados uno arriba del otro por franjas. A diferencia del QR y otro tipo de códigos 2D, puede ser leído por un lector lineal estándar de 1D. Permiten caracteres ASCII. Utiliza detección y corrección de errores potente, variable según la cantidad de palabras de corrección que se añadan. Ocupan mayor área que los QR.
