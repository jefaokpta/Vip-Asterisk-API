package br.com.vip.vipasteriskapi.asterisk

import org.asteriskjava.manager.ManagerEventListener
import org.asteriskjava.manager.event.*

class Event: ManagerEventListener{

    override fun onManagerEvent(event: ManagerEvent?) {
        if (event is PeerStatusEvent) {
            //HandleEvent().handle(event as PeerStatusEvent?)
            return
        }

        if (event is NewChannelEvent) {
            //HandleEvent().handle(event as NewChannelEvent?)
            return
        }

        if (event is NewStateEvent) {
            //HandleEvent().handle(event as NewStateEvent?)
            return
        }

        if (event is HangupEvent) {
            //AgentHandler().handle(event)
            return
        }
        if (event is QueueSummaryEvent) {
            //HandleQueue().handle(event as QueueSummaryEvent?)
            return
        }
        if (event is QueueParamsEvent) {
            //HandleQueue().handle(event as QueueParamsEvent?)
            return
        }
        if (event is QueueMemberEvent) {
            //HandleAgent().handle(event as QueueMemberEvent?)
            return
        }
        if (event is QueueMemberRemovedEvent) {
            //HandleAgent().handle(event as QueueMemberRemovedEvent?)
            return
        }
        if (event is QueueEntryEvent) {
            //AgentHandler().handle(event)
            println(event)
            return
        }
        if (event is AgentConnectEvent) {
            println(event)
            //AgentHandler().handle(event)
            return
        }
        if (event is QueueCallerAbandonEvent) {
            println(event)
            //HandleAgent().handle(event as QueueCallerAbandonEvent?)
            return
        }
        if (event is LeaveEvent) {
            //HandleAgent().handle(event as LeaveEvent?)
            return
        }
        if (event is QueueMemberPausedEvent) {
            //HandleAgent().handle(event as QueueMemberPausedEvent?)
            return
        }
        if (event is AgentCalledEvent) {
            //AgentHandler().handle(event)
            println(event)
            return
        }
        //if (event is CdrEvent) return

        if (event is VarSetEvent) return
        if (event is ExtensionStatusEvent) return
        if (event is NewExtenEvent) return
        if (event is QueueSummaryCompleteEvent) return
        if (event is QueueStatusCompleteEvent) return
        if (event is RtcpSentEvent) return
        if (event is RtcpReceivedEvent) return
        if (event is ChannelReloadEvent) return
        if (event is NewCallerIdEvent) return
        if (event is BridgeEvent) {
            //HandleEvent().handle(event as BridgeEvent?)
            return
        }
        if (event is NewAccountCodeEvent) return
        if (event is ChannelUpdateEvent) return
        if (event is JitterBufStatsEvent) return
        if (event is DialEvent) {
            //HandleEvent().handle(event as DialEvent?)
            return
        }
        if (event is MusicOnHoldEvent) return
        if (event is RenameEvent) return
        if (event is MasqueradeEvent) return
        if (event is DtmfEvent) return
        if (event is JoinEvent) return
        if (event is QueueMemberAddedEvent) return
        if (event is RegistryEvent) return
        if (event is SoftHangupRequestEvent) return
        if (event is HangupRequestEvent) return
        if (event is HoldEvent) return
        if (event is UnholdEvent) return
        if (event is AgentCompleteEvent) return
        if (event is AgentRingNoAnswerEvent) return
        if (event is DisconnectEvent) return
        if (event is FullyBootedEvent) return
        if (event is ConnectEvent) return
        if (event is MessageWaitingEvent) return
        if (event is MeetMeJoinEvent) return
        if (event is MeetMeEndEvent) return
        if (event is MeetMeLeaveEvent) return
        if (event is ConfbridgeEndEvent) return
        if (event is ConfbridgeJoinEvent) return
        if (event is ConfbridgeLeaveEvent) return

        //POSSIVEIS PJSIP OU AST16
        if (event is SuccessfulAuthEvent) return
        if (event is ChallengeSentEvent) return
        if (event is ContactStatusEvent) return
        if (event is DeviceStateChangeEvent) return
        if (event is ReloadEvent) return
        if (event is ChallengeResponseFailedEvent) return

        println(event)
    }
}