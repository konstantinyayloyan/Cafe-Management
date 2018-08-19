package com.cafemanagement.repository;

import com.cafemanagement.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long>{
}
