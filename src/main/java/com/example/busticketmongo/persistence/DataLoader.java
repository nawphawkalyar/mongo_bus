package com.example.busticketmongo.persistence;

import com.example.busticketmongo.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@Service
public class DataLoader implements CommandLineRunner {
    private MongoTemplate mongoTemplate;

    public DataLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override @Profile("dev")
    public void run(String... args) throws Exception {

        BusRoute mandalayYangon=new BusRoute(new Bus("JJ",BusStatus.MODERATE, Arrays.asList(
                new Seats("A1", SeatStatus.VACANT),
                new Seats("A2", SeatStatus.VACANT),
                new Seats("A3", SeatStatus.VACANT),
                new Seats("A4", SeatStatus.VACANT),
                new Seats("A5", SeatStatus.VACANT)


        )),
                new Routes("Mandalay","Yangon"),
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2),
                Arrays.asList("Pegu","Pyinmana")

                );

        BusRoute yangonMadalay=new BusRoute(new Bus("JJ",BusStatus.MODERATE, Arrays.asList(
                new Seats("A1", SeatStatus.VACANT),
                new Seats("A2", SeatStatus.VACANT),
                new Seats("A3", SeatStatus.VACANT),
                new Seats("A4", SeatStatus.VACANT),
                new Seats("A5", SeatStatus.VACANT)


        )),
                new Routes("Yangon","Mandalay"),
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2),
                Arrays.asList("Pegu","Pyinmana")

                );

        BusRoute yangonTaungyi=new BusRoute(new Bus("TT",BusStatus.MODERATE, Arrays.asList(
                new Seats("A1", SeatStatus.VACANT),
                new Seats("A2", SeatStatus.VACANT),
                new Seats("A3", SeatStatus.VACANT),
                new Seats("A4", SeatStatus.VACANT),
                new Seats("A5", SeatStatus.VACANT)


        )),
                new Routes("Yangon","Taungyi"),
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2),
                Arrays.asList("TharSyi","Kalaw")

                );


//        Collection<BusRoute> busRoutes=
//                Arrays.asList(mandalayYangon,yangonMadalay,yangonTaungyi);
//        this.mongoTemplate.insertAll(busRoutes);


    }
}
