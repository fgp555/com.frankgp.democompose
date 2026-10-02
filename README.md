# Jetpack Compose Learning App - Social Media Theme

Una aplicación Android interactiva y educativa diseñada para enseñar los componentes fundamentales de **Jetpack Compose** a través de un caso de estudio del mundo real: **una aplicación de Redes Sociales**.

## Características Principales

- **Recorrido Guiado de 12 Pasos**: Los usuarios aprenden visualmente un componente por pantalla, sin distracciones de código, siguiendo un flujo guiado con indicadores de progreso.
- **Tema de Redes Sociales**: Feed de publicaciones, historias (stories), perfiles de usuario, interacciones con "Me gusta" animados y diseño moderno con Material 3.
- **Gestión de Estado Reactiva**: Implementado con ViewModel, StateFlow y corrutinas de Kotlin.
- **Diseño Adaptativo / Responsivo**: Compatible con teléfonos (vista vertical con navegación inferior) y tabletas (vista horizontal con NavigationRail y diseño de múltiples paneles).
- **Modo Oscuro / Claro**: Selector interactivo de tema.

---

## Estructura de los 12 Pasos del Recorrido

1. **Text Composable**: Títulos, subtítulos, cuerpo y metadatos en perfiles de usuario.
2. **Button Composable**: Botones elevados, contorneados, flotantes y de texto con estados interactivos.
3. **Card Composable**: Tarjetas de publicaciones con sombras, esquinas redondeadas y elevación.
4. **Image & Icon Composable**: Avatares con anillos de gradiente para historias e iconos animados.
5. **LazyColumn**: Listas verticales eficientes para el feed de publicaciones.
6. **LazyRow**: Listas horizontales fluidas para la barra de historias.
7. **TextField Composable**: Entradas de una y múltiples líneas, barras de búsqueda y validación de errores.
8. **Checkbox & RadioButton**: Opciones múltiples y filtros de categoría de contenido.
9. **Switch & Slider**: Interruptores para modo oscuro/claro y controles deslizantes de calificación de publicaciones.
10. **Navegación (Multiple Types)**: Bottom Navigation, NavigationRail y menús laterales.
11. **Estado con ViewModel + Corrutinas**: Carga simulada de red, indicadores de carga y actualización (*pull-to-refresh*).
12. **Diseño Responsivo**: Adaptación dinámica entre teléfonos y tabletas.

---

## Requisitos Técnicos

- **Lenguaje**: Kotlin
- **Framework UI**: Jetpack Compose + Material 3
- **Arquitectura**: MVVM (Model-View-ViewModel) + StateFlow
- **SDK Mínimo**: Android 7.0 (API 24)
- **SDK Target**: Android 15 (API 37)

---

## Cómo Ejecutar

1. Abre el proyecto en **Android Studio**.
2. Sincroniza Gradle (`Sync Project with Gradle Files`).
3. Conecta un dispositivo físico o inicia un emulador Android.
4. Haz clic en **Run** (`Shift + F10`) para iniciar la aplicación.
