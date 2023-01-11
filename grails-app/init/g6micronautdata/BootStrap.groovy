package g6micronautdata

import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import groovy.sql.Sql

import javax.sql.DataSource

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->
        addPeople()
    }

    @Transactional
    void addPeople() {
        def sql = Sql.newInstance(url: grailsApplication.config.datasources.oracle.url, user: 'mike_data', password: 'mike_data')
        try {
            def personTable = sql.firstRow('select table_name from user_tables where table_name =? ', 'PERSON')
            if( !personTable ) {
                sql.execute '''create table PERSON ( id INTEGER,
                                        forename VARCHAR(50),
                                        surname VARCHAR(50),
                                        dob DATE )'''
            }
            def personSeq = sql.firstRow("SELECT count(*) personSeq  FROM user_sequences WHERE sequence_name =?" , 'PERSON_ID_SEQ')
            if( !personSeq ) {
                sql.execute( 'create sequence PERSON_ID_SEQ start with 1 increment by 1' )
            }
            def totalPeople = sql.firstRow('select count(*) total from person')
            if( !totalPeople.TOTAL ) {
                sql.executeInsert("insert into PERSON (id, forename, surname, dob) values ( 1, 'Bob', 'Yellow', '1974-04-12' )")
                sql.executeInsert("insert into PERSON (id, forename, surname, dob) values ( 2, 'Sue', 'Orange', '1912-07-01' )")
            }
        }
        finally {
            sql?.close()
        }
    }

    def destroy = {
    }
}
