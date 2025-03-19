set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%\libAllure\aspectjweaver-1.9.20.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libExtent5\*;%ProjectPath%libReportNG\*;%ProjectPath%Libraries\*;" org.testng.TestNG "%ProjectPath%resources\nopCommerce.xml"
allure serve .\allure-results\
pause