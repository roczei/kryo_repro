package com.roczei.testing

import com.esotericsoftware.kryo.kryo5.Kryo
import com.esotericsoftware.kryo.kryo5.io.Input
import com.esotericsoftware.kryo.kryo5.io.Output
import com.esotericsoftware.kryo.kryo5.objenesis.strategy.StdInstantiatorStrategy

import java.io.{FileInputStream, FileOutputStream}

case class TestVarArgs(vargs: String*)

object Main {
  def main(args: Array[String]): Unit = {
    val kryo = new Kryo()
    kryo.setInstantiatorStrategy(new StdInstantiatorStrategy())
    kryo.register(classOf[TestVarArgs])
    kryo.register(Class.forName("scala.collection.mutable.WrappedArray$ofRef"))
    kryo.register(Class.forName("[Ljava.lang.String;"))
    val t = TestVarArgs("hey", "you", "guys")
    val output = new Output(new FileOutputStream("file.bin"))
    kryo.writeObject(output, t)
    output.close()
    val input = new Input(new FileInputStream("file.bin"))
    val i = kryo.readObject(input, classOf[TestVarArgs])
    input.close()
    assert(i.equals(t))
  }
}