package br.com.vip.vipasteriskapi.controller

import br.com.vip.vipasteriskapi.model.Peer
import br.com.vip.vipasteriskapi.service.PeerService
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/v1/secure/peers")
class PeerController(val peerService: PeerService) {

    @GetMapping
    fun getAll() = peerService.getAllPeers()

    @PostMapping
    fun set(@RequestBody p: Peer) = peerService.setPeer(p)
}