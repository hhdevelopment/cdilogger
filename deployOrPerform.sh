#CURRENT_VERSION=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec)
CURRENT_VERSION=`python -c "import xml.etree.ElementTree as ET; print(ET.parse(open('pom.xml')).getroot().find('{http://maven.apache.org/POM/4.0.0}version').text)"`
echo "CURRENT_VERSION = "$CURRENT_VERSION
echo "releaseVersion = "$releaseVersion
# mvn --B -Dtag=${project-name}-${releaseVersion} release:prepare \
#                 -DreleaseVersion=${releaseVersion} \
#                 -DdevelopmentVersion=${developmentVersion}
