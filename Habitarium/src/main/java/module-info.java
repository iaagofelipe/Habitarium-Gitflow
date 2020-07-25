module com.habitarium.back {
    requires java.sql;
    requires net.bytebuddy;
    requires java.persistence;
    requires com.fasterxml.classmate;
    requires java.xml.bind;


    opens com.habitarium.entity;
    exports com.habitarium.controller;
    exports com.habitarium.entity;
    exports com.habitarium.dao;
    exports com.habitarium.enuns;
}