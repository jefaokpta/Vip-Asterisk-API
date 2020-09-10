package br.com.vip.vipasteriskapi.asterisk

import org.asteriskjava.manager.ManagerConnectionFactory

class Connection {

    companion object {
            val connect = ManagerConnectionFactory(
                    "192.168.15.47",
                    "vip",
                    "vipadminmanager123")
                    .createManagerConnection()
    }

}