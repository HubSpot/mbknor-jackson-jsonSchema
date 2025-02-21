package com.kjetland.jackson.jsonSchema.testDataScala

import com.fasterxml.jackson.annotation.{JsonSubTypes, JsonTypeInfo}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(Array(
  new JsonSubTypes.Type(value = classOf[Column], name = "Column"),
  new JsonSubTypes.Type(value = classOf[Module], name = "Module")
))
trait RowItem
case class Column(rows:List[Row]) extends RowItem
case class Module(data:String) extends RowItem
case class Row(items:List[RowItem])
