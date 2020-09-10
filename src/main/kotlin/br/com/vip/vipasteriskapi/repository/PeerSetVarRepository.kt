package br.com.vip.vipasteriskapi.repository

import br.com.vip.vipasteriskapi.model.PeerSetVar
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PeerSetVarRepository: CrudRepository<PeerSetVar, UUID> {
}