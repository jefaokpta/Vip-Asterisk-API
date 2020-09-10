package br.com.vip.vipasteriskapi.service

import br.com.vip.vipasteriskapi.model.Peer
import br.com.vip.vipasteriskapi.model.PeerSetVar
import br.com.vip.vipasteriskapi.repository.PeerRepository
import br.com.vip.vipasteriskapi.repository.PeerSetVarRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PeerService(
        val peerRepository: PeerRepository,
        val peerSetVarRepository: PeerSetVarRepository
) {

    fun getAllPeers() = ResponseEntity.ok(peerRepository.findAll())

    fun setPeer(p: Peer): ResponseEntity<Any>{
        return peerRepository.findByPeer(p.peer).run{
            if (isPresent)
                ResponseEntity.ok(get())
            else {
                val peer = peerRepository.save(p)
                peerSetVarRepository.save(PeerSetVar(peer.id, "PEER_ID", peer.id.toString()))
                ResponseEntity.ok(peer)
            }
        }
    }


}