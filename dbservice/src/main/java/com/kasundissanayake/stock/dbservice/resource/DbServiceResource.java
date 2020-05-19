package com.kasundissanayake.stock.dbservice.resource;

import com.kasundissanayake.stock.dbservice.model.Quote;
import com.kasundissanayake.stock.dbservice.model.Quotes;
import com.kasundissanayake.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {
    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username")
                                      final String username){
        return getQuotesByUsername(username);

    }

    private List<String> getQuotesByUsername(@PathVariable("username") String username) {
        return quotesRepository.findByUserName(username)
        .stream()
        .map(Quote::getQuote)
        .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));


        return getQuotesByUsername(quotes.getUserName());
    }

//    @PostMapping("/delete/{username}")
//    public boolean delete(@PathVariable("username") final String userName){
//
//        List<Quote> quotes = quotesRepository.findByUserName(userName);
//
//
//    }
}
