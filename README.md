Zadanie projektowe na przedmiot: Programowanie aplikacji biznesowych w oparciu o platformę Java.</br>
Każda osoba  w zespole powinna odpowiadać za implementację wybranych elementów aplikacji </br>
(np.: podział wg. funkcjonalności rodzajów użytkowników lub warstw),</br>
Aplikacja powinna mieć różne role użytkowników i związane z nimi osobne funkcjonalności (np.: administrator, klient, ...).</br>
Liczba ról powinna być równa ilości osób realizujących projekt. Termin oddania projektu to ostatnie zajęcia PS.</br>

Ogólne wymagania dot. projektu:

    Dane przechowywane w relacyjnej bazie.
    Dostęp do danych poprzez pulę połączeń skonfigurowaną na serwerze aplikacyjnym.
    Podział na warstwy (osobne komponenty dla warstwy danych - wzorzec DAO, logiki i prezentacji, komunikacja między warstwami z użyciem interfejsów), komponenty warstwy danych i logiki powinny działać w kontenerze serwera aplikacyjnego (EJB lub CDI), warstwa prezentacji może być aplikacją webową lub aplikacją kliencką (konsolową lub z GUI działającą jako stand-alone client application w kontenerze aplikacji klienckich).
    Obsługa uwierzytelniania
    Asynchroniczne przetwarzanie (np.: z użyciem JMS)
    Dziennik zdarzeń.
    Testy jednostkowe.
    
    
1) Sklep internetowy

Funkcjonalność:

    Przeglądanie/dodawanie/edycja/usuwanie produktów.
    Możliwość składania zamówienia na wybrane produkty (koszyk zakupów).
    Możliwość przeglądania złożonych zamówień.
    Przesyłanie wiadomości o złożonym zamówieniu poprzez e-mail.
    Uwierzytelnianie.
