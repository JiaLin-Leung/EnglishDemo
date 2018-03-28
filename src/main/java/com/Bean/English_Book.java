package com.Bean;

import java.io.Serializable;
import java.util.List;

public class English_Book implements Serializable {

    private String response;
    private String error;
    private String message;
    private String next;
    private EnglishBooksBean data;

    public class EnglishBooksBean implements Serializable{

        private List<BooksBean> books;

        public List<BooksBean> getBooks() {
            return books;
        }

        public void setBooks(List<BooksBean> books) {
            this.books = books;
        }

        @Override
        public String toString() {
            return "EnglishBooksBean{" +
                    "books=" + books +
                    '}';
        }
    }

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

    public EnglishBooksBean getData() {
        return data;
    }

    public void setData(EnglishBooksBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "English_Book{" +
                "response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", data=" + data +
                '}';
    }

    public class BooksBean implements Serializable{
        private String press_name;
        private String name;
        private String subject_id;
        private String grade_id;
        private String volume;
        private String book_type;
        private String grade_name;
        private String volume_name;
        private String version_name;
        private String id;
        private String press_id;

        @Override
        public String toString() {
            return "BooksBean{" +
                    "press_name='" + press_name + '\'' +
                    ", name='" + name + '\'' +
                    ", subject_id='" + subject_id + '\'' +
                    ", grade_id='" + grade_id + '\'' +
                    ", volume='" + volume + '\'' +
                    ", book_type='" + book_type + '\'' +
                    ", grade_name='" + grade_name + '\'' +
                    ", volume_name='" + volume_name + '\'' +
                    ", version_name='" + version_name + '\'' +
                    ", id='" + id + '\'' +
                    ", press_id='" + press_id + '\'' +
                    '}';
        }

        public String getPress_name() {
            return press_name;
        }

        public void setPress_name(String press_name) {
            this.press_name = press_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getGrade_id() {
            return grade_id;
        }

        public void setGrade_id(String grade_id) {
            this.grade_id = grade_id;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getBook_type() {
            return book_type;
        }

        public void setBook_type(String book_type) {
            this.book_type = book_type;
        }

        public String getGrade_name() {
            return grade_name;
        }

        public void setGrade_name(String grade_name) {
            this.grade_name = grade_name;
        }

        public String getVolume_name() {
            return volume_name;
        }

        public void setVolume_name(String volume_name) {
            this.volume_name = volume_name;
        }

        public String getVersion_name() {
            return version_name;
        }

        public void setVersion_name(String version_name) {
            this.version_name = version_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPress_id() {
            return press_id;
        }

        public void setPress_id(String press_id) {
            this.press_id = press_id;
        }
    }
}
