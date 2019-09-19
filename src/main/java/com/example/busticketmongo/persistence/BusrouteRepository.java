package com.example.busticketmongo.persistence;

import com.example.busticketmongo.model.BusRoute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BusrouteRepository extends MongoRepository<BusRoute,String> ,
    QuerydslPredicateExecutor<BusRoute>{
    List<BusRoute> findByBusNameContains(String busName);

    List<BusRoute> findByRoutesToCity(String toCity);

    @Query("{'bus.name':{$eq:?0}}")
    List<BusRoute> findAllBusName(String busName);
}
