package br.com.vip.vipasteriskapi

import br.com.vip.vipasteriskapi.asterisk.Connection
import br.com.vip.vipasteriskapi.asterisk.Event
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VipAsteriskApiApplication

fun main(args: Array<String>) {
    runApplication<VipAsteriskApiApplication>(*args)

    Connection.connect.run {
        addEventListener(Event())
        login()
    }
}
