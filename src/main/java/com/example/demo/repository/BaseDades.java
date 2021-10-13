package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Empleat;

public interface BaseDades extends JpaRepository<Empleat, Integer> {

}