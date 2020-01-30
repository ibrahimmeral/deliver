package com.cristianruizblog.loginSecurity.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String tel;

    String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    Client client;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = false)
    State state;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    Payment payment;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "short_schedule_id", nullable = false)
    ShortSchedule shortSchedule;

    public ShortSchedule getShortSchedule() {
        return shortSchedule;
    }

    public void setShortSchedule(ShortSchedule shortSchedule) {
        this.shortSchedule = shortSchedule;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }




    Float fee;

    Float tip;

    Timestamp saveTime;

    Timestamp deliverTime;

    public Timestamp getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Timestamp deliverTime) {
        this.deliverTime = deliverTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Timestamp getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Timestamp saveTime) {
        this.saveTime = saveTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getTip() {
        return this.tip;
    }

    public void setTip(Float tip) {
        this.tip = tip;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSaveTimeString(){
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(this.saveTime);
    }
}
