package br.com.vip.vipasteriskapi.controller

import br.com.vip.vipasteriskapi.model.Peer
import br.com.vip.vipasteriskapi.service.PeerService
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/v1/secure/peers")
class PeerController(val peerService: PeerService) {

    @GetMapping
    fun getAll() = peerService.getAllPeers()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = peerService.getPeerById(id)

    @PostMapping
    fun set(@RequestBody p: Peer) = peerService.setPeer(p)
}