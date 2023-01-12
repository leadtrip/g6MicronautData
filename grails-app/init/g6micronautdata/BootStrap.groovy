package g6micronautdata

import grails.gorm.transactions.Transactional
import groovy.sql.Sql

import javax.sql.DataSource

class BootStrap {

    DataSource dataSource       // this is the grails dataSource which happens to be the same as the micronaut one in this case

    def init = { servletContext ->
        addPeople()
    }

    @Transactional
    void addPeople() {
        def sql = new Sql(dataSource)
        try {
            sql.execute '''create table person ( 
                                        id LONG auto_increment,
                                        forename VARCHAR(50),
                                        surname VARCHAR(50),
                                        dob DATE )'''
            sql.executeInsert("insert into person ( forename, surname, dob) values ( 'Bob', 'Yellow', '1974-04-12' )")
            sql.executeInsert("insert into person ( forename, surname, dob) values ( 'Sue', 'Orange', '1912-07-01' )")
        }
        finally {
            sql?.close()
        }
    }

    def destroy = {
    }
}
