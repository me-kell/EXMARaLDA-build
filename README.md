# EXMARaLDA maven build (for Windows)

This is work on progress. It is an attempt to automate and to document the build process of [EXMARaLDA](https://github.com/EXMARaLDA/exmaralda).

## Requirements

- Java Development Kit and Jave Runtime Environment (tested with jdk-8u144-windows-i586)
- Git
- Maven (tested with apache-maven-3.5.0)
- JSmooth (tested with jsmooth-0.9.9-7)
- Files of an EXMARaLDA installation

## Prepare

Make sure you have a JDK (not just a JRE) and Maven installed.

We assume the following:

- the JDK is in `C:\sde\tools\jdk-8u144-windows-i586`
- the JRE is in `C:\sde\tools\jdk-8u144-windows-i586\jre`
- Git is in `C:\sde\tools\Git-2.13.2-64-bit`
- maven is in `C:\sde\tools\apache-maven-3.5.0`
- JSmooth is in `C:\sde\tools\jsmooth-0.9.9-7`

We also assume that

- the original EXMARaLDA installation (or a simple copy of it) is in `c:\Program Files (x86)\EXMARaLDA` and we'll access it with `%EXMARALDA_ORIGINAL_INSTALLATION_DIR%`.
- the build will be in `c:\workspace\exmaralda` and we'll access it with `%EXMARALDA_WORKING_DIR%`.

In a DOS-Box enter the following commands to set the environment variables:

    set JAVA_HOME=C:\sde\tools\jdk-8u144-windows-i586
    set MAVEN_OPTS=-Xmx1524m
    set MAVEN_HOME=C:\sde\tools\apache-maven-3.5.0
    set GIT_HOME=C:\sde\tools\Git-2.13.2-64-bit
    set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%GIT_HOME%\bin;%PATH%

    set EXMARALDA_WORKING_DIR=c:\workspace\exmaralda

Clone this repository and change the current directory to %EXMARALDA_WORKING_DIR%

    if exist %EXMARALDA_WORKING_DIR%\..\checkoutDirectory cd /d %EXMARALDA_WORKING_DIR%\.. && if exist %EXMARALDA_WORKING_DIR% rd /s /q %EXMARALDA_WORKING_DIR%
    :: if exist %HOMEPATH%\.m2\repository rd /s /q %HOMEPATH%\.m2\repository
    git.exe clone --depth 1 --branch master https://github.com/me-kell/EXMARaLDA-build.git %EXMARALDA_WORKING_DIR%
    cd /d %EXMARALDA_WORKING_DIR%

    if exist %EXMARALDA_WORKING_DIR%\..\checkoutDirectory xcopy %EXMARALDA_WORKING_DIR%\..\checkoutDirectory %EXMARALDA_WORKING_DIR%\checkoutDirectory /s /e /q /y /i

## Before build with Maven

Checkout EXMARaLDA (feel free to change the version), download dependencies, prepare sources and validate (i.e. install dependencies of) the project (note the use of `utils.xml`):

    cd /d %EXMARALDA_WORKING_DIR%
    if not exist %EXMARALDA_WORKING_DIR%\..\checkoutDirectory mvn -f utils.xml scm:checkout@checkout_exmaralda -DexmaraldaVersion=1.6 -DexmaraldaVersionType=tag
    mvn -f utils.xml antrun:run@download_dependencies
    mvn -f utils.xml antrun:run@prepare_sources
    mvn -f utils.xml validate

## Build with Maven

Run maven with following goals (note the use of `pom.xml`).

    cd /d %EXMARALDA_WORKING_DIR%
    mvn -f pom.xml clean
    mvn -f pom.xml dependency:copy-dependencies@copy-dependencies
    mvn -f pom.xml resources:copy-resources@copy-resources
    mvn -f pom.xml resources:resources
    mvn -f pom.xml compiler:compile
    mvn -f pom.xml jar:jar

Since the goals above are attached to the lifecycle's phases you could simply call:

    mvn -f pom.xml clean package

After this you can run the PartiturEditor with following maven goal (you need a JRE, not just the JDK):

    mvn -f pom.xml exec:exec@partitureditor

## Make a windows executable

This part is experimental and not yet fully implemented. Some parts of EXMARaLDA won't work yet! For a working application use `mvn -f pom.xml exec:exec@partitureditor`.

To wrap the Partitureditor as windows executable with JSmooth (note the use of `utils.xml`)

    mvn -f utils.xml antrun:run@jsmoothgen_partitureditor_fobs

You'll find the executable in

    %EXMARALDA_WORKING_DIR%\target\PartiturEditorWithFOBS.exe

For test purposes there is an example file included: `%EXMARALDA_WORKING_DIR%\exmaralda.exb` with its corresponding audio file `%EXMARALDA_WORKING_DIR%\exmaralda.wav`

Following commands build the executables for all EXMARaLDA applications:

    mvn -f utils.xml antrun:run@jsmoothgen_partitureditor_fobs
    mvn -f utils.xml antrun:run@jsmoothgen_coma
    mvn -f utils.xml antrun:run@jsmoothgen_exakt_fobs
    mvn -f utils.xml antrun:run@jsmoothgen_folker_fobs
    mvn -f utils.xml antrun:run@jsmoothgen_orthonormal_fobs
    mvn -f utils.xml antrun:run@jsmoothgen_teidrop

You'll find the executables in

    %EXMARALDA_WORKING_DIR%\target\PartiturEditorWithFOBS.exe
    %EXMARALDA_WORKING_DIR%\target\coma.exe
    %EXMARALDA_WORKING_DIR%\target\ExaktWithFOBS.exe
    %EXMARALDA_WORKING_DIR%\target\FolkerWithFOBS.exe
    %EXMARALDA_WORKING_DIR%\target\OrthoNormalWithFOBS.exe
    %EXMARALDA_WORKING_DIR%\target\teidrop.exe

## Assembly application

To aggregate the project output along with its dependencies and other files into a single distributable archive run:

    mvn -f pom.xml assembly:single

The aggregated output is in %EXMARALDA_WORKING_DIR%\target\EXMARaLDA-1.6-distribution

## Change Player

The `JDS Player` is bound in this build.
It sometimes makes problems. Therefore you should change it to `JMF Player`.
Start EXMARaLDA. Under `Edit > Preferences ... > Media` set the `JMF Player`.
Restart EXMARaLDA with `mvn -f pom.xml exec:exec@partitureditor`.

EXMARaLDA warns that "Your player preference is set to JMF-Player" and "This is not the recommended default player for your system. The recommended default player for your system is JDS-Player." And asks if "Do you want to switch to the recommended default player?" Answer "no".

## Generate Site

If you wish you can generate a site with information of the project

    mvn -f pom.xml dependency:resolve
    mvn -f pom.xml dependency:tree
    mvn -f pom.xml javadoc:javadoc
    mvn -f pom.xml jxr:jxr
    mvn -f pom.xml pmd:pmd
    mvn -f pom.xml pmd:cpd
    mvn -f pom.xml classycle:analyse
    mvn -f pom.xml tattletale:report
    mvn -f pom.xml site

The site is generated under `c:\workspace\maprepository\exmaralda\target\site` (`%EXMARALDA_WORKING_DIR%\target\site`)

