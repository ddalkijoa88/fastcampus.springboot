package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"user","item"})
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime orderAt;

    //orderDetail 입장에서는 본인이 다수이고 상대가 되는 user는 1이므로 N:1 관계가 형성된다
    //그러므로 다음과 같은 어노테이션으로 설정해야한다
    @ManyToOne
    private Users user;  //반드시 객체 이름으로 설정해야 hibernate가 테이블에서 user_id를 찾아갈 수 있다

    @ManyToOne
    private Item item;

}
