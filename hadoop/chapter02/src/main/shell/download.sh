#!/usr/bin/env bash
for i in $(seq 1901 2018)
do
    wget -r -np -nH --cut-dirs=3 ftp://ftp.ncdc.noaa.gov/pub/data/noaa/$i/
done
