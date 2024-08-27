package br.com.abner.chat.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeFrance implements TimeStrategy {
    @Override
    public String verifyTime(String country) {
        Locale locale = new Locale("fr", "FR");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss", locale);

        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));

        String date = dateFormat.format(new Date());
        return String.format("Data e Horário na %s é igual a %s", country, date);
    }
}
