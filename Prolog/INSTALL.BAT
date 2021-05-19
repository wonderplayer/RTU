echo off
if exist prolog.exe goto badstart
if "%1" == "" goto badstart
if "%2" == "" goto badstart
goto start
:badstart
echo Please let the hard-disk be the default drive and use:
echo 
echo     source:install source: targetdirectory
echo 
echo  like   a:install a: c:\prolog
goto quit

:disk1
echo Please insert the PC Prolog disk 1 labeled PROLOG.EXE into drive %1
pause

:start
if not exist %1prolog.exe goto disk1
md %2
md %2\BGI

copy %1*.* %2
copy %1\bgi\*.* %2\bgi

:disk2
echo Please insert the PC Prolog disk 2 labeled PROLOG.OVL into drive %1
pause

if not exist %1prolog.ovl goto disk2
copy %1*.* %2

:disk3
echo Please insert the PC Prolog disk 3 labeled PROLOG.LIB into drive %1
pause

if not exist %1prolog.lib goto disk3
copy %1*.* %2

echo 
echo The disk labeled DEMO PROGRAMS contains source for several
echo interesting demo programs programmed in PC-Prolog.
echo 

%2\yesno.exe Do you want to copy the demo programs to disk (y/n):
if not errorlevel 1 goto nodemo

goto adisk4
:disk4
echo Please insert the PC Prolog disk 4 labeled DEMO PROGRAMS into drive %1
pause

:adisk4
if not exist %1\pie\pie.pro goto disk4

md %2\pie
md %2\register
md %2\programs
md %2\geni
md %2\sen_an
md %2\geobase
md %2\diff
md %2\demotool
copy %1\pie\*.* %2\pie
copy %1\register\*.* %2\register
copy %1\programs\*.* %2\programs
copy %1\geni\*.* %2\geni
copy %1\sen_an\*.* %2\sen_an
copy %1\geobase\*.* %2\geobase
copy %1\diff\*.* %2\diff
copy %1\demotool\*.* %2\demotool

:nodemo

echo 
echo The disk labeled EXAMPLES contains source for the
echo examples in the PC-Prolog manual.
echo 

%2\yesno.exe Do you want to copy the examples to disk (y/n):
if not errorlevel 1 goto noexamples

goto adisk5
:disk5
echo Please insert the PC Prolog disk 5 labeled EXAMPLES into drive %1
pause
:adisk5
if not exist %1\refexamp\chnfn.pro goto disk5

md %2\examples
md %2\refexamp
md %2\answers
copy %1\examples\*.* %2\examples
copy %1\refexamp\*.* %2\refexamp
copy %1\answers\*.* %2\answers

:noexamples

echo 
echo The disk labeled PROLOG.EXE contains a demo of the BGI graphic
echo 

%2\yesno.exe Do you want to copy the BGI demo to disk (y/n):
if not errorlevel 1 goto nobgidemo

goto adisk1a

:disk1a
echo Please insert the PC Prolog disk 1 labeled PROLOG.EXE into drive %1
pause

:adisk1a
if not exist %1prolog.exe goto disk1a
md %2\bgidemo
copy %1\bgidemo\*.* %2\bgidemo

:nobgidemo


echo 
echo PC Prolog 3.10 is now installed on your hard disk. Before
echo running PC Prolog you should add 
echo 
echo   %2
echo 
echo to your DOS PATH so you can run the compiler from any directory.
echo For example, in your AUTOEXEC.BAT file you would add the line:
echo 
echo   PATH=%2
echo 
echo You should also add the lines
echo 
echo   FILES=20
echo   BUFFERS=40
echo 
echo to the CONFIG.SYS file located in the root directory of your hard
echo disk.
echo 
del %2\install.bat
del %2\yesno.exe
:quit
