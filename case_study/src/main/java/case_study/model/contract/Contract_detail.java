package case_study.model.contract;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
