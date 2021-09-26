package com.project.demo.demo_test.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "k_pac_set")
public class K_PAC_set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 250)
    private String title;

    @OneToMany(mappedBy = "kPacSet", fetch = FetchType.LAZY)
    private List<K_PAC> k_pacs;

    public List<K_PAC> getK_pacs() {
        return k_pacs;
    }

    public void setK_pacs(List<K_PAC> k_pacs) {
        this.k_pacs = k_pacs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
