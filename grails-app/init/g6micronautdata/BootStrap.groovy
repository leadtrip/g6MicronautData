package g6micronautdata

import grails.gorm.transactions.Transactional
import groovy.sql.Sql
import org.grails.datastore.gorm.GormEntity

import javax.sql.DataSource
import java.time.LocalDate
import java.time.Month

class BootStrap {

    DataSource dataSource       // this is the grails dataSource which happens to be the same as the micronaut one in this case

    def init = { servletContext ->
        addPeople()
    }

    @Transactional
    void addPeople() {
        def sql = new Sql(dataSource)
        try {
            sql.execute '''create table person ( id INTEGER,
                                        forename VARCHAR(50),
                                        surname VARCHAR(50),
                                        dob DATE )'''
            sql.execute( 'create sequence PERSON_ID_SEQ start with 3 increment by 1' )
            sql.executeInsert("insert into person (id, forename, surname, dob) values ( 1, 'Bob', 'Yellow', '1974-04-12' )")
            sql.executeInsert("insert into person (id, forename, surname, dob) values ( 2, 'Sue', 'Orange', '1912-07-01' )")
        }
        finally {
            sql?.close()
        }
    }

    def destroy = {
    }
}
