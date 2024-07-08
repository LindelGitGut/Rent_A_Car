Ziel ist es eine API zu schaffen welche folgende bedingungen erfüllt:


1. Die API soll es ermöglichen Fahrzeuge zu verwalten
2. Die API soll es ermöglichen Kunden zu verwalten
3. Die API soll es ermöglichen Termine/Reservierungen zu verwalten
4. Es soll nachvollziehbar sein welches Fahrzeug aktuell zur Verfügung steht

Daher werden 3 Entitäten benötigt:

1. Fahrzeug => Fahrzeuge n -> 1 Kunde
2. Kunde => Kunde 1 -> n Termine
3. Termin


Da wir dem 3 Schicht System arbeiten sollen die concerns getrennt werden:
 d.h. wir haben eine Schicht für die Datenbank, eine Schicht für die Logik und eine Schicht für die Präsentation
 d.h wir haben je ein Model für Service, Repository und Controller um eine einfache Anpassbarkeit sowie Skalierung zu ermöglichen





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


Daher sollten wir mit einer einzelnen Springboot Instanz genügend Kapazitäten
haben um den Anforderungen gerecht zu werden.




   
    