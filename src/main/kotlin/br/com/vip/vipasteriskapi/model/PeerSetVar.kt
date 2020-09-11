package br.com.vip.vipasteriskapi.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity @Table(name = "peer_set_vars", indexes = [
    Index(name = "SETVAR_IDX", columnList = "idSetVar", unique = false)
    ])
class PeerSetVar (
        @Column(columnDefinition = "BINARY(16)")
        val idSetVar: UUID,
        val keyVar: String,
        val valueVar: String
    ){
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()
}