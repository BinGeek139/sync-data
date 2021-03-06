package com.vnpt.eoffice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table
public class LoaiVanBan {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String ten;

    private String moTa;

    @OneToMany(mappedBy = "loaiVanBan",cascade = CascadeType.ALL)
    List<VanBan> vanBans;


}
