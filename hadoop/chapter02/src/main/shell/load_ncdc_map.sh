#!/usr/bin/env bash
read offset hdfsfile

echo "reporter:status:Retrieving $hdfsfile" >&2
hadoop fs -get $hdfsfile .

target=`basename $hdfsfile`
for file in $target/*
do
    gunzip -c $file >> $target.all
    echo "reporter:status:Processed $file" >&2
done

echo "reporter:status:Gzipping $target and putting in HDFS" >&2
gzip -c $target.all | hadoop fs -put - NCDC/gz/$target.gz
