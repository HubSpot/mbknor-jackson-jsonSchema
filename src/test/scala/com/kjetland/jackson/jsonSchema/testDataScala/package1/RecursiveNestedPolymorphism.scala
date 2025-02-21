package com.kjetland.jackson.jsonSchema.testDataScala.package1

import com.fasterxml.jackson.annotation.{JsonSubTypes, JsonTypeInfo}

case class Package1Brand(data:String)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(Array(
  new JsonSubTypes.Type(value = classOf[Column], name = "Column"),
  new JsonSubTypes.Type(value = classOf[Module], name = "Module")
))
trait RowItem
case class Column(rows:List[Row], brand:Package1Brand) extends RowItem
case class Module(data:String, brand:Package1Brand) extends RowItem
case class Row(items:List[RowItem], brand:Package1Brand)
