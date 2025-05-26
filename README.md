`JFileLinkLabel` is a Java Swing component designed to display a usable link to a [File](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/io/File.html),
[Path](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/nio/file/Path.html), or [URI](https://docs.oracle.com/en/java/javase/24/docs/api/java.base/java/net/URI.html).

## Table of Contents

* [Installation](https://github.com/Valkryst/JFileLinkLabel#installation)
    * [Gradle](https://github.com/Valkryst/JFileLinkLabel#-gradle)
    * [Maven](https://github.com/Valkryst/JFileLinkLabel#-maven)
    * [sbt](https://github.com/Valkryst/JFileLinkLabel#-scala-sbt)
* [Example](https://github.com/Valkryst/JFileLinkLabel#example)

## Installation

JFileLinkLabel is hosted on the [JitPack package repository](https://jitpack.io/#Valkryst/JFileLinkLabel)
which supports Gradle, Maven, and sbt.

### ![Gradle](https://i.imgur.com/qtc6bXq.png?1) Gradle

Add JitPack to your `build.gradle` at the end of repositories.

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add JFileLinkLabel as a dependency.

```
dependencies {
	implementation 'com.github.Valkryst:JFileLinkLabel:2025.5.26'
}
```

### ![Maven](https://i.imgur.com/2TZzobp.png?1) Maven

Add JitPack as a repository.

``` xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Add JFileLinkLabel as a dependency.

```xml
<dependency>
    <groupId>com.github.Valkryst</groupId>
    <artifactId>JFileLinkLabel</artifactId>
    <version>2025.5.26</version>
</dependency>
```

### ![Scala SBT](https://i.imgur.com/Nqv3mVd.png?1) Scala SBT

Add JitPack as a resolver.

```
resolvers += "jitpack" at "https://jitpack.io"
```

Add JFileLinkLabel as a dependency.

```
libraryDependencies += "com.github.Valkryst" % "JFileLinkLabel" % "2025.5.26"
```

## Example

This creates a new `JFileLinkLabel` and displays it in a `JFrame`.

```java
public class Driver {
  public static void main(final String[] args) {
    SwingUtilities.invokeLater(() -> {
      final JFileLinkLabel link = new JFileLinkLabel(
              "Link to Home Directory",
              Paths.get(System.getProperty("user.home"))
      );
      link.setForeground(Color.BLUE);

      final JFrame frame = new JFrame("JFileLinkLabel Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(400, 100));

      final Container contentPane = frame.getContentPane();
      contentPane.setLayout(new BorderLayout());
      contentPane.add(link, BorderLayout.CENTER);

      frame.setVisible(true);
      frame.pack();
      frame.setLocationRelativeTo(null);
    });
  }
}
```