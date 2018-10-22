#!/usr/bin/env bash
hadoop fs -mkdir NCDC
hadoop fs -put ~/dataset/* NCDC/
