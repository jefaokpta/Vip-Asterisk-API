package br.com.vip.vipasteriskapi.util

import br.com.vip.vipasteriskapi.model.PeerDTO
import java.io.File
import java.io.FileWriter

fun writeSipPeers(peers: List<PeerDTO>){
    val file = File("/tmp/pjsip.conf")
    if (!file.exists())
        file.createNewFile()
    val fwrite = FileWriter(file)
    fwrite.write(";Arquivo escrito automaticamente pelo sistema\n\n")

    peers.forEach { p ->
        fwrite.write(";=============== RAMAL: ${p.peer}\n")

        fwrite.write("[${p.peer}]\n")
        fwrite.write("type=endpoint\n")
        fwrite.write("context=VipPeers\n")
        fwrite.write("callerid=${p.callerid} <${p.peer.toString().substring(3)}>\n")
        fwrite.write("language=${p.language}\n")
        fwrite.write("call_group=${p.callGroup}\n")
        fwrite.write("pickup_group=${p.pickupGroup}\n")
        fwrite.write("disallow=all\n")
        fwrite.write("allow=${p.allow}\n")
        if (p.allowVideo.isNotEmpty()) fwrite.write("allow=${p.allowVideo}\n")
        fwrite.write("auth=${p.peer}\n")
        fwrite.write("aors=${p.peer}\n")
        p.setVars.forEach { fwrite.write("set_var=${it.keyVar}=${it.valueVar}\n") }

        fwrite.write(";=============== FIM RAMAL: ${p.peer}\n\n")

    }
    fwrite.flush()
    fwrite.close()
}