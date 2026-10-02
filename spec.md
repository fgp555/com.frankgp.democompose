# Especificación Técnica (Spec) - Jetpack Compose Learning App

## 1. Visión General y Objetivos
Construir una aplicación educativa en Android utilizando **Jetpack Compose** y **Material 3**, enfocada en enseñar los conceptos básicos y avanzados de Compose mediante la metáfora visual de una red social.

## 2. Arquitectura y Capas

### 2.1. Paquetes y Estructura
- `com.frankgp.democompose.models`: Modelos de datos (`User`, `Post`, `Story`) y datos de prueba (`DummyData`).
- `com.frankgp.democompose.viewmodels`: `SocialFeedViewModel` y `TourViewModel` para la gestión de estados y lógica de negocio.
- `com.frankgp.democompose.components`: Componentes reutilizables (`TourStepHeader`, `SocialPostCard`, `StoryItemView`).
- `com.frankgp.democompose.screens`: Las 12 pantallas correspondientes a cada paso del recorrido educativo (`ComposeStep1_TextScreen` a `ComposeStep12_ResponsiveScreen`).
- `com.frankgp.democompose.ui.theme`: Definición de colores, tipografías y tema Material 3 (`Theme.kt`, `Color.kt`, `Type.kt`).

### 2.2. Gestión de Estado
- Uso intensivo de `StateFlow` y `MutableStateFlow` en combinación con `collectAsState()` / `remember`.
- Manejo de estados locales para interacciones visuales (likes, texto de búsqueda, filtros, tema oscuro/claro).

## 3. Especificación de Componentes por Paso

| Paso | Componente Principal | Propósito Didáctico en Red Social |
|---|---|---|
| 1 | `Text` | Jerarquía tipográfica (Headline, Title, Body, Caption) en cabecera de perfil. |
| 2 | `Button` / `FloatingActionButton` | Acciones primarias y secundarias (Seguir, Compartir, Agregar post). |
| 3 | `Card` (Elevated, Filled, Outlined) | Tarjetas de publicaciones con elevación y radios de borde. |
| 4 | `Image` / `Icon` | Avatares con bordes degradados y feedback táctil animado. |
| 5 | `LazyColumn` | Renderizado eficiente de listas verticales para el feed. |
| 6 | `LazyRow` | Carrusel horizontal de historias de amigos. |
| 7 | `TextField` / `OutlinedTextField` | Creación de publicaciones, barras de búsqueda y validación de correos. |
| 8 | `Checkbox` / `RadioButton` | Selección múltiple de notificaciones y filtrado único de categorías. |
| 9 | `Switch` / `Slider` | Alternancia de temas (Oscuro/Claro) y calificación de publicaciones. |
| 10 | `NavigationBar` / `NavigationRail` | Demostración de patrones de navegación inferior y barras laterales. |
| 11 | `ViewModel` + Corrutinas | Simulación de carga asíncrona, estados de carga y actualización. |
| 12 | Diseño Adaptativo | Adaptación de UI entre teléfonos (vertical) y tabletas (horizontal). |

## 4. Dependencias Clave
- `androidx.compose:compose-bom` (Jetpack Compose Material 3)
- `androidx.lifecycle:lifecycle-viewmodel-compose`
- `androidx.compose.material:material-icons-extended`
- `androidx.activity:activity-compose`

## 5. Estándar para Iconos Adaptativos de Lanzador (Launcher Icons) [Para futuros proyectos]
Para evitar que los iconos se corten o excedan la zona segura en diferentes launchers de Android:
- **Lienzo (Viewport)**: `108dp x 108dp` (`viewportWidth="108"`, `viewportHeight="108"`).
- **Zona Segura (Safe Zone)**: El contenido principal debe ubicarse dentro del círculo central de diámetro `66dp` (es decir, delimitado aproximadamente entre las coordenadas `x: 21` a `87`, `y: 21` a `87`).
- **Margen de Seguridad Recomendado**: Mantener todos los elementos gráficos importantes dentro del rango de coordenadas `[24, 24]` a `[84, 84]` para prevenir recortes por máscaras circulares, de gota o de escudo en los distintos dispositivos.
- **Estructura**:
  - `ic_launcher_background.xml`: Color sólido o gradiente de fondo que cubra todo el lienzo de 108x108.
  - `ic_launcher_foreground.xml`: Gráfico vectorial centrado y escalado dentro del rango seguro para asegurar visibilidad total.
