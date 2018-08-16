package com.perspicace.ai.deepbot.neo4j;


import com.perspicace.ai.deepbot.domain.Show;
import com.perspicace.ai.deepbot.neo4j.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private PagesService<Show> showPagesService;


    public Show save(Show show) {
        return showRepository.save(show);
    }

}
