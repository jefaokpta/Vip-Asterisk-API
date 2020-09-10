package br.com.vip.vipasteriskapi.model

import br.com.vip.vipasteriskapi.model.enum.PeerType
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity @Table(name = "peers", indexes = [
    Index(name = "COMPANY_IDX", columnList = "company", unique = false),
    Index(name = "PEER_IDX", columnList = "peer", unique = true)
])
class Peer(
    val peer: Int,
    val featurePassword: Int,
    val callerid: String,
    val dtmfmode: String,
    val language: String,
    val mailbox: Boolean,
    val md5secret: String,
    val pickupGroup: Int,
    val callGroup: Int,
    val allow: String,
    val allowVideo: String,
    val callLimit: Int,
    val company: Int,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPeer")
    val emails: List<PeerEmail>

) {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()
    val context: String = "VipPeers"
    val qualifyFrequency: Int = 60
    val peerType: PeerType = PeerType.SIP
    val dnd: Int = 0
    val fwd: String = ""
    val lockPeer: Int = 0
    val channel: String = "$peerType/$peer"
}