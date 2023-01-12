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
        // this is the micronaut dataSource
        def oracleConfig = grailsApplication.config.datasources.oracle
        def sql = Sql.newInstance(url: oracleConfig.url, user: oracleConfig.username, password: oracleConfig.password)
        try {
            def personTable = sql.firstRow('select table_name from user_tables where table_name =? ', 'PERSON')
            if( !personTable ) {
                sql.execute '''create table PERSON ( id INTEGER,
                                        forename VARCHAR(50),
                                        surname VARCHAR(50),
                                        dob DATE )'''
                sql.execute( 'create sequence PERSON_ID_SEQ start with 1 increment by 1' )
                sql.executeInsert("insert into PERSON (id, forename, surname, dob) values ( PERSON_ID_SEQ.nextval, 'Bob', 'Yellow', '12-Apr-1974' )")
                sql.executeInsert("insert into PERSON (id, forename, surname, dob) values ( PERSON_ID_SEQ.nextval, 'Sue', 'Orange', '01-Jul-1912' )")
            }
        }
        finally {
            sql?.close()
        }
    }

    def destroy = {
    }
}
