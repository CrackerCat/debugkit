# Android DebugKit 
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) [ ![Download](https://api.bintray.com/packages/nebneb/DebugKit/debugkit/images/download.svg) ](https://bintray.com/nebneb/DebugKit/debugkit/_latestVersion)

DebugKit lib for Android allows you to use a fancy hovering debug tool to trigger some actions directly in the app. This tool is very useful to trigger some event at runtime, and to have a written feedback directly on your testing phone screen.

## Requirements

* Android SDK 15+

## Example

You can download an example apk here :
[DebugKit-Example.apk](https://github.com/hulab/debugkit/blob/master/resources/DebugKit-Example.apk)

# Installation
project of build.gradle

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```



module of build.gradle

```
implementation 'com.github.liangjingkanji:debugkit:1.2.2'
```

# Usage

```java
final DevTool.Builder builder = new DevTool.Builder(mContext);

builder.addFunction(new DebugFunction() {
            @Override
            public String call() throws Exception {
                log("doing some stuff...");
                doSomeStuff();
                return "Some stuff was done.";
            }
        }).addFunction(new DebugFunction() {
            @Override
            public String call() throws Exception {
                log("doing some other stuff...");
                doSomeStuff();
                return "Some stuff was done.";
            }
        }).addFunction(new DebugFunction("My function") {
            @Override
            public String call() throws Exception {
                log("doing some stuff again and again...");
                doSomeStuff();
                return "This function has a title!";
            }
        });                
        // This is a prebuilt function to clear the console, you can call clear() in any function
        // as well.
        .addFunction(new DebugFunction.Clear("Clear"))
        // This is a prebuilt function to dump the content of your shared preferences file.
        .addFunction(new DebugFunction.DumpSharedPreferences("Shared prefs", PREFS_FILE_NAME));
 
        // optional, DevToolFragment.DevToolTheme.DARK is set by default
builder.setTheme(DevToolFragment.DevToolTheme.DARK)
        //you can set the initial position of your debug tool (0,0) by default
       .displayAt(100, 100)
       .build();
```

## Result

Here we have 3 debug tools, from top to bottom:


* LIGHT theme with 5 defined functions
* Minified mode (clicking on the top left corner arrow)
* DARK theme with 3 defined functions and the logged text when clicking on each F1, F2 and F3
___
![Screenshot.png](https://github.com/hulab/debugkit/blob/master/resources/screenshot.png)
___
![dark theme](https://github.com/hulab/debugkit/blob/master/resources/theme_dark.gif)
![light theme](https://github.com/hulab/debugkit/blob/master/resources/theme_light.gif)
___

**Have fun!**
