package com.blood.donation.repositories;

import com.blood.donation.models.Giver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiverRepository extends JpaRepository<Giver,Long> {
}
