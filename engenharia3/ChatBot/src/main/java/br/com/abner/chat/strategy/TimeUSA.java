package br.com.abner.chat.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUSA implements TimeStrategy{
    @Override
    public String verifyTime(String country) {
        Locale locale = new Locale("en", "US");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss", locale);

        // Define o fuso horário para a França
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        String date = dateFormat.format(new Date());
        return String.format("Data e Horário nos %s é igual a %s", country, date);
    }
}
