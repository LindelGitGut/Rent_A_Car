Ziel ist es eine API zu schaffen welche folgende bedingungen erfüllt:

Rahmen:

ca. 250.000 Fahrzeuge zu verwalten
 => wir gehen für einen Eintrag in der Fahrzeug Entity von ca 100 bytes pro datensatz aus
    => 250.000 * 100 = 25.000.000 bytes = 25 MB

es sind ca. 25.000 Kunden zu verwalten
    => wir gehen für einen Eintrag in der Kunden Entity von ca 100 bytes pro datensatz aus
        => 25.000 * 100 = 2.500.000 bytes = 2,5 MB

nehmen wir an das jeder Kunde durchschnittlich 10 Requests pro Woche durchführt
    25.000 Kunden * 10 Requests = 250.000 Requests pro Woche

dann haben wir einen einen Request durchschnitt von 250.000 / 7 = 35.714,2857143 Requests pro Tag
    => 35.714,2857143 / 24 = 1.488,0952381 Requests pro Stunde
    => 1.488,0952381 / 60 = 24,8015873017 Requests pro Minute
    => 24,8015873017 / 60 = 0,4133597884 Requests pro Sekunde


Damit haben wir einen durchschnittlich einen Request alle 0,4133597884 Sekunden

Da wir Spitzen zum Wochenende erwarten multiplizieren wir die durchschnittlichen Requests mit 10
um hier für Spitzen vorbereitet zu sein, daher:

 => 0,4133597884 * 10 = 4,133597884 Requests pro Sekunde


Da Springboot/Tomcat standardmäßig 200 Threads zur Verfügung stellt, 
können wir davon ausgehen, dass wir 200 Requests pro Sekunde verarbeiten können.




   
    