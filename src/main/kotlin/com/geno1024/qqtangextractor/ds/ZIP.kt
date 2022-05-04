package com.geno1024.qqtangextractor.ds

import com.geno1024.qqtangextractor.Settings
import java.io.File
import java.nio.charset.Charset
import java.util.zip.ZipFile

class ZIP(path: String)
{
    val TAG = "[ZIP     ]"

    val file = File("${Settings.base}$path").apply { if (Settings.debug) print("$TAG handling $this: ") }

    fun decode() = ZipFile(file, Charset.forName("GBK")).apply {
        entries().toList().map {
            File("${Settings.version}/${file.toRelativeString(File(Settings.base)).substringBeforeLast('\\').replace('\\', '/')}/${it.name}").apply {
                if (it.isDirectory) mkdirs()
                else
                {
                    parentFile.mkdirs()
                    writeBytes(getInputStream(it).readBytes())
                }
            }
        }
        println()
    }
}
