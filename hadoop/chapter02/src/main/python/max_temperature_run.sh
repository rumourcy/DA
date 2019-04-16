#!/usr/bin/env bash
hadoop jar $HADOOP_HOME/share/hadoop/tools/lib/hadoop-streaming-*.jar \
  -D mapreduce.ifile.readahead=false \
  -input NCDC/gz \
  -output NCDC/python \
  -mapper max_temperature_mapper.py \
  -combiner max_temperature_reducer.py \
  -reducer max_temperature_reducer.py