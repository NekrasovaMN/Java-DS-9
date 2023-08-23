package SmartHouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void increaseVolume() {   //прибавить громкость
        Radio radio = new Radio();
        radio.setCurrentVolume(57);
        radio.volumeUp();

        int expected = 58;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeMoreMax() {   //если уровень громкости звука достиг максимального значения,
        // то дальнейшее нажатие на + не должно ни к чему приводить;
        radio.setCurrentVolume(100);
        radio.volumeUp();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolume() {      //убавить громкость
        radio.setCurrentVolume(48);
        radio.volumeDown();

        int expected = 47;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolumeAboveMax() { //больше максимальной
        radio.setCurrentVolume(102);

        radio.volumeUp();

        int expected = 1;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolumeBelowMin() { //больше минимальной
        radio.setCurrentVolume(-3);

        radio.volumeDown();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeLessMin() {      //если уровень громкости звука достиг минимального значения,
        // то дальнейшее нажатие на - не должно ни к чему приводить.
        radio.setCurrentVolume(0);
        radio.volumeDown();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setStation() {      //выбор станции
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(27);

        int expected = 27;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setStationMoreMax() {   //выбор станции больше Max
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(30);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setStationLessMin() {   //выбор станции меньше Min
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStation() {     //следующая станция
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(25);
        radio.next();

        int expected = 26;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationAfterMax() {     //Если текущая радиостанция — максимальная, и клиент нажал на кнопку next на пульте,
        // то текущей должна стать нулевая.
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(29);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStation() {     //предыдущая станция
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(29);
        radio.prev();

        int expected = 28;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationAfterMin() {     //Если текущая радиостанция — 0, и клиент нажал на кнопку prev на пульте,
        // то текущей должна стать максимальная.
        Radio radio = new Radio(30);
        radio.setCurrentRadioStation(0);
        radio.prev();

        int expected = 29;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
}