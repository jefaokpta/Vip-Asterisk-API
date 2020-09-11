package br.com.vip.vipasteriskapi.service

import br.com.vip.vipasteriskapi.model.Peer
import br.com.vip.vipasteriskapi.model.PeerDTO
import br.com.vip.vipasteriskapi.model.PeerSetVar
import br.com.vip.vipasteriskapi.repository.PeerRepository
import br.com.vip.vipasteriskapi.repository.PeerSetVarRepository
import br.com.vip.vipasteriskapi.util.convertToUUID
import br.com.vip.vipasteriskapi.util.writeSipPeers
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class PeerService(
        val peerRepository: PeerRepository,
        val peerSetVarRepository: PeerSetVarRepository
) {
    fun getAllPeers() = ResponseEntity.ok(peerRepository.findAll())

    fun getPeerById(id: String): ResponseEntity<Any> {
        val uuid = convertToUUID(id).run { this?: return ResponseEntity.notFound().build() }
        return peerRepository.findById(uuid).run {
            if (isPresent)
                ResponseEntity.ok(get())
            else
                ResponseEntity.notFound().build()
        }
    }

    fun setPeer(p: Peer): ResponseEntity<Any>{
        return peerRepository.findByPeer(p.peer).run{
            if (isPresent)
                ResponseEntity.ok(get())
            else {
                val peer= peerRepository.save(p)
                peerSetVarRepository.saveAll(
                        listOf(PeerSetVar(peer.id, "PEER_ID", peer.id.toString()),
                        PeerSetVar(peer.id, "COMPANY_ID", peer.company.toString())
                    )
                )
                writeSipPeers(peersToDTO(peerRepository.findAll()))
                ResponseEntity.ok(peer)
            }
        }
    }

    fun peersToDTO(peers: MutableIterable<Peer>) = peers.map {
            PeerDTO(
                    it.id,
                    it.peer,
                    it.featurePassword,
                    it.callerid,
                    it.dtmfmode,
                    it.language,
                    it.mailbox,
                    it.md5secret,
                    it.pickupGroup,
                    it.callGroup,
                    it.allow,
                    it.allowVideo,
                    it.callLimit,
                    it.company,
                    it.emails,
                    it.context,
                    it.qualifyFrequency,
                    it.peerType,
                    it.dnd,
                    it.fwd,
                    it.lockPeer,
                    it.channel,
                    peerSetVarRepository.findAllByIdSetVar(it.id)
            )
    }

}