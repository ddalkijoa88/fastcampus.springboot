package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
    //fetch type은 두가지가 존재한다.
    //LAZY = 지연로딩, EAGER = 즉시로딩
    //lazy type -> select * from item where id =?
    //eager type -> 연관관계가 설정된 모든 테이블을 조인(join)해서 검색한다. 데이터 수가 많다면 시간이 많이 걸리거나 원하는 데이터를 가져오지 못할수도 있다.
    //따라서, default type은 lazy이고, 1:1 관계라면 eager를 사용한다

}
