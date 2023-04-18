package com.roczei.testing

import com.esotericsoftware.kryo.kryo5.Kryo
import com.esotericsoftware.kryo.kryo5.io.Input
import com.esotericsoftware.kryo.kryo5.io.Output
import com.esotericsoftware.kryo.kryo5.Serializer

class TestVarArgsSerializer extends Serializer[String] {
  setImmutable(true)
  def write(kser: Kryo, out: Output, obj: String): Unit =
    out.writeString(obj)

  def read(kser: Kryo, in: Input, cls: Class[_ <: String]): String =
    new String(in.readString)
}