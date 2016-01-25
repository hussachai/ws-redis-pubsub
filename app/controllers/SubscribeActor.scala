package controllers

import java.net.InetSocketAddress
import akka.actor.{ActorRef, Props}
import redis.RedisClient
import redis.actors.RedisSubscriberActor
import redis.api.pubsub.{PMessage, Message}
import play.api.Logger

class SubscribeActor(redis: RedisClient, out: ActorRef, 
    channels: Seq[String] = Nil, patterns: Seq[String] = Nil) extends RedisSubscriberActor(
  new InetSocketAddress(redis.host, redis.port),
  channels,
  patterns,
  onConnectStatus = connected => { println(s"connected: $connected") }) {

  Logger.logger.debug(s"Started RedisSubscriberActor for channels: $channels")

  def onMessage(message: Message) {
    out ! message.data.decodeString("UTF-8")
  }

  def onPMessage(pmessage: PMessage) {}

  override def onClosingConnectionClosed(): Unit = {
    Logger.logger.debug(s"RedisSubscriberActor for channels: $channels is closing")
  }

  override def postStop() {
    Logger.logger.debug(s"RedisSubscriberActor for channels: $channels is stopping")
  }
}