package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.dao.Impl.PublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dao.Impl.QuoteDaoImpl;
import ru.kpfu.itis.solopov.net.dto.QuoteDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.model.Quote;
import ru.kpfu.itis.solopov.net.service.QuoteService;
import ru.kpfu.itis.solopov.net.service.QuoteService;

import java.util.List;
import java.util.stream.Collectors;

public class QuoteServiceImpl implements QuoteService {
    private final QuoteDaoImpl dao;
    public QuoteServiceImpl(Dao<Quote> dao) {
        this.dao = (QuoteDaoImpl) dao;
    }
    @Override
    public List<QuoteDto> getAll() {
        return dao.getAll().stream().map(
                q -> new QuoteDto(q.getText(), q.getAuthor(), q.getId())
        ).collect(Collectors.toList());
    }

    @Override
    public QuoteDto get(long id) {
        Quote quote = dao.get(id);
        return new QuoteDto(quote.getText(), quote.getAuthor(), quote.getId());
    }



    @Override
    public void save(Quote quote) {
        dao.save(quote);
    }
}
