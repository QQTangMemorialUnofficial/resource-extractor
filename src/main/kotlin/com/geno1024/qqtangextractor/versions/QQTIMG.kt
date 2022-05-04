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
        "/item/ItemZips" decodeFiles "ZIP"
        File(Settings.version).copyRecursively(File("${Settings.version}_temp"))
        File(Settings.version).deleteRecursively()
        Settings.base = "${Settings.version}_temp"
        "/item/ItemZips".apply {
            File("${Settings.base}$this").listFiles()?.forEach { category ->
                category.listFiles()?.forEach { index ->
                    index.listFiles()?.forEach { file ->
                        when (file.extension)
                        {
                            "img" -> "/${file.toRelativeString(File(Settings.base)).replace("\\", "/")}" decode "IMG"
                            "ini" -> "/${file.toRelativeString(File(Settings.base)).replace("\\", "/")}" copyTo "/${file.toRelativeString(File(Settings.base)).replace("\\", "/")}"
                        }
                    }
                }
            }
        }
        File("${Settings.version}/README.md").writeText(ResourceTree.toTreeDiagramWithinZip())
    }
}
