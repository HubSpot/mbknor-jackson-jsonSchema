#!/bin/bash -xe

project_version="$(sbt -warn --batch --no-colors 'print version')"
for i in $(find target -name "scala-2.1*")
do
  scala_dir="$(basename $i)"
  scala_version="${scala_dir#scala-}"
  artifact_dir="mbknor-jackson-jsonschema_$scala_version-$project_version"
  mkdir $artifact_dir
  find $i -maxdepth 1 -name "*-$project_version-javadoc.jar" -exec cp {} "$artifact_dir/javadoc.jar" \;
  find $i -maxdepth 1 -name "*-$project_version-sources.jar" -exec cp {} "$artifact_dir/sources.jar" \;
  find $i -maxdepth 1 -name "*-$project_version.jar" -exec cp {} "$artifact_dir/main.jar" \;
  find $i -maxdepth 1 -name "*-$project_version.pom" -exec cp {} "$artifact_dir/pom.xml" \;
done
