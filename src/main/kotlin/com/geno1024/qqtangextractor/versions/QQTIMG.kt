package com.geno1024.qqtangextractor.versions

import com.geno1024.qqtangextractor.Settings
import com.geno1024.qqtangextractor.copyTo
import com.geno1024.qqtangextractor.decode
import com.geno1024.qqtangextractor.decodeFiles
import com.geno1024.qqtangextractor.ds.ResourceTree
import java.io.File

object QQTIMG
{
    operator fun invoke()
    {
        "/qqt-img.qq.com/item/ItemZips" decodeFiles "ZIP"
        File(Settings.version).copyRecursively(File("${Settings.version}_temp"))
        File(Settings.version).deleteRecursively()
        Settings.version = "${Settings.version}_temp"
        println(Runtime.getRuntime().exec(arrayOf("ls", "-alFR")).inputStream.readAllBytes().toString(Charsets.UTF_8))
        "/qqt-img.qq.com/item/ItemZips".apply {
            File("${Settings.version}$this").listFiles()?.forEach { category ->
                category.listFiles()?.forEach { index ->
                    index.listFiles()?.forEach { file ->
                        when (file.extension)
                        {
                            "img" -> "/${file.toRelativeString(File("${Settings.version}_temp")).replace("\\", "/")}" decode "IMG"
//                            "ini" -> "/${file.toRelativeString(File("${Settings.version}_temp")).replace("\\", "/")}" copyTo "/${file.toRelativeString(File(Settings.base)).replace("\\", "/")}"
                            else -> println(file)
                        }
                    }
                }
            }
        }
        File("${Settings.version}/README.md").writeText(ResourceTree.toTreeDiagramWithinZip())
    }
}
