package com.example.PodcastDirectoryAPI.repository;

import com.example.PodcastDirectoryAPI.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<Audit, Long> {
}
