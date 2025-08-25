 plugins {
   id("com.android.application")
   id("org.jetbrains.kotlin.android")
   id("org.jetbrains.kotlin.plugin.compose")
-  id("com.google.devtools.ksp")
-  id("com.google.dagger.hilt.android")
+  id("org.jetbrains.kotlin.kapt")
+  id("com.google.dagger.hilt.android")
 }
 
 android {
   namespace = "com.quantos.composestarter"
-  compileSdk = 35
+  compileSdk = 36
   defaultConfig {
     applicationId = "com.quantos.composestarter"
     minSdk = 24
-    targetSdk = 35
+    targetSdk = 36
     versionCode = 1
     versionName = "1.0"
     testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
     vectorDrawables.useSupportLibrary = true
   }
-  kotlinOptions { jvmTarget = "17" }
+  // можно оставить kotlinOptions как есть или перейти на jvmToolchain (см. ниже)
 }
 
+// современный способ вместо kotlinOptions
+kotlin { jvmToolchain(17) }
 
 dependencies {
   // Compose BOM и прочее — оставить как есть
-  // Hilt (через KSP)
-  implementation("com.google.dagger:hilt-android:2.57.1")
-  ksp("com.google.dagger:hilt-compiler:2.57.1")
+  // Hilt (через KAPT)
+  implementation("com.google.dagger:hilt-android:2.57.1")
+  kapt("com.google.dagger:hilt-compiler:2.57.1")
   implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
 
   // Coroutines и пр. — без изменений
 
-  // DataStore (Preferences)
-  implementation("androidx.datastore:datastore-preferences:1.1.7")
+  // DataStore — добавь core, чтобы тип DataStore был на classpath во время аннотаций
+  implementation("androidx.datastore:datastore-core:1.1.7")
+  implementation("androidx.datastore:datastore-preferences:1.1.7")
 }
