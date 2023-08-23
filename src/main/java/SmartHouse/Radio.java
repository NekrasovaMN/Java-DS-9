package SmartHouse;

public class Radio {
    private int currentVolume;          // текущая громкость
    private int currentRadioStation;// текущая радиостанция
    private int numberStation = 10; // номер станции
    private int minStation = 0; // мин. станция
    private int maxStation = numberStation - 1; //мах. станция
    private int minVolume = 0; //мин. громкость
    private int maxVolume = 100; //мак. громкость

    public Radio() { // конструктор для задания числа радиостанций по умолчанию
    }

    public Radio(int numberStation) {
        this.maxStation = numberStation - 1;
    }

    public Radio(int minVolume, int maxVolume) { // конструктор для задания уровня громкости
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {  // установка радиостанции
        if (newCurrentRadioStation > maxStation) {
            return;
        }
        if (newCurrentRadioStation < minStation) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > maxVolume) {
            return;
        }
        if (newCurrentVolume < minVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void volumeUp() {                // увеличение громкости на 1
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        }
    }

    public void volumeDown() {              // уменьшение громкости на 1
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        }
    }

    public void next() {                // следующая радиостанция
        if (currentRadioStation < maxStation) {
            currentRadioStation = currentRadioStation + 1;
        } else {
            currentRadioStation = 0;
        }
    }

    public void prev() {                // предыдущая радиостанция
        if (currentRadioStation > minStation) {
            currentRadioStation = currentRadioStation - 1;
        } else {
            currentRadioStation = maxStation;
        }
    }
}