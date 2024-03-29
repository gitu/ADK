#!/usr/bin/gnuplot -persist
set terminal postscript monochrome "TimesNewRomanPSMT" 10
set output '9-22.ps'

set key top left 
set key box

set multiplot

set size .5,.5
set origin 0,0

set xlabel "d = number of dimensions" 
set ylabel "number of recursions" 
set title "# of single recursions as d increases for fixed n"

set xrange [ 0 : 32 ] noreverse nowriteback
set yrange [ 0 : 80000 ] noreverse nowriteback

set xtics 4

plot 'figure9-22.dat' using 1:2 index 0 title "n=131072 single" with linespoints,'figure9-22.dat' using 1:2 index 1 title "n=262144 single" with linespoints,'figure9-22.dat' using 1:2 index 2 title "n=524288 single" with linespoints

set size .5,.5
set origin .5,0

set xlabel "d = number of dimensions" 
set ylabel "number of recursions" 
set title "# of double recursions as d increases for fixed n"

set xrange [ 0 : 32 ] noreverse nowriteback
set yrange [ 0 : 300000 ] noreverse nowriteback

set xtics 4

plot 'figure9-22.dat' using 1:3 index 0 title "n=131072 double" with linespoints,'figure9-22.dat' using 1:3 index 1 title "n=262144 double" with linespoints,'figure9-22.dat' using 1:3 index 2 title "n=524288 double" with linespoints

#EOF
