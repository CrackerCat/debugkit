<p align="center"><img src="https://i.imgur.com/3NdQ93C.png" alt="1600" width="25%"/></p>

<p align="center"><strong>一个调试悬浮窗</strong></p>

<p align="center">
<a href="http://liangjingkanji.github.io/debugkit/">使用文档</a>
| <a href="https://github.com/liangjingkanji/document/blob/master/visit-pages.md">无法访问?</a>
| <a href="https://github.com/liangjingkanji/debugkit/releases/download/1.3.0/debugkit.apk">下载体验</a>
</p>

<p align="center">
<a href="https://jitpack.io/#liangjingkanji/debugkit"><img src="https://jitpack.io/v/liangjingkanji/debugkit.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>

<p align="center"><img src="https://i.imgur.com/9V87YJi.png" align="center" width="250" /></p>

## 功能

- [x] 配置多个可点击按钮
- [x] 亮色|暗色主题模式
- [x] 移动|关闭|最小化悬浮窗
- [x] 悬浮窗日志打印


<br>

## 安装

添加远程仓库根据创建项目的 Android Studio 版本有所不同

Android Studio Arctic Fox以下创建的项目 在项目根目录的 build.gradle 添加仓库

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

Android Studio Arctic Fox以上创建的项目 在项目根目录的 settings.gradle 添加仓库

```kotlin
dependencyResolutionManagement {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

然后在 module 的 build.gradle 添加依赖框架

```groovy
implementation 'com.github.liangjingkanji:debugkit:1.3.0'
```

<br>

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
