package ru.kpfu.itis.solopov.net.service;

import ru.kpfu.itis.solopov.net.dto.QuoteDto;
import ru.kpfu.itis.solopov.net.model.Quote;

import java.util.List;

public interface QuoteService {
    List<QuoteDto> getAll();
    void save(Quote quote);
    QuoteDto get(long id);
}
