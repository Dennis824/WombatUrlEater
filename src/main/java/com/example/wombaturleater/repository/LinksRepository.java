package com.example.wombaturleater.repository;

import com.example.wombaturleater.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Link, Integer>{

    @Query("select c from Link c where c.owner.id = ?1")
    List<Link> findAllLinksByOwner(int id);


}
