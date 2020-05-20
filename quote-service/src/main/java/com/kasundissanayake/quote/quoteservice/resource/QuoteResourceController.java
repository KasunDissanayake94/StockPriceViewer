package com.kasundissanayake.quote.quoteservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/rest/quote")
public class QuoteResourceController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{quoteName}")
    public List<HistoricalQuote> getHistory(@PathVariable("quoteName") final String quoteName) throws IOException {

        Stock google = YahooFinance.get(quoteName);
        List<HistoricalQuote> histQuotes = google.getHistory();
        return histQuotes;

    }
}
