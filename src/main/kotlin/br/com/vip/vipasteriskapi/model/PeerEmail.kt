package br.com.vip.vipasteriskapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity @Table(name = "peer_emails")
class PeerEmail(
        @Column(columnDefinition = "BINARY(16)")
        val idPeer: UUID? = null,
        val email: String
) {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

}