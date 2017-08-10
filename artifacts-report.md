# Artifacts (Open Issues)

The dependecy artifacts used by EXMARaLDA are reported in following groups:
    (1) artifacts existing in public repositories,
    (2) artifacts equivalent to ones existing in public repositories,
    (3) artifacts included in other packages,
    (4) artifacts of unknown origin,
    (5) extra artifacts needed to compile EXMARaLDA,
    (6) Not more needed artifacts, and
    (7) Special case.
The purpose of this report is to complete the documentation of the artifacts used by EXMARaLDA.
    

## Artifacts existing in public repositories

Following artifacts are the same as existing files in public repositories (e.g. Maven). They do follow the naming conventions.

- `commons-io-2.4.jar` is the same as [commons-io:commons-io:2.4](http://central.maven.org/maven2/commons-io/commons-io/2.4/commons-io-2.4.jar).
- `commons-lang-2.5.jar` is the same as [commons-lang:commons-lang:2.5](http://central.maven.org/maven2/commons-lang/commons-lang/2.5/commons-lang-2.5.jar).
- `commons-logging-1.2.jar` is the same as [commons-logging:commons-logging:1.2](http://central.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar).
- `httpclient-4.5.1.jar` is the same as [org.apache.httpcomponents:httpclient:4.5.1](http://central.maven.org/maven2/org/apache/httpcomponents/httpclient/4.5.1/httpclient-4.5.1.jar).
- `httpcore-4.4.3.jar` is the same as [org.apache.httpcomponents:httpcore:4.4.3](http://central.maven.org/maven2/org/apache/httpcomponents/httpcore/4.4.3/httpcore-4.4.3.jar).
- `httpmime-4.5.1.jar` is the same as [org.apache.httpcomponents:httpmime:4.5.1](http://central.maven.org/maven2/org/apache/httpcomponents/httpmime/4.5.1/httpmime-4.5.1.jar).
- `jaxen-1.1.6.jar` is the same as [jaxen:jaxen:1.1.6](http://central.maven.org/maven2/jaxen/jaxen/1.1.6/jaxen-1.1.6.jar).
- `jcalendar-1.4.jar` is the same as [com.toedter:jcalendar:1.4](http://central.maven.org/maven2/com/toedter/jcalendar/1.4/jcalendar-1.4.jar).
- `tritonus_share-0.3.6.jar` is the same as [org.mobicents.external.tritonus:tritonus_share:0.3.6](https://repository.jboss.org/org/mobicents/external/tritonus/tritonus_share/0.3.6/tritonus_share-0.3.6.jar).

## Artifacts equivalent to ones existing in public repositories

Following artifacts are the same as existing files in public repositories (e.g. Maven). Because they **don't follow the naming conventions** it is recommended to rename the artifact to follow the naming conventions.

- `javax.mail.jar` -> `javax.mail-1.5.6.jar` is the same as [com.sun.mail:javax.mail:1.5.6](https://maven.java.net/content/repositories/releases/com/sun/mail/javax.mail/1.5.6/javax.mail-1.5.6.jar).

    _The original jar `javax.mail-1.5.6.jar` has a different `META-INF\MANIFEST.MF` as the jar used by exmaralda. Otherwise the jars are binary the same._
- `jdom.jar` -> `jdom-1.1.3.jar` is the same as [org.jdom:jdom:1.1.3](http://central.maven.org/maven2/org/jdom/jdom/1.1.3/jdom-1.1.3.jar).
- `mrj.jar` -> `MRJToolkitStubs-1.0.jar` is the same as [mrj:MRJToolkitStubs:1.0](http://central.maven.org/maven2/mrj/MRJToolkitStubs/1.0/MRJToolkitStubs-1.0.jar).

    _The original  jar `MRJToolkitStubs-1.0.jar` and the used jar by exmaralda `mrj.jar` differ as follows: In `MRJToolkitStubs-1.0.jar` the class `com.apple.mrj.MRJFileUtils.java` has two new signatures: `public static File findFolder(short paramShort, MRJOSType paramMRJOSType)` and `public static File findFolder(short paramShort, MRJOSType paramMRJOSType, boolean paramBoolean)`, and the class `com.apple.mrj.MRJPriv.java` has two new signatures: `static File findFolder(short paramShort, MRJOSType paramMRJOSType)` and `static File findFolder(short paramShort, MRJOSType paramMRJOSType, boolean paramBoolean)`. Furthermore it has following files `META-INF\ABBOT.RSA`, `META-INF\ABBOT.SF`, `META-INF\MANIFEST.MF`. Otherwise the jars are binary the same._
- `mysql-connector-java-5.1.6-bin.jar` -> `mysql-connector-java-5.1.6.jar` is the same as [mysql:mysql-connector-java:5.1.6](http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.6/mysql-connector-java-5.1.6.jar).
- `saxon9he.jar` -> `Saxon-HE-9.6.0-7.jar` is the same as [net.sf.saxon:Saxon-HE:9.6.0-7](http://central.maven.org/maven2/net/sf/saxon/Saxon-HE/9.6.0-7/Saxon-HE-9.6.0-7.jar).
- `serializer.jar` -> `serializer-2.7.2.jar` is the same as [xalan:serializer:2.7.2](http://central.maven.org/maven2/xalan/serializer/2.7.2/serializer-2.7.2.jar).
- `stax-utils.jar` -> `stax-utils-20070216.jar` is the same as [net.java.dev.stax-utils:stax-utils:20070216](http://central.maven.org/maven2/net/java/dev/stax-utils/stax-utils/20070216/stax-utils-20070216.jar).
- `swing-worker-1.2.jar` -> `swingworker-1.2.jar` is the same as [org.jdesktop.swingworker:swingworker:1.2](http://projects.nigelsim.org/maven/org/jdesktop/swingworker/swingworker/1.2/swingworker-1.2.jar).

    _Version 1.2 is not existing (anymore). There are versions 1.2-1 or 1.2-2 that can be found in repository nigelsim.com. But, can this repository be trusted? Will it be available in the future? The jars are binary the same._
- `xalan.jar` -> `xalan-2.7.2.jar` is the same as [xalan:xalan:2.7.2](http://central.maven.org/maven2/xalan/xalan/2.7.2/xalan-2.7.2.jar).
- `xercesImpl.jar` -> `xercesImpl-2.11.0.jar` is the same as [xerces:xercesImpl:2.11.0](http://central.maven.org/maven2/xerces/xercesImpl/2.11.0/xercesImpl-2.11.0.jar).
- `xml-apis.jar` -> `xml-apis-1.4.01.jar` is the same as [xml-apis:xml-apis:1.4.01](http://central.maven.org/maven2/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar).

## Artifacts included in other packages

Following artifacts are found to be part of other files/packages and they don't follow the naming conventions. Because they **don't follow the naming conventions** it is recommended to rename the artifact to follow the naming conventions.
To avoid conflicts with existing `groupIds` we could make these artifacts belong to a new `groupId`=`exmaralda`, prefix the `artifactId` with `exmaralda-` and give the same `version` as the EXMARaLDA build (eg. `exmaralda:exmaralda-artifact-1.0:1.6`). This would help to discern it from real public artifacts.

- `BATIK.jar` is part of [batik-bin-1.8.zip](http://mirror.serversupportforum.de/apache/xmlgraphics/batik/binaries/batik-bin-1.8.zip) from which it can be extracted under the path ``. 

    _This jar seems to have mixed contents of batik-1.8 and some other classes. What is the purpose of this mixing?_ (recommended name: `exmaralda:exmaralda-:1.6`)
- `bounce.jar` is part of [bounce-v011.zip](https://ayera.dl.sourceforge.net/project/bounce/bounce/0.11/bounce-v011.zip) from which it can be extracted under the path `bounce.jar`. 

    _It seems an old version of nz.ac.waikato.cms.weka.thirdparty > bounce. Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-:1.6`)
- `cobra.jar` is part of [cobra-0.98.2.zip](https://ayera.dl.sourceforge.net/project/xamj/Cobra%20HTML%20Toolkit/0.98.2/cobra-0.98.2.zip) from which it can be extracted under the path `cobra-0.98.2/lib/cobra.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-cobra-0.98.2.jar:1.6`)
- `elan.jar` is part of [ELAN_4-9-1_win.exe](http://www.mpi.nl/tools/elan/ELAN_4-9-1_win.exe) from which it can be extracted under the path `InstallerData/Disk1/InstData/Resource1.zip/C_/MPI/ELAN_Releases/Install_Intermediates/lib/elan4.9.1/elan-4.9.1.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-elan-4.9.1:1.6`)
- `fobs4jmf.jar` is part of [fobs4jmf_0.4.2_win32.tar.bz2](https://10gbps-io.dl.sourceforge.net/project/fobs/fobs4jmf%20binaries/Fobs4JMF-0.4.2/fobs4jmf_0.4.2_win32.tar.bz2) from which it can be extracted under the path `fobs4jmf_0.4.2_win32.tar/fobs4jmf_0.4.2_win32/fobs4jmf.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-fobs4jmf-0.4.2.jar:1.6`)
- `jmf.jar` is part of [fobs4jmf_0.4.2_win32.tar.bz2](https://10gbps-io.dl.sourceforge.net/project/fobs/fobs4jmf%20binaries/Fobs4JMF-0.4.2/fobs4jmf_0.4.2_win32.tar.bz2) from which it can be extracted under the path `fobs4jmf_0.4.2_win32.tar/fobs4jmf_0.4.2_win32/jmf.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-jmf-0.4.2.jar:1.6`)
- `lobo.jar` is part of [lobo-distro-0.98.2.zip](https://ayera.dl.sourceforge.net/project/xamj/Lobo%20Browser/0.98.2/lobo-distro-0.98.2.zip) from which it can be extracted under the path `lobo-distro-0.98.2/lobo.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-lobo-0.98.2.jar:1.6`)
- `lobo-pub.jar` is part of [lobo-distro-0.98.2.zip](https://ayera.dl.sourceforge.net/project/xamj/Lobo%20Browser/0.98.2/lobo-distro-0.98.2.zip) from which it can be extracted under the path `lobo-distro-0.98.2/lobo-pub.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-lobo-pub-0.98.2.jar:1.6`)
- `quaqua.jar` is part of [quaqua-9.1.nested.zip](http://www.randelshofer.ch/quaqua/files/quaqua-9.1.nested.zip) from which it can be extracted under the path `quaqua-9.1.zip/Quaqua/dist/quaqua.jar`. 

    _Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-quaqua-9.1.jar:1.6`)

## Artifacts of unknown origin

The origin/source of following artifacts has not yet been identified

- `AppleJavaExtensions.jar` is of unknown origin.  (recommended name: `exmaralda:exmaralda-AppleJavaExtensions.jar:1.6`)
- `ipsk.jar` is of unknown origin. 

    _is this jar from BAS in München?_ (recommended name: `exmaralda:exmaralda-ipsk.jar:1.6`)
- `JavaQTMovieView-1.4.5.jar` is of unknown origin.  (recommended name: `exmaralda:exmaralda-JavaQTMovieView-1.4.5.jar:1.6`)
- `jctable.jar` is of unknown origin.  (recommended name: `exmaralda:exmaralda-jctable.jar:1.6`)
- `jmf.jar` is of unknown origin. 

    _Content of this jar do not correspond to any of the versions 2.1.1e, 2.2.1b, fs-3.0. The used jar by exmaralda is a subset of  "FobsJMF/jmf.jar". Furthermore there are three modified/changed classes: `com.sun.media.renderer.audio.AudioRenderer`, `com.sun.media.util.RegistryLib`, `com.sun.media.BasicRendererModule`. Otherwise the jars are binary the same._ (recommended name: `exmaralda:exmaralda-jmf.jar:1.6`)

## Extra artifacts needed to compile EXMARaLDA

These artifacts are needed to compile EXMARaLDA. But they are not needed for runtime

- `oaipmh-cmdi-bindings-1.0.9.jar` is the same as [eu.clarin.weblicht:oaipmh-cmdi-bindings:1.0.9](http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.6/mysql-connector-java-5.1.6.jar).
- `wlfxb-1.3.2.jar` is the same as [eu.clarin.weblicht:wlfxb:1.3.2](https://repository.jboss.org/org/mobicents/external/tritonus/tritonus_share/0.3.6/tritonus_share-0.3.6.jar).

## Not more needed artifacts

Following artifacts seem to be not not more needed. They have been overstriked in EXMARaLDA Libraries.

- `jakarta-oro-2.0.8.jar` scheint nicht gebraucht zu werden
- `jna-3.5.2.jar` wurde für den alten DS-Player gebraucht, jetzt nicht mehr
- `jniwrap-3.6.1.jar` wurde für den alten DS-Player gebraucht, jetzt nicht mehr
- `ojdbc6.jar` DGD-Package muss raus aus GIT!!!!
- `tritonus_jorbis-0.3.6.jar` Das macht Ärger, wollen wir nicht.
- `winpack-3.6.jar` wurde für den alten DS-Player gebraucht, jetzt nicht mehr

Following artifacts seem to be not more needed. In EXMARaLDA Libraries is asked if they are still needed.

- `ant.jar` was ist das? Kann das weg?
- `basicplayer3.0.jar` Sch**ss-Player, brauchen wir nicht, kann weg
- `commons-net-1.4.1.jar` braucht das jemand? Coma?
- `fedora-client-0.1.6-with-dependencies.jar` es gibt neuere Version, habe aber keine Binaries gefunden, JAR wird für Distribution nicht gebraucht, kommt raus, weil riesig groß, package kann eigentlich ganz weg
- `forms-1.2.1.jar` braucht das jemand? Coma?
- `ipsk_audiotools.jar` Siehe Mail von J** / T** K**
- `ipsk_utils.jar` Siehe Mail von J** / T** K**
- `JavaQTMovieView-1.4.4.jar` 
- `saxon8-jdom.jar` braucht das jemand? Coma?

## Special case

- The jars `ipsk_audiotools.jar`, `ipsk_utils.jar` are mentioned in `EXMARaLDA Libraries`. They are not existing in the distribution packages. Its content seems to be merged into `ipsk.jar`.
- `ipsk.jar`: This jar contains a (probably full) merge of the BAS-jars `ipsk_audiotools.jar` (from `ips_ audiotools-###-src.zip`) and `ipsk_utils.jar` (from `ips_javautils-###-src.zip`). The exact version cannot be reproduced. This jar has no manifest. The time stamps of its contents is 27.07.2012 and 30.07.2012. Probably they are older versions that cannot be found under [http://www.bas.uni-muenchen.de/Bas/software/source/packages/release/].
