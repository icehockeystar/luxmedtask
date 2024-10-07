package org.euroit.luxmedtask.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
