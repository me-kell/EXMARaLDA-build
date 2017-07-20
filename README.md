# EXMARaLDA maven build (for Windows)

This is work on progress. It is an attempt to automate and to document the build process of EXMARaLDA.

## Requirements

- Maven (tested with apache-maven-3.5.0)
- Java Development Kit (tested with jdk1.8.0_131)
- Files of an EXMARaLDA installation

## Prepare

Make sure you have a JDK (not just a JRE) and Maven installed.

We assume the build will be in `c:\workspace\exmaralda` and access it with `%EXMARALDA_WORKING_DIR%`.

In a DOS-Box enter the following commands. Please note this will delete the existing directory:

    set EXMARALDA_WORKING_DIR=c:\workspace\exmaralda
    cd /d c:\
    if exist %EXMARALDA_WORKING_DIR% rmdir /s /q %EXMARALDA_WORKING_DIR%
    mkdir %EXMARALDA_WORKING_DIR%
    mkdir %EXMARALDA_WORKING_DIR%\exmaralda-installation
    cd /d %EXMARALDA_WORKING_DIR%

We assume your original EXMARaLDA installatin is in `c:\Program Files (x86)\EXMARaLDA` and access it with `%EXMARALDA_ORIGINAL_INSTALLATION_DIR%`.
Copy all files of the EXMARaLDA installation to `c:\workspace\exmaralda` (`%EXMARALDA_WORKING_DIR%`)

    set EXMARALDA_ORIGINAL_INSTALLATION_DIR=c:\Program Files (x86)\EXMARaLDA
    echo "%EXMARALDA_ORIGINAL_INSTALLATION_DIR%" "%EXMARALDA_WORKING_DIR%"
    cd /d "%EXMARALDA_ORIGINAL_INSTALLATION_DIR%"
    xcopy "%EXMARALDA_ORIGINAL_INSTALLATION_DIR%" "%EXMARALDA_WORKING_DIR%\exmaralda-installation" /y /i
    xcopy "%EXMARALDA_ORIGINAL_INSTALLATION_DIR%"\FobsJMF "%EXMARALDA_WORKING_DIR%\exmaralda-installation\FobsJMF" /y /i

Download `https://github.com/me-kell/EXMARaLDA-Build/archive/master.zip` and extract its contents to `c:\workspace\exmaralda` (`%EXMARALDA_WORKING_DIR%`)

- **README.md** (this file)
- **pom.xml** (EXMARaLDA build POM)
- **pom-prepare.xml** (utils POM to prepare the build. It calls prepare.xml)
- **prepare.xml** (ant buildfile to prepare the build. Called by pom-prepare.xml)
- **SplashScreen.png** (a modified SplashScreeen.png to test this buid)
- **UrlsOfContextClassLoaderOfCurrentThread.java** (utils)
- **exmaralda.exb** (simple test exmaralda file. Uses exmaralda.wav)
- **exmaralda.wav** (simple test wav file)

## Build with Maven

We assume the JDK in `C:\sde\tools\jdk1.8.0_131` and maven in `C:\sde\tools\apache-maven-3.5.0`.
In a DOS-Box enter the following commands to set environment variables for Maven

    set JAVA_HOME=C:\sde\tools\jdk1.8.0_131
    set MAVEN_OPTS=-Xmx1524m
    set MAVEN_HOME=C:\sde\tools\apache-maven-3.5.0
    set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

    set EXMARALDA_WORKING_DIR=c:\workspace\exmaralda

    cd /d %EXMARALDA_WORKING_DIR%

The following prepares a directory structure and adds dependencies to local maven repository (See `pom-prepare.xml` and `prepare.xml`). This will ask your permission to delete existing directories (`%EXMARALDA_WORKING_DIR%\tmp` and `%EXMARALDA_WORKING_DIR%\src`).

    mvn -f pom-prepare.xml antrun:run@prepare validate

Run maven with following goals.

    mvn -f pom.xml clean dependency:copy-dependencies@copy-dependencies resources:resources compiler:compile jar:jar

Or simply `mvn -f pom.xml clean package`.

After this you can run the PartiturEditor with following maven goal:

    mvn -f pom.xml exec:exec@partitureditor

## Change Player

The `JDS Player` is not bound in this build. Therefore you should change it to `JMF Player`.
Start EXMARaLDA. Under `Edit > Preferences ... > Media` set the `JMF Player`.
Restart EXMARaLDA with `mvn -f pom.xml exec:exec@partitureditor`.

EXMARaLDA warns that "Your player preference is set to JMF-Player" and "This is not the recommended default player for your system. The recommended default player for your system is JDS-Player." And asks if "Do you want to switch to the recommended default player?" Answer "no".

## Generate Site

If you wish you can generate a site with information of the project

    mvn -f pom.xml site
    mvn -f pom.xml dependency:resolve
    mvn -f pom.xml dependency:tree
    mvn -f pom.xml javadoc:javadoc
    mvn -f pom.xml jxr:jxr
    mvn -f pom.xml pmd:pmd
    mvn -f pom.xml pmd:cpd

The site is generated under `c:\workspace\maprepository\exmaralda\target\site` (`%EXMARALDA_WORKING_DIR%\target\site`)

