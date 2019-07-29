package com.zhaopin.springbootjpa.repository;

import com.zhaopin.springbootjpa.dataobject.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
