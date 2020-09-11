package br.com.vip.vipasteriskapi.model

import br.com.vip.vipasteriskapi.model.enum.PeerType
import java.util.*

class PeerDTO(
        val id: UUID,
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
        val emails: List<PeerEmail>,
        val context: String,
        val qualifyFrequency: Int,
        val peerType: PeerType,
        val dnd: Int,
        val fwd: String,
        val lockPeer: Int,
        val channel: String,
        val setVars: MutableIterable<PeerSetVar>

) {
}