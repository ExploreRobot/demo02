package com.offcn.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "member")
public class Member implements Serializable {
    private String _id;
    private String m_name;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "_id='" + _id + '\'' +
                ", m_name='" + m_name + '\'' +
                '}';
    }
}
