package com.example.busticketmongo.api;

import com.example.busticketmongo.model.BusRoute;
import com.example.busticketmongo.model.BusStatus;
import com.example.busticketmongo.model.QBusRoute;
import com.example.busticketmongo.persistence.BusrouteRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/busroutes")
public class BusRouteController {
    private MongoTemplate mongoTemplate;
    private BusrouteRepository busrouteRepository;

    public BusRouteController(MongoTemplate mongoTemplate, BusrouteRepository busrouteRepository) {
        this.mongoTemplate = mongoTemplate;
        this.busrouteRepository = busrouteRepository;
    }

    @GetMapping("/all")
    public Collection<BusRoute> showAllBusRoute(){
        Collection<BusRoute> busRoutes=this.mongoTemplate.findAll(BusRoute.class);
        return busRoutes;
    }
    @GetMapping("/{busName}")
    public Collection<BusRoute> ByBusName(@PathVariable String busName){
        //return this.busrouteRepository.findByBusNameContains(busName);
        return this.busrouteRepository.findAllBusName(busName);
    }
    @GetMapping("/cityname/{toCity}")
    public Collection<BusRoute> byToCity(@PathVariable String toCity){
        return this.busrouteRepository.findByRoutesToCity(toCity);
    }
    @GetMapping("query/{busName}/{toCity}")
    public Collection<BusRoute> byBusNameAndtoCityAndBusStatus(@PathVariable String busName,@PathVariable String toCity){
        QBusRoute qBusRoute=new QBusRoute("query");
        BooleanExpression busNamePredicate = qBusRoute.bus.name.eq(busName);
        Predicate toCityPredicate = qBusRoute.routes.toCity.eq(toCity);
        Predicate busStatusPredicate=qBusRoute.bus.busStatus.eq(BusStatus.MODERATE);
        Predicate customPredicate=busNamePredicate.and(toCityPredicate).and(busStatusPredicate);
        return (Collection<BusRoute>) this.busrouteRepository.findAll(customPredicate);
    }
}
