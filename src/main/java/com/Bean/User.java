package com.Bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private String response;
    private String error;
    private String message;
    private String next;
    private User_data_bean data;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public User_data_bean getData() {
        return data;
    }

    public void setData(User_data_bean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", data=" + data +
                '}';
    }

    public class User_data_bean implements Serializable{
        private String id;
        private String border;
        private String portrait;
        private String bind_id;
        private String name;
        private String dept_type;
        private String type;
        private String subject_id;
        private String sex;
        private String platform_id;
        private String phone;
        private List<UntisBean> units;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBorder() {
            return border;
        }

        public void setBorder(String border) {
            this.border = border;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getBind_id() {
            return bind_id;
        }

        public void setBind_id(String bind_id) {
            this.bind_id = bind_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept_type() {
            return dept_type;
        }

        public void setDept_type(String dept_type) {
            this.dept_type = dept_type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPlatform_id() {
            return platform_id;
        }

        public void setPlatform_id(String platform_id) {
            this.platform_id = platform_id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<UntisBean> getUnits() {
            return units;
        }

        public void setUnits(List<UntisBean> units) {
            this.units = units;
        }

        @Override
        public String toString() {
            return "User_data_bean{" +
                    "id='" + id + '\'' +
                    ", border='" + border + '\'' +
                    ", portrait='" + portrait + '\'' +
                    ", bind_id='" + bind_id + '\'' +
                    ", name='" + name + '\'' +
                    ", dept_type='" + dept_type + '\'' +
                    ", type='" + type + '\'' +
                    ", subject_id='" + subject_id + '\'' +
                    ", sex='" + sex + '\'' +
                    ", platform_id='" + platform_id + '\'' +
                    ", phone='" + phone + '\'' +
                    ", units=" + units +
                    '}';
        }
    }
}
