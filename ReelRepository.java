package com.myorganisation.nexify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelRepository<Reel> extends JpaRepository<Reel, Long> {
}
