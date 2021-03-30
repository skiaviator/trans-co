//package transport.co.api.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Setter
//@Getter
//@Table(name = "route_stops")
//public class RouteStop {
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name="route_id",nullable=false)
//    private Route route;
//
//    @ManyToOne
//    @JoinColumn(name="stop_id",nullable=false)
//    private Stop stop;
//}
