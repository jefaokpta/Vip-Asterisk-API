package br.com.vip.vipasteriskapi.repository

import br.com.vip.vipasteriskapi.model.Peer
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PeerRepository: CrudRepository<Peer, UUID> {

    // ASSASSINANDO O PROBLEMA DE N+1
    @Query("FROM Peer p join fetch p.emails")
    override fun findAll(): MutableIterable<Peer>

    fun findByPeer(peer: Int): Optional<Peer>

    fun existsByPeer(peer: Int): Boolean
}