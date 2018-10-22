#! /bin/bash

for ((i=1901;i<=1939;i+=1))
do
  echo hdfs:///user/falcon/NCDC/$i >> ncdc_files.txt
done
