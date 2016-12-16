import java.io._

import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream

object Example {
  def main(args: Array[String]): Unit = {
    println("Sample Scala Project")
    allInOne("test")
  }

  def stepByStep(name:String) ={

    //*.tar.bz2 to *.tar
    val fin = new FileInputStream(name + ".tar.bz2")
    val in = new BufferedInputStream(fin)
    val out = new FileOutputStream(name + ".tar")
    val bzIn = new BZip2CompressorInputStream(in)
    val buffer = new Array[Byte](1024 * 1024)
    var n = 0
    do {
      n = bzIn.read(buffer)
      if (n > 0) out.write(buffer, 0, n)
    } while (n > -1)
    out.close()
    bzIn.close()

    //*.tar to files
    val tarEntry = new TarArchiveInputStream(new BufferedInputStream(new FileInputStream(name + ".tar")))
    var entry = tarEntry.getNextTarEntry
    while (entry != null) {
      val destPath = new File(entry.getName)
      if (entry.isDirectory) {
        destPath.mkdir()
      } else {
        destPath.createNewFile()
        val dest = new BufferedOutputStream(new FileOutputStream(destPath))
        do {
          n = tarEntry.read(buffer)
          if (n > 0) dest.write(buffer, 0, n)
        } while (n > -1)
        dest.close()
      }
      entry = tarEntry.getNextTarEntry
    }
    tarEntry.close()
  }
  def allInOne(name:String): Unit = {
    val tarEntry = new TarArchiveInputStream(
      new BZip2CompressorInputStream(
        new BufferedInputStream(
          new FileInputStream(name + ".tar.bz2")
        )))
    val buffer = new Array[Byte](1024 * 1024)
    var n = 0
    var entry = tarEntry.getNextTarEntry
    while (entry != null) {
      val destPath = new File(entry.getName)
      if (entry.isDirectory) {
        destPath.mkdir()
      } else {
        destPath.createNewFile()
        val dest = new BufferedOutputStream(new FileOutputStream(destPath))
        do {
          n = tarEntry.read(buffer)
          if (n > 0) dest.write(buffer, 0, n)
        } while (n > -1)
        dest.close()
      }
      entry = tarEntry.getNextTarEntry
    }
    tarEntry.close()

  }
}