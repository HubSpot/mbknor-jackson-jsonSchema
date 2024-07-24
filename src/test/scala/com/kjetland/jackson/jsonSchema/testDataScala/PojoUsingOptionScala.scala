package com.kjetland.jackson.jsonSchema.testDataScala

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import java.util.{OptionalDouble, OptionalInt, OptionalLong}

case class PojoUsingOptionScala(
                                 _string:Option[String],
                                 @JsonDeserialize(contentAs = classOf[Int])     _integer:Option[Int],
                                 @JsonDeserialize(contentAs = classOf[Int])     _optionalInt:OptionalInt,
                                 @JsonDeserialize(contentAs = classOf[Boolean]) _boolean:Option[Boolean],
                                 @JsonDeserialize(contentAs = classOf[Double])  _double:Option[Double],
                                 @JsonDeserialize(contentAs = classOf[Double])  _optionalDouble:OptionalDouble,
                                 @JsonDeserialize(contentAs = classOf[Long])    _optionalLong:OptionalLong,
                                 child1:Option[Child1Scala],
                                 optionalList:Option[List[ClassNotExtendingAnythingScala]]
                                 //, parent:Option[ParentScala] - Not using this one: jackson-scala-module does not support Option combined with Polymorphism
                               )
