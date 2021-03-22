//package com.blood.donation.repositories;
//
//import com.blood.donation.models.Giver;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface GiverRepository extends JpaRepository<Giver,Long> {
//
//    List<Giver> findAllByTypeBlood(String typeBlood);
//    List<Giver> findAllByTypeBloodAndUser_City(String typeBlood,String city);
//    List<Giver> findAllByUser_City(String city);
//}
