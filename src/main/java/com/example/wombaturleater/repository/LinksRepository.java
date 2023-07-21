package com.example.wombaturleater.repository;

import com.example.wombaturleater.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<Link, Integer>{

}
